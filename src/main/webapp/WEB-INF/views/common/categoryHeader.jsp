<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.pageTitle}</title>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<!-- 부트스트랩관련 라이브러리 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<!-- 사용자작성 css -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css" />
<!-- 주소api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<style>
nav.navbar-light{
	background : #117a8b;
}
.navbar-light .navbar-brand{
	color : white;
}
.navbar-light .navbar-nav .active>.nav-link{
	color : white;
}

.header-btn{
	color : white;
	border-color: white;
}
.header-btn:hover {
    background-color: #117a8b;
    border-color: white;
}

.navbar-expand-lg .btn-outline-success:hover {
	background-color: #32aeb8;
}
#modal-checkbox{
	padding-right: 252px;
}
.loginbtn{
	background : none;
	border : none;
}
.loginbtn:hover{
	color : white;
}
#category-nav{
     position: relative;
    top: 88px;
    width: 89%;
    left: 7%;
    pointer:cursor;
}
#search-container{
    position: relative;
    top: 72px;
    left: 39%;
}
hr{
    top: 102px;
    position: relative;
}

</style>
</head>
<body>
<div id="container">
   <header>
		<nav class="fixed-top navbar-expand-lg navbar-light">
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <!-- //collapse navbar-collapse -->
		  <div class="navbar-collapse collapse " id="navbarTogglerDemo01">
		    <a class="navbar-brand" href="${pageContext.request.contextPath}">God of Delivery</a>
		    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		      <li class="nav-item active">
		        <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li>				    
		        <a class="nav-link" href="${pageContext.request.contextPath }/admin/qnaboard.do">고객센터</a>
		      </li>		    
		      <li class="nav-item">
		        <a class="nav-link" href="${pageContext.request.contextPath }/admin/dashBoard.do">관리자</a>
		      </li>
		    </ul>
		    
		<!-- 회원 로그인,회원가입 버튼 -->
	   <c:if test="${memberLoggedIn == null}">
	   	<c:if test="${sellerLoggedIn == null}">
		<!--https://getbootstrap.com/docs/4.1/components/buttons/#outline-buttons-->
			<button class="btn btn-outline-success header-btn" type="button" data-toggle="modal" data-target="#loginModal">로그인</button> 
		 	&nbsp;  
			<button class="btn btn-outline-success header-btn" type="button" 
	     		onclick="location.href='${pageContext.request.contextPath}/chooseEnrollType.do'">회원가입</button>
		 </c:if>
		</c:if>
		<c:if test="${memberLoggedIn != null}">
		  <c:if test="${sellerLoggedIn == null}">
			<a href="#">${memberLoggedIn.memberName}</a>님 안녕하세요 &nbsp;
			<button class="btn btn-outline-sucess" type="button" onclick="location.href='${pageContext.request.contextPath}/member/memberLogout.do'">로그아웃</button>
		  </c:if>
		</c:if>
		<c:if test="${sellerLoggedIn != null}">
		  <c:if test="${memberLoggedIn == null}">
			<a href="${pageContext.request.contextPath}/seller/sellerView.do">${sellerLoggedIn.sellerName}</a>&nbsp;사장님 안녕하세요 &nbsp;
			<button class="btn loginbtn"  type="button" onclick="location.href='${pageContext.request.contextPath}/seller/sellerLogout.do'">로그아웃</button>
		    &nbsp;  
		 	<button class="btn btn-outline-success header-btn" type="button" 
		 	 onclick="location.href='${pageContext.request.contextPath}/seller/goMyShop.do?sellerId=seller1'">내가게</button> 
		  </c:if>
		</c:if>
		
	
		</nav>
		</div>
   </header>

   	<!-- 로그인모달 : https://getbootstrap.com/docs/4.1/components/modal/#live-demo -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	    <!-- 1 -->
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">로그인</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <!--로그인폼 : https://getbootstrap.com/docs/4.1/components/forms/#overview -->
	      <!-- 팝업창이 생겼을때 부모창 영역을 컨트롤할 수 없는 상태를 모달이라고 한다. 제어권이 팝업에 우선으로 부여된다. 그외의 팝업창은 nonemodal이라한다. -->
          <form id="loginFrm" method="post">
	     <!-- 2 -->
	      <div class="modal-body">
			    <input type="text" class="form-control" name="memberId" placeholder="아이디" required>
			    <br />
			    <input type="password" class="form-control" name="password" placeholder="비밀번호" required>
	      </div>
	      <!-- 3 -->
	            
	      
	      <div class="modal-footer">
	      	<div id="modal-checkbox">
	      		<input type="checkbox" name="login" value="mem" onclick="NoMultiChk(this);"/> &nbsp;회원
	      		<input type="checkbox" name="login" value="sell" onclick="NoMultiChk(this);"/> &nbsp;사장님
	      	</div>
	        <button type="button" class="btn btn-outline-success" onclick="check();" >로그인</button>
	      </div>
		  </form>
	    </div>
	  </div>
	</div>
	
	<!-- 검색창 -->
    <div id="search-container">
		   <form class="form-inline my-2 my-lg-0">
		     <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" id="search">
		     <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		   </form>
    </div>
	
	<!-- 카테고리란 -->
	<ul class="nav nav-pills nav-fill" id="category-nav">
	  <li class="nav-item">
	    <a class="nav-link" onclick="categoryList(this);" name="1" id="chicken">치킨</a>
	  </li>
	    <li class="nav-item">
	    <a class="nav-link" onclick="categoryList(this);" name="2" id="pizza">피자</a>
	  </li>
	    <li class="nav-item">
	    <a class="nav-link"onclick="categoryList(this);" name="3" id="bossam">보쌈/족발</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" onclick="categoryList(this);" name="4" id="bunsik">분식</a>
	  </li>
	    <li class="nav-item">
	    <a class="nav-link" onclick="categoryList(this);" name="5" id="china">중식</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" onclick="categoryList(this);" name="6" id="japan">일식</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" onclick="categoryList(this);" name="7" id="korea">한식</a>
	  </li>
	</ul>
	
	<hr>

	<script>
	function NoMultiChk(chk){
		var obj = document.getElementsByName("login");
	    for(var i=0; i<obj.length; i++){
	        if(obj[i] != chk){
	            obj[i].checked = false;
	        }
	    }
	}
	
	function check(){
		var chk = $("[name='login']:checked").val();
		
		if(chk === "mem"){
			$("#loginFrm").attr("action","${pageContext.request.contextPath}/member/memberLogin.do" );
			
		}else{
			
			$("#loginFrm").attr("action","${pageContext.request.contextPath}/seller/sellerLogin.do" );
			$("#loginFrm").submit();
		}
	}
	
	function categoryList(item){
		var categoryNo = $(item).attr("name");
	    location.href = "${pageContext.request.contextPath}/storeInfo/storeInfoList.do?categoryNo="+categoryNo;
	}

	//치킨눌렀을 시
	$("#chicken").on("click", function(){
		$("#all").removeClass("active");
		$("#chicken").addClass("active");
		$("#pizza").removeClass("active");
		$("#bossam").removeClass("active");
		$("#bunsik").removeClass("active");
		$("#china").removeClass("active");
		$("#japan").removeClass("active");
		$("#korea").removeClass("active");
	});
	//피자
	$("#pizza").on("click", function(){
		$("#all").removeClass("active");
		$("#chicken").removeClass("active");
		$("#pizza").addClass("active");
		$("#bossam").removeClass("active");
		$("#bunsik").removeClass("active");
		$("#china").removeClass("active");
		$("#japan").removeClass("active");
		$("#korea").removeClass("active");
	});
	//보쌈
	$("#bossam").on("click", function(){
		$("#all").removeClass("active");
		$("#chicken").removeClass("active");
		$("#pizza").removeClass("active");
		$("#bossam").addClass("active");
		$("#bunsik").removeClass("active");
		$("#china").removeClass("active");
		$("#japan").removeClass("active");
		$("#korea").removeClass("active");
	});
	//분식
		$("#bunsik").on("click", function(){
		$("#all").removeClass("active");
		$("#chicken").removeClass("active");
		$("#pizza").removeClass("active");
		$("#bossam").removeClass("active");
		$("#bunsik").addClass("active");
		$("#china").removeClass("active");
		$("#japan").removeClass("active");
		$("#korea").removeClass("active");
	});
	//중식
		$("#china").on("click", function(){
		$("#all").removeClass("active");
		$("#chicken").removeClass("active");
		$("#pizza").removeClass("active");
		$("#bossam").removeClass("active");
		$("#bunsik").removeClass("active");
		$("#china").addClass("active");
		$("#japan").removeClass("active");
		$("#korea").removeClass("active");
	});
	//일식
		$("#japan").on("click", function(){
		$("#all").removeClass("active");
		$("#chicken").removeClass("active");
		$("#pizza").removeClass("active");
		$("#bossam").removeClass("active");
		$("#bunsik").removeClass("active");
		$("#china").removeClass("active");
		$("#japan").addClass("active");
		$("#korea").removeClass("active");
	});
	//한식
		$("#korea").on("click", function(){
		$("#all").removeClass("active");
		$("#chicken").removeClass("active");
		$("#pizza").removeClass("active");
		$("#bossam").removeClass("active");
		$("#bunsik").removeClass("active");
		$("#china").removeClass("active");
		$("#japan").removeClass("active");
		$("#korea").addClass("active");
	});
	
	</script>
   <section id="content">


