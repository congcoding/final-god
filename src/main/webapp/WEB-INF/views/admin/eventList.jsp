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
<style>
input#btn-add{float:right; margin: 0 0 15px;}
table#tbl-event tr th{text-align:center;}
table#tbl-event tr td{text-align:center;}
table#tbl-event tr td a {text-decoration:none !important;}
</style>
<script>
$(function(){
	$("#collapsePages").addClass("show");	
	$("#eventControl").addClass("active");	
	$("#toDoList").addClass("active");	
});
function fn_goEventForm(){
	location.href = "${pageContext.request.contextPath}/admin/eventForm.do";
}
</script>

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
         <section id="board-container" class="container">

		<input type="button" value="이벤트 등록" id="btn-add" class="btn btn-outline-success" onclick="fn_goEventForm();"/>
		<table id="tbl-event" class="table table-striped table-hover">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>시작일</th>
				<th>마지막일</th>
				<th>수량</th>
				<!-- 목록뿌리기 : 파일이있으면 file.png 보여주기 -->
			</tr>
			<c:if test="${not empty list}">
				<c:forEach items="${list }" var="b">
			<tr>
				<td>${b['EVENTNO'] }</td>
				<td><a href="${pageContext.request.contextPath }/admin/eventView.do?eventNo=${b['EVENTNO'] } " >${b["EVENTTITLE"] }</a></td>
				<td><fmt:formatDate value="${b['STARTDATE']}" type="date" /> </td>
				<td><fmt:formatDate value="${b['ENDDATE']}" type="date" /> </td>
				<td>${b['AMOUNT'] }</td>
			</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">등록된 정보가 없습니다.</td>
				</tr>
			</c:if>
		
		</table>
	
	<%
		int totalContents = (int)request.getAttribute("totalContents");
		int numPerPage = (int)request.getAttribute("numPerPage");
		int cPage = (int)request.getAttribute("cPage");
	%>
	<div>
	<%=com.kh.god.common.util.Utils.getPerBar(totalContents,cPage,numPerPage,"eventList.do") %>
	</div>
		
	<!-- 페이지바  -->
</section> 

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>
