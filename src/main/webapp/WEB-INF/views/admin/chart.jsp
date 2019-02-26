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
    ['한식', ${chartByCategoryList[6]}],
  ]);

  var options = {
  };

  var chart = new google.visualization.PieChart(document.getElementById('chartByCategory'));

  chart.draw(data, options);
}



</script>

<style>
input#btnYear{float : right;}
input#getYear{float : right;}
</style>

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
            <div class="card-header py-3" style="display:inline-block;">
              <h6 class="m-0 font-weight-bold text-primary" style="display:inline-block;">월별 판매량</h6>
              <input type="button" id="btnYear" class="btn-light btn-sm" value="검색" />
              <input type="text" id="getYear" placeholder="ex)2018" />
            </div>
            <div class="card-body">
              <div id="chartByMonth" style="width:700px; height:300px;"> </div>
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
  
  <script>
  $("#btnYear").on("click",function(){
		
	  var year = $("#getYear").val();
	  google.charts.load("current", {packages:["corechart", 'bar']});
	  google.charts.setOnLoadCallback(drawByMonthChart);

	  function drawByMonthChart(){
	  	var month1 = 0;
	  	var month2 = 0;
	  	var month3 = 0;
	  	var month4 = 0;
	  	var month5 = 0;
	  	var month6 = 0;
	  	var month7 = 0;
	  	var month8 = 0;
	  	var month9 = 0;
	  	var month10 = 0;
	  	var month11 = 0;
	  	var month12 = 0;
		
	  	$.ajax({
	  		url : "${pageContext.request.contextPath}/admin/chartByMonth.do?year="+year,
	  		type : "post",
	  		async : "false",
	  		success : function(list){
	  			

	 			$.each(list,function(index,item){
	 				
	 				for(var i in item){
	 					if(item[i] == 01){
	 						month1 +=1;
	 					}else if(item[i]==02){
	 						month2 +=1;
	 					}else if(item[i]==03){
	 						month3 +=1;
	 					}else if(item[i]==04){
	 						month4 +=1;
	 					}else if(item[i]==05){
	 						month5 +=1;
	 					}else if(item[i]==06){
	 						month6 +=1;
	 					}else if(item[i]==07){
	 						month7 +=1;
	 					}else if(item[i]==08){
	 						month8 +=1;
	 					}else if(item[i]==09){
	 						month9 +=1;
	 					}else if(item[i]==10){
	 						month10 +=1;
	 					}else if(item[i]==11){
	 						month11 +=1;
	 					}else if(item[i]==12){
	 						month12 +=1;
	 					}
	 				}
	 				
	  			var data= new google.visualization.arrayToDataTable([
		  			 ['Month', 'Quantity',{role:'style'}],
		  	          ['01',  month1,'#6B8E23'],
		  	          ['02',  month2,'#DA70D6'],
		  	          ['03',  month3,'#66CDAA'],
		  	          ['04',  month4,'#20B2AA'],
		  	          ['05',  month5,'#ADD8E6'],
		  	          ['06',  month6,'#6495ED'],
		  	          ['07',  month7,'#8B008B'],
		  	          ['08',  month8,'#008B8B'],
		  	          ['09',  month9,'#000080'],
		  	          ['10',  month10,'#483D8B'],
		  	          ['11',  month11,'#2F4F4F'],
		  	          ['12',  month12,'#8B4513']
	  			]);

	  	        var options = {
	  	        		title: year+'년도 월별 판매량',
	  	              chartArea: {width: '70%'},
	  	              hAxis: {
	  	                title: 'Month',
	  	                minValue: 0
	  	              },
	  	              vAxis: {
	  	                title: 'Quantity'
	  	              }
	  	        };

	  	        var chart = new google.visualization.LineChart(document.getElementById('chartByMonth'));
	  	      $("#searchYear").show();

	  	        chart.draw(data, options);
	  		}); /* each end */
	  	}

	  	});
	   }
	  });
  </script>

