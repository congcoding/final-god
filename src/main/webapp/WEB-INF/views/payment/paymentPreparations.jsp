<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/payment/paymentPreparations.css" />
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<div id="container">
			<form>
				<table class="table" id="deliveryInformation">
				  <thead class="thead-light">
				    <tr>
				      <th scope="col">배달정보</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td>
				      <label for="inputEmail3" class="col-sm-2 col-form-label">주소</label>
		    			<div class="col-sm-10">
		      			<input type="text" class="form-control" id="fixedAddress" readonly='readonly'>
		      			<br>
		      		    <input type="text" class="form-control" id="address" placeholder="(필수)상세주소 입력" required>
		      		    <span id="addressWarning">상세한 주소를 입력해주세요.</span>
					    </div>
					    <label for="inputEmail3" class="col-sm-2 col-form-label">전화번호</label>
		    			<div class="col-sm-10">
		      			<input type="tel" class="form-control" id="tel" placeholder="(필수)휴대전화 번호 입력(-제외한 번호만 입력해주세요)" required>
		      			 <span id="telWarning">휴대전화번호는 숫자만 입력해주세요.</span>
					    </div>
					  </td>
				    </tr>
				  </tbody>
				  
				<thead class="thead-light">
				    <tr>
				      <th scope="col">주문시 요청사항</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td>
		    			<div class="col-sm-10">
		      			<input type="text" class="form-control" id="inputEmail3" placeholder="주문시 요청사항이 있다면 남겨주세요.">
					  </td>
				    </tr>
				  </tbody>
				  
				  	<thead class="thead-light">
				    <tr>
				      <th scope="col">결제수단 선택</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td>  
				      <input type="hidden" name="methodForController">
				      	<div class="laterPayment">
						      	만나서 결제
						      	<br>
						      	  <button type="button" class="btn btn-outline-info method" value="later_cash" name="method">현금</button>&nbsp;
						    	  <button type="button" class="btn btn-outline-info method" value="later_card" name="method">카드</button>
						    </div>
						   	<br>
						    <div class="nowPayment">
						      	웹에서 결제
						      	<br>
						      	  <button type="button" class="btn btn-outline-info method" value="now_card" name="method">신용카드</button>&nbsp;
						    	  <button type="button" class="btn btn-outline-info method" value="now_naverpay" name="method">네이버페이</button>&nbsp;
						    	  <button type="button" class="btn btn-outline-info method" value="now_kakao" name="method">카카오페이</button> 	  
						    </div>
					   </td>
				    </tr>
				  </tbody>
				  
				<thead class="thead-light">
				    <tr>
				      <th scope="col">할인방법 선택</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      	<td>
						    <label for="inputPassword3" class="col-sm-2 col-form-label">쿠폰</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="coupon" placeholder="웹에서 결제시 가능합니다." readonly>
						      <button type="button" class="btn btn-info" id="couponBtn">적용</button>
						    </div>
						</td>
				    </tr>
				  </tbody>
				</table>
	</form>
	
		
		
		<!-- 주문표 이거 세션에 담긴걸 꺼내는 형식으로!!-->
			<div id="cart">
				<table class="table">
				  <thead class="thead-light">
				    <tr>
				      <th scope="col">주문내역</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<!-- 가게정보 -->
				    <tr>
				      <td>육선포차참숯닭발오돌뼈불떡볶이-본점</td>
				    </tr>
				    <!-- 주문메뉴 -->
				    
				    <tr class="checkOut">
				      <td><span>후라이드치킨 </span>X<span>1</span>개</td>
				    </tr>
				    <tr id="totalPrice" class="checkOut">
				      <td id="totalPriceSpan"><span>총 주문내역</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>36000</span>원</td>
				    </tr>
					
				  </tbody>
				</table>
				<button type="button" class="btn btn-info" id="orderEndBtn">주문완료</button>
				
				
			</div> 
