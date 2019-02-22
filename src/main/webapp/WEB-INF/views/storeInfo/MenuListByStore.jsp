<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/categoryHeader.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/store/menuList.css" />

<div id="last-container">
	
	<!-- 매장 요약-------------------------------------------------------------------------------------------------->
	<div id="menuThumb-container" class="card">
	  <ul class="list-group">
		<c:forEach items="${storeInfo}" var="storeInfo">
	    <li class="list-group-item">${storeInfo.storeName}</li>
	    <li class="list-group-item">
	    	<div><img alt="" src="${pageContext.request.contextPath }/resources/images/pizza.png"></div>
	    	<div class="introduce">최소주문금액  ${storeInfo.deliveryMinPrice}</div>
	    	<div class="introduce">결제수단 카드결제,만나서결제</div>
	    </li>	    
	    <li class="list-group-item">가게소개 : ${storeInfo.storeIntro}</li>
		</c:forEach>	
	  </ul>
	</div> 
	
	<!-- 상세보기-------------------------------------------------------------------------------------------------->
	<div id="menuView-container">
		
		<!-- 네비게이션 탭 --------------------------------------------------------->
		<div id="MenuNavi">		
			<ul class="nav nav-tabs">
				  <li class="nav-item">
				    <a class="nav-link active" id="clickMenu" href="#">메뉴 <span>${menuTotalCount}</span>개</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" id="clickreview" href="#">클린리뷰  <span>38</span></a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" id="clickInformation" href="#">정보</a>
				  </li>
			</ul>
		</div>
		
		<!-- 메뉴/리뷰/사업자 정보---------------------------------------------------->
		<div id="Menu-wrapper">		
			<!-- 메뉴리스트 -->
			<table class="table table-hover active" id="menuTable">				  
				<!--menuList 가 존재하면 -->
				<c:if test="${not empty menuList}">
				  
				  <!-- 주메뉴 -->
				  <thead><tr><th scope="col" colspan="3">주메뉴</th></tr></thead>
				  <tbody>
					  <c:forEach items="${menuList}" var="menuList">
						<c:if test = "${fn : contains(menuList.menuCode, 'M')}">
						    <tr id="main-menu">
						      <td>${menuList.menuName}</td>
						      <td>${menuList.menuPrice}</td>
							  <td>
							  	<button type="button" class="btn btn-primary btn-sm"
										onclick = "inputCart('${menuList.menuCode}');">
									주문담기
								</button>
							  </td>    
						    </tr>
						 </c:if>
					   </c:forEach>
				  </tbody>
				  
				  <!-- 사이드메뉴 -->
				  <thead><tr><th scope="col" colspan="2">사이드메뉴</th></tr></thead>
				  <tbody>
				    <c:forEach items="${menuList}" var="menuList">
						<c:if test = "${fn : contains(menuList.menuCode, 'S')}">
						    <tr id="side-menu">
						      <td>${menuList.menuName}</td>
						      <td>${menuList.menuPrice}</td>
							  <td>
							  	<button type="button" class="btn btn-primary btn-sm" 
										onclick = "inputCart('${menuList.menuCode}');">주문담기</button>
							  </td>     
						    </tr>
						 </c:if>
					 </c:forEach>
				  </tbody>
				  
				  <!--  음료  -->
				  <thead><tr><th scope="col" colspan="2">음료</th></tr></thead>
				  <tbody>
				    <c:forEach items="${menuList}" var="menuList">
						<c:if test = "${fn : contains(menuList.menuCode, 'D')}">
						    <tr id="drink-menu">
						      <td>${menuList.menuName}</td>
						      <td>${menuList.menuPrice}</td>
							  <td>
							  	<button type="button" class="btn btn-primary btn-sm"
										onclick = "inputCart('${menuList.menuCode}');">주문담기</button>
							  </td>      
						    </tr>
						 </c:if>
					 </c:forEach>
				  </tbody>		  		  
				
				</c:if>
			</table> <!-- menuTable -->
	
			<!-- 클린리뷰테이블 -->
			
		
			<!-- 사업자정보 -->
			<table class="table" id="sellerInformation">
				<c:forEach items="${storeInfo}" var="storeInfo">		
					<thead><tr><th scope="col">가게명</th></tr></thead>
					<tbody><tr><td>${storeInfo.storeName}</td></tr></tbody>						  				  
					
					<thead><tr><th scope="col">가게소개</th></tr></thead>
					<tbody><tr><td>${storeInfo.storeIntro}</td></tr></tbody>
					
					<thead><tr><th scope="col">가게주소</th></tr></thead>
					<tbody><tr><td>${storeInfo.storeAddress}</td></tr></tbody>			  
					
					<thead><tr><th scope="col">가게전화번호</th></tr></thead>
					<tbody><tr><td>${storeInfo.storeTel}</td></tr></tbody>			 
					
					<thead><tr><th scope="col">휴무일</th></tr></thead>
					<tbody><tr><td>${storeInfo.personalDay}</td></tr></tbody>			 
					
					<thead><tr><th scope="col">영업시간</th></tr></thead>
					<tbody><tr><td>${storeInfo.operatingHours}</td></tr></tbody>
				</c:forEach> <!-- end of ${storeInfo} -->
			</table> <!-- end of table#sellerInformation -->
			
		</div>	
			

		<div style=”clear:both;”></div>
		
		
		<!-- 주문표 ---------------------------------------------------------------->
		<div id="Cart-wrapper" >
			<table class="table" id="cart">
				<thead class="thead-dark">
					<tr>
						<th scope="col" colspan="3">주문표</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody id="tbody-cart">		
				
			    </tbody>
			    <tfoot>
			    	<tr><td colspan="3">
			    			<button type="button" class="btn btn-outline-success" 
			    					data-toggle="modal" data-target="#checkCart">주문하기</button>			    						    			
			    		</td></tr>    	
			    </tfoot>
			</table>
		</div><!-- div#Cart-wrapper -->	
			
	</div> <!-- div#menu-container -->
	
	
