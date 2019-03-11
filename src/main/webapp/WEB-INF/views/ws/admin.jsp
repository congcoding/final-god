<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>

<!-- Custom fonts for this template-->
<link href="${pageContext.request.contextPath }/resources/css/fontawesome-free/css/all.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${pageContext.request.contextPath }/resources/css/sb-admin-2.css" rel="stylesheet">

<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.6.0/moment.min.js"></script>

<script>
$(function(){
	$("#collapsePages").addClass("show");	
	$("#stompControl").addClass("active");	
	$("#toDoList").addClass("active");	
});

function getMoment(time){
	var date = moment("/Date("+time+")/").format("YYYY/MM/DD HH:mm:ss").toString();
	return date;
}

$(document).ready(function() {
	$('#exampleModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var chatId = button.data('chatid');
		var memberId = button.data('memberid');
		var modal = $(this);
		modal.find('.modal-title').text(memberId);
		modal.find('.modal-body').html('<iframe id="frame" src="/god/ws/adminChat.do/'+chatId+'" frameborder="0" width="420" height="450" marginwidth="0" marginheight="0"></iframe>')
	}).on('hidden.bs.modal', function (event) {
		location.reload();
	});
})
</script>

<style>
div#chatroom-container{display:inline-block; width:700px; height:500px; overflow-y:scroll}
div#chat-wrapper{display:inline-block; margin:0 auto; width:430px; height:700px;}
li.chatAdmin{background-color:#32aeb8; border:1px solid lightgray; border-radius:10px; padding:5px; margin:5px; display:table; float:right; clear:both;}
li.chatUser{border:1px solid lightgray; border-radius:10px; padding:5px; margin:5px; display:table; float:left; clear:both;}
table#chatTable th{vertical-align:middle; text-align:center;}
table#chatTable td{vertical-align:middle;}
</style>

<!-- Page Wrapper -->
  <div id="wrapper">

	<jsp:include page="/WEB-INF/views/admin/sideBar.jsp"></jsp:include>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-4 text-gray-800">채팅 문의 관리</h1>
          
          <div id="chatroom-container">
          <table class="table" id="chatTable">
			  <thead>
			    <tr>
			      <th scope="col">회원아이디</th>
			      <th scope="col">최근메세지</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${recentList }" var="m" varStatus="vs">
			    <tr>
			      <td>
			      	<button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#exampleModal" data-chatid="${m.CHATID}" data-memberid="${m.MEMBERID}">
			  			${fn:substring(m.MEMBERID,0,20) } <span class="badge badge-primary badge-pill">${m.CNT }</span>
					</button>
			      </td>
			      <td>
			      	<c:if test="${fn:length(m.MSG)>22}">${fn:substring(m.MSG,0,22)}...</c:if>
			      	<c:if test="${fn:length(m.MSG)<=22}">${m.MSG}</c:if>
			      </td>
			    </tr>
			  </c:forEach>
		  	</tbody>
		  </table>
		  </div>
		  
	    <!-- Modal시작 -->
		<!-- https://getbootstrap.com/docs/4.1/components/modal/#live-demo -->
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel"></h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body" style="text-align:center; height:500px;">

		      </div>
		    </div>
		  </div>
		</div>
		<!-- Modal 끝-->
		
        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->