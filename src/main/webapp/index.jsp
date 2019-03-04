﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/home.css" />

<style>
section#menu-content{
	background: linear-gradient(to top, 
				transparent 0, transparent 78%,
				#32aeb8 78%, #32aeb8 100%);
}
div#menu-content{
    padding: 50px;
    overflow: auto;
    margin: 0 auto;
    max-width: 912px;
}

div#search-container{
	display: table;
    padding: 50px 0 35px 0;
    margin: 0 auto;
}
div.card{
	width: 250px;
    height: 250px;
    float: left;
    margin: 10px;
    cursor : pointer;
}
</style>
<script>
function categoryList(item){
	var categoryNo = $(item).attr("name");
    location.href = "${pageContext.request.contextPath}/storeInfo/storeInfoList.do?categoryNo="+categoryNo;
}

$(function(){
	$.ajax({
	    url: "${pageContext.request.contextPath}/admin/carouselEvent.do",
	    dataType : "json",
	    contentType : "application/json; charset=UTF-8",
	    success: function(data) {
	    	$.each(data,function(index,item){
	    		
	    			var html = "";
	    			var count = "";
	    		for(var i in item){
	    			if(i==0){
	    				count += "<li data-target='#carouselExampleIndicators' data-slide-to='0' class='active'></li>";
	    			}else{
	    				count += "<li data-target='#carouselExampleIndicators' data-slide-to='"+i+"'></li>";
	    			}
	    		}
	    		$("#countEvent").html(count);
	    		for(var i in item){
	    			
	    			if(i==0){
	    				html += "<div class='carousel-item active'>";
	    			}else {
	    				html +="<div class='carousel-item'>";	
	    			}
	    			html += "<img onclick='fn_eventView("+item[i].EVENTNO+")'"; 
	    			html += "class='d-block w-100' style='height:212px;width:812px;' src='${pageContext.request.contextPath}/resources/upload/event/"+item[i].EVENTSMALL+"' />";
    				html +="</div>";
	    		}
	    			$("#eventShow").html(html);
	    			
	    	});
	    	
	    },error : function(request,status,error){
	    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
	});
});

function fn_eventView(eventNo){
	location.href="${pageContext.request.contextPath}/event/eventView.do?eventNo="+eventNo;
}
</script>

<section id="menu-content">
	<div id="menu-content">
	
		<div id="event-container">
			<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
			  <ol class="carousel-indicators" id="countEvent">
			    <!-- <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li> -->
			  </ol>
			  <div class="carousel-inner" id="eventShow">
				  	
			  </div>
			  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
		</div>
		
	   	<div id="search-container">
		   <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath }/member/searchByLoaction">
		     <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" id="search" name="location">
		     <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		   </form>
		</div>
	
	
	<%-- <img src="${pageContext.request.contextPath }/resources/images/logo-spring.png" id="center-image" alt="스프링로고" /> --%>
		<!-- 치킨 / 보쌈,족발  / 피자 / 한식 /중식/일식/분식/ -->
		<div class="card bg-white text-black">
			<a onclick="categoryList(this);" name="1">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/chicken.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">치킨</h5>
			  </div>
			</a>
		</div>
		
		<div class="card bg-white text-black">
			<a onclick="categoryList(this);" name="2">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/pizza.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">피자</h5>
			  </div>
			</a>
		</div>
		
		<div class="card bg-white text-black">
			<a onclick="categoryList(this);" name="3">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/jokbal_bossam.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">보쌈,족발</h5>
			  </div>
			</a>
		</div>
		
		<div class="card bg-white text-black">
			<a onclick="categoryList(this);" name="4">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/snack.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">분식</h5>
			  </div>
			</a>
		</div>
		
		<div class="card bg-white text-black">
			<a onclick="categoryList(this);" name="5">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/chinese.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">중식</h5>
			  </div>
			</a>
		</div>
		
		<div class="card bg-white text-black">
			<a onclick="categoryList(this);" name="6">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/japanese.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">일식</h5>
			  </div>
			</a>
		</div>
		
		<div class="card bg-white text-black">
			<a onclick="categoryList(this);" name="7">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/korean.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">한식</h5>
			  </div>
			</a>
		</div>
	
	</div>	
	
	<div id="content">
	
	</div>
</section>	
<script>
function getLocation(){
	if(navigator.geolocation){
		navigator.geolocation.getCurrentPosition(function(position) {
			var lon = position.coords.latitude; //y
			var lat = position.coords.longitude; //x
		
			$.ajax({
			    url: 'https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x='+lat+'&y='+lon,
			    type: 'GET',
			    cache: false,
			    contentType : 'application/json;charset=UTF-8',
			    crossOrigin: true,
			    headers:{'Authorization' : 'KakaoAK 4c6d6939204abedb25e64dcf1adfaaf2'},
			    success: function(data) {
			    	var address=data.documents[0].address_name;
			    	$("#search").val(address);
			    },error:function(request,status,error){
			        alert("다시 시도해주세요.\n" + "code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    }
			});
		}, function(error){
			console.log(error);
		}, {
			enableHighAccuracy:false,
			maximumAge:0,
			timeout : Infinity
		});
	} else {
		alert("GPS를 지원하지 않습니다.");
	}
}
getLocation();
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>