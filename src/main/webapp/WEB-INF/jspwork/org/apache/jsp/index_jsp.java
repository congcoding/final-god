/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
<<<<<<< HEAD
 * Generated at: 2019-02-23 07:38:16 UTC
=======
 * Generated at: 2019-02-22 09:06:50 UTC
>>>>>>> 384f12c04acdf523c895b58323eb3f0bd47c3a20
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.release();
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("pageTitle", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("배달의 신", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/home.css\" />\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("section#menu-content{\r\n");
      out.write("\tbackground: linear-gradient(to top, \r\n");
      out.write("\t\t\t\ttransparent 0, transparent 78%,\r\n");
      out.write("\t\t\t\t#32aeb8 78%, #32aeb8 100%);\r\n");
      out.write("}\r\n");
      out.write("div#menu-content{\r\n");
      out.write("    padding: 50px;\r\n");
      out.write("    overflow: auto;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("    max-width: 912px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div#search-container{\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("    padding: 50px 0 35px 0;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("}\r\n");
      out.write(".card{\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("    height: 250px;\r\n");
      out.write("    float: left;\r\n");
      out.write("    margin: 10px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("function categoryList(item){\r\n");
      out.write("\tvar categoryNo = $(item).attr(\"name\");\r\n");
      out.write("    location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
<<<<<<< HEAD
      out.write("/storeInfo/storeInfoList.do?categoryNo=\"+categoryNo;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t    url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/carouselEvent.do\",\r\n");
      out.write("\t    dataType : \"json\",\r\n");
      out.write("\t    contentType : \"application/json; charset=UTF-8\",\r\n");
      out.write("\t    success: function(data) {\r\n");
      out.write("\t    \t$.each(data,function(index,item){\r\n");
      out.write("\t    \t\tconsole.log(item[0]);\r\n");
      out.write("\t    \t\t\tvar html = \"\";\r\n");
      out.write("\t    \t\t\tvar count = \"\";\r\n");
      out.write("\t    \t\tfor(var i in item){\r\n");
      out.write("\t    \t\t\tif(i==0){\r\n");
      out.write("\t    \t\t\t\tcount += \"<li data-target='#carouselExampleIndicators' data-slide-to='0' class='active'></li>\";\r\n");
      out.write("\t    \t\t\t}else{\r\n");
      out.write("\t    \t\t\t\tcount += \"<li data-target='#carouselExampleIndicators' data-slide-to='\"+i+\"'></li>\";\r\n");
      out.write("\t    \t\t\t}\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t\t$(\"#countEvent\").html(count);\r\n");
      out.write("\t    \t\tfor(var i in item){\r\n");
      out.write("\t    \t\t\tconsole.log(item[i].EVENTNO);\r\n");
      out.write("\t    \t\t\tif(i==0){\r\n");
      out.write("\t    \t\t\t\thtml += \"<div class='carousel-item active'>\";\r\n");
      out.write("\t    \t\t\t}else {\r\n");
      out.write("\t    \t\t\t\thtml +=\"<div class='carousel-item'>\";\t\r\n");
      out.write("\t    \t\t\t}\r\n");
      out.write("\t    \t\t\thtml += \"<img onclick='fn_eventView(\"+item[i].EVENTNO+\")'\"; \r\n");
      out.write("\t    \t\t\thtml += \"class='d-block w-100' style='height:212px;width:812px;' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/upload/event/\"+item[i].EVENTSMALL+\"' />\";\r\n");
      out.write("    \t\t\t\thtml +=\"</div>\";\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t\t\t$(\"#eventShow\").html(html);\r\n");
      out.write("\t    \t\t\t\r\n");
      out.write("\t    \t});\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    },error : function(request,status,error){\r\n");
      out.write("\t    \tconsole.log(\"code:\"+request.status+\"\\n\"+\"message:\"+request.responseText+\"\\n\"+\"error:\"+error);\r\n");
      out.write("\t    }\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function fn_eventView(eventNo){\r\n");
      out.write("\tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/event/eventView.do?eventNo=\"+eventNo;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<section id=\"menu-content\">\r\n");
      out.write("\t<div id=\"menu-content\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div id=\"event-container\">\r\n");
      out.write("\t\t\t<div id=\"carouselExampleIndicators\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("\t\t\t  <ol class=\"carousel-indicators\" id=\"countEvent\">\r\n");
      out.write("\t\t\t    <!-- <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("\t\t\t    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\r\n");
      out.write("\t\t\t    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li> -->\r\n");
      out.write("\t\t\t  </ol>\r\n");
      out.write("\t\t\t  <div class=\"carousel-inner\" id=\"eventShow\">\r\n");
      out.write("\t\t\t\t  \t\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t  <a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"prev\">\r\n");
      out.write("\t\t\t    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("\t\t\t    <span class=\"sr-only\">Previous</span>\r\n");
      out.write("\t\t\t  </a>\r\n");
      out.write("\t\t\t  <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"next\">\r\n");
      out.write("\t\t\t    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("\t\t\t    <span class=\"sr-only\">Next</span>\r\n");
      out.write("\t\t\t  </a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t   \t<div id=\"search-container\">\r\n");
      out.write("\t\t   <form class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("\t\t     <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\" id=\"search\">\r\n");
      out.write("\t\t     <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\r\n");
      out.write("\t\t   </form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
=======
      out.write("/storeInfo/storeInfoList.do?categoryNo=\"+categoryNo;\n");
      out.write("}\n");
      out.write("\n");
      out.write("$(function(){\n");
      out.write("\t$.ajax({\n");
      out.write("\t    url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/carouselEvent.do\",\n");
      out.write("\t    dataType : \"json\",\n");
      out.write("\t    contentType : \"application/json; charset=UTF-8\",\n");
      out.write("\t    success: function(data) {\n");
      out.write("\t    \t$.each(data,function(index,item){\n");
      out.write("\t    \t\t\n");
      out.write("\t    \t\t\tvar html = \"\";\n");
      out.write("\t    \t\t\tvar count = \"\";\n");
      out.write("\t    \t\tfor(var i in item){\n");
      out.write("\t    \t\t\tif(i==0){\n");
      out.write("\t    \t\t\t\tcount += \"<li data-target='#carouselExampleIndicators' data-slide-to='0' class='active'></li>\";\n");
      out.write("\t    \t\t\t}else{\n");
      out.write("\t    \t\t\t\tcount += \"<li data-target='#carouselExampleIndicators' data-slide-to='\"+i+\"'></li>\";\n");
      out.write("\t    \t\t\t}\n");
      out.write("\t    \t\t}\n");
      out.write("\t    \t\t$(\"#countEvent\").html(count);\n");
      out.write("\t    \t\tfor(var i in item){\n");
      out.write("\t    \t\t\t\n");
      out.write("\t    \t\t\tif(i==0){\n");
      out.write("\t    \t\t\t\thtml += \"<div class='carousel-item active'>\";\n");
      out.write("\t    \t\t\t}else {\n");
      out.write("\t    \t\t\t\thtml +=\"<div class='carousel-item'>\";\t\n");
      out.write("\t    \t\t\t}\n");
      out.write("\t    \t\t\thtml += \"<img onclick='fn_eventView(\"+item[i].EVENTNO+\")'\"; \n");
      out.write("\t    \t\t\thtml += \"class='d-block w-100' style='height:212px;width:812px;' src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/upload/event/\"+item[i].EVENTSMALL+\"' />\";\n");
      out.write("    \t\t\t\thtml +=\"</div>\";\n");
      out.write("\t    \t\t}\n");
      out.write("\t    \t\t\t$(\"#eventShow\").html(html);\n");
      out.write("\t    \t\t\t\n");
      out.write("\t    \t});\n");
      out.write("\t    \t\n");
      out.write("\t    },error : function(request,status,error){\n");
      out.write("\t    \tconsole.log(\"code:\"+request.status+\"\\n\"+\"message:\"+request.responseText+\"\\n\"+\"error:\"+error);\n");
      out.write("\t    }\n");
      out.write("\t});\n");
      out.write("});\n");
      out.write("\n");
      out.write("function fn_eventView(eventNo){\n");
      out.write("\tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/event/eventView.do?eventNo=\"+eventNo;\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<section id=\"menu-content\">\n");
      out.write("\t<div id=\"menu-content\">\n");
      out.write("\t\n");
      out.write("\t\t<div id=\"event-container\">\n");
      out.write("\t\t\t<div id=\"carouselExampleIndicators\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("\t\t\t  <ol class=\"carousel-indicators\" id=\"countEvent\">\n");
      out.write("\t\t\t    <!-- <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("\t\t\t    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\n");
      out.write("\t\t\t    <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li> -->\n");
      out.write("\t\t\t  </ol>\n");
      out.write("\t\t\t  <div class=\"carousel-inner\" id=\"eventShow\">\n");
      out.write("\t\t\t\t  \t\n");
      out.write("\t\t\t  </div>\n");
      out.write("\t\t\t  <a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"prev\">\n");
      out.write("\t\t\t    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("\t\t\t    <span class=\"sr-only\">Previous</span>\n");
      out.write("\t\t\t  </a>\n");
      out.write("\t\t\t  <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"next\">\n");
      out.write("\t\t\t    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("\t\t\t    <span class=\"sr-only\">Next</span>\n");
      out.write("\t\t\t  </a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t   \t<div id=\"search-container\">\n");
      out.write("\t\t   <form class=\"form-inline my-2 my-lg-0\">\n");
      out.write("\t\t     <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\" id=\"search\">\n");
      out.write("\t\t     <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n");
      out.write("\t\t   </form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\n");
      out.write("\t\n");
>>>>>>> 384f12c04acdf523c895b58323eb3f0bd47c3a20
      out.write("\t");
      out.write("\r\n");
      out.write("\t\t<!-- 치킨 / 보쌈,족발  / 피자 / 한식 /중식/일식/분식/ -->\r\n");
      out.write("\t\t<div class=\"card bg-white text-black\">\r\n");
      out.write("\t\t\t<a onclick=\"categoryList(this);\" name=\"1\">\r\n");
      out.write("\t\t\t  <img class=\"card-img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/chicken.png\" >\r\n");
      out.write("\t\t\t  <div class=\"card-img-overlay\">\r\n");
      out.write("\t\t\t    <h5 class=\"card-title\">치킨</h5>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"card bg-white text-black\">\r\n");
      out.write("\t\t\t<a onclick=\"categoryList(this);\" name=\"2\">\r\n");
      out.write("\t\t\t  <img class=\"card-img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/pizza.png\" >\r\n");
      out.write("\t\t\t  <div class=\"card-img-overlay\">\r\n");
      out.write("\t\t\t    <h5 class=\"card-title\">피자</h5>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"card bg-white text-black\">\r\n");
      out.write("\t\t\t<a onclick=\"categoryList(this);\" name=\"3\">\r\n");
      out.write("\t\t\t  <img class=\"card-img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/jokbal_bossam.png\" >\r\n");
      out.write("\t\t\t  <div class=\"card-img-overlay\">\r\n");
      out.write("\t\t\t    <h5 class=\"card-title\">보쌈,족발</h5>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"card bg-white text-black\">\r\n");
      out.write("\t\t\t<a onclick=\"categoryList(this);\" name=\"4\">\r\n");
      out.write("\t\t\t  <img class=\"card-img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/snack.png\" >\r\n");
      out.write("\t\t\t  <div class=\"card-img-overlay\">\r\n");
      out.write("\t\t\t    <h5 class=\"card-title\">분식</h5>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"card bg-white text-black\">\r\n");
      out.write("\t\t\t<a onclick=\"categoryList(this);\" name=\"5\">\r\n");
      out.write("\t\t\t  <img class=\"card-img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/chinese.png\" >\r\n");
      out.write("\t\t\t  <div class=\"card-img-overlay\">\r\n");
      out.write("\t\t\t    <h5 class=\"card-title\">중식</h5>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"card bg-white text-black\">\r\n");
      out.write("\t\t\t<a onclick=\"categoryList(this);\" name=\"6\">\r\n");
      out.write("\t\t\t  <img class=\"card-img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/japanese.png\" >\r\n");
      out.write("\t\t\t  <div class=\"card-img-overlay\">\r\n");
      out.write("\t\t\t    <h5 class=\"card-title\">일식</h5>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"card bg-white text-black\">\r\n");
      out.write("\t\t\t<a onclick=\"categoryList(this);\" name=\"7\">\r\n");
      out.write("\t\t\t  <img class=\"card-img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/korean.png\" >\r\n");
      out.write("\t\t\t  <div class=\"card-img-overlay\">\r\n");
      out.write("\t\t\t    <h5 class=\"card-title\">한식</h5>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"content\">\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</section>\t\r\n");
      out.write("<script>\r\n");
      out.write("//21897f5bf48b00dcb812e4f648ac8393\r\n");
      out.write("function getLocation(){\r\n");
      out.write("\tif(navigator.geolocation){\r\n");
      out.write("\t\tnavigator.geolocation.getCurrentPosition(function(position) {\r\n");
      out.write("\t\t\tvar lon = position.coords.latitude; //y\r\n");
      out.write("\t\t\tvar lat = position.coords.longitude; //x\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t//https://developers.kakao.com/docs/restapi/local#좌표-행정구역정보-변환\r\n");
      out.write("\t\t\t    url: 'https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x='+lat+'&y='+lon,\r\n");
      out.write("\t\t\t    type: 'GET',\r\n");
      out.write("\t\t\t    cache: false,\r\n");
      out.write("\t\t\t    contentType : 'application/json;charset=UTF-8',\r\n");
      out.write("\t\t\t    crossOrigin: true,\r\n");
      out.write("\t\t\t    headers:{'Authorization' : 'KakaoAK 4c6d6939204abedb25e64dcf1adfaaf2'},\r\n");
      out.write("\t\t\t    success: function(data) {\r\n");
      out.write("\t\t\t    \tconsole.log(data);\r\n");
      out.write("\r\n");
      out.write("\t\t\t    \tconsole.log(data.documents[0].region_2depth_name);\r\n");
      out.write("\t\t\t    \tconsole.log(data.documents[0].address_name);\r\n");
      out.write("\t\t\t    \tvar address=data.documents[0].address_name;\r\n");
      out.write("\t\t\t    \t$(\"#search\").val(address);\r\n");
      out.write("\t\t\t    },error:function(request,status,error){\r\n");
      out.write("\t\t\t        alert(\"다시 시도해주세요.\\n\" + \"code:\"+request.status+\"\\n\"+\"message:\"+request.responseText+\"\\n\"+\"error:\"+error);\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}, function(error){\r\n");
      out.write("\t\t\tconsole.log(error);\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tenableHighAccuracy:false,\r\n");
      out.write("\t\t\tmaximumAge:0,\r\n");
      out.write("\t\t\ttimeout : Infinity\r\n");
      out.write("\t\t});\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\talert(\"GPS를 지원하지 않습니다.\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("getLocation();\r\n");
      out.write("</script>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
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
      // /index.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
}
