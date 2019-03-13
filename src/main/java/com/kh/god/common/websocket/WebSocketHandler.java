package com.kh.god.common.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.kh.god.chat.controller.ChatController;
import com.kh.god.seller.controller.SellerController;

public class WebSocketHandler  extends TextWebSocketHandler{
	//강제 로그아웃 때문에 필요
	@Autowired
	SellerController sellerController;
	@Autowired
	ChatController chatController;
	private final Logger logger = Logger.getLogger(getClass());
	private Map<String,String> loginSession;
	//메세지는 날려줄 웹소켓 전용
	private static List<WebSocketSession> sessionList;
	//실제 로그인한 HttpServletSession의 아이디정보, session정보
	private static Map<String,WebSocketSession> userSession;
	//실제 session의 아이디정보 유저정보
	private static List<String> userInfo;
	
	private WebSocketHandler() {
		userSession = new HashMap<>();
		sessionList = new ArrayList<>();
		userInfo = new ArrayList<>();
	}
	
	public static WebSocketHandler getInstance() {
		return LazyHolder.INSTANCE;
	}
	private static class LazyHolder{
		private static final WebSocketHandler INSTANCE = new WebSocketHandler();
	}
	
	public Map<String,WebSocketSession> getUserList(){
		return userSession;
	}
	public List<WebSocketSession> getSessionList(){
		return sessionList;
	}
//	public void setUserList(String loginId,WebSocketSession session) {
//		userSession.put(loginId,session);
//	}
	//※클라이언트 연결 된 후
		//WebSocketSession을 매개 변수로 받고 클라이언트가 연결된 후 
		//해당 클라이언트의 정보를 가져와 연결확인 작업을한다.
		//클라이언트의 세션을 세션 저장 리스트에 add()로 추가 한다.
		// afterConnectionEstablished : 웹소켓이 연결되면 호출되는 함수
		// 웹소켓이 연결 되는 것 = 프론트에서 웹소켓이 정확한 경로를 잡아 생성 되는 것
	    @Override
	    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	        sessionList.add(session);
	        logger.info("afterConnectionEstablished: "+session);
	        
	        userSession.put(getId(session),session);
	        userInfo.add(getId(session));
	        logger.debug("유저목록 리스트(로그인,비로그인) : "+sessionList+" : "+userInfo);
	        logger.debug("유저목록 리스트(로그인) : "+getUserList()+" : "+getUserList().size());
	    }
	    
	 
	//※클라이언트와 연결이 끊어진 경우
	//add()와 반대로 remove()를 이용해서 세션리스트에서 제거한다.
	    @Override
	    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	        logger.debug("연결이 끊어 집니다. 리스트에서 사라질 ID : "+getId(session));
	        userSession.remove(getId(session));
	        userInfo.remove(getId(session));
	    	sessionList.remove(session);
//	    	userList.remove(getId(session));
	    }
	 
	// 웹 소켓 서버로 데이터를 전송했을 경우
	//연결된 모든 클라이언트에게 메시지 전송 : 리스트
	//연결된 모든 사용자에게 보내야 하므로 for문으로 세션리스트에 있는 모든 세션들을 돌면서
	// sendMessage()를 이용해 데이터를 주고 받는다.
	  
	    @Override
	    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	    	
//	    	String senderId = getId(session);
//	    	for (WebSocketSession sess : sessionList) {
//	    		//문자열의 형태 : 문자 !%/ 대상 !%/ 방이름
//	        	logger.info("메세지를 전송합니다. :"+message.getPayload());
//	            sess.sendMessage(new TextMessage(senderId +":"+message.getPayload()));
//	        }
	    	
//	    	protocol : 
//	    	1. cmd(채팅),메세지 보낸자 ,메세지 받는자, 메세지 내용 (축소), 채팅방 번호, 보낸시간 ex) chat,sender,receiver,content , chatRoomNo, sendTime
//	    	2. cmd(리뷰),리뷰 작성자, 가게이름, 가게번호, 가게사장아이디 ex) review,writer,storeName,storeNo,sellerId
	    	String msg = message.getPayload();