</div>
<script src="https://nsp.pay.naver.com/sdk/js/naverpay.min.js"></script>
<script>
$(document).ready(function(){
	var IMP = window.IMP; // 생략가능
	IMP.init('imp40675186'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
});

function getLocation(){
	if(navigator.geolocation){
		navigator.geolocation.getCurrentPosition(function(position) {
			var lon = position.coords.latitude; //y
			var lat = position.coords.longitude; //x
		
			$.ajax({
				//https://developers.kakao.com/docs/restapi/local#좌표-행정구역정보-변환
			    url: 'https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x='+lat+'&y='+lon,
			    type: 'GET',
			    cache: false,
			    contentType : 'application/json;charset=UTF-8',
			    crossOrigin: true,
			    headers:{'Authorization' : 'KakaoAK 4c6d6939204abedb25e64dcf1adfaaf2'},
			    success: function(data) {
			    	console.log(data);

			    	console.log(data.documents[0].region_2depth_name);
			    	console.log(data.documents[0].address_name);
			    	var address=data.documents[1].address_name;
			    	$("#fixedAddress").val(address);
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
$("#tel").keyup(function() {
 	var data = $("#tel").val();
 	
 	if(data.indexOf("-") != -1){
 		$("#tel").addClass(" is-invalid");
 		$("#telWarning").css("display","inline");
 	} else{
 		$("#tel").removeClass(" is-invalid");
 		$("#telWarning").css("display","none");

 	}
});
//주소 입력하지않고 전화번호를 클릭했을 시
$("#tel").on("click", function(){
	if($("#address").val().trim().length==0){
		$("#address").addClass(" is-invalid");
 		$("#addressWarning").css("display","inline");
	}
});
$("#address").keyup(function() {
		console.log("도달");
		$("#address").removeClass(" is-invalid");
		$("#addressWarning").css("display","none");
});

$("#orderEndBtn").on("click",function(){
	 var method = $("input[name=methodForController]").val();
	 if(method=='now_card'){
		 IMP.request_pay({
		       pg : 'inicis', // version 1.1.0부터 지원.
		       pay_method : 'card',
		       merchant_uid : 'merchant_' + new Date().getTime(),//주문번호
		       name : '주문명:결제테스트', //메뉴
		       amount : 1000, //가격
		       buyer_email : 'iamport@siot.do', //멤버 전화번호
		       
		       buyer_tel : '010-1234-5678', //멤버 전화번호
		   }, function(rsp) {
		       if ( rsp.success ) {
		    	   //컨트롤러단에 보내기
		           var msg = '결제가 완료되었습니다.';
		           msg += '고유ID : ' + rsp.imp_uid;
		           msg += '상점 거래ID : ' + rsp.merchant_uid;
		           msg += '결제 금액 : ' + rsp.paid_amount;
		           msg += '카드 승인번호 : ' + rsp.apply_num;
		           
		           location.href = "${pageContext.request.contextPath}/payment/paymentEnd.do?paymentId="+rsp.imp_uid;
		       } else {
		           var msg = '결제에 실패하였습니다.';
		           msg += '에러내용 : ' + rsp.error_msg;
		       }
		       alert(msg);
		   });

	 } else if(method=='now_naverpay'){
		    var oPay = Naver.Pay.create({
		          "mode" : "production", // development or production
		          "clientId": "u86j4ripEt8LRfPGzQ8" // clientId
		    });

		    //직접 만드신 네이버페이 결제버튼에 click Event를 할당하세요
		
		        oPay.open({
		          "merchantUserKey": "가맹점 사용자 식별키",
		          "merchantPayKey": "가맹점 주문 번호",
		          "productName": "상품명을 입력하세요",
		          "totalPayAmount": "1000",
		          "taxScopeAmount": "1000",
		          "taxExScopeAmount": "0",
		          "returnUrl": "사용자 결제 완료 후 결제 결과를 받을 URL"
		        });
		  
	 }

});


/* 만나서 결제클릭시  */
$(".laterPayment").on("click", function(){
	$("#coupon").prop('readonly', true);

});
/* 웹에서 결제클릭시 */
$(".nowPayment").on("click", function(){
	$("#coupon").prop('readonly', false);
});


/* 결제수단클릭시 */
 $("[name=method]").on("click", function(){
		$("input[name=methodForController]").val($(this).val());
})



</script>


<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>