<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>
<link rel="stylesheet" href="#" />

<style>
.table{
	margin: 0 auto;
	margin-top: 10%;
	width: 80%;
}
</style>

<table class="table table-bordered" id="menuTable">
	<tr>
		<td colspan="4" style="text-align: center;" id="menu-td"><h2>메뉴</h2></td>
	</tr>
	<tr>
		<th scope="col">번호</th>
		<th scope="col">메뉴명</th>
		<th scope="col">메뉴가격</th>
		<th scope="col">변경</th>
	</tr>


	<c:forEach items="${menu}" var="menu" varStatus="vs">
		<tr>
			<th scope="row">${vs.count}</th>
			<td style="display: none;"><c:out value="${menu.menuCode }"/></td>
			<td><c:out value="${menu.menuName}" /></td>
			<td><c:out value="${menu.menuPrice}" /></td>
			<td>
				<button type="button" class="btn btn-outline-info"  data-toggle="modal" data-target="#exampleModal" id="menuUpdate-btn" onclick="location.href='/seller/updateMenu.do?menuCode=${menu.menuCode}'">수정</button>
				<button type="button" class="btn btn-outline-info"  id="delete-btn" onclick="location.href='${pageContext.request.contextPath}/seller/deleteMenu.do?menuCode=${menu.menuCode}'">삭제</button>
				<%-- <button type="button" class="btn btn-outline-info" id="soldout-btn" onclick="location.href='${pageContext.request.contextPath}/seller/goUpdateMenu.do?menuCode=${menu.menuCode}'">품절</button> --%>
				<button type="button" class="btn btn-outline-info" id="soldout-btn" onclick="location.href='${pageContext.request.contextPath}/seller/goUpdateMenu.do?menuCode=${menu.menuCode}'">품절</button>
			</td>
		</tr>
	</c:forEach>
</table>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Recipient:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Message:</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div>
    </div>
  </div>
</div>
<br /><br />
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>