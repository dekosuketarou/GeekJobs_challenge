package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.JumsHelper;
import jums.UserDataDTO;

public final class delete_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");

    if (session.getAttribute("ac") != null) {
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO) hs.getAttribute("result");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\"href=\"styleSheet1.css\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("            <div class=\"base\">\r\n");
      out.write("        <h1>削除確認</h1>\r\n");
      out.write("        <table align=\"center\">\r\n");
      out.write("            <tr><th colspan=\"2\" align=\"left\">\r\n");
      out.write("        以下の内容を削除します。よろしいですか？<br>\r\n");
      out.write("        名前:");
      out.print( udd.getName());
      out.write("<br>\r\n");
      out.write("        生年月日:");
      out.print( udd.getBirthday());
      out.write("<br>\r\n");
      out.write("        種別:");
      out.print( udd.getType());
      out.write("<br>\r\n");
      out.write("        電話番号:");
      out.print( udd.getTell());
      out.write("<br>\r\n");
      out.write("        自己紹介:<br>");
      out.print( udd.getComment());
      out.write("<br>\r\n");
      out.write("        登録日時:");
      out.print( udd.getNewDate());
      out.write("<br>\r\n");
      out.write("                </th></tr>\r\n");
      out.write("            <tr><td>\r\n");
      out.write("        <form action=\"DeleteResult\" method=\"POST\">\r\n");
      out.write("            <input type=\"submit\" name=\"YES\" value=\"はい\">\r\n");
      out.write("        </form>\r\n");
      out.write("                </td><td>\r\n");
      out.write("        <form action=\"ResultDetail\" method=\"POST\">\r\n");
      out.write("            <input type=\"submit\" name=\"NO\" value=\"詳細画面に戻る\">\r\n");
      out.write("        </form>\r\n");
      out.write("                </td></tr></table>\r\n");
      out.write("            </div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <div style=\"text-align: center\">\r\n");
      out.write("        ");
      out.print(jh.home());
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("            ");
}else{response.sendRedirect("index.jsp");}
      out.write("         \r\n");
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
