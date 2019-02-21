package com.kh.god.chat.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.god.chat.model.vo.Chat;
import com.kh.god.chat.model.vo.ChatRoom;

@Repository
public class ChatDaoImpl implements ChatDao {
	@Autowired
	SqlSession sqlSession;
	Logger logger = Logger.getLogger(getClass());
	/**
	 * 채팅방 리스트를 뽑아오는 곳
	 */
	@Override
	public List<ChatRoom> selectChatRoomList(String sellerId) {
		
		return sqlSession.selectList("chat.selectChatRoomList", sellerId);
	}
	/**
	 * PreView로 보여줄 제일 마지막 채팅 기록
	 */
	@Override
	public List<Map<String,String>> selectChatLog(Map<Integer, Integer> roomMap) {
		List<Map<String,String>> chatLog = new ArrayList<>();

		for(int i = 0; i < roomMap.size(); i++) {
			int chatRoomNo = roomMap.get(i);
			Map<String,String> chat = sqlSession.selectOne("chat.selectChatLog", chatRoomNo);
//			String rnum = chat.get("rnum");
//			System.out.println(rnum instanceof String);
			chatLog.add(chat);
		}
		return chatLog;
	}
	/**
	 * 채팅방을 들어가면 보여줄 그 방의 모든 채팅 기록
	 */
	@Override
	public List<Map<String,String>> selectChattingLogs(Map<String,String> map) {
		logger.debug(map.get("sendId"));
		if(!map.get("sendId").equals("<no>")) {
			sqlSession.update("chat.updateReadFlag",map);
		}
//		int chatRoomNo = Integer.parseInt(map.get("chatRoomNo"));
		return sqlSession.selectList("chat.selectChattingLogs", map);
	}
	/**
	 * 채팅을 보내면 DB에 저장될 메소드
	 */
	@Override
	public int insertChatLog(Chat chat) {
		return sqlSession.insert("chat.insertChatLog", chat);
	}
	
}
