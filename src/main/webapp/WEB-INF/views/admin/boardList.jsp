﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
a {text-decoration:none;}
table#tbl-board{margin-left: 300px; width : 500px; margin-top:10px;}
div#container{margin-top:80px; margin-left : 50px; width : 900px; height:50px;}
div#qnacontainer{margin-left : -40px; width : 450px; height : 50px; text-align : center; font-weight : bold;cursor : pointer;}
div#asking{margin-top:-50px; margin-left : 600px; width : 450px; height : 50px; text-align : center; font-weight : bold; cursor : pointer;}
</style>
<script>
function fn_goBoardForm(){
	location.href = "${pageContext.request.contextPath}/admin/boardForm.do";
}
function fn_goQnaList(){
	location.href = "${pageContext.request.contextPath}/admin/boardList.do";
}
</script>
<section id="board-container" class="container">
<!-- 전체 게시글 출력 -->
	<div id="container">
	<div id="qnacontainer" class="alert-info" onclikc="fn_goQnaList();">FAQ</div> <div id="asking" class="alert-light" onclick="fn_goBoardForm();">1:1문의</div>
	</div>
	<table id="tbl-board" class="table table-borderless table-hover">
		<thead class="thead-light">
			<tr>
				<th>자주 묻는 질문</th>
			</tr>
		</thead>
		<c:if test="${not empty list}">
			<c:forEach items="${list }" var="b">
		<tbody>
		<tr>
			<td><a href="${pageContext.request.contextPath }/admin/boardView.do?boardNo=${b['BOARDNO'] } ">${b["BOARDTITLE"] }</a></td>
		</tr>
		</tbody>
			</c:forEach>
		</c:if>
		<c:if test="${empty list}">
		<tbody>
			<tr>
				<td colspan="4">등록된 정보가 없습니다</td>
			</tr>
		</tbody>
		</c:if>
	
	 </table>
	 
	
	<%
		int totalContents = (int)request.getAttribute("totalContents");
		int numPerPage = (int)request.getAttribute("numPerPage");
		int cPage = (int)request.getAttribute("cPage");
	%>
	
	<%=com.kh.god.common.util.Utils.getPerBar(totalContents,cPage,numPerPage,"qnaboard.do") %>
		
	<!-- 페이지바  -->
</section> 

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>