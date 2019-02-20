<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/seller/updateStoreInfo.css" />
<div class="container">
<h2>가게 정보</h2>
<br>
  <form id="updateFrm" method="post">
    <div class="form-group row">
      <label for="inputEmail3" class="col-sm-2 col-form-label">가게명</label>
      <div class="col-sm-10">
      
      	<c:forEach items="${store}" var="store">
        <input type="text" class="form-control" id="storeName" value="${store.storeName}" readonly>
      	<input type="hidden" class="form-control" id="storeNo" name="storeNo" value="${store.storeNo}">
      	
      </div>
    </div>
    <div class="form-group row">
      <label for="inputEmail3" class="col-sm-2 col-form-label">영업시간</label>
      <div class="col-sm-10">
      <!-- 오전~오후 -->
        <input type="text" class="form-control" name="operatingHours" value="${store.operatingHours}" id="operatingHours" placeholder="고객들에게 소개될 영업시간 입니다">  
      </div>
      
    </div>
    <div class="form-group row">
      <label for="inputPassword3" class="col-sm-2 col-form-label">가게전화번호</label>
      <div class="col-sm-10 tel">
      	<!--지역번호  -->
         	<select class="custom-select mb-2 mr-sm-2 mb-sm-0 locationNum" id="locationStartNum" name="locationStartNum">

		    	<option value="02" <c:if test="${fn:substring(store.storeTel, 0, 2)=='02'}">selected="selected"</c:if>>02</option>
		    	<option value="031"<c:if test="${fn:substring(store.storeTel, 0, 2)=='031'}">selected="selected"</c:if>>031</option>
		    	<option value="032"<c:if test="${fn:substring(store.storeTel, 0, 2)=='032'}">selected="selected"</c:if>>032</option>
		    	<option value="033"<c:if test="${fn:substring(store.storeTel, 0, 2)=='033'}">selected="selected"</c:if>>033</option>
		    	<option value="041"<c:if test="${fn:substring(store.storeTel, 0, 2)=='041'}">selected="selected"</c:if>>041</option>
		    	<option value="042"<c:if test="${fn:substring(store.storeTel, 0, 2)=='042'}">selected="selected"</c:if>>042</option>
		    	<option value="043"<c:if test="${fn:substring(store.storeTel, 0, 2)=='043'}">selected="selected"</c:if>>043</option>
		    	<option value="044"<c:if test="${fn:substring(store.storeTel, 0, 2)=='044'}">selected="selected"</c:if>>044</option>
		    	<option value="051"<c:if test="${fn:substring(store.storeTel, 0, 2)=='051'}">selected="selected"</c:if>>051</option>
		    	<option value="052"<c:if test="${fn:substring(store.storeTel, 0, 2)=='052'}">selected="selected"</c:if>>052</option>
		    	<option value="053"<c:if test="${fn:substring(store.storeTel, 0, 2)=='053'}">selected="selected"</c:if>>053</option>
   			    <option value="054"<c:if test="${fn:substring(store.storeTel, 0, 2)=='054'}">selected="selected"</c:if>>054</option>
   			    <option value="055"<c:if test="${fn:substring(store.storeTel, 0, 2)=='055'}">selected="selected"</c:if>>055</option>
   			    <option value="061"<c:if test="${fn:substring(store.storeTel, 0, 2)=='061'}">selected="selected"</c:if>>061</option>
   			    <option value="062"<c:if test="${fn:substring(store.storeTel, 0, 2)=='062'}">selected="selected"</c:if>>062</option>
   			    <option value="063"<c:if test="${fn:substring(store.storeTel, 0, 2)=='063'}">selected="selected"</c:if>>063</option>
   			    <option value="064"<c:if test="${fn:substring(store.storeTel, 0, 2)=='064'}">selected="selected"</c:if>>064</option>
	 	    </select>
	 	   <input type="num" class="form-control storeName"  id="tel1" name="tel1" value="${fn:substring(store.storeTel, 3, 7)}">
	 	   <span id="tel2">-</span>
           <input type="num" class="form-control storeName" id="tel3" name="tel2" value="${fn:substring(store.storeTel, 8, 12)}">    
      </div>
     </c:forEach>
      
    </div>
    <div id="address-container">
        <label for="inputEmail3" class="col-sm-2 col-form-label">가게 주소</label>
        <button type="button" id="updateAddressBtn" class="btn btn-outline-info">주소수정</button>
        <br>
        <c:forEach items="${store}" var="store">
        <input type="text" class="form-control" id="fixedAddress" name="address1" value="${store.storeAddress}" readonly>  
        <br>
        <input type="text" class="form-control" id="address" name="address2" placeholder="상세주소를 입력해주세요">    
    </div> 
    <div id="personalday-container">   
  		<label for="inputEmail3" class="col-sm-2 col-form-label">휴무일</label>
        <input type="text" class="form-control" name="personalday" value="${store.personalDay}" id="storeName" placeholder="고객들에게 소개될 휴무일 입니다">  
        </c:forEach>    
	</div>
	<br>
	<br>
	<!-- 썸네일변경 폼 -->
	<h2>대표사진 변경</h2>
	<div id="thunbnail-container">
		  <div id="preview">
<!-- thumbAttachment -->
		  <c:forEach items="${thumbAttachment}" var="thumbAttachment">
		  <img id="image_section" style="width:300px;height:300px;" src='${pageContext.request.contextPath}/resources/upload/storeInfo/${thumbAttachment.renamedFileName}' alt="your image" />
		  <input type="hidden" name="nowThumb" value="${thumbAttachment.renamedFileName}" >
		  </c:forEach>
		  </div>
		  <select class="custom-select mb-2 mr-sm-2 mb-sm-0 locationNum" id="thumb"  name="newThumb" >
		 			<c:forEach items="${attachment}" var="attachment">
		    			<option value= ${attachment.renamedFileName} id="renameFile">${attachment.originalFileName}</option>
		    		</c:forEach>
		  </select>
	</div>

     
      <div class="btnGroup">
	       <button type="button" id="updateBtn" class="btn btn-primary btn-lg">수정하기</button>
		   <button type="button" class="btn btn-secondary btn-lg">돌아가기</button>
      </div>
   
 </form>
</div>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
$("#updateAddressBtn").on("click", function(){
    new daum.Postcode({
        oncomplete: function(data) {
            $("#fixedAddress").val(data.address);
            $("#address").css("visibility","visible");
            $("#fixedAddress").prop("readonly", true);
        }
    }).open();
})



//사용자에게 미리 썸네일보여주는 제이쿼리
$( "#thumb" ).change(function() {
	 var str = "";
  $( "select[name=newThumb] option:selected" ).each(function() {
    str += $( this ).val();
    console.log(str);
  });
 
  $("#image_section").attr("src","${pageContext.request.contextPath}/resources/upload/storeInfo/"+str);
  
});

//폼전송
$("#updateBtn").on("click", function(){
	 var formData = $("#updateFrm").serialize();
	//ction="${pageContext.request.contextPath}/seller/updateStoreInfo.do" 
	$.ajax({
		url : "${pageContext.request.contextPath}/seller/updateStoreInfo.do",
		type : 'POST',
		data:formData,
		success:function(data){
			alert("수정이 완료되었습니다.");
		},error:function(){
			console.log("에이젝스오류");
		}
	});
})
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>