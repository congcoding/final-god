package com.kh.god.chat.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.god.chat.model.service.ChatService;
import com.kh.god.chat.model.vo.Chat;
import com.kh.god.chat.model.vo.ChatRoom;
import com.kh.god.seller.model.vo.Seller;



@Controller
public class ChatController {
	Logger logger = Logger.getLogger(getClass());
	@Autowired
	ChatService chatService;
	
//	public ModelAndView chatRoom(ModelAndView mav, HttpServletRequest request) {
//		logger.debug("채팅방에 들어옴 :  "+new Date());
//		Member m = 	(Member)request.getSession().getAttribute("userId");
//		String msg = "";
//		String view = "";
//		String loc = "";
//		if(m == null) {
//			loc = "/";
//			view = "common/msg";
//			msg = "로그인을 하신 후 이용할 수 있습니다.";
//			mav.addObject("loc", loc);
//			mav.addObject("msg", msg);
//			mav.setViewName(view);
//		}else {
//			
//		}
//		return mav;
//	}
	/**
	 * 채팅방 리스트와 각각의 채팅방리스트의 마지막 채팅 내용을 보여줄 데이터를 가져옴
	 * @param sellerId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/chat/chatRoomList.do",method=RequestMethod.GET)
	public List<Map<String,String>> chatRoomList(@RequestParam String sellerId) {
		List<Map<String,String>> chatRoom = chatService.selectChatRoomList(sellerId);
		return chatRoom;
	}
	/**
	 * 선택해서 들어간 채팅방의 채팅 기록을 보여줌.
	 * @param chatRoomNo
	 * @param sendId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/chat/chattingLog.do",method=RequestMethod.GET)
	public List<Map<String,String>> chattingLog(@RequestParam String chatRoomNo,@RequestParam String sendId){
		logger.debug("chattingLog 채팅 기록 가져오기전 받은 파라미터값들 : "+chatRoomNo+" : "+sendId);
		Map<String,String> map = new HashMap<>();
		map.put("chatRoomNo",chatRoomNo);
		map.put("sendId",sendId);
		
		List<Map<String,String>> chatLog = chatService.selectChattingLogs(map); 
		logger.debug(chatLog);
		return chatLog;
	}
	/**
	 * 전송한 채팅을 DB에 넣고 갱신된 채팅기록을 가져옴.
	 * @param sendId
	 * @param sendContent
	 * @param chatRoomNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/chat/insertChatLog.do")
	public int insertChatLog(@RequestParam String sendId,@RequestParam String sendContent, @RequestParam String chatRoomNo){
		logger.debug("insertChatLog 저장할  채팅 : "+sendId +": "+chatRoomNo+":"+sendContent );
//		Map<String,String> chat = new HashMap<>();
//		chat.put("sendId",sendId);
//		chat.put("sendContent",sendContent);
//		chat.put("chatRoomNo",chatRoomNo);


		Date date = new java.sql.Date(System.currentTimeMillis());
		logger.debug("현재 시간 : "+date);
		Chat chat = new Chat();
		chat.setChatContent(sendContent);
		chat.setChatRoomNo(Integer.parseInt(chatRoomNo));
		chat.setSendMember(sendId);
		chat.setSendTime(date);
		
		int result = chatService.insertChatLog(chat);
		
		return result;
	}
	@ResponseBody
	@RequestMapping(value="/chat/searchPerson.do")
	public List<Seller> searchPerson(@RequestParam String searchId) {
		logger.debug("찾을 사람의 ID : "+searchId);
		List<Seller> sellerId = chatService.searchPerson(searchId);
		logger.debug(sellerId);
		return sellerId;
	}
	@ResponseBody
	@RequestMapping(value="/chat/addPerson.do")
	public List<Map<String,String>> addPerson(@RequestParam(name="addId") String addId , @RequestParam(name="loginId") String loginId) {
		logger.debug("addPerson searchId: "+addId + " : "+loginId);
		ChatRoom roomId = new ChatRoom();
		roomId.setSellerId(loginId);
		roomId.setSellerId2(addId);
		List<Map<String, String>> result = null;
		result = chatService.addPerson(roomId);
		
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/chat/notReadMessage.do")
	public String notReadMessage(@RequestParam(name="sellerId") String sellerId) {
		String notReadCount = chatService.notReadMessage(sellerId);
		logger.debug(notReadCount);
		return notReadCount;
	}
}

