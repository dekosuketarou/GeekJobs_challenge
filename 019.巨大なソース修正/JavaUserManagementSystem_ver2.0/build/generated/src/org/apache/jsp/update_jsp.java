package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.UserDataDTO;
import jums.JumsHelper;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO) hs.getAttribute("result");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\"href=\"styleSheet1.css\">\n");
      out.write("        <title>JUMS変更画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"base\">\n");
      out.write("            <h1>ユーザー情報変更</h1>\n");
      out.write("            <div class=\"oripad\">\n");
      out.write("                変更するユーザー情報<BR><BR>\n");
      out.write("                ID:");
      out.print(udd.getUserID());
      out.write("<br>\n");
      out.write("                名前:");
      out.print( udd.getName());
      out.write("<br>\n");
      out.write("                生年月日:");
      out.print( udd.getBirthday());
      out.write("<br>\n");
      out.write("                種別:");
      out.print( udd.getType());
      out.write("<br>\n");
      out.write("                電話番号:");
      out.print( udd.getTell());
      out.write("<br>\n");
      out.write("                自己紹介:");
      out.print( udd.getComment());
      out.write("<br><br>\n");
      out.write("\n");
      out.write("                ユーザー情報の変更箇所を入力してください<br><br>\n");
      out.write("                <form action=\"UpdateResult\" method=\"POST\">\n");
      out.write("                    名前:\n");
      out.write("                    <input type=\"text\" name=\"name\" value=\"\">\n");
      out.write("                    <br><br>\n");
      out.write("\n");
      out.write("                    生年月日:　\n");
      out.write("                    <select name=\"year\">\n");
      out.write("                        <option value=\"\">----</option>\n");
      out.write("                        ");
 for (int i = 1950; i <= 2010; i++) {
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(i);
      out.write("\" >");
      out.print(i);
      out.write("</option>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </select>年\n");
      out.write("                    <select name=\"month\">\n");
      out.write("                        <option value=\"\">--</option>\n");
      out.write("                        ");
 for (int i = 1; i <= 12; i++) {
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(i);
      out.write("\" >");
      out.print(i);
      out.write("</option>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </select>月\n");
      out.write("                    <select name=\"day\">\n");
      out.write("                        <option value=\"\">--</option>\n");
      out.write("                        ");
 for (int i = 1; i <= 31; i++) {
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </select>日\n");
      out.write("                    <br><br>\n");
      out.write("\n");
      out.write("                    種別:\n");
      out.write("                    <br>\n");
      out.write("                    ");
 for (int i = 1; i <= 3; i++) {
      out.write("\n");
      out.write("                    <input type=\"radio\" name=\"type\" value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(jh.exTypenum(i));
      out.write("<br>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                    <br>\n");
      out.write("\n");
      out.write("                    電話番号:\n");
      out.write("                    <input type=\"text\" name=\"tell\" value=\"\">\n");
      out.write("                    <br><br>\n");
      out.write("\n");
      out.write("                    自己紹介文\n");
      out.write("                    <br>\n");
      out.write("                    <textarea name=\"comment\" rows=10 cols=40 style=\"resize:none\" wrap=\"hard\"></textarea><br><br>\n");
      out.write("                    </div>\n");
      out.write("                    <div style=\"text-align: center\"><input type=\"submit\" name=\"btnSubmit\" value=\"確認画面へ\"></div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <div style=\"text-align: center\">\n");
      out.write("                ");
      out.print(jh.home());
      out.write("\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
