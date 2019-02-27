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
table#tbl-event tr th{text-align:center;}
table#tbl-event tr td{text-align:center;}
</style>

<script>
$(function(){
	$("#storeList").addClass("active");	
});
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
          <h1 class="h3 mb-4 text-gray-800">가게 관리</h1>
          
          <table id="tbl-event" class="table table-striped table-hover">
			<tr>
				<th>사업자 번호</th>
				<th>가게 이름</th>
				<th>가게 전화번호</th>
				<th>가게 등급</th>
				<th>카테고리</th>
				<th>사장님 아이디</th>
				<th>영업 중지 여부</th>
			</tr>
			<c:if test="${not empty list}">
				<c:forEach items="${list }" var="store">
					<tr>
						<td>${store.storeNo}</td>
						<td><a href="${pageContext.request.contextPath }/admin/storeView.do?storeNo=${store.storeNo} " >${store.storeName }</a></td>
						<td>${store.storeTel }</td>
						<td>${store.storeGrade }</td>
						<td>
							<c:choose>
								<c:when test="${store.categoryNo=='1'}">치킨</c:when>
								<c:when test="${store.categoryNo=='2'}">피자</c:when>
								<c:when test="${store.categoryNo=='3'}">보쌈, 족발</c:when>
								<c:when test="${store.categoryNo=='4'}">분식</c:when>
								<c:when test="${store.categoryNo=='5'}">중식</c:when>
								<c:when test="${store.categoryNo=='6'}">일식</c:when>
								<c:when test="${store.categoryNo=='7'}">한식</c:when>
							</c:choose>
						</td>
						<td>${store.sellerId }</td>
						<td>${store.pmsFlag=='C'?"중지":"" }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">새로운 가게 신청이 없습니다.</td>
				</tr>
			</c:if>
		
		  </table>
	
		<%
			int totalContents = (int)request.getAttribute("totalContents");
			int numPerPage = (int)request.getAttribute("numPerPage");
			int cPage = (int)request.getAttribute("cPage");
		%>
		<div>
		<%=com.kh.god.common.util.Utils.getPerBar(totalContents,cPage,numPerPage,"storeList.do") %>
		</div>
          

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->