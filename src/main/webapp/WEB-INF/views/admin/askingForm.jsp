<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>

<style>
div#board-container input{width:400px; margin:0 auto; text-align:center;}
div#board-container div{width:400px; margin:0 auto; }

table#tbl-board tr th{text-align:center;}
table#tbl-board tr td{text-align:center;}
a {text-decoration:none;}
div#head-container{margin:70px auto; width : 900px; height:50px;}
div#qna{margin-left : -40px; width : 450px; height : 50px; text-align : center; font-weight : bold;cursor : pointer;display: table-cell;vertical-align: middle;}
div#asking{margin-top:-50px; margin-left : 500px; width : 450px; height : 50px; text-align : center; font-weight : bold; cursor : pointer;display: table-cell;vertical-align: middle;}
input#boardTitle{font-weight : bold;}
form{width:500px; margin:0 auto;}
form input#askbtn{margin-left:200px;}
</style>
<script>
function fn_goAskingList(){
	if("${memberLoggedIn }" != ""){
		var memberId= "${memberLoggedIn.memberId }";
		location.href = "${pageContext.request.contextPath}/admin/askingList.do?boardWriter="+memberId;	
	}else if("${sellerLoggedIn }" != ""){
		var sellerId = "${sellerLoggedIn.sellerId }";
		location.href = "${pageContext.request.contextPath}/admin/askingList.do?boardWriter="+sellerId;
	}else if("${sellerLoggedIn }" == "" && "${memberLoggedIn }" == ""){
		alert("로그인 후 이용 가능합니다.");
		return;
	}
}
function fn_goQnaList(){
	location.href = "${pageContext.request.contextPath}/admin/qnaboard.do";
}
function insertValidate(){
	return true;
}

</script>


<div id="head-container">
	<div id="qna" class="alert-light" onclick="fn_goQnaList();">FAQ</div> <div id="asking" class="alert-info" onclick="fn_goAskingList();">1:1문의</div>
</div>

 		<form name="askingForm" action="${pageContext.request.contextPath }/admin/insertAsking.do" method="post" onsubmit="return insertValidate();">
			<input type="text" class="form-control" placeholder="제목" name="boardTitle" id="boardTitle">
			<br />
		 	<input type="text" class="form-control" name="boardWriter" id="boardWriter" value="${param.boardWriter }" readOnly />
		 	<br />
			<textarea class="form-control" name="boardContent" id="boardContent" placeholder="내용" style="height:300px;" ></textarea>
			<br />
			<input type="submit" class="btn btn-outline-success" id="askbtn" value="문의하기" >
		</form>
		
		

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>