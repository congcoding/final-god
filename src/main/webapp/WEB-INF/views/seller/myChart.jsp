<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>
<!-- DatePicker -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(function(){
	var storeNo = "${param.storeNo}"
	$("#collapse"+storeNo).addClass("show");
	$("#collapse"+storeNo).parent("li").addClass("active");	
	$("#collapse"+storeNo+">div>a.myChart").addClass("active");	
});


</script>
		<div id="wrapper">

	<jsp:include page="/WEB-INF/views/seller/sideBar.jsp"></jsp:include>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-4 text-gray-800">통계</h1>
           </div>
           <div class="card-header py-3">
           <div class="card shadow mb-4" style="width : 35rem; height : 30rem;">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between" >
                  <h6 class="m-0 font-weight-bold text-primary" id="saleVolumeTitle"> 판매량</h6>
                  <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                     <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink" id="chartofSaleVolume">
                      <div class="dropdown-header" >Sales volume by period:</div>
                      <div class="dropdown-item" id="totalSaleVolumeofToday" value="today">Today</div>
                      <div class="dropdown-item" id="totalSaleVolumeofWeek" value="week">Week</div>
                      <div class="dropdown-item" id="totalSaleVolumeofMonth" value="month">Month</div>
                      <div class="dropdown-item" id="totalSaleVolumeof3Month" value="3month">Three Month</div>
                    </div> 
                  </div> 
                </div>
                <!-- card body -->
                <div class="card-body" id="saleVolumeBody" style="text-align : center;">
                 <input class='form-control' type='text' id='weeklyDatePicker' placeholder='Select Week' readonly style="width:15rem; display :none;   "/>&nbsp
                 <button type='button' class='btn btn-light' id='btnByWeek' style="display : none;">조회</button>
                 <div class='timeChart' style='height : 90%;'></div>
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
<script>
var chart = null;

$("div[id^=totalSaleVolumeof]").css("cursor","pointer");
$("div[id^=totalSaleVolumeof]").on('click',function(){
	$("#saleVolumeTitle").text(($(this).text())+" 판매량");
	if($(this).text() === 'Week'){
		$("#weeklyDatePicker").css("display","inline-block");
		$("#btnByWeek").css("display","inline");
	}else{
		$("#weeklyDatePicker").css("display","none");
		$("#btnByWeek").css("display","none");
		
	}
});


$('#btnByWeek').on("click", function(){
		
		var weeklyStartDate = $("#weeklyDatePicker").val().substring(0, 10);
		var weeklyEndDate = $("#weeklyDatePicker").val().substring(11, 21);
		
		$.ajax({
			url : "${pageContext.request.contextPath}/seller/chartByWeek.do?weeklyStartDate="+weeklyStartDate+"&weeklyEndDate="+weeklyEndDate,
			type : "post",
			async:"false",
			success : function(data){
				console.log(data);
			}
	     
		});//end of ajax
});

$(function(){
	var startDate;
    var endDate;
    	$("#weeklyDatePicker").datepicker({
        	dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
            dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
            monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
            monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
            showOtherMonths: true,
            selectOtherMonths: true,
    		selectWeek:true,
    		yearRange: 'c-99:c+99',
    		nextText : '다음달',
    		prevText : '이전달',
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
    		},
    		onChangeMonthYear: function(year, month, widget) {
    			setTimeout("applyWeeklyHighlight()", 100);
    		}
        }); //end of datepicker
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
</script>   
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>	
