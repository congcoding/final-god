<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link href="${pageContext.request.contextPath }/resources/css/fontawesome-free/css/all.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/sb-admin-2.css" rel="stylesheet">
<!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-god sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Divider -->
      <hr class="sidebar-divider my-0"><hr /><hr />
      <!-- Nav Item - Dashboard -->
     
    
       <li class="nav-item" id="dashBoard">
        <a class="nav-link" href="${pageContext.request.contextPath}/admin/dashBoard.do">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>요약</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item" id="toDoList">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>할 일</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" id="sellerAsking" href="login.html">판매자 신청 현황</a>
            <a class="collapse-item" id="adControl" href="register.html">광고 관리</a>
            <a class="collapse-item" id="eventControl" href="forgot-password.html">이벤트 관리</a>
            <a class="collapse-item" id="qnaControl" href="404.html">문의 관리</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Charts -->
      <li class="nav-item" id="chart">
        <a class="nav-link" href="charts.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>통계</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item" id="memberList">
        <a class="nav-link" href="${pageContext.request.contextPath}/admin/memberList.do">
          <i class="fas fa-fw fa-table"></i>
          <span>회원 관리</span></a>
      </li>
      
      <!-- Nav Item - Tables -->
      <li class="nav-item" id="sellerList">
        <a class="nav-link" href="tables.html">
          <i class="fas fa-fw fa-table"></i>
          <span>판매자 관리</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
     <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->


  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>
