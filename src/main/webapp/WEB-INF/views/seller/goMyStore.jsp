<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/store/goMyStore.css" />
<h2 id="storeStatus">내 가게 현황</h2>
<h2 id="menu">메뉴보기</h2>

<table id="container">
  <tr style="vertical-align:top">
    <td id="left">
    <c:if test="${not empty store}">
    	<c:forEach items="${store}" var="store">
    		<div class="storeName" onclick="boxEvent();">${store.storeName}</div>
	    	<div class="boxEvent">
	    		<a href="#">주문내역</a>
	    		&nbsp;
	    		&nbsp;
	    		<a href="#">내 가게 통계</a>
	    		&nbsp;
	    		&nbsp;
	    		<a href="#">내 가게 수정</a>
	    		&nbsp;
	    		&nbsp;
	    		<a href="#">리뷰관리</a>
	    	</div>
    	</c:forEach> 	
    </c:if>
    </td>
    </tr>
</table>

<table class="table table-bordered">
	<thead>
		<tr>
			<th scope="col">번호</th>
			<th scope="col">메뉴명</th>
			<th scope="col">메뉴가격</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${menu}" var="menu" varStatus="vs">
			<tr>
				<th scope="row">${vs.count}</th>
				<td>${menu.menuName}</td>
				<td>${menu.menuPrice}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- 페이지바 부분 -->
<%--    <%
      int totalContents = (int)request.getAttribute("totalContents");
      int numPerPage = (int)request.getAttribute("numPerPage");
      int cPage = (int)request.getAttribute("cPage");
   %>
   <nav aria-label="Page navigation example">
  	<ul class="pagination justify-content-center">
   <%=com.kh.god.common.util.Utils.getPerBar(totalContents, cPage, numPerPage, "boardList.do")%>   
    </ul>
   </nav> --%>

   
<script>

$(".storeName").on("click", function(){
	 if($(".boxEvent").css("display") == "none"){   
	        jQuery('.boxEvent').show();  
	    } else {  
	        jQuery('.boxEvent').hide();  
	    } 
})

</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>