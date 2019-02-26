<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="배달의 신" name="pageTitle" />
</jsp:include>
<!-- <link rel="stylesheet" href="css" /> -->
주문이 완료되었습니다.
주문이 접수되면 고객님의 번호로 배달소요시간을 문자로 발송해드립니다.
고객님을 위해 배달의 신이 달려갑니다!
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>