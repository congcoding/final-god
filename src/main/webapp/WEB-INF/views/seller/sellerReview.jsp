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
#reply{
	width: 78%;
    margin-left: 4%;
}
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
          
         
		  <div class="card">
		    <div class="card-header" role="tab" id="headingOne">
		      <h5 class="mb-0">
		        <a data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
		          <span>'qwrfik123'</span>님의 리뷰
		        </a>
<button type="button" class="btn btn-outline-info" data-target="#giveCouponModal" data-toggle="modal">쿠폰지급</button>		      </h5>
		    </div>

		    <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion">
		      <div class="comment">
		        <li class="list-group-item list-group-item-light">맛있어요~ 서비스도 괜찮았습니다~</li>
		     	<li class="list-group-item list-group-item-primary reply">감사합니다! 다음에 또 주문해주세요:) !</li>    		     		
		      </div>
		      <!-- 리뷰답댓 -->     
		      <br>
		      <input type="email" class="form-control" id="reply" aria-describedby="emailHelp">
		      <button type="button" class="btn btn-info replyBtn">답글달기</button>
		    </div>
  	    </div>
  	   
  
  <div class="card">
    <div class="card-header" role="tab" id="headingTwo">
      <h5 class="mb-0">
        <a class="collapsed" data-toggle="collapse" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          'nanda5050'님의 리뷰
        </a>
        <button type="button" class="btn btn-outline-info" data-target="#giveCouponModal" data-toggle="modal">쿠폰지급</button>
      </h5>
    </div>
    <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo" data-parent="#accordion">
      <div class="card-body">
        	 <div class="comment">
		        <li class="list-group-item list-group-item-light">너무늦게왔어요;</li>
		     	<li class="list-group-item list-group-item-primary reply">죄송합니다ㅜㅜ 주문량이많아서요 쿠폰드릴테니 다음에 또 주문해주세요</li>    		     		
		      </div>
		           
		      <br>
		      <input type="email" class="form-control" id="reply" aria-describedby="emailHelp">
		      <button type="button" class="btn btn-info replyBtn">답글달기</button>
      </div>
    </div>
  </div> 

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
        <form>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">쿠폰명</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          
         <div class="form-group">
            <label for="message-text" class="form-control-label">할인금액</label>
				<select class="form-control form-control-sm">
				  <option>10%할인쿠폰</option>
				  <option>1000원할인쿠폰</option>
				  <option>2000원할인쿠폰</option>
				</select>
          </div>
          
          <div class="form-group">
            <label for="message-text" class="form-control-label">사용기한</label>
				<select class="form-control form-control-sm">
				  <option>3일</option>
				  <option>7일</option>
				  <option>10일</option>
				</select>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">쿠폰지급</button>
      </div>
    </div>
  </div>
</div>
    
</div>
          <!-- 여기부터 코드 붙여넣으면 됨 -->

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->