<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/locationHeader.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>

<style>
div.row{
 	margin-top: 168px;
    margin-left: 92px;
}

li#storeNo{
	display: none;
}
</style>
<script>
$(document).ready(function(){
	var categoryNo = ${categoryNo};
	if(categoryNo==1){
		$("#chicken").addClass("active");
	} else if(categoryNo==2){
		$("#pizza").addClass("active");

	} else if(categoryNo==3){
		$("#bossam").addClass("active");

	} else if(categoryNo==4){
		$("#bunsik").addClass("active");

	} else if(categoryNo==5){
		$("#china").addClass("active");

	} else if(categoryNo==6){
		$("#japan").addClass("active");

	} else if(categoryNo==7){
		$("#korea").addClass("active");

	}
	
});
</script>
<section id="storeInfo-container" class="container">
	<!-- 전체 게시글 출력 -->
	<div class="row">
	
			<c:forEach items="${list }" var="list" varStatus="status">
			
				<c:if test="${list.storeGrade eq 'A'}">
					<div class="card" style="width: 20rem; border : 1px solid #e9fbfa; background-color:#e9fbfa;" ></div>
				</c:if>
				<c:if test="${list.storeGrade eq 'B'}">
					<div class="card" style="width: 20rem; border:1px solid #26d9d0;"></div>
				</c:if>
				<c:if test="${list.storeGrade eq 'C'}">
					<div class="card" style="width: 20rem;"  style="border:red;"></div>
				</c:if>
					<img class="card-img-top" src="" alt="StoreInfo Thumbnail">
					<div class="card-body">
						<h5 class="card-title" style="font-weight: bold;">
							<c:out value="${list.storeName }" />
						</h5>
						<p class="card-text">
							<c:out value="${list.storeIntro }" />
						</p>
					</div>
					
					<ul class="list-group list-group-flush">						
						<c:if test="${list.storeGrade eq 'A'}">
							<li id="storeNo" ><c:out value="${list.storeNo }"></c:out></li>
							<li class="list-group-item" style="border:1px solid #e9fbfa; background-color:#e9fbfa;"><strong>영업시간 </strong> <c:out
									value="${list.operatingHours }" /></li>
							<li class="list-group-item" style="border:1px solid #e9fbfa; background-color:#e9fbfa;"><strong>전화번호 </strong> <c:out
									value="${list.storeTel }" /></li>
							<li class="list-group-item" style="border:1px solid #e9fbfa; background-color:#e9fbfa;"><strong>배달최소금액 </strong> <c:out
									value="${list.deliveryMinPrice }" /></li>
						</c:if>
						
						<c:if test="${list.storeGrade eq 'B'}">
							<li id="storeNo" ><c:out value="${list.storeNo }"></c:out></li>
							<li class="list-group-item" style="border:1px solid #e9fbfa;"><strong>영업시간 </strong> <c:out
									value="${list.operatingHours }" /></li>
							<li class="list-group-item" style="border:1px solid #e9fbfa;"><strong>전화번호 </strong> <c:out
									value="${list.storeTel }" /></li>
							<li class="list-group-item" style="border:1px solid #e9fbfa;"><strong>배달최소금액 </strong> <c:out
									value="${list.deliveryMinPrice }" /></li>
						</c:if>
						
						<c:if test="${list.storeGrade eq 'C'}">
							<li id="storeNo" ><c:out value="${list.storeNo }"></c:out></li>
							<li class="list-group-item" ><strong>영업시간 </strong> <c:out
									value="${list.operatingHours }" /></li>
							<li class="list-group-item" ><strong>전화번호 </strong> <c:out
									value="${list.storeTel }" /></li>
							<li class="list-group-item" ><strong>배달최소금액 </strong> <c:out
									value="${list.deliveryMinPrice }" /></li>
						</c:if>
					</ul>
					<div class="card-body">
						<a class="btn btn-primary" href="${pageContext.request.contextPath }/menu/menuList.do?storeNo=${list.storeNo }">주문하기</a>
					</div>
						
			</c:forEach>
	</div> <!-- div.row -->

	<%
		int totalContents = (int) request.getAttribute("totalContents");
		int numPerPage = (int) request.getAttribute("numPerPage");
		int cPage = (int) request.getAttribute("cPage");
		int categoryNo = (int) request.getAttribute("categoryNo");
	%>
	
	<%=com.kh.god.common.util.Utils.getPerBar(totalContents, cPage, numPerPage,"storeInfoList.do?categoryNo="+categoryNo) %>
		
	<!-- 페이지바  -->
</section> 

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>