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
div#head-container{margin:30px auto; width : 900px; height:50px;}
div#member{margin-left : -40px; width : 450px; height : 50px; text-align : center; font-weight : bold;cursor : pointer;display: table-cell;vertical-align: middle;}
div#seller{margin-top:-50px; margin-left : 500px; width : 450px; height : 50px; text-align : center; font-weight : bold; cursor : pointer;display: table-cell;vertical-align: middle;}
input#boardTitle{font-weight : bold;}
div#pageBar{margin:35px auto;}
</style>
<script>
$(function(){
	$("#memberList").addClass("active");	
});

function fn_goMemberForm(){
	location.href = "${pageContext.request.contextPath}/admin/memberList.do";
};
function fn_goSellerList(){
	location.href = "${pageContext.request.contextPath}/admin/sellerList.do";
};

</script>
<%
		int totalContents = (int)request.getAttribute("totalContents");
		int numPerPage = (int)request.getAttribute("numPerPage");
		int cPage = (int)request.getAttribute("cPage");
%>

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
          <div id="head-container">
			<div id="member" class="alert-light" onclikc="fn_goMemberList();">일반회원</div> <div id="seller" class="alert-info" onclick="fn_goSellerForm();">판매자</div>
		  </div>
		  
          <table class="table">
			  <thead>
			    <tr>
			      <th scope="col">아이디</th>
			      <th scope="col">이름</th>
			      <th scope="col">이메일</th>
			      <th scope="col">전화번호</th>
			      <th scope="col">블랙리스트</th>
			    </tr>
			  </thead>
			  <tbody>
				  <c:if test="${not empty seller }">
				  	<c:forEach items="${seller }" var="seller">
					    <tr>
					      <td name="sellerId" id="sellerId">${seller.sellerId }</td>
					      <td name="sellerName" id="sellerName">${seller.sellerName }</td>
					      <td name="email" id="email">${seller.email }</td>
					      <td name="phone" id="phone">${seller.phone }</td>
					      <c:if test="${seller.blackFlag }==Y">
					      	<td name="blackFlag" id="blackFlag" class="table-danger">${seller.blackFlag }</td>
					      </c:if>
					      <c:if test="${seller.blackFlag }==N">
					      	<td name="blackFlag" id="blackFlag">${seller.blackFlag }</td>
					      </c:if>
					    </tr>
				    </c:forEach>
				   </c:if>
			  </tbody>
			 
		</table>
	
		<div id="pageBar">
			<%=com.kh.god.common.util.Utils.getPerBar(totalContents,cPage,numPerPage,"qnaboard.do") %>
		</div>

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

