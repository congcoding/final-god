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
div#board-container{width:400px; margin:30px auto; text-align:center;}
div#board-container input{margin-bottom:15px;}
/* 부트스트랩 : 파일라벨명 정렬*/
div#board-container label.custom-file-label{text-align:left;}
</style>

<script>
$(function(){
	$("#collapsePages").addClass("show");	
	$("#eventControl").addClass("active");	
	$("#toDoList").addClass("active");	
});
function fileDownload(oName, rName){
	//한글파일명이 있을 수 있으므로, 명시적으로 encoding
	oName = encodeURIComponent(oName);
	location.href="${pageContext.request.contextPath}/board/fileDownload.do?oName="+oName+"&rName="+rName;
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
          <div id="board-container">
			<form name="eventFrm" action="${pageContext.request.contextPath }/admin/insertEvent.do" method="post" onsubmit="return validate();" enctype="multipart/form-data">
				<input type="text" class="form-control" placeholder="제목" name="eventTitle" id="eventTitle" value="${event.eventTitle }" required>
	
				<div class="input-group" style="width:200px; display:inline-block; ">
					  <select class="custom-select" name="discount" id="discount" style="width:200px;">
					    <option selected>할인</option>
					    <option value="1000">1000원 할인</option>
					    <option value="2000">2000원 할인</option>
					    <option value="3000">3000원 할인</option>
					    <option value="0.9">10% 할인</option>
					    <option value="0.8">20% 할인</option>
					  </select>
				</div>
				<div style="width:160px; display:inline-block; margin-left:30px;" >
			    <input type="number" class="form-control" name="amount" id="amount" min="10"placeholder = "쿠폰 수량" />
			    </div>
			
				<!-- input:file소스 : https://getbootstrap.com/docs/4.1/components/input-group/#custom-file-input -->
				<div class="input-group mb-3" style="padding:0px;">
				  <div class="input-group-prepend" style="padding:0px;">
				    <span class="input-group-text">썸네일</span>
				  </div>
				  <div class="custom-file">
				    <input type="file" class="custom-file-input" name="upFile" id="eventSmall" multiple>
				    <label class="custom-file-label" for="eventSmall">파일을 선택하세요</label>
				  </div>
				</div>
				<div class="input-group mb-3" style="padding:0px;">
				  <div class="input-group-prepend" style="padding:0px;">
				    <span class="input-group-text">콘텐트</span>
				  </div>
				  <div class="custom-file">
				    <input type="file" class="custom-file-input" name="upFile" id="eventBig" multiple>
				    <label class="custom-file-label" for="eventBig">파일을 선택하세요</label>
				  </div>
				</div>
				
				<input type="text" class="form-control" name="startDate" id="startDatepicker" placeholder="이벤트 시작일" style="width:180px; display:inline-block" />
				&nbsp;
				-
				&nbsp;
				<input type="text" class="form-control" name="endDate" id="endDatepicker" placeholder="이벤트 종료일" style="width:180px; display:inline-block" />		
				
				<br />
				<input type="submit" class="btn btn-outline-success" value="저장" >
			</form>
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

