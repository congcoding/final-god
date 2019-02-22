<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.pageTitle}</title>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.js"></script>
<!-- 부트스트랩관련 라이브러리 -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 

<!-- 사용자작성 css -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css" />

<!-- 주소api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
 
<style>
nav.navbar-light{
	background : #117a8b;
}
.navbar-light .navbar-brand{
	color : white;
}
.navbar-light .navbar-nav .active>.nav-link{
	color : white;
}

.header-btn{
	background-color: #117a8b;
	border-color: white;
	color : white;
}
.header-btn:hover {
    background-color: #117a8b;
    border-color: white;
}

.navbar-expand-lg .btn-outline-success:hover {
	background-color: #32aeb8;
}

#modal-checkbox{
	padding-right: 252px;
}
#modal-checkbox>span{
	visibility: hidden;
}
.loginbtn{
	background : none;
	border : none;
}
.loginbtn:hover{
	color : white;
}
div.profileImage{
	border : 2px solid lightgray;
	width : 100%;
	height : 12vh;
	border-radius : 0.25em;
}
div.profileImage div#memberstatus{
	position : relative;
	left : 2.8rem; 
	bottom : 1rem;
	border-radius : 100%;
	width : 1rem;
	height : 1rem;
	padding : 0;
}
div.profileImage div#communicateWith{
	position : relative;
	left : 7rem;
	bottom : 4rem;
}
div#messagePreviewContent{
	overflow : hidden;
	text-overflow : ellipsis;
	white-space:normal;
}
div#chatView{
	width : 98%;
	margin-left : 0.25em;
	overflow: -moz-scrollbars-vertical;
	overflow-x: hidden;
	overflow-y: auto;
}
div#chatView div.messageFormatMyself{

	position : relative;
	left : 9rem;
	width : 14rem;
	text-align : right;
	border : 1px solid lightgray;
	border-radius :1em;
	/*text-overflow : clip;*/
	white-break : break-all;
}
div#chatView div.messageFormatHim{

	width : 14rem;
	text-align : left;
	border : 1px solid lightgray;
	border-radius : 1em;
	text-overflow : clip;
	white-break:normal;

}
div#socketAlert{
	display : none;
	z-index : 10;
}

</style>
</head>
<!-- chatting modal -->
		<div class="modal fade" id="chatModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content" style="height : 40em; width : 25em;" id="chatModalContent">
	    </div>
	  </div>
	</div><!-- end of chatting modal -->
