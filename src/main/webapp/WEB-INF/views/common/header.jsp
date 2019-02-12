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
.btn-outline-success{
	color : white;
	border-color: white;
}
.btn-outline-success:hover {
    background-color: #117a8b;
    border-color: white;
}

.navbar-expand-lg .btn-outline-success:hover {
	background-color: #32aeb8;
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
		        <a class="nav-link" href="#">관리자</a>
		      </li>
		    </ul>
		    
		    
		 	<button class="btn btn-outline-success" type="button" data-toggle="modal" data-target="#loginModal">로그인</button> 
		 	&nbsp;  
		    <button class="btn btn-outline-success" type="button" 
	     	  		onclick="location.href='${pageContext.request.contextPath}/NewFile.do'">회원가입</button>
		  
		  </div>
		</nav>
   </header>
   
   <section id="content">