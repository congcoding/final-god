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

div#MemberEnroll-container{
    margin: 150px auto 0;
	width : 800px;
	text-align : center;
}
div.form-group label{ padding-top : 0.5em; text-align: left;}
div.form-group input{
	width : 280px;
}
div#inputProfile{
	border: 1px solid;
    background-size: cover;
    width: 150px;
    height: 150px;
    z-index: 100;
    position: absolute;
    left: 71%;
    top: 27%;
}
input#gender1, input#gender2{width : 30px;}
input#gender2 {margin-left:50px;}
select#selectYear{ width : 100px;}
select#selectMonth, select#selectDay{ width : 65px;}



</style>

<div id="MemberEnroll-container">
	<h2>개인 회원 가입</h2>
	<br />
	<hr />	
	<br />
	
	<form name="memberEnrollFrm" action="${pageContext.request.contextPath}/member/memberEnrollEnd.do" 
		  method="post" 
		  onsubmit="return validate();" >
		<!-- 프로필 사진 -->
		<div id=inputProfile>
			<img src="" alt=""/>
		</div>
		<div class="input-group mb-3">
  			<div class="custom-file">
    		<input type="file" class="custom-file-input" id="inputGroupFile02">
    			<label class="custom-file-label" for="inputGroupFile02" aria-describedby="inputGroupFileAddon02">Choose file</label>
  			</div>
  			<div class="input-group-append">
    			<span class="input-group-text" id="inputGroupFileAddon02">Upload</span>
  			</div>
		</div>
		
		
		
		<!-- 아이디 -->
		<div class="form-group row">
    		<label for="inputMemberId" class="col-sm-3">아이디</label>
    		<div>
      			<input type="text" class="form-control" id="inputMemberId" placeholder="6~16자 영문,숫자">
    		</div>
  		</div>	
		<!-- 비밀번호 -->
		<div class="form-group row">
    		<label for="inputPassword" class="col-sm-3">비밀번호</label>
    		<div>
      			<input type="password" class="form-control" id="inputPassword" placeholder="6~16자 영문,숫자">
    		</div>
  		</div>
  		<div class="form-group row">
    		<label for="checkPassword" class="col-sm-3">비밀번호 확인</label>
    		<div>
      			<input type="password" class="form-control" id="checkPassword" placeholder="Password Check">
    		</div>
  		</div>
  		
		<hr />
		
		<!-- 이름 -->
		<div class="form-group row">
    		<label for="inputMemberName" class="col-sm-3">이름</label>
    		<div>
      			<input type="text" class="form-control" id="inputMemberName">
    		</div>
  		</div>		
  		
		<!-- 생년월일 -->
		<div class="form-group row">
			<label for="selectBirth" class="col-sm-3">생년월일</label>	
			<select class="form-control selectBirth" id="selectYear" > 
  				<option selected="selected" disabled="disabled">년</option>
  				<c:forEach var="year" begin="1935" end = "2004">
  					<option value="year">${year }</option>
  				</c:forEach>
			</select>
			&nbsp;
			<select class="form-control selectBirth" id="selectMonth" > 
  				<option selected="selected" disabled="disabled">월</option>
  				<c:forEach var="month" begin="01" end = "12">
  					<option value="month">${month }</option>
  				</c:forEach>
			</select>
			&nbsp;
			<select class="form-control selectBirth" id="selectDay" > 
  				<option selected="selected" disabled="disabled">일</option>
  				<c:forEach var="day" begin="1" end = "31">
  					<option value="day">${day }</option>
  				</c:forEach>
			</select>
		</div>
		
		<!-- 성별 -->
  		<div class="form-group row">
	  		<label for="checkGender" class="col-sm-3">성별</label>
	  		<div class="form-check form-check-inline" id="checkGender">
	  			<input class="form-check-input" type="radio" name="inlineRadioOptions" id="gender1" value="M">
	  			<label class="form-check-label col-form-label" for="gender1">남자</label>
			</div>
			<div class="form-check form-check-inline">
	  			<input class="form-check-input" type="radio" name="inlineRadioOptions" id="gender2" value="F">
	  			<label class="form-check-label col-form-label" for="gender2">여자</label>
			</div>
  		</div>
		
		<!-- 이메일 -->
		<div class="form-group row">
    		<label for="inputEmail" class="col-sm-3">이메일</label>
    		<div class="form-inline">
      			<input type="email" class="form-control">
      			&nbsp;@&nbsp;
      			<input type="email" class="form-control" id="inputEmailAddress" >
      			&nbsp;
      			<select class="form-control" id="selectEmailAddress" >
      				 <option value="">선택하세요</option>
      				 <option value="naver.com">naver.com</option>
                     <option value="hanmail.net">hanmail.net</option>
                     <option value="nate.com">nate.com</option>
                     <option value="daum.net">daum.net</option>
                     <option value="gmail.com">gmail.com</option>
                     <option value="etc">직접입력</option>
      			</select> 
      		</div>
  		</div>
  	
	
		<!-- 핸드폰 번호 -->
		<div class="form-group row">
			<label for="selectPhone" class="col-sm-3">핸드폰 번호</label>	
			<div class="form-inline">
				<select class="form-control selectPhone" id="selectPhone" > 
	  				<option selected="selected">010</option>
	  				<option>019</option>
	  				<option>016</option>
				</select>
				&nbsp;-&nbsp;
				<input class="form-control selectPhone" type="text" maxlength="4" style="width: 80px;"
					   onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>  
				&nbsp;-&nbsp;
				<input class="form-control selectPhone" type="text" maxlength="4" style="width: 80px;" 
					   onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
			</div>
		</div>
			
		
		<!-- 주소 api -->
		<div class="form-group row">
			<label for="address" class="col-sm-3">주소</label>	
			<input class = "form-control" type="text" name="address" id="address" onclick="execDaumPostcode();"/>		
		</div>
		
		<!-- 취향 -->
		<!-- 프로필 사진 -->
		
		<hr />
		
		<input type="submit" class="btn btn-outline-success" value="가입하기" >
	
	</form>
