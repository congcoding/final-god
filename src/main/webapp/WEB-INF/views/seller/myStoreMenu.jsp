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

<script>
$(function(){
	var storeNo = "${param.storeNo}"
	$("#collapse"+storeNo).addClass("show");
	$("#collapse"+storeNo).parent("li").addClass("active");	
	$("#collapse"+storeNo+">div>a.myStoreMenu").addClass("active");	
});
</script>

<!-- Page Wrapper -->
  <div id="wrapper">

	<jsp:include page="/WEB-INF/views/seller/sideBar.jsp"></jsp:include>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-4 text-gray-800">내 가게 메뉴 수정</h1>
          
          <!-- 여기부터 코드 붙여넣으면 됨 -->
<table class="table table-bordered" id="menuTable">
	<tr>
		<td colspan="4" style="text-align: center;" id="menu-td"><h2>메뉴</h2></td>
	</tr>
	<tr>
		<th scope="col">번호</th>
		<th scope="col">메뉴명</th>
		<th scope="col">메뉴가격</th>
		<th scope="col">변경</th>
	</tr>


	<c:forEach items="${menu}" var="menu" varStatus="vs">
		<tr>
			<th scope="row">${vs.count}</th>
			<td><c:out value="${menu.menuName}" /></td>
			<td><c:out value="${menu.menuPrice}" /></td>
			<td>
				<button type="button" class="btn btn-outline-info"  data-toggle="modal" data-target="#exampleModal" id="menuUpdate-btn" onclick="location.href='${pageContext.request.contextPath}/seller/updateMenu.do?menuCode=${menu.menuCode}'">수정</button>
				<button type="button" class="btn btn-outline-info"  id="delete-btn" onclick="location.href='${pageContext.request.contextPath}/seller/deleteMenu.do?menuCode=${menu.menuCode}'">삭제</button>
				<c:if test="${menu.soldoutFlag eq 'N'}">
					<button type="button" class="btn btn-outline-info" id="soldout-btn" onclick="location.href='${pageContext.request.contextPath}/seller/goUpdateMenu.do?menuCode=${menu.menuCode}&storeNo=${menu.storeNo }&soldoutFlag=${menu.soldoutFlag }'">품절</button>
				</c:if>
				<c:if test="${menu.soldoutFlag eq 'Y'}">
					<button type="button" class="btn btn-outline-info" id="soldout-btn" onclick="location.href='${pageContext.request.contextPath}/seller/goUpdateMenu.do?menuCode=${menu.menuCode}&storeNo=${menu.storeNo }&soldoutFlag=${menu.soldoutFlag }'">품절취소</button>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Recipient:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Message:</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div>
    </div>
  </div>
</div>
<br /><br />
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

