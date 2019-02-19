<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="고객센터" name="pageTitle"/>
</jsp:include>
<style>
/*글쓰기버튼*/
input#btn-add{float:right; margin: 0 0 15px;}
table#tbl-board tr th{text-align:center;}
table#tbl-board tr td{text-align:center;}
section#board-container{height:700px;}
a {text-decoration:none;}
table#tbl-board{ width : 500px; margin:-35px auto;}
div#head-container{margin:70px auto; width : 900px; height:50px;}
div#qna{margin-left : -40px; width : 450px; height : 50px; text-align : center; font-weight : bold;cursor : pointer;display: table-cell;vertical-align: middle;}
div#asking{margin-top:-50px; margin-left : 500px; width : 450px; height : 50px; text-align : center; font-weight : bold; cursor : pointer;display: table-cell;vertical-align: middle;}
div#pageBar{margin:35px auto;}
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
function validate(){
	if("${memberLoggedIn }" != ""){
		var memberId= "${memberLoggedIn.memberId }";
		location.href = "${pageContext.request.contextPath}/admin/askingForm.do?boardWriter="+memberId;	
	}else if("${sellerLoggedIn }" != ""){
		var sellerId = "${sellerLoggedIn.sellerId }";
		location.href = "${pageContext.request.contextPath}/admin/askingForm.do?boardWriter="+sellerId;
	}

}
</script>

<section id="board-container" class="container">
<!-- 전체 게시글 출력 -->
	
<div id="head-container">
	<div id="qna" class="alert-light" onclick="fn_goQnaList();">FAQ</div> <div id="asking" class="alert-info" onclick="fn_goAskingList();">1:1문의</div>
</div>
<section id="board-container" class="container">
<!-- 전체 게시글 출력 -->
	<table id="tbl-board" class="table table-borderless table-hover">
		<thead class="thead-light">
			<tr>
				<th>내가 한 질문</th>
				<th>답변</th>
			</tr>
		</thead>
		<c:if test="${not empty list}">
			<c:forEach items="${list }" var="b">
		<tbody>
		<tr>
			<td><a href="${pageContext.request.contextPath }/admin/askingView.do?boardNo=${b.boardNo } ">${b.boardTitle }</a></td>
			<td></td>
		</tr>
		<c:if test="${not empty boardRefList }">
			<c:forEach items="${boardRefList }" var="ref">
				<c:if test="${b.boardNo == ref.boardRef}">
					<tr>
						<td></td>
						<td><a href="${pageContext.request.contextPath }/admin/answeringView.do?boardNo=${ref.boardNo }&boardRef=${ref.boardRef } ">답변보러가기</a></td>
					</tr>
				</c:if>
				<c:if test="${b.boardNo != ref.boardRef}">
					<td></td>
					<td>문의중</td>
				</c:if>
			</c:forEach>
		</c:if>
		</tbody>
			</c:forEach>
		</c:if>
		<c:if test="${empty list}">
		<tbody>
			<tr>
				<td colspan="4">질문이존재하지 않습니다!</td>
			</tr>
		</tbody>
		</c:if>
	
	 </table>
	 
	
	<%
		int totalContents = (int)request.getAttribute("totalContents");
		int numPerPage = (int)request.getAttribute("numPerPage");
		int cPage = (int)request.getAttribute("cPage");
	%>

	<div id="pageBar">
	<%=com.kh.god.common.util.Utils.getPerBar(totalContents,cPage,numPerPage,"qnaboard.do") %>
	</div>
	<!-- 페이지바  -->
	 	<input type="button" class="btn btn-outline-success" style="margin-left:490px;" value="문의하러가기" onclick="validate();" >
</section> 

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>