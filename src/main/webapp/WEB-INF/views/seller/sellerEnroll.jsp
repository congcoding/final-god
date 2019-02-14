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
	<h2>사업자 회원 가입</h2>
	<br />
	<hr />	
	<br />
	
	<form name="sellerEnrollFrm" action="${pageContext.request.contextPath}/seller/sellerEnrollEnd.do" 
		  method="post" 
		  onsubmit="return validate();" >
		<!-- 프로필 사진 -->
		
		
		
		
		<!-- 아이디 -->
		<div class="form-group row">
    		<label for="inputMemberId" class="col-sm-3">아이디</label>
    		<div>
      			<input type="text" class="form-control" id="inputMemberId" placeholder="6~16자 영문,숫자">
    		</div>
    		<!-- 중복 관련 체크  -->
    		<span class="guide ok">이 아이디는 사용 가능합니다.</span>
    		<span class="guide error">이 아이디는 사용할 수 없습니다.</span>
    		<input type="hidden" name="idDuplicateCheck" id="idDuplicateCheck" value="0" />
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
			
		
	
		
		<input type="submit" class="btn btn-outline-success" value="가입하기" >
	
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