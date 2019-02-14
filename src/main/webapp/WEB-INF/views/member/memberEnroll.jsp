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
	width : 500px;
	text-align : center;
}
div.form-group label{ padding-top : 0.5em; text-align: left;}
div.form-group input{
	width : 280px;
}


</style>

<div id="MemberEnroll-container">
	<h2>개인 회원 가입</h2>
	<br />
	<hr />	
	<br />
	
	<form name="memberEnrollFrm" action="${pageContext.request.contextPath}/member/memberEnrollEnd.do" 
		  method="post" 
		  onsubmit="return validate();" >

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
		
		<!-- 이메일 -->
		<div class="form-group row">
    		<label for="inputEmail" class="col-sm-3">이메일</label>
    		<div>
      			<input type="email" class="form-control" id="inputEmail" placeholder="Email">
    		</div>
  		</div>
  		<!-- 성별 -->
  		<div class="form-check form-check-inline">
  			<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
  			<label class="form-check-label" for="inlineRadio1">남</label>
		</div>
		<div class="form-check form-check-inline">
  			<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
  			<label class="form-check-label" for="inlineRadio2">여</label>
		</div>
  		
		
		<!-- 핸드폰 번호 -->
		<!-- 주소 api -->
		<!-- 취향 -->
		<!-- 프로필 사진 -->
		

		<input type="submit" class="btn btn-outline-success" value="가입" >&nbsp;
		<input type="reset" class="btn btn-outline-success" value="취소">
	</form>
</div>

<script>
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

</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>	