</div> <!-- #last-container -->



<!-- 결제를 위한 폼전송 -->
<form action="${pageContext.request.contextPath}/menu/inputCart.do" name="inputCartFrm" id="inputCartFrm">
	<input type="hidden" name="menuCode"/>
</form>

<script>
var cart = JSON.parse(sessionStorage.getItem("cart"));

$(document).ready(function() {  
  
    $(window).scroll(function()  
    {  
        $('#cart').animate({top:$(window).scrollTop()+"px" },
        {queue: false, duration: 350});    
    });  
    
    
    
    //가게정보숨기기
	$("#sellerInformation").hide();
    //리뷰숨기기

    
    cartHtml();
});

//주문표 html 
function cartHtml(){
   
    var sum = 0;
    
    //데이터를 테이블에 추가하기
	var html = "";
	$('#tbody-cart').html("");
    
	if(cart != null){		    								
		
		if(cart.length != 0){
			
			html += "<tr><th>메뉴</th><th>가격</th><th>수량</th><th></th></tr>";
			
	    	for (var i=0; i<cart.length; i++){			  
	    	
		  		html += "<tr><td>"+cart[i].menuName+"</td>";
		  		html += "<td>"+cart[i].menuPrice*cart[i].amount+"</td>"
		  		html += "<td><button type='button' class='btn-xs add-order-num' onclick=InputCartAmount('" +i+ "'," +1+ "); ";
		  		
		  		if(cart[i].amount==9){html += "disabled";}
		  		
		  		html += ">+</button>";
		  		html += "<input type='text' class='order-num' readonly value="+cart[i].amount+">";
		  		html += "<button type='button' class='btn-xs minus-order-num' onclick=InputCartAmount('"+i+"'," +-1 +"); ";
		  		
		  		if(cart[i].amount==1){html += "disabled";}
		  		
		  		html += ">-</button></td>";
				html += "<td><button  type='button' class='btn-xs delete-order' onclick=deleteCartMenu('"+i+"');>x</button></td></tr>";  //삭제 버튼	
		  		sum += cart[i].menuPrice*cart[i].amount;
		   	}   
	    	
	    	html += "<tr><td>합계</td><td>"+sum+"</td><td></td></tr>"
	    	
		}else{
			html += "<tr><td>주문표에 담긴 메뉴가 없습니다.</td></tr>";
		}
		  	
	}else{ //cart == null
		
		html += "<tr><td>주문표에 담긴 메뉴가 없습니다.</td></tr>";
	}//end of if(cart.length)

	$('#tbody-cart').html(html);
	
}



//메뉴 수량 증가 감소
function InputCartAmount(index,num){
	
	if(cart[index].amount == 1 && num==-1){ 
		//cart[index].amount 는 1이 최소값
	}else if(cart[index].amount == 9 && num == 1){
		//cart[index].amount 는 9가 최대값
	}else{
		cart[index].amount = cart[index].amount + num;	
	}
	sessionStorage.setItem("cart", JSON.stringify(cart));		
	cartHtml();

}

//메뉴 삭제
function deleteCartMenu(index){
	
	cart.splice(index,1);
	sessionStorage.setItem("cart", JSON.stringify(cart));	
	cartHtml();
	
}

//주문 담기 : 카트에 담기 (세션)
function inputCart(menuCode){
	
	//menuCode를 이용해서 menu 객체 꺼내기
	$.ajax({
		url : "${pageContext.request.contextPath}/menu/selecOneMenu.do",
		method : "get",
		data : {menuCode : menuCode},
		success : function(menu){	
	
			//cart 배열에 menu 객체 추가
			if(cart == null){ //cart 가 이미 storage에 없음 : 첫 객체일 경우 cart 배열을 생성 하고 추가			
				cart = [];						
				cart.push(menu);
			}else{ //cart 가 이미 storage에 있음
				
				var cnt = 0;			
				for (var i=0; i<cart.length; i++){					
					if(menu.menuCode == cart[i].menuCode){ //검색한 메뉴가 cart 에 담겨있으면 	
						cnt ++;
						cart[i].amount = cart[i].amount + 1;
					}													
				}//end of for (중복찾기)
				
					if(cnt == 0){ //중복없음
					cart.push(menu);
				}							
			}			
			// 세션 스토리지에 저장
			sessionStorage.setItem("cart", JSON.stringify(cart));			
			cartHtml();			
		}, //success : 
		error : function(){
			console.log("ajax 에러");
		}
	});
}


/* 각 메뉴->카트 확인 모달영역 */
/* function checkCart(menuName,menuCode,menuPrice){
	
//주문하기 버튼을 누르면 폼 전송 (이름,코드,가격)
$('#checkCart').on('show.bs.modal', function (event) {
	$(".modal-body").text(item);
	
	$("#goPayment").on("click", function(){
		location.href = "${pageContext.request.contextPath}/payment/goPaymentPage.do?menuName="
						+item+"&menuCode="+item2+"&menuPrice="+item3;
	});	
	
});

<<<<<<< HEAD
} */


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

function goPayment(){
	location.href = "${pageContext.request.contextPath}/payment/goPaymentPage.do";
}
</script>


<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>