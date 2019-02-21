package com.kh.god.chat.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.god.chat.model.vo.Chat;
import com.kh.god.chat.model.vo.ChatRoom;

public interface ChatDao {

	List<ChatRoom> selectChatRoomList(String sellerId);

	List<Map<String,String>> selectChatLog(Map<Integer, Integer> roomMap);

	List<Map<String,String>> selectChattingLogs(Map<String, String> map);

	int insertChatLog(Chat chat);

}
