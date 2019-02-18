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
				      	<div class="laterPayment">
						      	만나서 결제
						      	<br>
						      	  <button type="button" class="btn btn-outline-info">현금</button>&nbsp;
						    	  <button type="button" class="btn btn-outline-info">카드</button>
						    </div>
						   	<br>
						    <div class="nowPayment">
						      	웹에서 결제
						      	<br>
						      	  <button type="button" class="btn btn-outline-info" >신용카드</button>&nbsp;
						    	  <button type="button" class="btn btn-outline-info" >네이버페이</button>&nbsp;
						    	  <button type="button" class="btn btn-outline-info" >카카오페이</button> 	  
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
	
				<!-- 주문표 -->
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
<script>
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
/* 만나서 결제클릭시  */
$(".laterPayment").on("click", function(){
	$("#coupon").prop('readonly', true);

});
/* 웹에서 결제클릭시 */
$(".nowPayment").on("click", function(){
	$("#coupon").prop('readonly', false);
});
</script>


<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>