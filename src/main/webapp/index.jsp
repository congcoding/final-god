<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>

<style>
section#menu-content{
	background: linear-gradient(to top, 
				transparent 0, transparent 70%,
				#32aeb8 70%, #32aeb8 100%);
}
div#menu-content{
    padding: 50px;
    overflow: auto;
    margin: 0 auto;
    max-width: 912px;
}
div#search-container{
	display: table;
    padding: 100px 0;
    margin: 0 auto;
}
.card{
	width: 250px;
    height: 250px;
    float: left;
    margin: 10px;
}
</style>
<section id="menu-content">
	<div id="menu-content">
	   <div id="search-container">
		   <form class="form-inline my-2 my-lg-0">
		     <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
		     <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		   </form>
		</div>
	
	
	<%-- <img src="${pageContext.request.contextPath }/resources/images/logo-spring.png" id="center-image" alt="스프링로고" /> --%>
		<!-- 치킨 / 보쌈,족발  / 피자 / 한식 /중식/일식/분식/ -->
		<div class="card bg-white text-white">
			<a href="#">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">치킨</h5>
			  </div>
			</a>
		</div>
		
		<div class="card bg-white text-white">
			<a href="#">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">보쌈,족발</h5>
			  </div>
			</a>
		</div>
		
		<div class="card bg-white text-white">
			<a href="#">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">피자</h5>
			  </div>
			</a>
		</div>
		
		<div class="card bg-white text-white">
			<a href="#">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">중식</h5>
			  </div>
			</a>
		</div>
		
		
		<div class="card bg-white text-white">
			<a href="#">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">일식</h5>
			  </div>
			</a>
		</div>
		
		<div class="card bg-white text-white">
			<a href="#">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">한식</h5>
			  </div>
			</a>
		</div>
	
		<div class="card bg-white text-white">
			<a href="#">
			  <img class="card-img" src="${pageContext.request.contextPath }/resources/images/.png" >
			  <div class="card-img-overlay">
			    <h5 class="card-title">분식</h5>
			  </div>
			</a>
		</div>
	</div>	
</section>	
	
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>