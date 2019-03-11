<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>
<style>

.comment{
width: 543px;
    margin: 0 auto;
    margin-top: 25px;
}
.reply{
    text-align: right;
}
.replyBtn{
    position: relative;
    left: 85%;
    top: -38px;
}
.card{
margin: 30px;
}
</style>


<!-- Custom fonts for this template-->
<link href="${pageContext.request.contextPath }/resources/css/fontawesome-free/css/all.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${pageContext.request.contextPath }/resources/css/sb-admin-2.css" rel="stylesheet">

<script>
$(function(){
	var storeNo = "${param.storeNo}"
	$("#collapse"+storeNo).addClass("show");
	$("#collapse"+storeNo).parent("li").addClass("active");	
	$("#collapse"+storeNo+">div>a.sellerReview").addClass("active");	
});

	     
function appendComment(reviewRef, content){
 console.log(reviewRef, content);
 var html = '<li class="list-group-item list-group-item-primary reply">'+content+'</li>';
 $(".div"+reviewRef).append(html);
 $(".divHide"+reviewRef).css("display","none");
}		    	 

</script>

<!-- Page Wrapper -->
  <div id="wrapper">

	<jsp:include page="/WEB-INF/views/seller/sideBar.jsp"></jsp:include>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-4 text-gray-800">리뷰관리</h1>
          
          <div id="accordion" role="tablist">
          
        <c:forEach items="${review1}" var="review1" varStatus="status">
         
		<c:if test="${review1.commentLevel == '1'}">
		  <div class="card">
		    <div class="card-header" role="tab" id="headingOne">
		      <h5 class="mb-0">
		        <a data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
		         <input type="hidden" value='${review1.writer}' class="memberId">
		          '<span class="memberId">${review1.writer}</span>'님의 리뷰
		        </a>
		        &nbsp;&nbsp;
				<button type="button" class="btn btn-outline-info couponBtn" data-target="#giveCouponModal" data-toggle="modal">쿠폰지급</button>
		        </h5>
		    </div>
		</c:if>
		
			
		
		    <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion">
		      <div class="comment div${review1.reviewNo}">
		      
   		      <c:if test="${review1.commentLevel==1}">
		        <li class="list-group-item list-group-item-light">${review1.content}</li>
		      </c:if> 
		  
		       <c:if test="${review1.commentLevel==2}">  
	      		<script type="text/javascript">appendComment("${review1.reviewRef}", "${review1.content}");</script>
	      	   </c:if>
		      
		      
		      </div>
		      <!-- 리뷰답댓 -->   
		      <c:if test="${review1.commentLevel==1}">		        
		      <br>
		      <div class="divHide${review1.reviewNo}">   
			      <input type="text" class="form-control replyText replyInput${review1.reviewNo}" style="width: 78%; margin-left: 4%;">
			      <button type="button" class="btn btn-info replyBtn" onclick="goComment2('${review1.reviewNo}','${review1.storeNo}');">답글달기</button>
			  </div>    
		      </c:if> 
		    </div>
  	    </div>
  	    
	     
  	</c:forEach>
  	
  	

<div class="modal fade" id="giveCouponModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">쿠폰지급</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
<form name="couponFrm" action="${pageContext.request.contextPath}/seller/giveCouponBySeller">
        <!-- 가게명 -->
        <input type="hidden" value="${param.storeName}" name="storeName" id="storeName">
        <!-- 사업자번호 -->
        <input type="hidden" value="${param.storeNo}" name="storeNo" id="storeNo">
        <!-- 회원아이디 -->
        <input type="hidden" name="memberIdForCoupon" id="memberIdForCoupon">
        
          <div class="form-group">            
            <span style="color: green;"> "[가게명] + 대상 + 할인금액" 으로 고객님께 지급됩니다.</span>  
            <br> 
             <br>          
            <label for="recipient-name" class="form-control-label">대상</label> 
            	<select class="form-control form-control-sm to" name="to" id="to">
				  <option>단골고객</option>
				  <option>감사고객</option>
				  <option>신규고객</option>
				</select>
          </div>
          
         <div class="form-group">
            <label for="message-text" class="form-control-label">할인금액</label>
				<select class="form-control form-control-sm howMuch" name="howMuch" id="howMuch">
				  <option>10%할인쿠폰</option>
				  <option>1000원할인쿠폰</option>
				  <option>2000원할인쿠폰</option>
				</select>
          </div>
          
          <div class="form-group">
            <label for="message-text" class="form-control-label">사용기한</label>
				<select class="form-control form-control-sm howLong" name="howLong" id="howLong">
				  <option>3일</option>
				  <option>7일</option>
				  <option>10일</option>
				</select>
          </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary giveCoupon">쿠폰지급</button>
      </div>
          
	</form>
      
    </div>
  </div>
</div>
</div>
   

<script>
function goComment2(reviewNo,storeNo){
	console.log(reviewNo,storeNo);
	var reply = $(".replyInput"+reviewNo).val();
	console.log(reply);
	var sellerId = '${sellerLoggedIn.sellerId}';
	$.ajax({
		url :"${pageContext.request.contextPath}/seller/inputComment2.do", //대댓글
		data : {reviewNo:reviewNo,reply:reply,storeNo:storeNo,sellerId:sellerId},
		success : function(data){
			console.log("성공");
		},
		error : function(){
			console.log("에이젝스오류");
		}
		
	});
	appendComment(reviewNo, reply);
}
$(".couponBtn").on("click", function(){
	var memberId = $(".memberId").val();
	$("#memberIdForCoupon").val(memberId);
	
});

</script>
          <!-- 여기부터 코드 붙여넣으면 됨 -->

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->