</div>

<script>
/* select창에서 선택한 이메일 주소를 input이메일주소창으로 넣어주기 */
$("#selectEmailAddress").on("change",function(){
	$('#inputEmailAddress').val($('#selectEmailAddress').val());	
});
/* input이메일 주소창에 수정이 있으면 select이메일 창의 값을 직접입력으로 변경 */
$("#inputEmailAddress").on("focus",function(){
	$('#selectEmailAddress').val('etc');
});

function validate(){ /* 유효성 검사 */
	
	if($("#memberId_").val().trim().length < 4){
	      alert("아이디는 4글자 이상 입력해주세요");
	      return false;	      
 	}
	//아이디 중복 검사
	if($("#idDuplicateCheck").val()==0){
			alert("아이디 중복검사를 해주세요");
			return false;
	}
 	
	if($("#password_").val() != $("#password2").val()){
	      alert("비밀번호가 일치하지 않습니다.");
	      return false;
	}
	
	return true;
}


$("#memberId_").on("keyup",function(){

	   var memberId = $(this).val();	   
	   //아이디 4글자 이상 작성했을 시 에만 중복여부 검사요청
	   if(memberId.trim().length<4){
	      $(".guide").hide();
	      $("#idDuplicateCheck").val(0);
	      return;
	   }
	   
	   //ajax요청
	   $.ajax({
	      url : "${pageContext.request.contextPath}/member/checkIdDuplicate.do",
	      method : "get",
	      data: {memberId : memberId}, //{}: 객체형태  // "memberId="+memberId+"&age=": 직렬화된 형태도 가능
	      success : function(data){
	         //console.log(data);
	         //console.log(JSON.stringify(data));
	         //console.log(JSON.parse(JSON.stringify(data)));
	         
	        /*  if(data === "true"){  --> ajax 사용할때는 text로 왔었다  */
	       	 if(data.isUsable == true){  //jsonView는 객체로 뱉는중(boolean 으로 뱉고있다. jquery 가 바꿔줌)
	        	 $(".guide.error").hide();
	        	 $(".guide.ok").show();
	        	 $("#idDuplicateCheck").val(1);	        	
	         }else{ //false
	        	 $(".guide.error").show();
	        	 $(".guide.ok").hide();
	        	 $("#idDuplicateCheck").val(0);
	         }
	      },
	      error : function(){
	         console.log("ajax요청 에러");
	      }
	   });
	   
});


function execDaumPostcode(){
	console.log('함수호출');
	
    var popUpAddress = 
	new daum.Postcode({
	    oncomplete:function(data){
	         var fullRoadAddr = data.roadAddress;
	         var extraRoadAddr = '';
	         
	         if(data.bname !=='' &&/[동|로|가]$/g.test(data.bname)){
	            extraRoadAddr += data.bname;
	         }
	         if(data.buildingName !=='' &&data.apartment === 'Y'){
	            extraRoadAddr += (extraRoadAddr !== ''?','+data.buildingName : data.build);
	         }
	         if(extraRoadAddr !== ''){
	            extraRoadAddr = '(' + extraRoadAddr +')';
	         }
	         if(fullRoadAddr !== ''){
	            fullRoadAddr += extraRoadAddr;
	         }
	         document.getElementById("address").value = fullRoadAddr;
	     }
   	}).open({
   	    popupName: 'postcodePopup' //팝업 이름을 설정(영문,한글,숫자 모두 가능, 영문 추천)
   	});
   
}




</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>	