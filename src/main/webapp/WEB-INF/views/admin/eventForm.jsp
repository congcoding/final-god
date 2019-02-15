<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Custom fonts for this template-->
<link href="${pageContext.request.contextPath }/resources/css/fontawesome-free/css/all.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${pageContext.request.contextPath }/resources/css/sb-admin-2.css" rel="stylesheet">

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="이벤트 등록" name="pageTitle"/>
</jsp:include>
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


/* textarea에도 required속성을 적용가능하지만, 공백이 입력된 경우 대비 유효성검사를 실시함. */
function validate(){
	return true;
}

//부트스트랩 : 파일 벼경시 파일명 보이기 
$(function(){
    $("[name=upFile]").on('change', function(){
       /*  var fileName = $(this).val(); */
       /* console.log($(this)); */
       var fileName = $(this).prop("files")[0].name;
        $(this).next(".custom-file-label").html(fileName);
    });
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
         <div id="board-container">
		<form name="eventFrm" action="${pageContext.request.contextPath }/admin/insertEvent.do" method="post" onsubmit="return validate();" enctype="multipart/form-data">
			<input type="text" class="form-control" placeholder="제목" name="eventTitle" id="eventTitle" required>
			<div class="input-group" style="width:200px; display:inline-block; margin-left:-70px;">
				  <select class="custom-select" name="discount" id="inputGroupSelect04 disount" style="width:200px;">
				    <option selected>할인</option>
				    <option value="1000">1000원 할인</option>
				    <option value="2000">2000원 할인</option>
				    <option value="3000">3000원 할인</option>
				    <option value="0.9">10% 할인</option>
				    <option value="0.8">20% 할인</option>
				  </select>
			</div>
			<div style="width:100px; display:inline-block; margin-left:23px;" >
		    <input type="number" name="amount" id="amount" min="10"placeholder = "쿠폰 수량" style="height:38px;"/>
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
  <script src="${pageContext.request.contextPath }/resources/js/sb-admin-2.min.js"></script>
