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

function updateMenu(menuName, menuPrice, menuCode, storeNo){
/* 	console.log("######", menuName);
	console.log("######", menuPrice);
	console.log("######", menuCode);
	console.log("######", storeNo); */
	
	$("#updateMenuName").val(menuName);
	$("#updateMenuPrice").val(menuPrice);
	$("#updateMenuCode").val(menuCode);
	$("#updateStoreNo").val(storeNo);
}

function deleteMenu(menuCode, storeNo){
	location.href="${pageContext.request.contextPath}/seller/deleteMenu.do?menuCode="+menuCode+"&storeNo="+storeNo;
}

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
			<td><fmt:formatNumber value="${menu.menuPrice }"/>원</td>
			<td>
				<button type="button" class="btn btn-outline-info"  data-toggle="modal" data-target="#updateMenuModal" id="menuUpdate-btn" onclick="updateMenu('${menu.menuName}', ${menu.menuPrice }, '${menu.menuCode }', '${menu.storeNo}');">수정</button>
				<button type="button" class="btn btn-outline-info"  id="delete-btn" onclick="deleteMenu('${menu.menuCode}', '${menu.storeNo }');">삭제</button>
				<c:if test="${menu.soldoutFlag eq 'N'}">
					<button type="button" class="btn btn-outline-info" id="soldout-btn" onclick="location.href='${pageContext.request.contextPath}/seller/goUpdateMenu.do?menuCode=${menu.menuCode}&storeNo=${menu.storeNo }&soldoutFlag=${menu.soldoutFlag }'">품절</button>
				</c:if>
				<c:if test="${menu.soldoutFlag eq 'Y'}">
					<button type="button" class="btn btn-outline-info" id="soldout-btn" onclick="location.href='${pageContext.request.contextPath}/seller/goUpdateMenu.do?menuCode=${menu.menuCode}&storeNo=${menu.storeNo }&soldoutFlag=${menu.soldoutFlag }'">품절취소</button>
				</c:if>
			</td>
		</tr>
	</c:forEach>
	<td colspan="4" style="text-align: right;" id="insertMenu-td"><button type="button" class="btn btn-outline-info"  data-toggle="modal" data-target="#insertMenuModal" id="menuInsert-btn">추가</button></td>
</table>
<!-- updateMenuModal -->
<form action="${pageContext.request.contextPath}/seller/updateMenu.do">
	<div class="modal fade" id="updateMenuModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">메뉴 수정</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form>
	          <div class="form-group">
	          	<input type="hidden" class="form-control" id="updateMenuCode" name="menuCode"/>
	          	<input type="hidden" class="form-control" id="updateStoreNo" name="storeNo"/>
	            <label for="menuName" class="col-form-label">메뉴명</label>
	            <input type="text" class="form-control" id="updateMenuName" name="menuName"/>
	            <label for="menuPrice" class="col-form-label">메뉴가격</label>
	            <input type="text" class="form-control" id="updateMenuPrice" name="menuPrice"/>
	          </div>
	          <div class="form-group">
	            <label for="message-text" class="col-form-label">메뉴사진</label>
	            <textarea class="form-control" id="message-text"></textarea>
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	        <button type="submit" class="btn btn-primary">수정</button>
	      </div>
	    </div>
	  </div>
	</div>
</form>

<!-- insertMenuModal -->
<form action="${pageContext.request.contextPath}/seller/insertMenu.do">
	<div class="modal fade" id="insertMenuModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">메뉴 추가</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form>
	          <div class="form-group">
	          	<input type="hidden" class="form-control" id="insertCategoryNo" name="categoryNo" value="${categoryNo}"/>
	          	<input type="hidden" class="form-control" id="insertStoreNo" name="storeNo" value="${storeNo}"/>
	            <label for="menuName" class="col-form-label">메뉴명</label>
	            <input type="text" class="form-control" id="insertMenuName" name="menuName"/>
	            <label for="menuPrice" class="col-form-label">메뉴가격</label>
	            <input type="text" class="form-control" id="insertMenuPrice" name="menuPrice"/>
	            <label for="menuPrice" class="col-form-label">종류</label>
	            <div class="btn-group-vertical container">
					<div class="btn-group" data-toggle="buttons">
					  <label class="btn btn-info active">
					    <input type="radio" name="menuOptions" id="mainOption" value="M" autocomplete="off" checked> 메인 메뉴
					  </label>
					  <label class="btn btn-info">
					    <input type="radio" name="menuOptions" id="sideOption" value="S" autocomplete="off"> 사이드 메뉴
					  </label>
					  <label class="btn btn-info">
					    <input type="radio" name="menuOptions" id="drinkOption" value="D" autocomplete="off"> 음료 메뉴
					  </label>
					</div>
				</div>
	            
	          </div>
	          <div class="form-group">
	            <label for="message-text" class="col-form-label">메뉴사진</label>
	            <textarea class="form-control" id="message-text"></textarea>
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	        <button type="submit" class="btn btn-info">추가</button>
	      </div>
	    </div>
	  </div>
	</div>
</form>
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

