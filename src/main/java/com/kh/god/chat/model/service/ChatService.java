package com.kh.god.chat.model.service;

import java.util.List;
import java.util.Map;

import com.kh.god.chat.model.vo.Chat;

public interface ChatService {
	List<Map<String,String>> selectChatRoomList(String sellerId);

	List<Map<String,String>> selectChattingLogs(Map<String, String> map);

	int insertChatLog(Chat chat);

}
