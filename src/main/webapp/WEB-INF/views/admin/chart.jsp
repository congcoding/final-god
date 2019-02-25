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

<!-- 구글차트 API -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script>
$(function(){
	$("#chart").addClass("active");	
});

/* 카테고리별 판매량 (파이 차트) */
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

  var data = google.visualization.arrayToDataTable([
    ['Category', 'Total Price'],
    ['치킨', ${chartByCategoryList[0]}],
    ['피자', ${chartByCategoryList[1]}],
    ['보쌈, 족발', ${chartByCategoryList[2]}],
    ['분식', ${chartByCategoryList[3]}],
    ['중식', ${chartByCategoryList[4]}],
    ['일식', ${chartByCategoryList[5]}],
    ['한식', ${chartByCategoryList[6]}]
  ]);

  var options = {
  };

  var chart = new google.visualization.PieChart(document.getElementById('chartByCategory'));

  chart.draw(data, options);
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
          <h1 class="h3 mb-4 text-gray-800">통계</h1>
          
          <!-- 카테고리별 판매량 (파이 차트) -->
          <div class="card shadow mb-4" style="width:740px">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">카테고리별 판매량</h6>
            </div>
            <div class="card-body">
              <div id="chartByCategory" style="width:700px; height:300px;"></div>
            </div>
          </div>
          
          <div class="card shadow mb-4" style="width:740px">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">카테고리별 판매량</h6>
            </div>
            <div class="card-body">
              <div id="chartByCategory" style="width:700px; height:300px;"></div>
            </div>
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

