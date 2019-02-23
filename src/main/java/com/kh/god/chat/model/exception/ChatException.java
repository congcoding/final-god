package com.kh.god.chat.model.exception;

import com.kh.god.chat.model.vo.ChatRoom;

public class ChatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ChatException() {
		super();
	}
	public ChatException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ChatException(String message) {
		super(message);
	
		// TODO Auto-generated constructor stub
	}

	public ChatException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
