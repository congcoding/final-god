package com.kh.god.chat.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.god.chat.model.dao.ChatDao;
import com.kh.god.chat.model.vo.Chat;
import com.kh.god.chat.model.vo.ChatRoom;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	ChatDao chatDao;
	Logger logger = Logger.getLogger(getClass());
	@Override
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
}
