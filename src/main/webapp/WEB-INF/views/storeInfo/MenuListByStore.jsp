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

<div id="last-container">

	<!-- 상세보기-------------------------------------------------------------------------------------------------->
	<div id="menuView-container">
		
		<div id=menuView-left>	
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
		</div>
		
		<!-- 주문표 ---------------------------------------------------------------->
		<div id="Cart-wrapper">
			<table class="table" id="cart">
				<thead class="thead-dark">
					<tr>
						<th scope="col" colspan="3">주문표</th>
					</tr>
				</thead>
				<tbody id="tbody-cart">		
				
			    </tbody>
			    <tfoot>
			    	<tr>
			    		<td colspan="4">
			    			<button type="button" class="btn btn-outline-success" 
			    					data-toggle="modal" data-target="#checkCart">주문하기</button>			    						    			
			    		</td>
			    	</tr>    	
			    </tfoot>
			</table>
		</div><!-- div#Cart-wrapper -->	
		
			
	</div> <!-- div#menu-container -->
	
	<!-- 주문표 삭제여부 물어보는 Modal  -->	
	<div class="modal fade" id="checkEmptyCart" tabindex="-1" role="dialog" 
		 aria-labelledby="checkEmptyCartLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      
	      <div class="modal-header" style="display: block;">
	        <h5 class="modal-title" id="checkEmptyCartLabel">주문표에 담기</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      
	      <div class="modal-body">
	        	다른 음식점에서 이미 담은 메뉴가 있습니다. <br />
	        	담긴 메뉴를 취소하고 새로운 음식점에서 메뉴를 담을까요?
	        	<input type="hidden" id = "newMenuCode"/>
	      </div>
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary" onclick="emptyCart( $('#newMenuCode').val() );">확인</button>
	      </div>
    	</div>
  	  </div>
	</div>
	
</div> <!-- #last-container -->




<script>
var cart = JSON.parse(sessionStorage.getItem("cart"));

$(document).ready(function() {  
	
	var cartWidth = $('#cart').innerHeight();

    $(window).scroll(function(){
    	// #div의 현재 위치
    	var cartTbl = $("#cart").offset();  	
    	var tableWidth = cartWidth+cartTbl.top;

    	console.log("테이블 길이~~~",cartWidth);  	
    	console.log("스크롤 높이~~~",cartWidth+$(window).scrollTop());
    	
    	  		
        $('#cart').animate(    		
        	{top: $(window).scrollTop()+"px"},{queue: false, duration: 300}
        );  
    
    	//console.log($(window).scrollTop());
    });  
    
    //가게정보숨기기
	$("#sellerInformation").hide();
    //리뷰숨기기

    
    cartHtml();
});

//주문표 html 
function cartHtml(){
    
	console.log("cartHtml 호출");
    
	var sum = 0;
    
    //데이터를 테이블에 추가하기
	var html = "";
	$('#tbody-cart').html("");
    
		if(cart != null){		    								
		
		/* if(cart.length != 0){
			
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
	    	
	    	html += "<tr><td>합계</td><td colspan ='3'>"+sum+"</td></tr>"; */
	    	
	    	if(cart.length != 0){
	    		html += "<tr><th>메뉴</th><th></th></tr>";
	    		
	    		for (var i=0; i<cart.length; i++){	
	    			//메뉴 이름
	    			html += "<tr><td colspan = '3'>"+cart[i].menuName+"</td></tr>"; 
	    			 			    	
	    			//수량 버튼
	    			html += "<tr><td><button  type='button' class='btn-xs delete-order' onclick=deleteCartMenu('"+i+"');>x</button></td>";
	    			
	    			html += "<td><button type='button' class='btn-xs add-order-num' onclick=InputCartAmount('" +i+ "'," +1+ ");"; //증가 버튼
	    			if(cart[i].amount==9){html += "disabled";} 
	    			html += ">+</button>";	    			
	    			html += "<input type='text' class='order-num' readonly value="+cart[i].amount+">"; //카트에 담긴 수량			  		
	    			html += "<button type='button' class='btn-xs minus-order-num' onclick=InputCartAmount('"+i+"'," +-1 +"); "; //감소 버튼		  		
			  		if(cart[i].amount==1){html += "disabled";}
			  		html += ">-</button></td>";
			  		
			  		//가격
	    			html += "<td>"+cart[i].menuPrice*cart[i].amount+"</td>";
			  		
			  		html += "</tr>";
			  		
			  		sum += cart[i].menuPrice*cart[i].amount;
	    		}
	    		
	    		html += "<tr><td colspan ='2'>합계</td><td>"+sum+"</td></tr>"; 
	    		
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
	
	console.log("inputCart 호출",menuCode);
	
	//menuCode를 이용해서 menu 객체 꺼내기
	$.ajax({
		url : "${pageContext.request.contextPath}/menu/selecOneMenu.do",
		method : "get",
		data : {menuCode : menuCode},
		success : function(menu){	
			
			console.log("cart = ",cart);
			console.log("selectMenu = ",menu);
			
			//cart 배열에 menu 객체 추가
			if(cart == null){ //cart 가 이미 storage에 없음 : 첫 객체일 경우 cart 배열을 생성 하고 추가			
				cart = [];						
				cart.push(menu);
				
			}else{ //cart 가 이미 storage에 있음
				
				var cnt = 0;		
			
				for (var i=0; i<cart.length; i++){					
					
					if(menu.storeNo != cart[i].storeNo){ //새로 추가한 메뉴가 기존의 메뉴와 다른 사업자번호를 가지고 있다면
						$('#newMenuCode').val(menu.menuCode);
						$('#checkEmptyCart').modal(); //모달이 실행되고서 아래도 계속실행중임..
						cnt = 1;
					}else{						
						if(menu.menuCode == cart[i].menuCode){ //꺼낸 메뉴가 cart에 이미 담겨있으면 	
							cnt ++;
							cart[i].amount = cart[i].amount + 1;
						}						
					}	
											
				}//end of for (중복찾기)
				
				if(cnt == 0){ //중복없음
					cart.push(menu);
				}
				
			}//else (cart != null)
			
			// 세션 스토리지에 저장
			sessionStorage.setItem("cart", JSON.stringify(cart));			
			cartHtml();
			console.log("ajax 완료-----------------------------------------------------------------");
		}, //success : 
		error : function(){
			console.log("ajax 에러");
		}
	});
}


function emptyCart(newMenuCode){

	cart = [];
	inputCart(newMenuCode);
	$('#checkEmptyCart').modal('hide');

}


/* 각 메뉴->카트 확인 모달영역 */
function checkOrder(){
	
	//주문하기 버튼을 누르면 폼 전송 (이름,코드,가격)
	$('#checkCart').on('show.bs.modal', function (event) {
		$(".modal-body").text(item);		
		$("#goPayment").on("click", function(){
			location.href = "${pageContext.request.contextPath}/payment/goPaymentPage.do";
		});			
	});

} 


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