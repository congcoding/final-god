package com.kh.god.chat.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.god.chat.model.dao.ChatDao;
import com.kh.god.chat.model.vo.Chat;
import com.kh.god.chat.model.vo.ChatRoom;
import com.kh.god.seller.model.vo.Seller;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	ChatDao chatDao;
	Logger logger = Logger.getLogger(getClass());
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<Map<String,String>> selectChatRoomList(String sellerId) {
		List<ChatRoom> chatRoom = chatDao.selectChatRoomList(sellerId);
		logger.debug("로그인한 아이디로 검색한 채팅방 리스트 : "+chatRoom);
		List<Map<String,String>> chatLog = null;
		
		if(chatRoom != null) {
			Map<Integer,Integer> roomMap = new HashMap<>();
			for(int i = 0; i < chatRoom.size(); i++) {
				roomMap.put(i, chatRoom.get(i).getChatRoomNo());
			}
			chatLog = chatDao.selectChatLog(roomMap);
			logger.debug("채팅로그 : "+chatLog);
		}
		return chatLog;
	}
	@Override
	public List<Map<String,String>> selectChattingLogs(Map<String,String> map) {
		return chatDao.selectChattingLogs(map);
	}
	@Override
	public int insertChatLog(Chat chat) {
		logger.debug("DAO가기전 chat맵"+chat);
		int result = chatDao.insertChatLog(chat);
//		List<Map<String,String>> chatLog = null;
//		if(result > 0) {
//			chat.put("sendId","<no>");
//			logger.debug("insert후 sendId를 바꾼뒤 chat맵"+chat);
//			chatLog = chatDao.selectChattingLogs(chat);
//		}
		return result;
	}
	@Override
	public List<Seller> searchPerson(String searchId) {
		return chatDao.searchPerson(searchId);
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<Map<String,String>> addPerson(ChatRoom roomId)  {
		ChatRoom chatRoom = null;
		Map<String, String> map = new HashMap<>();
		List<Map<String,String>> chatList = null;
		
		chatRoom =	chatDao.searchChatRoom(roomId);
		int result = 0;
		logger.debug("추가할 사람과의 채팅방이 기존에 있는가 ? : "+chatRoom);
		if(chatRoom != null) {
			if("존재하지않는아이디".equals(chatRoom.getSellerId())) {
				map.put("SELLERID",chatRoom.getSellerId());
				chatList = new ArrayList<>();
				chatList.add(map);
			}else {
				map.put("sendId", "<no>");
				map.put("chatRoomNo",chatRoom.getChatRoomNo()+"");
				chatList = chatDao.selectChattingLogs(map);
			}
		}else {
			try {
				result = chatDao.creatChatRoom(roomId);
				map.put("SELLERID",roomId.getSellerId());
				map.put("SELLERID2", roomId.getSellerId2());
				map.put("chatRoomNo",roomId.getChatRoomNo()+"");
				map.put("CHATCONTENT",null);
				map.put("SENDTIME",null);
				map.put("SENDMEMBER",null);
				
			}catch(DataAccessException e) {
				if(e instanceof DataIntegrityViolationException){
					logger.debug("무결성 제약 조건 위반");
					map.put("SELLERID", "존재하지않는아이디");
				}
			}
			chatList = new ArrayList<>();
			chatList.add(map);
		}
		return chatList;
	}
	
	@Override
	public String notReadMessage(String memberId) {
		return chatDao.notReadMessage(memberId);
	}
}
