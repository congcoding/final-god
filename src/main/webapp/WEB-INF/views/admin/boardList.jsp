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
a {text-decoration:none;}
<<<<<<< HEAD
table#tbl-board{margin-left: 300px; width : 500px; margin-top:10px;}
div#container{margin-top:80px; margin-left : 50px; width : 900px; height:50px;}
div#qnacontainer{margin-left : -40px; width : 450px; height : 50px; text-align : center; font-weight : bold;cursor : pointer;}
div#asking{margin-top:-50px; margin-left : 600px; width : 450px; height : 50px; text-align : center; font-weight : bold; cursor : pointer;}
=======
table#tbl-board{ width : 500px; margin:-35px auto;}
div#head-container{margin:70px auto; width : 900px; height:50px;}
div#qna{margin-left : -40px; width : 450px; height : 50px; text-align : center; font-weight : bold;cursor : pointer;display: table-cell;vertical-align: middle;}
div#asking{margin-top:-50px; margin-left : 500px; width : 450px; height : 50px; text-align : center; font-weight : bold; cursor : pointer;display: table-cell;vertical-align: middle;}
div#pageBar{margin:35px auto;}
>>>>>>> 357ac722f0be599ecfa97a82d424006833000c35
</style>
<script>
function fn_goBoardForm(){
	location.href = "${pageContext.request.contextPath}/admin/boardForm.do";
}
function fn_goQnaList(){
	location.href = "${pageContext.request.contextPath}/admin/boardList.do";
}
</script>
<<<<<<< HEAD
<section id="board-container" class="container">
<!-- 전체 게시글 출력 -->
	<div id="container">
	<div id="qnacontainer" class="alert-info" onclikc="fn_goQnaList();">FAQ</div> <div id="asking" class="alert-light" onclick="fn_goBoardForm();">1:1문의</div>
	</div>
=======
<div id="head-container">
	<div id="qna" class="alert-info" onclikc="fn_goQnaList();">FAQ</div> <div id="asking" class="alert-light" onclick="fn_goBoardForm();">1:1문의</div>
</div>
<section id="board-container" class="container">
<!-- 전체 게시글 출력 -->
>>>>>>> 357ac722f0be599ecfa97a82d424006833000c35
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
<<<<<<< HEAD
	
	<%=com.kh.god.common.util.Utils.getPerBar(totalContents,cPage,numPerPage,"qnaboard.do") %>
=======
	<div id="pageBar">
	<%=com.kh.god.common.util.Utils.getPerBar(totalContents,cPage,numPerPage,"qnaboard.do") %>
	</div>
>>>>>>> 357ac722f0be599ecfa97a82d424006833000c35
		
	<!-- 페이지바  -->
</section> 

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>