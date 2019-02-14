<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="고객센터" name="pageTitle"/>
</jsp:include>
<script>

</script>
<section id="storeInfo-container" class="container">
<!-- 전체 게시글 출력 -->
	<c:forEach items="${list }" var="list" varStatus="status">
	<div class="card" style="width: 20rem;">
		<img class="card-img-top" src="..." alt="StoreInfo Thumbnail">
		<div class="card-body">
			<h4 class="card-title"><c:out value="${list.storeName }"/></h4>
			<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
		</div>
		<ul class="list-group list-group-flush">
			<li class="list-group-item">Cras justo odio</li>
			<li class="list-group-item">Dapibus ac facilisis in</li>
			<li class="list-group-item">Vestibulum at eros</li>
		</ul>
		<div class="card-body">
			<a href="#" class="card-link">Card link</a> <a href="#"
				class="card-link">Another link</a>
		</div>
	</div>
	</c:forEach>

	<%
		int totalContents = (int)request.getAttribute("totalContents");
		int numPerPage = (int)request.getAttribute("numPerPage");
		int cPage = (int)request.getAttribute("cPage");
		int categoryNo = (int)request.getAttribute("categoryNo");
	%>
	
	<%=com.kh.god.common.util.Utils.getPerBar(totalContents,cPage,numPerPage,"storeInfoList.do") %>
		
	<!-- 페이지바  -->
</section> 

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>