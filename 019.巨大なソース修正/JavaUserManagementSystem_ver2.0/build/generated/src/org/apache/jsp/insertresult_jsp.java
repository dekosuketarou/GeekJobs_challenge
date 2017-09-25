package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import jums.JumsHelper;
import jums.UserDataBeans;

public final class insertresult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');

    if (request.getAttribute("ac") != null) {    
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans) request.getAttribute("udb");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\"href=\"styleSheet1.css\">\r\n");
      out.write("        <title>JUMS登録結果画面</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"base\">\r\n");
      out.write("            <h1>登録結果</h1><br>\r\n");
      out.write("            <table align=\"center\"><tr><td style=\"text-align: left\">\r\n");
      out.write("            名前:");
      out.print( udb.getName());
      out.write("<br>\r\n");
      out.write("            生年月日:");
      out.print( udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日");
      out.write("<br>\r\n");
      out.write("            種別:");
      out.print( jh.exTypenum(udb.getType()));
      out.write("<br>\r\n");
      out.write("            電話番号:");
      out.print( udb.getTell());
      out.write("<br>\r\n");
      out.write("            自己紹介:<br>");
      out.print( udb.getComment());
      out.write("<br>\r\n");
      out.write("            以上の内容で登録しました。<br><br>\r\n");
      out.write("                    </td></tr></table>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <div style=\"text-align: center\">\r\n");
      out.write("            ");
      out.print(jh.home());
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
}else{response.sendRedirect("index.jsp");}
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
