/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-02-18 09:19:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class answeringView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1548382399000L));
    _jspx_dependants.put("jar:file:/Users/jueun/Desktop/sts_workspace/GodOfDelivery/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fmt.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/Users/jueun/Desktop/sts_workspace/GodOfDelivery/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fn.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/Users/jueun/Desktop/sts_workspace/GodOfDelivery/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_fmt_005frequestEncoding_005f0(_jspx_page_context))
        return;
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("pageTitle", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("배달의 신", request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("div#board-container input{width:400px; margin:0 auto; text-align:center;}\n");
      out.write("div#board-container div{width:400px; margin:0 auto; }\n");
      out.write("div#mine {margin-left:350px; font-weight : bold;}\n");
      out.write("div#mine_ {margin-left:350px; font-weight : bold;}\n");
      out.write("table#tbl-board tr th{text-align:center;}\n");
      out.write("table#tbl-board tr td{text-align:center;}\n");
      out.write("a {text-decoration:none;}\n");
      out.write("div#head-container{margin:70px auto; width : 900px; height:50px;}\n");
      out.write("div#qna{margin-left : -40px; width : 450px; height : 50px; text-align : center; font-weight : bold;cursor : pointer;display: table-cell;vertical-align: middle;}\n");
      out.write("div#asking{margin-top:-50px; margin-left : 500px; width : 450px; height : 50px; text-align : center; font-weight : bold; cursor : pointer;display: table-cell;vertical-align: middle;}\n");
      out.write("input#boardTitle{font-weight : bold;}\n");
      out.write("div#answer{margin-top:-50px;}\n");
      out.write("</style>\n");
      out.write("<script>\n");
      out.write("function fn_goAskingList(){\n");
      out.write("\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberLoggedIn }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" != \"\"){\n");
      out.write("\t\tvar memberId= \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberLoggedIn.memberId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\n");
      out.write("\t\tlocation.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/askingList.do?boardWriter=\"+memberId;\t\n");
      out.write("\t}else if(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sellerLoggedIn }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" != \"\"){\n");
      out.write("\t\tvar sellerId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sellerLoggedIn.sellerId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\n");
      out.write("\t\tlocation.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/askingList.do?boardWriter=\"+sellerId;\n");
      out.write("\t}else if(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sellerLoggedIn }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" == \"\" && \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberLoggedIn }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" == \"\"){\n");
      out.write("\t\talert(\"로그인 후 이용 가능합니다.\");\n");
      out.write("\t\treturn;\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("function fn_goQnaList(){\n");
      out.write("\tlocation.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/qnaboard.do\";\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"head-container\">\n");
      out.write("\t<div id=\"qna\" class=\"alert-light\" onclick=\"fn_goQnaList();\">FAQ</div> <div id=\"asking\" class=\"alert-info\" onclick=\"fn_goAskingList();\">1:1문의</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write(" \t\t<div id=\"mine\" class=\"alert-light\"> 나의 문의 내용 : </div>\n");
      out.write(" \t\t<br />\n");
      out.write(" \t<div id=\"board-container\">\n");
      out.write(" \t\t\n");
      out.write("\t\t<input type=\"text\" class=\"form-control\" placeholder=\"제목\" name=\"boardTitle\" id=\"boardTitle\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.boardTitle }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("\t\t<br />\n");
      out.write("\t\t<div class=\"form-control\" name=\"boardContent\" placeholder=\"내용\" style=\"border:none; height:150px;\" required>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.boardContent }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("\t\t<div id=\"answer\">\n");
      out.write("\t\t\t<div id=\"mine_\" class=\"alert-light\"> 답변 : </div>\n");
      out.write("\t\t\t\t<div class=\"answering-container\" style=\"margin-left:450px; color:darkblue;font-weight : bold;\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${boardRef.boardContent }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("  </div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\n");
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
      // /WEB-INF/views/admin/answeringView.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
