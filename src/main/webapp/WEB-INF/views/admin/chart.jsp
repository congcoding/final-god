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

<!-- DatePicker -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
$(function(){
	$("#chart").addClass("active");	
});

/* 카테고리별 판매량 (파이 차트) */
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChartByCategory);

function drawChartByCategory() {

  var data = google.visualization.arrayToDataTable([
    ['Category', 'Total Price'],
    ['치킨', ${chartByCategoryList[0]}],
    ['피자', ${chartByCategoryList[1]}],
    ['보쌈/족발', ${chartByCategoryList[2]}],
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

/* 일주일 판매량 */
/* 일주일 판매량 DatePicker*/
$(function(){
	var startDate;
    var endDate;
    
    $('#weeklyDatePicker').datepicker( {
    	dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
        dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
        monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        showOtherMonths: true,
        selectOtherMonths: true,
		selectWeek:true,
        onSelect: function(dateText, inst) { 
            var date = $(this).datepicker('getDate');
            startDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay());
            endDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay() + 6);
			var dateFormat = 'yy/mm/dd'
            startDate = $.datepicker.formatDate( dateFormat, startDate, inst.settings );
            endDate = $.datepicker.formatDate( dateFormat, endDate, inst.settings );

			$('#weeklyDatePicker').val(startDate + '~' + endDate);
            
            setTimeout("applyWeeklyHighlight()", 100);
        },
		beforeShow : function() {
			setTimeout("applyWeeklyHighlight()", 100);
		}
    });
});

function applyWeeklyHighlight() {

	$('.ui-datepicker-calendar tr').each(function() {

		if ($(this).parent().get(0).tagName == 'TBODY') {
			$(this).mouseover(function() {
				$(this).find('a').css({
					'background' : '#ffffcc',
					'border' : '1px solid #dddddd'
				});
				$(this).find('a').removeClass('ui-state-default');
				$(this).css('background', '#ffffcc');
			});
			
			$(this).mouseout(function() {
				$(this).css('background', '#ffffff');
				$(this).find('a').css('background', '');
				$(this).find('a').addClass('ui-state-default');
			});
		}

	});
}


/* 일주일 판매량 차트*/	
google.charts.setOnLoadCallback(drawChartByWeek);

function drawChartByWeek(){

	// 차트 데이터
	var data = new google.visualization.arrayToDataTable([
		['요일', '치킨', '피자', '보쌈/족발', '분식', '중식', '일식', '한식'], 
		['월', 10, 20, 30, 40, 20, 30, 40],
		['화', 15, 30, 35, 20, 20, 30, 40],
		['수', 20, 25, 40, 30, 20, 30, 40],
		['목', 10, 30, 20, 50, 20, 30, 40],
		['금', 5, 10, 25, 55, 20, 30, 40],
		['토', 5, 10, 25, 55, 20, 30, 40],
		['일', 5, 10, 25, 55, 20, 30, 40]
	]);
	
	var chart_options = {
		title : '그때 그시절 그것',
		width : 700,
		height : 400,
		bar : {
			groupWidth : '50%'
		},
		isStacked : true // 그래프 쌓기(스택), 기본값은 false
	};

	var chart = new google.visualization.ColumnChart(document.getElementById('chartByWeek'));
	chart.draw(data, chart_options);
}

/* 일주일 판매량 ajax*/
$(function(){
	$('#btnByWeek').on("click", function(){
		
		var weeklyStartDate = $("#weeklyDatePicker").val().substring(0, 10);
		var weeklyEndDate = $("#weeklyDatePicker").val().substring(11, 21);
		
		$.ajax({
			url : "${pageContext.request.contextPath}/admin/chartByWeek.do?weeklyStartDate="+weeklyStartDate+"&weeklyEndDate="+weeklyEndDate,
			type : "post",
			async:"false",
			success : function(list){
				
			}
	     
		});
	})
})

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
              <h6 class="m-0 font-weight-bold text-primary">일주일 판매량</h6>
            </div>
            <div class="card-body" style="text-align:center;">
              <input class="form-control" type='text' id='weeklyDatePicker' placeholder="Select Week" style="width:210px; display:inline-block"/>
              <button type="button" class="btn btn-light" id="btnByWeek">조회</button>
              <div id="chartByWeek" style="width:700px; height:300px;"></div>
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

