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
  <form name="updateFrm" action="${pageContext.request.contextPath}/seller/updateStore.do" method="post" enctype="multipart/form-data">
    <div class="form-group row">
      <label for="inputEmail3" class="col-sm-2 col-form-label">가게명</label>
      <div class="col-sm-10">
      
      	<c:forEach items="${store}" var="store">
        <input type="text" class="form-control" id="storeName" value="${store.storeName}" readonly>
      	
      </div>
    </div>
    <div class="form-group row">
      <label for="inputEmail3" class="col-sm-2 col-form-label">영업시간</label>
      <div class="col-sm-10">
      <!-- 오전~오후 -->
	        <select class="custom-select mb-2 mr-sm-2 mb-sm-0 chooseAmPm" name="startChooseAmPm" >
		    	<option selected value="오전">오전</option>
		    	<option value="오후">오후</option>
	 	    </select>
	 	    <!-- 몇시 -->
       		<select class="custom-select mb-2 mr-sm-2 mb-sm-0 chooseAmPm" id="startTime" name="startTime">
		    	<option selected class="chooseTime">1</option>
		    	<c:forEach var="cnt" begin="1" end="12">
		    	<option value="${cnt}" class="chooseTime">${cnt}</option>
		    	</c:forEach>
	 	    </select>
	 	    ~
	 	    <!-- 오전~오후 -->
	        <select class="custom-select mb-2 mr-sm-2 mb-sm-0 chooseAmPm" id="chooseAmPm" name="endChooseAmPm">
		    	<option selected value="오전">오전</option>
		    	<option value="오후">오후</option>
	 	    </select>
	 	    <!-- 몇시 -->
       		<select class="custom-select mb-2 mr-sm-2 mb-sm-0 chooseAmPm" id="endTime" name="endTime">
		    	<option selected>1</option>
		    	<c:forEach var="cnt" begin="1" end="12">
		    	<option value="${cnt}">${cnt}</option>
		    	</c:forEach>
	 	    </select>
      </div>
    </div>
    <div class="form-group row">
      <label for="inputPassword3" class="col-sm-2 col-form-label">가게전화번호</label>
      <div class="col-sm-10 tel">
      	<!--지역번호  -->
         	<select class="custom-select mb-2 mr-sm-2 mb-sm-0 locationNum" id="locationStartNum" name="locationStartNum">
		    	<option selected>02</option>
		    	<option value="031">031</option>
		    	<option value="032">032</option>
		    	<option value="033">033</option>
		    	<option value="041">041</option>
		    	<option value="042">042</option>
		    	<option value="043">043</option>
		    	<option value="044">044</option>
		    	<option value="051">051</option>
		    	<option value="052">052</option>
		    	<option value="053">053</option>
   			    <option value="054">054</option>
   			    <option value="055">055</option>
   			    <option value="061">061</option>
   			    <option value="062">062</option>
   			    <option value="063">063</option>
   			    <option value="064">064</option>
	 	    </select>
	 	   <input type="num" class="form-control storeName"  id="tel1" name="tel1">
	 	   <span id="tel2">-</span>
           <input type="num" class="form-control storeName" id="tel3" name="tel2">    
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
        <input type="text" class="form-control" name="personalday" value="${store.personalDay}" id="storeName" placeholder="고객들에게 보여질 정보에 소개될 휴무일 입니다">  
        </c:forEach>    
	</div>
	<br>
	<br>
	<!-- 썸네일변경 폼 -->
	<h2>대표사진 변경</h2>
	<div id="thunbnail-container">
		  <div id="preview">
		  <img id="image_section" style="width:300px;height:300px;" src="#" alt="your image" />
		  </div>
		  <select class="custom-select mb-2 mr-sm-2 mb-sm-0 locationNum" id="thumb" name="thumb">
		 		<c:forEach items="${attachment}" var="attachment">
		    	<option selected onclick="preview('${attachment.renamedFileName}')">${attachment.originalFileName}</option>
		    	</c:forEach>
		  </select>
	</div>

 
      <div class="btnGroup">
	       <button type="submit" class="btn btn-primary btn-lg">수정하기</button>
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

function readURL(input) {
 
    if (input.files && input.files[0]) {
        var reader = new FileReader();
 
        reader.onload = function (e) {
            $('#image_section').attr('src', e.target.result);
        }
 
        reader.readAsDataURL(input.files[0]);
    }
}
 
$("#imgInput").change(function(){
    readURL(this);
});
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>