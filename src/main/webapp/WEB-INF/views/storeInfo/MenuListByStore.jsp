<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/store/menuList.css" />

<div class="card" style="width: 20rem;">
  <ul class="list-group list-group-flush">
    <li class="list-group-item">파스타보이 - 역삼점</li>
    <li class="list-group-item">최소주문금액 <span>17000원</span></li>
    <li class="list-group-item">사장님알림 : 주문접수와 동시에 깨끗한 오픈주방에서 조리!</li>
  </ul>
</div>

<div id="container">
    <!-- 네비게이션 바 -->
		<ul class="nav nav-tabs" id="navi">
		  <li class="nav-item">
		    <a class="nav-link active" id="clickMenu" href="#">메뉴 <span>38</span>개</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="clickreview" href="#">클린리뷰  <span>38</span></a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="clickInformation" href="#">정보</a>
		  </li>
		</ul>
	<!-- 장바구니 -->
		<table class="table" id="cart">
			<thead class="thead-dark">
			    <tr>
			      <th scope="col">주문표</th>
			    </tr>
		  	</thead>
			<tbody>
		    <tr>
		      <th scope="cart-content">여기에 담김</th>
		    </tr>
		    <tr>
		      <th scope="row">
		      	<button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#exampleModal">주문하기</button>
		      </th>
		    </tr>
		    </tbody>
		</table>
		<!-- 메뉴리스트 -->
		<table class="table table-hover active" id="menuTable">
		  <thead>
		    <tr>
		      <th scope="col">주메뉴</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:if test="${not empty menuList}">
			  <c:forEach items="${menuList}" var="menuList">
				<c:if test = "${fn : contains(menuList.menuCode, 'M')}">
				    <tr id="main-menu">
				      <td><span>${menuList.menuName}</span> 
						<button type="button" class="btn btn-secondary btn-sm">주문함</button>
				      	<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal">결제하기</button>
					  </td>     
				    </tr>
				 </c:if>
			   </c:forEach>
		  </tbody>
		  
		    <thead>
		    <tr>
		      <th scope="col">사이드메뉴</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${menuList}" var="menuList">
				<c:if test = "${fn : contains(menuList.menuCode, 'S')}">
				    <tr id="side-menu">
				      <td><span>${menuList.menuName}</span> 
						<button type="button" class="btn btn-secondary btn-sm">주문함</button>
				      	<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal">결제하기</button>
					  </td>     
				    </tr>
				 </c:if>
			   </c:forEach>
		  </tbody>
		  
		    <thead>
		    <tr>
		      <th scope="col">음료</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${menuList}" var="menuList">
				<c:if test = "${fn : contains(menuList.menuCode, 'D')}">
				    <tr id="drink-menu">
				      <td><span>${menuList.menuName}</span> 
						<button type="button" class="btn btn-secondary btn-sm">주문함</button>
				      	<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal">결제하기</button>
					  </td>     
				    </tr>
				 </c:if>
			   </c:forEach>
		  </tbody>		  
		</c:if>
		</table>
		
		<!-- 클린리뷰 -->
		
		
		<!-- 사업자정보 -->
		<table class="table" id="sellerInformation">
			  <thead>
			    <tr>
			      <th scope="col">가게명</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>${storeInfo.storeName}</td>
			    </tr>
			  </tbody>
			  
			   <thead>
			    <tr>
			      <th scope="col">가게소개</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>${storeInfo.storeIntro}</td>
			    </tr>
			  </tbody>
			  
			  
			  	<thead>
			    <tr>
			      <th scope="col">가게주소</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>${storeInfo.storeIntro}</td>
			    </tr>
			  </tbody>
			  
			  <thead>
			    <tr>
			      <th scope="col">가게전화번호</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>${storeInfo.storeTel}</td>
			    </tr>
			 </tbody>
			 
			 <thead>
			    <tr>
			      <th scope="col">휴무일</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>${storeInfo.personalDay}</td>
			    </tr>
			 </tbody>
			 
			<thead>
			    <tr>
			      <th scope="col">영업시간</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>${storeInfo.operatingHours}</td>
			    </tr>
			 </tbody>
		</table>
	
</div>
<!-- 주문확인 모달창 -->
<!-- Button trigger modal -->
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">이렇게 주문할까요?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        	장바구니담긴 데이터 가져오기
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">결제하기</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
	
<script>
$(document).ready(function() {  
	   
    $(window).scroll(function()  
    {  
        $('#cart').animate({top:$(window).scrollTop()+"px" },
        {queue: false, duration: 350});    
    });  
    
    //가게정보숨기기
	$("#sellerInformation").hide();
    //리뷰숨기기


       
}); 
/* 클린리뷰 클릭시 */
$("#clickreview").click("on", function(){
	$("#clickreview").addClass("active");
	$("#clickMenu").removeClass("active");
	$("#clickInformation").removeClass("active");
	//클린리뷰 보이기
	//메뉴테이블 숨기기
	$("#menuTable").hide();
	//가게정보 숨기기
	$("#sellerInformation").hide();


});
/* 메뉴클릭시 */
$("#clickMenu").click("on", function(){
	$("#clickMenu").addClass("active");
	$("#clickreview").removeClass("active");
	$("#clickInformation").removeClass("active");
	//메뉴테이블 보이기
	$("#menuTable").show();
	//가게정보 숨기기
	$("#sellerInformation").hide();

});
/* 정보클릭시 */
$("#clickInformation").click("on", function(){
	$("#clickInformation").addClass("active");
	$("#clickMenu").removeClass("active");
	$("#clickreview").removeClass("active");
	//메뉴테이블 숨기기
	$("#menuTable").hide();
	//메뉴테이블 보이기
	$("#sellerInformation").show();

	
});
</script>


<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>