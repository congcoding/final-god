<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name=""/>
</jsp:include>


<h1>회원가입을 환영합니다</h1>

<div id="enrollType-container">

	<div class="container">
	   	고객님 회원가입 
	  	<button type="button" class="btn btn-info btn-lg" 
	  			onclick="location.href='${pageContext.request.contextPath}/member/memberEnroll.do'">개인 회원 가입</button>
	
	</div>
	
	<div class="container">
		사장님 회원가입
		<button type="button" class="btn btn-info btn-lg"
				onclick="location.href='${pageContext.request.contextPath}/seller/sellerEnroll.do'">사업자 회원 가입</button>	
	</div>

</div>


<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>	