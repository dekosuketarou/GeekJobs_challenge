package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import jums.JumsHelper;
import jums.UserDataBeans;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = null;
    boolean reinput = false;
    if (request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")) {
        reinput = true;
        udb = (UserDataBeans) hs.getAttribute("udb");
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\"href=\"styleSheet1.css\">\r\n");
      out.write("        <title>JUMS登録画面</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"base\">\r\n");
      out.write("            <h1>Jumsユーザー登録画面</h1>\r\n");
      out.write("            <div class=\"oripad\">\r\n");
      out.write("                <form action=\"InsertConfirm\" method=\"POST\">\r\n");
      out.write("                    名前:\r\n");
      out.write("                    <input type=\"text\" name=\"name\" value=\"");
 if (reinput) {
                    out.print(udb.getName());
                    }
      out.write("\" maxlength=\"10\">\r\n");
      out.write("                    <br><br>\r\n");
      out.write("\r\n");
      out.write("                    生年月日:　\r\n");
      out.write("                    <select name=\"year\">\r\n");
      out.write("                        <option value=\"\">----</option>\r\n");
      out.write("                        ");
 for (int i = 1950; i <= 2010; i++) {
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print(i);
      out.write('"');
      out.write(' ');
 if (reinput && udb.getYear() == i) {
                        out.print("selected = \"selected\"");
                    }
      out.write('>');
      out.print(i);
      out.write("</option>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                    </select>年\r\n");
      out.write("                    <select name=\"month\">\r\n");
      out.write("                        <option value=\"\">--</option>\r\n");
      out.write("                        ");
 for (int i = 1; i <= 12; i++) {
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print(i);
      out.write('"');
      out.write(' ');
 if (reinput && udb.getMonth() == i) {
                        out.print("selected = \"selected\"");
                    }
      out.write('>');
      out.print(i);
      out.write("</option>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                    </select>月\r\n");
      out.write("                    <select name=\"day\">\r\n");
      out.write("                        <option value=\"\">--</option>\r\n");
      out.write("                        ");
 for (int i = 1; i <= 31; i++) {
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print(i);
      out.write('"');
 if (reinput && udb.getDay() == i) {
                        out.print("selected = \"selected\"");
                    }
      out.write('>');
      out.print(i);
      out.write("</option>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                    </select>日\r\n");
      out.write("                    <br><br>\r\n");
      out.write("\r\n");
      out.write("                    種別:\r\n");
      out.write("                    <br>\r\n");
      out.write("                    ");
 for (int i = 1; i <= 3; i++) {
      out.write("\r\n");
      out.write("                    <input type=\"radio\" name=\"type\" value=\"");
      out.print(i);
      out.write('"');
if (reinput && udb.getType() == i) {
                            out.print("checked = \"checked\"");
                        }
      out.write('>');
      out.print(jh.exTypenum(i));
      out.write("<br>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                    <br>\r\n");
      out.write("\r\n");
      out.write("                    電話番号:\r\n");
      out.write("                    <input type=\"text\" name=\"tell\" value=\"");
 if (reinput) {
                    out.print(udb.getTell());
                }
      out.write("\" maxlength=\"15\">\r\n");
      out.write("                    <br><br>\r\n");
      out.write("\r\n");
      out.write("                    自己紹介文\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <textarea name=\"comment\" rows=10 cols=35 style=\"resize:none\" wrap=\"hard\" maxlength=\"100\">");
 if (reinput) {
                    out.print(udb.getComment());
                }
      out.write("</textarea><br><br>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <input type=\"hidden\" name=\"ac\"  value=\"");
      out.print( hs.getAttribute("ac"));
      out.write("\">\r\n");
      out.write("                    <div style=\"text-align: center\"><input type=\"submit\" name=\"btnSubmit\" value=\"確認画面へ\" ></div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("            <div style=\"text-align: center\">\r\n");
      out.write("                ");
      out.print(jh.home());
      out.write("\r\n");
      out.write("            </div>\r\n");
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
