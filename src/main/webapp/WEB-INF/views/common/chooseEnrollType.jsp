<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name=""/>
</jsp:include>
<style>
#enrollType-container2{
	width : 800px;
	height :500px;
	margin: 200px auto;
	display: block;
}

#enrollType-container2 >h1{
	text-align: center;
	font-size: 60px;
}

#enrollType-container2 img{
	width : 250px;
	height : 235px;
}
#enrollType-container2 .container{
	width : 40%;
	margin: 40px;
	float : left;
}
#enrollType-container2 button{
    display: block;
    margin-top : 45px;
    width: 250px;
    height : 75px;
}


</style>


<div id="enrollType-container">
	
	<div id="enrollType-container2">
	<h1 class= "font-weight-bold">Welcome!</h1>
		<div class="container">
		 <img src="${pageContext.request.contextPath }/resources/images/member.png"  alt="" />
		 <button type="button" id="btn1" class="btn btn-info btn-lg" 
		  		 onclick="location.href='${pageContext.request.contextPath}/member/memberEnroll.do'">개인 회원 가입</button>		
		</div>		
		
		<div class="container">
			<img src="${pageContext.request.contextPath }/resources/images/seller.png"  alt="" />
			<button type="button" id="btn2" class="btn btn-info btn-lg" 
					onclick="location.href='${pageContext.request.contextPath}/seller/sellerEnroll.do'">사업자 회원 가입</button>	
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>	