<body>
<div id="socketAlert" class="alert alert-success" role="alert" ></div>
<div id="container">
   <header>
		<nav class="fixed-top navbar-expand-lg navbar-light" style="z-index : 1;">
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <!-- //collapse navbar-collapse -->
		  <div class="navbar-collapse collapse " id="navbarTogglerDemo01">
		    <a class="navbar-brand" href="${pageContext.request.contextPath}">God of Delivery</a>
		    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		      <li class="nav-item active">
		        <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">				    
		        <a class="nav-link" href="${pageContext.request.contextPath }/admin/qnaboard.do">고객센터</a>
		      </li>		    
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath }/admin/dashBoard.do">관리자</a>
		      </li>
		    </ul>
		    
		<!-- 회원 로그인,회원가입 버튼 -->
	   <c:if test="${memberLoggedIn == null}">
	   	<c:if test="${sellerLoggedIn == null}">
		<!--https://getbootstrap.com/docs/4.1/components/buttons/#outline-buttons-->
			<button class="btn btn-outline-success header-btn" type="button" data-toggle="modal" data-target="#loginModal">로그인</button> 
		 	&nbsp;  
			<button class="btn btn-outline-success header-btn" type="button" 
	     		onclick="location.href='${pageContext.request.contextPath}/chooseEnrollType.do'">회원가입</button>
		 </c:if>
		</c:if>
		
		<!-- member 로그인후  -->
		<c:if test="${memberLoggedIn != null}">
		  <c:if test="${sellerLoggedIn == null}">
		  	<!-- onclick="location.href='${pageContext.request.contextPath}/member/memberEnroll.do' -->
			<a href="${pageContext.request.contextPath}/member/memberView.do?memberId=${memberLoggedIn.memberId}">${memberLoggedIn.memberName}</a>님 안녕하세요 &nbsp;
			<button class="btn btn-outline-sucess" type="button" 
					onclick = "memberLogOut();">로그아웃</button>
		  </c:if>
		</c:if>
		
		<!-- seller 로그인후  -->
		<c:if test="${sellerLoggedIn != null}">
		  <c:if test="${memberLoggedIn == null}">
		  <!-- 알람  -->
			<ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="fas fa-bell fa-fw"></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter">3+</span>
              </a>
              <!-- Dropdown - Alerts -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                  Alerts Center
                </h6>
                
                <div class="dropdown-item d-flex align-items-center">
                  <div class="mr-3">
                    <div class="icon-circle bg-primary">
                      <i class="fas fa-file-alt text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 12, 2019</div>
                    <span class="font-weight-bold">A new monthly report is ready to download!</span>
                  </div>
                </div>
                
                
                
                <div class="dropdown-item d-flex align-items-center" >
                  <div class="mr-3">
                    <div class="icon-circle bg-success">
                      <i class="fas fa-donate text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 7, 2019</div>
                    $290.29 has been deposited into your account!
                  </div>
                </div>
              
                <div class="dropdown-item d-flex align-items-center" >
                  <div class="mr-3">
                    <div class="icon-circle bg-warning">
                      <i class="fas fa-exclamation-triangle text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 2, 2019</div>
                    Spending Alert: We've noticed unusually high spending for your account.
                  </div>
                </div>
                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
              </div>
            </li>

            <!-- 메신저 -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="fas fa-envelope fa-fw"></i>
                <!-- Counter - Messages -->
                <span class="badge badge-danger badge-counter">7</span>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown" id="messageDropdownBox" style="width : 30rem;">
             
              </div>
            </li>
            </ul>
			<a href="${pageContext.request.contextPath}/seller/sellerView.do">${sellerLoggedIn.sellerName}</a>&nbsp;사장님 안녕하세요 &nbsp;
			<button class="btn loginbtn"  type="button" onclick="location.href='${pageContext.request.contextPath}/seller/sellerLogout.do?sellerId=${sellerLoggedIn.sellerId}'">로그아웃</button>
		    &nbsp;  
		 	<button class="btn btn-outline-success header-btn" type="button" 
		 	 onclick="location.href='${pageContext.request.contextPath}/seller/goMyShop.do?sellerId=${sellerLoggedIn.sellerId}'">내가게</button> 
		  </c:if>
		</c:if>
		</div>
		</nav>
		</div>
	
   </header>

   	<!-- 로그인모달 : https://getbootstrap.com/docs/4.1/components/modal/#live-demo -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	    <!-- 1 -->
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">로그인</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <!--로그인폼 : https://getbootstrap.com/docs/4.1/components/forms/#overview -->
	      <!-- 팝업창이 생겼을때 부모창 영역을 컨트롤할 수 없는 상태를 모달이라고 한다. 제어권이 팝업에 우선으로 부여된다. 그외의 팝업창은 nonemodal이라한다. -->
          <form id="loginFrm" method="post">
	     <!-- 2 -->
	      <div class="modal-body">
			    <input type="text" class="form-control" name="memberId" placeholder="아이디" required>
			    <br />
			    <input type="password" class="form-control" name="password" placeholder="비밀번호" required>
	      </div>
	      <!-- 3 -->
	      
	      <div class="modal-footer">
	      	<div id="modal-checkbox" style="padding-right :80px">
	      		<input type="checkbox" name="login" value="mem" onclick="NoMultiChk(this);"/> &nbsp;회원
	      		<input type="checkbox" name="login" value="sell" onclick="NoMultiChk(this);"/> &nbsp;사장님
	      		<span style="color:red;">&nbsp;회원유형을 체크하세요</span>
	      	</div>
	      	<!-- 	<input type="checkbox" name="autoLogin" />  -->
	        <button type="button" class="btn btn-outline-success" onclick="check();" >로그인</button>
	      </div>
		  </form>
	    </div>
	  </div>
	</div>
	
	<script>
	function memberLogOut(){
		sessionStorage.clear();
		location.href=
			'${pageContext.request.contextPath}/member/memberLogout.do?memberId=${memberLoggedIn.memberId}';
	}
	
	function NoMultiChk(chk){
		var obj = document.getElementsByName("login");
	    for(var i=0; i<obj.length; i++){
	        if(obj[i] != chk){
	            obj[i].checked = false;
	        }
	    }
	}
	
	function check(){
		
	/*  	if($("#autoLogin :checked")){
			$("#autoLogin").val("1");
		}else{
			$("#autoLogin").val("");
		}  */
		
		var chk = $("[name='login']:checked").val();
		
		if(chk == undefined) {
			$("#modal-checkbox>span").css("visibility", "visible");
			return false;
		}
		
		if(chk === "mem"){
			$("#loginFrm").attr("action","${pageContext.request.contextPath}/member/memberLogin.do" );
			$("#loginFrm").submit();			
		}else{
			$("#loginFrm").attr("action","${pageContext.request.contextPath}/seller/sellerLogin.do" );
			$("#loginFrm").submit();
		}
		
		
	}
	
	
	 //채팅방 목록 구현
	 $("#messagesDropdown").on('click',function(){
		if($("#messagesDropdown").attr('aria-expanded') === 'false'){
			$.ajax({
				url : "${pageContext.request.contextPath}/chat/chatRoomList.do",
				data : {"sellerId" : '${sellerLoggedIn.sellerId}'},
				type : "get",
				dataType : "json",
				success : function(data){
					var mform = $("<div><h6 class='dropdown-header'>Message Center</h6></div>");
					for(var i in data){
						var messageForm = $("<div class='dropdown-item d-flex align-items-center' id='messageView"+i+" '> <div class='dropdown-list-image mr-3'><img class='rounded-circle' src='https://source.unsplash.com/fn_BT9fwg_E/60x60' alt=''><div class='status-indicator bg-success'></div></div></div>");
						var message = data[i];
						timeStamp = (message.sendtime).substring(0,16);
						
						var messageData = "<div><div class='text-truncate' id='messagePreviewContent' value="+message.chatroomno+">"+message.CHATCONTENT+"</div> <div class='small text-gray-500' id='sendPerson'  value="+message.SENDMEMBER+">"+message.SENDMEMBER+" / "+  timeStamp+"</div></div>";
						messageForm.append(messageData);
						mform.append(messageForm);
					}
						
					mform.append("<a class='dropdown-item text-center small text-gray-500' href='#'>Read More Messages</a>");
					$("#messageDropdownBox").html(mform);
				
				},
				error : function(jqxhr,textStatus,errorTrown){
					console.log("채팅 목록 가져오는중 에러 남!");
					console.log(jqxhr);
					console.log(textStatus);
					console.log(errorTrown);
				}
			});//end of ajax
		}
	 });
	 var socket = null;
	//채팅방에서 메세지 전송을 누르면 웹소켓을 통해서 메세지가 전달됨.
	$(document).on('click', 'button[id="sendMessage"]', function(evt){
			evt.preventDefault();
			sendMsgTime = getTimeStamp;
			var sendContent = $("input[name=messageContent]").val();
			
			if(sendContent.trim().length != 0){//메세지 내용이 없으면 보내지 않는다.
			var message = {
					sendId : '${sellerLoggedIn.sellerId}',
					sendContent : sendContent,
					chatRoomNo : $("input[id=sendChatRoomNo]").val(),
					
			};
			//ajax를 통해서 DB에 채팅 로그를 담음.
			 $.ajax({
				url : "${pageContext.request.contextPath}/chat/insertChatLog.do",
				data : message,
				success : function(data){
					 
				 	messageData = "<div class='messageFormatMyself' ><div class='text-truncate' id='messageContentShow' value="+message.chatRoomNo+">"+message.sendContent+"</div> <div class='small text-gray-500' id='sendPerson'>"+message.sendId+" / "+  sendMsgTime +"</div></div>";
			 		$("#chatView").append(messageData);
			 		setTimeout(function(){
		 				$("#chatView").scrollTop($("#chatView")[0].scrollHeight);
		 			},100);
			 		
				},
				error : function(jqxhr,textStatus,errorTrown){
		 			console.log("작성한 채팅을 데이터베이스에 넣을때  에러 남!");
					console.log(jqxhr);
					console.log(textStatus);
					console.log(errorTrown);
		 		}
			});//end of ajax
			if(socket.readyState !== 1) return;
			sendMessage();
			}
	});
	//1. cmd(채팅),메세지 보낸자 ,메세지 받는자, 메세지 내용 (축소), 채팅방 번호, 보낸시간 ex) chat,sendUser,receiver,messageContent , chatRoomNo, sendTime
	function sendMessage(){
		
		var msg ={};
		msg.cmd = "chat";
		msg.sender = "${sellerLoggedIn.sellerId}";
		msg.receiver = $("#communicateWith").text();
		msg.content =  $("input[name='messageContent']").val();
		msg.chatRoomNo = $("input[id=sendChatRoomNo]").val();
		msg.sendTime = getTimeStamp();
		sendMsgTime = msg.sendTime;
		
		socket.send(JSON.stringify(msg));
		$("input[name=messageContent]").val("");
	}

	function getTimeStamp() {
		   var date = new Date();
		   var s =
		     leadingZeros(date.getFullYear(), 4) + '-' +
		     leadingZeros(date.getMonth() + 1, 2) + '-' +
		     leadingZeros(date.getDate(), 2) + ' ' +

		     leadingZeros(date.getHours(), 2) + ':' +
		     leadingZeros(date.getMinutes(), 2)
			
		   return s;
		}

		 function leadingZeros(n, digits) {
		   var zero = '';
		   n = n.toString();

		   if (n.length < digits) {
		     for (i = 0; i < digits - n.length; i++)
		       zero += '0';
		   }
		   return zero + n;
		 }


	$(document).ready(function(){
		 connectWebSocket();
	});
	 
	//개별 상세 채팅방 구현
	 $(document).on('click', 'div[id^="messageView"]', function(){
		 	var chatroominfo ={
		 						chatRoomNo : $(this).children().eq(1).children("#messagePreviewContent").attr('value'),
		 						sendId : $(this).children().eq(1).children("#sendPerson").attr('value')!='${sellerLoggedIn.sellerId}'?$(this).children().eq(1).children("#sendPerson").text():"<no>"
		 					};
		 	$("#chatModal").modal('show');
		 	
		 	$.ajax({
		 		url : "${pageContext.request.contextPath}/chat/chattingLog.do",
		 		data : chatroominfo,
		 		success : function(data){
		 			successLodingChatLogs(data);
		 			setTimeout(function(){
			 			$("#chatView").scrollTop($("#chatView")[0].scrollHeight);
			 		},150);
		 			
				},
		 		error : function(jqxhr,textStatus,errorTrown){
		 			console.log("채팅 기록을 가져오는중 에러 남!");
					console.log(jqxhr);
					console.log(textStatus);
					console.log(errorTrown);
		 		},
		 		complete : function(){
		 		}
		 	});//end of ajax
		 	
	 });
	 
	 function successLodingChatLogs(data){
		 var myId = '${sellerLoggedIn.sellerId}';
			var chatForm = $("<div style='height : 100%; padding: 0'></div>");
			var chatHeader = $("<div class='modal-header'> <h5 class='modal-title' id='exampleModalLabel'></h5>	<div class='profileImage'><img class='rounded-circle' src='https://source.unsplash.com/fn_BT9fwg_E/60x60' alt=''><div class='status-indicator bg-success' id='memberstatus'></div><div id='communicateWith'>"+ (myId != data[0].SELLERID2 ? data[0].SELLERID2 : data[0].SELLERID) +"</div></div><button type='button' class='close' data-dismiss='modal' aria-label='Close' style='padding : 0.1em;'><span aria-hidden='true'>&times;</span></button></div>");
			var chatBody = $("<div class='shadow rounded border border-success' id='chatView' style='height : 25rem;' ></div>");
			var chatFooter = $("<div class='modal-footer' style='width : 100%;'><input type='hidden' id='sendChatRoomNo' value="+data[0].chatRoomNo+" /><input type='text' class='form-control' name='messageContent' placeholder='메세지를 입력하세요.' id='messageContent' /><button type='button' class='btn btn-outline-success' id='sendMessage'>전송</button></div> ");
			for(var i in data){
				//console.log(data[i]);
					messageType = data[i];
					timeStamp = (messageType.sendTime).substring(0,16);
				if(data[i].SENDMEMBER == myId){
					 messageData = "<div class='messageFormatMyself' ><div class='text-truncate' id='messageContentShow' value="+messageType.chatRoomNo+">"+messageType.CHATCONTENT+"</div> <div class='small text-gray-500' id='sendPerson'>"+messageType.SENDMEMBER+" / "+  timeStamp +"</div></div>";
				}else{
					 messageData = "<div class='messageFormatHim' ><div class='text-truncate' id='messageContentShow' value="+messageType.chatRoomNo+">"+messageType.CHATCONTENT+"</div> <div class='small text-gray-500' id='sendPerson'>"+messageType.SENDMEMBER+" / "+ timeStamp +"</div></div>";
				}
				chatBody.append(messageData);
			}
				
			chatForm.html(chatHeader);
			chatForm.append(chatBody);
			chatForm.append(chatFooter);
			$("#chatModalContent").html(chatForm);
			hasFocusRoom = $("#sendChatRoomNo").val();
	 }
	var sendMsgTime = null;
	var alertType = null ;
	var messageType = null;
	 //사용자가 어느 채팅방에 들어가 있는지 확인하는 변수
	var hasFocusRoom = 0;
	var messageData = "";
	var timeStamp;
	 function receiveMessage(alertType,messageType){
		console.log("메세지 전송 후 : "+alertType+" : "+messageType);
		 // 받는 사람이 현재 그 채팅방을 보고 있으면 알람을 주지 않고 메세지를 보냄.
		 if(hasFocusRoom === messageType.chatRoomNo){
			 if(messageType.sender === '${sellerLoggedIn.sellerId}'){
				 messageData = "<div class='messageFormatMyself' ><div class='text-truncate' id='messageContentShow' value="+messageType.chatRoomNo+">"+messageType.content+"</div> <div class='small text-gray-500' id='sendPerson'>"+messageType.sender+" / "+  (messageType.sendTime) +"</div></div>";
			}else{
				 messageData = "<div class='messageFormatHim' ><div class='text-truncate' id='messageContentShow' value="+messageType.chatRoomNo+">"+messageType.content+"</div> <div class='small text-gray-500' id='sendPerson'>"+messageType.sender+" / "+  (messageType.sendTime) +"</div></div>";
			}
			
			
			 $("#chatView").append(messageData);
			 setTimeout(function(){
		 			$("#chatView").scrollTop($("#chatView")[0].scrollHeight);
		 	},150);
		 }else{
			 $("#socketAlert").css("display","block").text(alertType.sender+"님이 "+alertType.content+"라고 보냄");
		 		
		 		setTimeout(function(){
		 			$("#socketAlert").css("display","none");
		 		},3000); 
		 }
		 
	 }
	 function connectWebSocket(){
	 	var ws = new SockJS("<c:url value="/echo"/>"); 
	 	socket = ws;
	 	ws.onopen = function(){
	 		console.log("Info : connection opened.");
	 	};
	 	ws.onmessage = function(event){
	 		alertType = null;
	 		messageType = null;
	 		var message = JSON.parse(event.data);
	 		console.log("소켓 갔다와서 : "+message);
	 		for(var i = 0; i < message.length; i++){
		 		if(message[i].cmd === "alert")
		 			  alertType = message[i];
		 		else 
		 			 messageType = message[i];
	 		}
	 		if(alertType != null && messageType != null){
		 		receiveMessage(alertType,messageType);
	 		}
	 		
	 	};
	 	ws.onclose = function(event){
	 		console.log("Info : connection closed.");
	 	};
	 	ws.onerror = function(err){
	 		console.log("Error : ",err);
	 	}; 
	 	
	 }
	
	</script>
   <section id="content">