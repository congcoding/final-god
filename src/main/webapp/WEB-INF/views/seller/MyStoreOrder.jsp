<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/seller/MyStoreOrder.css" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>



<h2 id="title">주문현황</h2>
<div id="container">
<div class="row">
  <div class="col-4">
    <div class="list-group" id="list-tab" role="tablist">
      <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" href="#list-home" role="tab" aria-controls="home">접수대기</a>
      <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list" href="#list-profile" role="tab" aria-controls="profile">접수완료</a>
      <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list" href="#list-messages" role="tab" aria-controls="messages">배달완료</a>
    </div>
  </div>
  <div class="col-8">
    <div class="tab-content" id="nav-tabContent">
      <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">
      	<!-- 접수대기중인 목록 -->
				<table class="table table-hover" id="orderWaitng">
				  <thead>
				    <tr>
				      <th scope="col">주문메뉴</th>      
				      <th scope="col">주소</th>
				      <th scope="col">전화번호</th>
				      <th scope="col">요청사항</th>
				      <th scope="col">결제수단</th>
				      <th scope="col">총 가격</th>
				      <th scope="col">주문시간</th>     
				     <th scope="col"></th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				    <!--${fn:split('1|2|3|4|5', '|') }  -->
				      <c:forEach items="${orderList1}" var="orderList1">
				      <td class="orderMenu">
				      <c:forEach items="${fn:split(orderList1.NAME,'/')}" var="menu">
				      ${menu}<br>
				      </c:forEach>
				      </td>
				      <td class="orderAddress">${orderList1.ADDRESS}</td>
				      <td class="orderPhone">${orderList1.PHONE}</td>
				      <c:if test="${orderList1.REQUEST eq null}">
				      <td class="orderRequest">${orderList1.REQUEST}</td>
				      </c:if>
				      
				      <c:if test="${orderList1.PRICEWAY=='Y'}">
				      <td class="orderWay">결제완료</td>
				      </c:if>
				      <c:if test="${orderList1.REQUEST=='N'}">
				      <td class="orderWay">만나서결제</td>
				      </c:if>
				     
				      <td class="orderPrice">${orderList1.TOTALPRICE}</td>
				      <td class="orderPrice">${orderList1.ORDERTIME}</td>
				     
				      <td>
				      <button type="button" id="orderAcception" class="btn btn-info" data-toggle="modal" data-target="#exampleModal">주문접수</button>
				      <button type="button" id="orderCancel" class="btn btn-secondary" data-toggle="modal" data-target="#cancelOrder">접수취소</button>
				      </td> 
				    </tr>
				      </c:forEach>
				  </tbody>
				</table>
      </div>
      <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">
		<!-- 접수완료된 오더들 -->
				<table class="table table-hover" id="orderWaitng">
				  <thead>
				    <tr>
				      <th scope="col">주문메뉴</th>      
				      <th scope="col">주소</th>
				      <th scope="col">전화번호</th>
				      <th scope="col">요청사항</th>
				      <th scope="col">결제수단</th>
				      <th scope="col">총 가격</th>
				      <th scope="col">주문시간</th>     
				     <th scope="col"></th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				    <!--${fn:split('1|2|3|4|5', '|') }  -->
				      <c:forEach items="${orderList1}" var="orderList1">
				      <td class="orderMenu">
				      <c:forEach items="${fn:split(orderList1.NAME,'/')}" var="menu">
				      ${menu}<br>
				      </c:forEach>
				      </td>
				      <td class="orderAddress">${orderList1.ADDRESS}</td>
				      <td class="orderPhone">${orderList1.PHONE}</td>
				      <c:if test="${orderList1.REQUEST eq null}">
				      <td class="orderRequest">${orderList1.REQUEST}</td>
				      </c:if>
				      
				      <c:if test="${orderList1.PRICEWAY=='Y'}">
				      <td class="orderWay">결제완료</td>
				      </c:if>
				      <c:if test="${orderList1.REQUEST=='N'}">
				      <td class="orderWay">만나서결제</td>
				      </c:if>
				     
				      <td class="orderPrice">${orderList1.TOTALPRICE}</td>
				      <td class="orderPrice">${orderList1.ORDERTIME}</td>
				     
				      <td>
				      <button type="button" id="orderAcception" class="btn btn-info" data-toggle="modal" data-target="#exampleModal">배달완료</button>
				      </td> 
				    </tr>
				     </c:forEach>
				  </tbody>
				</table>


	   </div>
      <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">
		<!-- 배달완료된 오더들 -->
		<table class="table table-hover" id="orderWaitng">
				  <thead>
				    <tr>
				      <th scope="col">주문메뉴</th>      
				      <th scope="col">주소</th>
				      <th scope="col">전화번호</th>
				      <th scope="col">요청사항</th>
				      <th scope="col">결제수단</th>
				      <th scope="col">총 가격</th>
				      <th scope="col">주문시간</th>     
				     <th scope="col"></th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				    <!--${fn:split('1|2|3|4|5', '|') }  -->
				      <c:forEach items="${orderList1}" var="orderList1">
				      <td class="orderMenu">
				      <c:forEach items="${fn:split(orderList1.NAME,'/')}" var="menu">
				      ${menu}<br>
				      </c:forEach>
				      </td>
				      <td class="orderAddress">${orderList1.ADDRESS}</td>
				      <td class="orderPhone">${orderList1.PHONE}</td>
				      <c:if test="${orderList1.REQUEST eq null}">
				      <td class="orderRequest">${orderList1.REQUEST}</td>
				      </c:if>
				      
				      <c:if test="${orderList1.PRICEWAY=='Y'}">
				      <td class="orderWay">결제완료</td>
				      </c:if>
				      <c:if test="${orderList1.REQUEST=='N'}">
				      <td class="orderWay">만나서결제</td>
				      </c:if>
				     
				      <td class="orderPrice">${orderList1.TOTALPRICE}</td>
				      <td class="orderPrice">${orderList1.ORDERTIME}</td>
				     
				      <td>
				      </td> 
				    </tr>
				     </c:forEach>
				  </tbody>
				</table>

	  </div>
    </div>
  </div>
</div>
	
     
     <!-- 접수모달창 -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">배달예정시간</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
			<button type="button" class="btn btn-info">10분~30분</button>
			<button type="button" class="btn btn-info">30분~50분</button>
			<button type="button" class="btn btn-info">50분~60분</button>
			<button type="button" class="btn btn-info">60분 이상</button>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">주문접수</button>
      </div>
    </div>
  </div>
</div>
</div>

<!-- 주문취소 선택시 -->
<div class="modal fade" id="cancelOrder" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">배달 취소 사유</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <input type='radio' name='reason' value='female' id="" class="btnReason"/>주문량이 너무 많아서
            <br>
            <br>
            <input type='radio' name='reason' value='female' class="btnReason"/>배달소요시간이 오래 걸릴 거같아서
            <br>
            <br>
            <input type='radio' name='reason' value='female' class="btnReason"/>해당메뉴품절
            <br>
            <br>
            <input type='radio' name='reason' value='female' id="etc"/>기타
            <br>
            <label for="message-text" class="form-control-label">배달취소사유:</label>
            <textarea class="form-control" id="cancelReason" readonly></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary">주문취소</button>
      </div>
    </div>
  </div>
</div>
<script>
$("#etc").on("click", function(){
	$("#cancelReason").prop('readonly', false);
});
$(".btnReason").on("click", function(){
	$("#cancelReason").prop('readonly', true);
});
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>