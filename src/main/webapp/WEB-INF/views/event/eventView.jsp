<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="이벤트" name="pageTitle"/>
</jsp:include>
<style>
div#event-container{width:700px; margin:30px auto; text-align:center;}
div#event-container input{margin-bottom:15px;}
table#tblEvent{margin-top:50px;}
</style>

<div id="event-container" class="container">
	<table class="table table-bordered" id="tblEvent">
		<tr>
			<td><img src="${pageContext.request.contextPath }/resources/upload/event/${event.eventBig }" width="500px" onclick="fileDownload('${event.eventBig}')"/></td>
		</tr>
	</table>
</div> 

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>