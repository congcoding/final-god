/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-02-28 10:50:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.seller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myChart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1548321130691L));
    _jspx_dependants.put("jar:file:/C:/Workspaces/sts_workspace/GodOfDelivery/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/C:/Workspaces/sts_workspace/GodOfDelivery/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fmt.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/C:/Workspaces/sts_workspace/GodOfDelivery/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fn.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_fmt_005frequestEncoding_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("pageTitle", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("<!-- DatePicker -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("\tvar storeNo = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.storeNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t$(\"#collapse\"+storeNo).addClass(\"show\");\r\n");
      out.write("\t$(\"#collapse\"+storeNo).parent(\"li\").addClass(\"active\");\t\r\n");
      out.write("\t$(\"#collapse\"+storeNo+\">div>a.myChart\").addClass(\"active\");\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\t\t<div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/seller/sideBar.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Content Wrapper -->\r\n");
      out.write("    <div id=\"content-wrapper\" class=\"d-flex flex-column\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Main Content -->\r\n");
      out.write("      <div id=\"content\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Begin Page Content -->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("          <!-- Page Heading -->\r\n");
      out.write("          <h1 class=\"h3 mb-4 text-gray-800\">통계</h1>\r\n");
      out.write("           </div>\r\n");
      out.write("           <div class=\"card-header py-3\">\r\n");
      out.write("           <div class=\"card shadow mb-4\" style=\"width : 35rem; height : 30rem;\">\r\n");
      out.write("                <div class=\"card-header py-3 d-flex flex-row align-items-center justify-content-between\" >\r\n");
      out.write("                  <h6 class=\"m-0 font-weight-bold text-primary\" id=\"saleVolumeTitle\"> 판매량</h6>\r\n");
      out.write("                  <div class=\"dropdown no-arrow\">\r\n");
      out.write("                    <a class=\"dropdown-toggle\" href=\"#\" role=\"button\" id=\"dropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                      <i class=\"fas fa-ellipsis-v fa-sm fa-fw text-gray-400\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                     <div class=\"dropdown-menu dropdown-menu-right shadow animated--fade-in\" aria-labelledby=\"dropdownMenuLink\" id=\"chartofSaleVolume\">\r\n");
      out.write("                      <div class=\"dropdown-header\" >Sales volume by period:</div>\r\n");
      out.write("                      <div class=\"dropdown-item\" id=\"totalSaleVolumeofToday\" value=\"today\">Today</div>\r\n");
      out.write("                      <div class=\"dropdown-item\" id=\"totalSaleVolumeofWeek\" value=\"week\">Week</div>\r\n");
      out.write("                      <div class=\"dropdown-item\" id=\"totalSaleVolumeofMonth\" value=\"month\">Month</div>\r\n");
      out.write("                      <div class=\"dropdown-item\" id=\"totalSaleVolumeof3Month\" value=\"3month\">Three Month</div>\r\n");
      out.write("                    </div> \r\n");
      out.write("                  </div> \r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- card body -->\r\n");
      out.write("                <div class=\"card-body\" id=\"saleVolumeBody\" style=\"text-align : center;\">\r\n");
      out.write("                 <input class='form-control' type='text' id='weeklyDatePicker' placeholder='Select Week' readonly style=\"width:15rem; display :none;   \"/>&nbsp\r\n");
      out.write("                 <button type='button' class='btn btn-light' id='btnByWeek' style=\"display : none;\">조회</button>\r\n");
      out.write("                 <div class='timeChart' style='height : 90%;'></div>\r\n");
      out.write("                  </div>\r\n");
      out.write("              </div>\r\n");
      out.write("             \r\n");
      out.write("          </div>\r\n");
      out.write("        <!-- /.container-fluid -->\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- End of Main Content -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End of Content Wrapper -->\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- End of Page Wrapper -->\r\n");
      out.write("<script>\r\n");
      out.write("var chart = null;\r\n");
      out.write("google.charts.load('current', {'packages':['corechart']});\r\n");
      out.write("\r\n");
      out.write("$(\"div[id^=totalSaleVolumeof]\").css(\"cursor\",\"pointer\");\r\n");
      out.write("$(\"div[id^=totalSaleVolumeof]\").on('click',function(){\r\n");
      out.write("\tclearChart();\r\n");
      out.write("\t$(\"#saleVolumeTitle\").text(($(this).text())+\" 판매량\");\r\n");
      out.write("\tif($(this).text() === 'Week'){\r\n");
      out.write("\t\t$(\"#weeklyDatePicker\").css(\"display\",\"inline-block\");\r\n");
      out.write("\t\t$(\"#btnByWeek\").css(\"display\",\"inline\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$(\"#weeklyDatePicker\").css(\"display\",\"none\");\r\n");
      out.write("\t\t$(\"#btnByWeek\").css(\"display\",\"none\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("//주간 판매량을 볼 수 있다.\r\n");
      out.write("$('#btnByWeek').on(\"click\", function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar weeklyStartDate = $(\"#weeklyDatePicker\").val().substring(0, 10);\r\n");
      out.write("\t\tvar weeklyEndDate = $(\"#weeklyDatePicker\").val().substring(11, 21);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#hasData\").css(\"display\",\"none\");\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/seller/chartByWeek.do?weeklyStartDate=\"+weeklyStartDate+\"&weeklyEndDate=\"+weeklyEndDate+\"&storeNo=\"+'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${storeNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("',\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\tsuccess : function(data){\r\n");
      out.write("\t\t\t\tif(data.length != 0){ //data가 들어있는지 안들어있는지 검사하고 안들어있으면 현재 판매량이 없다고 보여줌.\r\n");
      out.write("\t\t  \t\t  \tgoogle.charts.load('current', {'packages':['corechart']});\r\n");
      out.write("\t\t  \t\t  \tgoogle.charts.setOnLoadCallback(drawChart(data,'week'));\r\n");
      out.write("\t\t\t\t  }else{\r\n");
      out.write("\t\t\t\t\t  var noData = $(\"<span id='hasData' style='position : relative; left : 8rem; top : 10rem; display : inline;'><i class='far fa-dizzy'></i>&nbsp이런 아직 판매량이 없습니다!</span>\");\r\n");
      out.write("\t\t\t\t\t  $(\".timeChart\").html(noData);\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t     \r\n");
      out.write("\t\t});//end of ajax\r\n");
      out.write("});\r\n");
      out.write("var storeNameForOne = \"\";\r\n");
      out.write("window.onload=function(){\r\n");
      out.write("    // 페이지가 로딩된 후 실행해야 되는 코드를 추가한다.\r\n");
      out.write("     var storeInfo = new Array();\r\n");
      out.write("\t    ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    \tstoreNameForOne = storeInfo[0].STORENAME;\r\n");
      out.write("\t\tif(storeInfo[0].originalPrice === 'noData'){\r\n");
      out.write("\t\t\tvar noData = $(\"<span id='hasData' style='position : relative;  top : 7rem; display : inline; '><i class='far fa-dizzy'></i>&nbsp이런 아직 판매량이 없습니다!</span>\");\r\n");
      out.write("\t\t\t$(\".timeChart\").html(noData);\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t//console.log(storeInfo);\r\n");
      out.write("\t\t\tgoogle.charts.setOnLoadCallback(drawChart(storeInfo,'today'));\r\n");
      out.write("\t\t}\r\n");
      out.write("}\r\n");
      out.write("$(function(){\r\n");
      out.write("\tvar startDate;\r\n");
      out.write("    var endDate;\r\n");
      out.write("    \t$(\"#weeklyDatePicker\").datepicker({\r\n");
      out.write("        \tdayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],\r\n");
      out.write("            dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], \r\n");
      out.write("            monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],\r\n");
      out.write("            monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],\r\n");
      out.write("            showOtherMonths: true,\r\n");
      out.write("            selectOtherMonths: true,\r\n");
      out.write("    \t\tselectWeek:true,\r\n");
      out.write("    \t\tyearRange: 'c-99:c+99',\r\n");
      out.write("    \t\tnextText : '다음달',\r\n");
      out.write("    \t\tprevText : '이전달',\r\n");
      out.write("            onSelect: function(dateText, inst) { \r\n");
      out.write("                var date = $(this).datepicker('getDate');\r\n");
      out.write("                startDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay());\r\n");
      out.write("                endDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay() + 6);\r\n");
      out.write("    \t\t\tvar dateFormat = 'yy/mm/dd'\r\n");
      out.write("                startDate = $.datepicker.formatDate( dateFormat, startDate, inst.settings );\r\n");
      out.write("                endDate = $.datepicker.formatDate( dateFormat, endDate, inst.settings );\r\n");
      out.write("\r\n");
      out.write("    \t\t\t$('#weeklyDatePicker').val(startDate + '~' + endDate);\r\n");
      out.write("                \r\n");
      out.write("                setTimeout(\"applyWeeklyHighlight()\", 100);\r\n");
      out.write("            },\r\n");
      out.write("    \t\tbeforeShow : function() {\r\n");
      out.write("    \t\t\tsetTimeout(\"applyWeeklyHighlight()\", 100);\r\n");
      out.write("    \t\t},\r\n");
      out.write("    \t\tonChangeMonthYear: function(year, month, widget) {\r\n");
      out.write("    \t\t\tsetTimeout(\"applyWeeklyHighlight()\", 100);\r\n");
      out.write("    \t\t}\r\n");
      out.write("        }); //end of datepicker\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function applyWeeklyHighlight() {\r\n");
      out.write("\t$('.ui-datepicker-calendar tr').each(function() {\r\n");
      out.write("\t\r\n");
      out.write("\t\tif ($(this).parent().get(0).tagName == 'TBODY') {\r\n");
      out.write("\t\t\t$(this).mouseover(function() {\r\n");
      out.write("\t\t\t\t$(this).find('a').css({\r\n");
      out.write("\t\t\t\t\t'background' : '#ffffcc',\r\n");
      out.write("\t\t\t\t\t'border' : '1px solid #dddddd'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(this).find('a').removeClass('ui-state-default');\r\n");
      out.write("\t\t\t\t$(this).css('background', '#ffffcc');\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(this).mouseout(function() {\r\n");
      out.write("\t\t\t\t$(this).css('background', '#ffffff');\r\n");
      out.write("\t\t\t\t$(this).find('a').css('background', '');\r\n");
      out.write("\t\t\t\t$(this).find('a').addClass('ui-state-default');\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//이미 그려져 있는 차트를 지운다.\r\n");
      out.write("function clearChart(){\r\n");
      out.write("\t  if(chart != null){\r\n");
      out.write("\t \t chart.clearChart();\r\n");
      out.write("\t  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//한주의 판매량 차트 그리기\r\n");
      out.write("function drawChart(data,types){\r\n");
      out.write("\t\r\n");
      out.write("\t  if(types === 'week'){\r\n");
      out.write("\t\t  var day = [];\r\n");
      out.write("\t\t  for(var i = 0; i < 2; i++){\r\n");
      out.write("\t\t\t  day[i] = new Array();\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  //각 요일별 총금액\r\n");
      out.write("\t\t  var storeName = [storeNameForOne,'같은 업종 평균 판매량'];\r\n");
      out.write("\t\t  for(var i in data){\r\n");
      out.write("\t\t\t  var sale = data[i];\r\n");
      out.write("\t\t\t  var totalSum = parseInt(sale.TOTALSUM);\r\n");
      out.write("\t\t\t  var number = parseInt(sale.NUM);\r\n");
      out.write("\t\t\t  var one = parseInt(sale.ONESUM);\r\n");
      out.write("\t\t\t  var averagePrice = 0;\r\n");
      out.write("\t          if(number != 0){\r\n");
      out.write("\t          \taveragePrice = totalSum/number;\r\n");
      out.write("\t          }\r\n");
      out.write("\t\t\t // day[0].push(sale.PERIOD);\r\n");
      out.write("\t\t\t  day[0].push(one);\r\n");
      out.write("\t\t\t  day[1].push(averagePrice);\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t  }// end of for in\r\n");
      out.write("\t\t  console.log(day);\r\n");
      out.write("\t\t  //2차 배열 생성\r\n");
      out.write("\t\t  var info = [];\r\n");
      out.write("\t\t  for(var i = 0; i < 8; i++){\r\n");
      out.write("\t\t\t  info[i] = new Array();\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  for(var j = 0; j < 2; j++){\r\n");
      out.write("\t\t\t  //처음은 카테고리가 들어갈 배열\r\n");
      out.write("\t\t\t  if(j == 0){\r\n");
      out.write("\t\t\t\t info[0][0] = 'week';\t \t\t\t \r\n");
      out.write("\t\t\t\t  for(var i = 0; i < storeName.length; i++){\r\n");
      out.write("\t\t\t\t\t  \tinfo[0][i+1] = storeName[i];\r\n");
      out.write("\t\t\t \t }//end of for\r\n");
      out.write("\t\t\t  }else{\r\n");
      out.write("\t\t\t\t  info[1][0] = 'Mon';\r\n");
      out.write("\t\t\t\t  info[2][0] = 'Tues';\r\n");
      out.write("\t\t\t\t  info[3][0] = 'Wed';\r\n");
      out.write("\t\t\t\t  info[4][0] = 'Thurs';\r\n");
      out.write("\t\t\t\t  info[5][0] = 'Fri';\r\n");
      out.write("\t\t\t\t  info[6][0] = 'Satur';\r\n");
      out.write("\t\t\t\t  info[7][0] = 'Sun';\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t  for(var i = 0; i < storeName.length; i++){\r\n");
      out.write("\t\t\t\t\tfor(var k = 1; k < info.length; k++){\r\n");
      out.write("\t\t\t\t\t  \tinfo[k][(i+1)] = 0;\r\n");
      out.write("\t\t\t\t\t  \tinfo[k][(i+1)] += day[i][k-1];\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t  }//end of for\r\n");
      out.write("\t  }else if(types === 'today'){\r\n");
      out.write("\t\t  var day = [];\r\n");
      out.write("\t\t\tvar storeName = [storeNameForOne];\r\n");
      out.write("\t\t\tfor(var i  = 0; i < storeName.length; i++){\r\n");
      out.write("\t\t\t\tday[i] = new Array();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//storeName = storeNameArr(data);\r\n");
      out.write("\t\t\t//makeArray(storeName.length);\r\n");
      out.write("\t\t  console.log(data);\r\n");
      out.write("\t\t  for(var i in data){\r\n");
      out.write("\t\t\t  var sale = data[i];\r\n");
      out.write("\t\t\t // console.log(sale.ORDERDAY);\r\n");
      out.write("\t\t\t  var totalPrice = parseInt(sale.TOTALPRICE);\r\n");
      out.write("\t          var hour = parseInt(sale.ORDERDAY);\r\n");
      out.write("\t\t\t\t  for(var i = 0; i < storeName.length; i++){\r\n");
      out.write("\t\t\t\t\t  if(storeName[i] != sale.STORENAME){\r\n");
      out.write("\t\t\t\t\t  }else{\r\n");
      out.write("\t\t\t\t\t\t  for(var k = 0; k < 24; k++){\r\n");
      out.write("\t\t\t\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t\t\t  if(hour == k){\r\n");
      out.write("\t\t\t\t\t\t\t\t  day[i][k] = 0;\r\n");
      out.write("\t\t\t\t\t\t\t\t  day[i][k] += totalPrice;\r\n");
      out.write("\t\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t\t /*  if(hour >= 0 && hour < 3){\r\n");
      out.write("\t\t\t\t\t\t\t  day[i] += totalPrice;\r\n");
      out.write("\t\t\t\t\t\t  }else if(hour >= 3 && hour < 3){\r\n");
      out.write("\t\t\t\t\t\t\t  day[i] += totalPrice;\r\n");
      out.write("\t\t\t\t\t\t  }else if(hour >= 6 && hour < 9){\r\n");
      out.write("\t\t\t\t\t\t\t  day[i] += totalPrice; \r\n");
      out.write("\t\t\t\t\t\t  }else if(hour >= 9 && hour < 12){\r\n");
      out.write("\t\t\t\t\t\t\t  day[i] += totalPrice;\r\n");
      out.write("\t\t\t\t\t\t  }else if(hour >= 12 && hour < 15){\r\n");
      out.write("\t\t\t\t\t\t\t  day[i] += totalPrice;\r\n");
      out.write("\t\t\t\t\t\t  }else if(hour >= 15 && hour < 18){\r\n");
      out.write("\t\t\t\t\t\t\t  day[i] += totalPrice;\r\n");
      out.write("\t\t\t\t\t\t  }else if(hour >= 18 && hour < 21){\r\n");
      out.write("\t\t\t\t\t\t\t  day[i] += totalPrice;\r\n");
      out.write("\t\t\t\t\t\t  }else if(hour >= 21 && hour <= 23){\r\n");
      out.write("\t\t\t\t\t\t\t  day[i] += totalPrice;\r\n");
      out.write("\t\t\t\t\t\t  } */\r\n");
      out.write("\t\t\t\t\t\t  break;\r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t  }//end of for\r\n");
      out.write("\t\t  }// end of for in\r\n");
      out.write("\t\t  var info = [];\r\n");
      out.write("\t\t  for(var i = 0; i < 25; i++){\r\n");
      out.write("\t\t\t  info[i] = new Array();\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t\t  //처음은 카테고리가 들어갈 배열\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t\t info[0][0] = 'Time';\t \t\t\t \r\n");
      out.write("\t\t\t\t  for(var i = 0; i < storeName.length; i++){\r\n");
      out.write("\t\t\t\t\t  \tinfo[0][i+1] = storeName[i];\r\n");
      out.write("\t\t\t \t }//end of for\r\n");
      out.write("\t\t\t\t  for(var i = 0; i < storeName.length; i++){\r\n");
      out.write("\t\t\t\t\t  for(var j = 1; j < info.length; j++){\r\n");
      out.write("\t\t\t\t\t\t  if((j-1) < 10){\r\n");
      out.write("\t\t\t\t\t\t  \tinfo[j][0] = \"0\"+(j-1)+\":00 ~ 0\"+(j)+\":00\";\r\n");
      out.write("\t\t\t\t\t\t  }else{\r\n");
      out.write("\t\t\t\t\t\t\tinfo[j][0] = (j-1)+\":00 ~ \"+(j)+\":00\";\r\n");
      out.write("\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t\t//  console.log(info);\r\n");
      out.write("\t\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t\t\t  info[j][(i+1)] = 0;\r\n");
      out.write("\t\t\t\t\t\t\t  info[j][(i+1)] = day[i][(j-1)];\r\n");
      out.write("\t\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t//console.log(info);\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\r\n");
      out.write("\t  }else if(types === 'month'){\r\n");
      out.write("\t\t  //day = []\r\n");
      out.write("\t\t  var storeName = [];\r\n");
      out.write("\t\t  storeName = storeNameArr(data);\r\n");
      out.write("\t\t  makeArray(storeName.length);\r\n");
      out.write("\t\t  console.log(day);\r\n");
      out.write("\t\t  for(var i in data){\r\n");
      out.write("\t\t\t  var sale = data[i];\r\n");
      out.write("\t          var date = parseInt((sale.ORDERDAY).substr(3));\r\n");
      out.write("\t          var totalPrice = parseInt(sale.TOTALPRICE);\r\n");
      out.write("\t\t\t\t  for(var i = 0; i < day.length; i++){\r\n");
      out.write("\t\t\t\t\t  if(storeName[i] != sale.STORENAME){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t  }else{\r\n");
      out.write("\t\t\t\t\t\t  day[i][date] = 0;\r\n");
      out.write("\t\t\t\t\t\t  day[i][date] += totalPrice;\r\n");
      out.write("\t\t\t\t\t\t  break;\r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t  }//end of for\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t  }// end of for in\r\n");
      out.write("\t\t  //2차 배열 생성\r\n");
      out.write("\t\t  var info = [];\r\n");
      out.write("\t\t  for(var i = 0; i < 32; i++){\r\n");
      out.write("\t\t\t  info[i] = new Array();\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t//처음은 카테고리가 들어갈 배열\r\n");
      out.write("\t\tinfo[0][0] = 'Day';\t \t\t\t \r\n");
      out.write("\t\t for(var i = 0; i < storeName.length; i++){\r\n");
      out.write("\t\t  \tinfo[0][i+1] = storeName[i];\r\n");
      out.write("\t\t \tfor(var k = 1; k <= 31; k++ ){\r\n");
      out.write("\t\t\t  info[k][0] = k+'일';\r\n");
      out.write("\t\t\t  if(day[i][k] > 0){\r\n");
      out.write("\t\t\t  \t//console.log(day[i][k]+\" i: \"+i+\" k: \"+k +\" i+1:\"+(i+1));\r\n");
      out.write("\t\t\t\t  info[k][i+1] = day[i][k];\r\n");
      out.write("\t\t\t  }else{\r\n");
      out.write("\t\t\t\t  info[k][i+1] = 0;\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t \t}\r\n");
      out.write("\t\t\t}//end of for\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t // console.log(info);\r\n");
      out.write("\t  }else if(types === '3month'){\r\n");
      out.write("\t\t  var storeName = [];\r\n");
      out.write("\t\t  storeName = storeNameArr(data);\r\n");
      out.write("\t\t  makeArray(storeName.length);\r\n");
      out.write("\t\t   var date = new Date();\r\n");
      out.write("\t\t   var time =  (date.getMonth() + 1, 2);\r\n");
      out.write("\t\t  for(var i in data){\r\n");
      out.write("\t\t\t  var sale = data[i];\r\n");
      out.write("\t          var month = parseInt((sale.ORDERDAY));\r\n");
      out.write("\t          console.log(month);\r\n");
      out.write("\t          var totalPrice = parseInt(sale.TOTALPRICE);\r\n");
      out.write("\t\t\t\t  for(var i = 0; i < day.length; i++){\r\n");
      out.write("\t\t\t\t\t  if(storeName[i] != sale.STORENAME){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t  }else{\r\n");
      out.write("\t\t\t\t\t\t  day[i][month] = 0;\r\n");
      out.write("\t\t\t\t\t\t  day[i][month] += totalPrice;\r\n");
      out.write("\t\t\t\t\t\t  break;\r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t  }//end of for\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t  }// end of for in\r\n");
      out.write("\t\t  //2차 배열 생성\r\n");
      out.write("\t\t  var info = [];\r\n");
      out.write("\t\t  for(var i = 0; i < 4; i++){\r\n");
      out.write("\t\t\t  info[i] = new Array();\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  var info = [];\r\n");
      out.write("\t\t//처음은 카테고리가 들어갈 배열\r\n");
      out.write("\t\tinfo[0][0] = 'Month';\t \t\t\t \r\n");
      out.write("\t\t for(var i = 0; i < storeName.length; i++){\r\n");
      out.write("\t\t  \tinfo[0][i+1] = storeName[i];\r\n");
      out.write("\t\t \tfor(var k = 3; k > 0; k-- ){\r\n");
      out.write("\t\t \t\tif(time-k == 0){\r\n");
      out.write("\t\t \t\t\tinfo[4-k][0] = '12월';\r\n");
      out.write("\t\t \t\t}else if(time-k == -1){\r\n");
      out.write("\t\t \t\t\tinfo[4-k][0] = '11월';\r\n");
      out.write("\t\t \t\t}else if((time-k) == -2){\r\n");
      out.write("\t\t \t\t\tinfo[4-k][0] = '10월';\r\n");
      out.write("\t\t \t\t}else{\r\n");
      out.write("\t\t\t\t\tinfo[4-k][0] = (time-k)+'월';\r\n");
      out.write("\t\t \t\t\t\r\n");
      out.write("\t\t \t\t}\r\n");
      out.write("\t\t\t  if(day[i][k] > 0){\r\n");
      out.write("\t\t\t  \t//console.log(day[i][k]+\" i: \"+i+\" k: \"+k +\" i+1:\"+(i+1));\r\n");
      out.write("\t\t\t\t  info[4-k][i+1] = day[i][k];\r\n");
      out.write("\t\t\t  }else{\r\n");
      out.write("\t\t\t\t  info[4-k][i+1] = 0;\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t \t}\r\n");
      out.write("\t\t\t}//end of for\r\n");
      out.write("\t\t\tconsole.log(info);\r\n");
      out.write("\t  }//end of types If\r\n");
      out.write("\t  \r\n");
      out.write("\t \r\n");
      out.write("\t  // Some raw data (not necessarily accurate) 2차 배열 형태로 넣어야함.\r\n");
      out.write("\t\tconsole.log(info);\r\n");
      out.write("\t    var chartData = google.visualization.arrayToDataTable(info);\r\n");
      out.write("\t    var options = {\r\n");
      out.write("\t      title : types+' Store Sale volume',\r\n");
      out.write("\t      vAxis: {title: 'Sale Price'},\r\n");
      out.write("\t      hAxis: {title: 'Time'},\r\n");
      out.write("\t      legend: { position: 'bottom' },\r\n");
      out.write("\t      seriesType: 'bars',\r\n");
      out.write("\t      series: {1: {type: 'line'}}\r\n");
      out.write("\t    };\r\n");
      out.write("\r\n");
      out.write("\t    chart = new google.visualization.ComboChart($(\".timeChart\")[0]);\r\n");
      out.write("\t    chart.draw(chartData, options);\r\n");
      out.write("\t\t  \r\n");
      out.write("\t  \r\n");
      out.write("}//end of drawChat\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>   \r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
      out.write('	');
      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_fmt_005frequestEncoding_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:requestEncoding
    org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag _jspx_th_fmt_005frequestEncoding_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag) _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag.class);
    boolean _jspx_th_fmt_005frequestEncoding_005f0_reused = false;
    try {
      _jspx_th_fmt_005frequestEncoding_005f0.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005frequestEncoding_005f0.setParent(null);
      // /WEB-INF/views/seller/myChart.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005frequestEncoding_005f0.setValue("UTF-8");
      int _jspx_eval_fmt_005frequestEncoding_005f0 = _jspx_th_fmt_005frequestEncoding_005f0.doStartTag();
      if (_jspx_th_fmt_005frequestEncoding_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.reuse(_jspx_th_fmt_005frequestEncoding_005f0);
      _jspx_th_fmt_005frequestEncoding_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005frequestEncoding_005f0, _jsp_getInstanceManager(), _jspx_th_fmt_005frequestEncoding_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/seller/myChart.jsp(119,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/seller/myChart.jsp(119,5) '${saleVolume}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${saleVolume}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/seller/myChart.jsp(119,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("info");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t    \tvar json = new Object();\r\n");
            out.write("\t    \tjson.originalPrice = '");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${info.originalPrice}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("';\r\n");
            out.write("\t    \tjson.STORENAME = '");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${info.STORENAME}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("';\r\n");
            out.write("\t    \tjson.storeNo = '");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${info.STORENO}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("';\r\n");
            out.write("\t    \tjson.TOTALPRICE = '");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${info.TOTALPRICE}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("';\r\n");
            out.write("\t    \tjson.ORDERDAY = '");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${info.ORDERDAY}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("';\r\n");
            out.write("\t    \tstoreInfo.push(json);\r\n");
            out.write("\t    ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