//	    	알람 식별 JSON
	    	Map<String, String> alertMap = new HashMap<>();
//	    	메세지 식별 JSON
	    	Map<String,String> messageMap = new HashMap<>();
	    	List<Map<String,String>> sendInfo = new ArrayList<>();
	    	List<String> connectInfo = new ArrayList<>();
	    	logger.debug("서버에 보낸 메세지 정보 : "+msg);
	    	if(!StringUtils.isEmpty(msg)) {
	    		String[] strs = msg.split(",");
	    		if(strs != null && strs.length == 8) {//채팅
	    			String[] cmd = strs[0].substring(strs[0].indexOf(":")+2).split("\"");
	    			String[] sendId = strs[1].substring(strs[1].indexOf(":")+2).split("\"");
	    			String[] receiver = strs[2].substring(strs[2].indexOf(":")+2).split("\"");
	    			String[] sendContent = strs[3].substring(strs[3].indexOf(":")+2).split("\"");
	    			String[] chatRoomNo = strs[4].substring(strs[4].indexOf(":")+2).split("\"");
	    			String[] sendTime = strs[5].substring(strs[5].indexOf(":")+2).split("\"");
	    			String[] currentFocusRoom = strs[6].substring(strs[6].indexOf(":")+2).split("\"");
	    			String[] DBFlag = strs[7].substring(strs[7].indexOf(":")+2).split("\"");
	    			alertMap.put("sender", sendId[0]);
	    			alertMap.put("cmd", "alert");
	    			alertMap.put("content", sendContent[0]);
	    			alertMap.put("DBFlag", DBFlag[0]);
	    			messageMap.put("DBFlag", DBFlag[0]);
	    			messageMap.put("sender", sendId[0]);
	    			messageMap.put("content", sendContent[0]);
	    			messageMap.put("chatRoomNo", chatRoomNo[0]);
	    			messageMap.put("receiver", receiver[0]);
	    			messageMap.put("sendTime", sendTime[0]);
	    			messageMap.put("currentFocusRoom", currentFocusRoom[0]);
	    			WebSocketSession chatReceiverSession =  userSession.get(receiver[0]);
	    			/**
	    			 * 여기서 받는 사람이 실시간으로 접속중이라면  if문이 동작하고 갔다가 포커싱되고있는 방번호를 받아와서디비에 저장., 받는사람이 접속중이 아니라면
	    			 * 그냥 DB에 저장 할  것이다.
	    			 */
	    			if("Y".equals(DBFlag[0])) {
	    				chatController.insertChatLog(sendId[0], sendContent[0], chatRoomNo[0], Integer.parseInt(currentFocusRoom[0]));
	    			}
//	    			상대방이 접속해 있을 때 바로 실시간으로 보여주기 위한 것.
	    			if("chat".equals(cmd[0]) && chatReceiverSession != null) {
	    				//로직 설명 : 처음에 사용자가 보내서 받는이가 온라인인지 확인한다. 확인이 되면 바로 저장하는게아니라 상대방이 현재 포커싱하고 있는 방번호를 가지고 온다. 그 다음에 DB에 저장.
	    				if("N".equals(DBFlag[0])) {
	    					messageMap.put("cmd", "chat");
	    					sendInfo.add(messageMap);
	    					sendInfo.add(alertMap);
	    					Gson gson = new Gson();
	    					String sendGson = gson.toJson(sendInfo);
	    					logger.debug(sendGson);
	    					TextMessage tmpMsg = new TextMessage(sendGson);
	    					logger.debug("다시 클라이언트로 보내기전 : " + tmpMsg);
	    					chatReceiverSession.sendMessage(tmpMsg);
	    				}
	    			}else {
	    				//offline이므로 그냥 DB에만 저장.
	    				chatController.insertChatLog(sendId[0], sendContent[0], chatRoomNo[0], Integer.parseInt(currentFocusRoom[0]));
	    			}
// 					접속해 있거나  접속해있지않아도  DB에 넣음.
	    			
	    		}else if(strs != null && strs.length == 5) {//리뷰
	    			String[] cmd = strs[0].substring(strs[0].indexOf(":")+2).split("\"");
	    			String[] reviewWriter = strs[1].substring(strs[1].indexOf(":")+2).split("\"");
	    			String[] storeName = strs[2].substring(strs[2].indexOf(":")+2).split("\"");
	    			String[] storeNo = strs[3].substring(strs[3].indexOf(":")+2).split("\"");
	    			String[] receiver = strs[4].substring(strs[4].indexOf(":")+2).split("\"");
	    			logger.debug("받는 아이디 :"+receiver[0]);
	    			alertMap.put("reviewWriter", reviewWriter[0]);
	    			alertMap.put("cmd", cmd[0]);
	    			alertMap.put("storeName", storeName[0]);
	    			alertMap.put("storeNo", storeNo[0]);
	    			sendInfo.add(alertMap);
	    			Gson gson = new Gson();
	    			String sendGson = gson.toJson(sendInfo);
	    			WebSocketSession reviewSendSession =  userSession.get(receiver[0]);
	    			if("review".equals(cmd[0]) && reviewSendSession != null) {
	    				TextMessage tmpMsg = new TextMessage(sendGson);
	    				reviewSendSession.sendMessage(tmpMsg);
	    			}
	    		}else if(strs != null && strs.length == 1) {//실시간 사용자 받아오기
	    			String[] cmd = strs[0].substring(strs[0].indexOf(":")+2).split("\"");
	    			alertMap.put("cmd", cmd[0]);
	    			if(cmd[0].equals("realTimeMember")) {
	    				connectInfo.add(cmd[0]);
	    				for(int i = 0; i < userInfo.size(); i++) {
	    					connectInfo.add(userInfo.get(i));
	    				}
	    			}
	    			Gson gson = new Gson();
	    			String sendGson = gson.toJson(connectInfo);
	    			logger.debug("다시 나에게로 돌아가기전 : "+connectInfo);
	    			for (WebSocketSession sess : sessionList) {
	    	        	TextMessage tmpMsg = new TextMessage(sendGson);
	    	            sess.sendMessage(tmpMsg);
	    	        }
	    			
	    		}else if(strs != null && strs.length == 2) {//강제 로그아웃 요청
	    			String[] cmd = strs[0].substring(strs[0].indexOf(":")+2).split("\"");
	    			String[] removeId = strs[1].substring(strs[1].indexOf(":")+2).split("\"");
	    			WebSocketSession reviewSendSession =  userSession.get(removeId[0]);
	    			WebSocketSession webSocket = userSession.get(removeId[0]);
	    			Gson gson = new Gson();
	    			connectInfo.add(cmd[0]);
	    			String sendGson = gson.toJson(connectInfo);
	    			//다른 브라우져에서 로그인 되어있는 것을 강제 로그아웃 시킨다.
	    			userSession.put(webSocket.getId(),webSocket);
	    			logger.debug("기존에있던 유저를 지우지않고  : "+userSession);
	    			userSession.remove(removeId[0]);
	    			logger.debug("기존에있던 유저를 지우고  : "+userSession);
	    			userInfo.remove(removeId[0]);
	    			//userSession.put(null, webSocket);
	    			if("forcedlogout".equals(cmd[0]) && reviewSendSession != null) {
	    				TextMessage tmpMsg = new TextMessage(sendGson);
	    				reviewSendSession.sendMessage(tmpMsg);
	    			}
	    			
	    			//강제 로그아웃 시킬 아이디 값을 통해서 DB에 저장된 sessionId값을 가지고 온다.
//	    			Seller sellerVO = sellerController.selectSellerBySellerId(removeId[0]);
//	    			loginSession = SellerController.getInstance().getLoginSession();
//	    			HttpSession logout = loginSession.get(sellerVO.getSessionKey());
//	    			SessionStatus sessionStatus;
	    			
					//sellerController.logout(sessionStatus, sellerVO.getSellerId(), logout, request, response);
	    		    
	    		}else if(strs != null && strs.length == 4) {//신고
	    			String[] cmd = strs[0].substring(strs[0].indexOf(":")+2).split("\"");
	    			String[] reportWriter = strs[1].substring(strs[1].indexOf(":")+2).split("\"");
	    			String[] reportType = strs[2].substring(strs[2].indexOf(":")+2).split("\"");
	    			String[] receiver = strs[3].substring(strs[3].indexOf(":")+2).split("\"");
	    			if(cmd[0].equals("report")) {
	    				if(reportType[0].equals("storeReport")) reportType[0] = "가게 신고";
	    				else if(reportType[0].equals("reviewReport")) reportType[0] = "리뷰 신고";
	    			}
	    			logger.debug("받는 아이디 :"+receiver[0]+" 신고 타입 : "+reportType[0]);
	    			alertMap.put("reportWriter", reportWriter[0]);
	    			alertMap.put("cmd", cmd[0]);
	    			//신고일 때는 신고 유형, 가게 신청일 땐 가게 이름이 된다.
	    			alertMap.put("reportType", reportType[0]);
	    			sendInfo.add(alertMap);
	    			Gson gson = new Gson();
	    			String sendGson = gson.toJson(sendInfo);
	    			WebSocketSession reviewSendSession =  userSession.get(receiver[0]);
	    			if("report".equals(cmd[0]) && reviewSendSession != null) {
	    				TextMessage tmpMsg = new TextMessage(sendGson);
	    				reviewSendSession.sendMessage(tmpMsg);
	    			}
	    		}else if(strs != null && strs.length == 3) {//상대방이 채팅방을 보고있는지(상대방이 온라인이면 상대방한테 보내고 오프라인이면 보낸이한테 다시 보냄)
	    			String[] cmd = strs[0].substring(strs[0].indexOf(":")+2).split("\"");
	    			String[] chatSender = strs[1].substring(strs[1].indexOf(":")+2).split("\"");
	    			String[] receiver = strs[2].substring(strs[2].indexOf(":")+2).split("\"");
	    			messageMap.put("cmd",cmd[0]);
	    			messageMap.put("sender",chatSender[0]);
	    			messageMap.put("receiver",receiver[0]);
	    			Gson gson = new Gson();
	    			WebSocketSession messageReceiverSession =  userSession.get(receiver[0]);
	    			if("report".equals(cmd[0]) && messageReceiverSession != null) {//상대방이 온라인일 때
	    				messageMap.put("onlineFlag","Y");
	    				String sendGson = gson.toJson(messageMap);
	    				TextMessage tmpMsg = new TextMessage(sendGson);
	    				messageReceiverSession.sendMessage(tmpMsg);
	    			}else {//상대방이 오프라인일 때.
	    				WebSocketSession senderSession = userSession.get(chatSender[0]);
	    				messageMap.put("onlineFlag","N");
	    				String sendGson = gson.toJson(messageMap);
	    				TextMessage tmpMsg = new TextMessage(sendGson);
	    				senderSession.sendMessage(tmpMsg);
	    				
	    			}
	    		}
	    		//메세지를 받았을 때 프로토콜
	    		
	    		
	    	}//end of if(!StringUtils.isEmpty(msg)) 비었는지.
	    }
	

	public String getId(WebSocketSession session) {
		loginSession = SellerController.getInstance().getLoginSession();
		logger.debug("getId의 sessionId의 값 : "+loginSession.get(session.getAttributes().get("loginId")));
		String loginMember = "";
		try {
			loginMember = (String)session.getAttributes().get("loginId");
		}catch(Exception e) {
//			e.printStackTrace();
			return session.getId();
		}
		
		return loginMember;
		
	}
}
