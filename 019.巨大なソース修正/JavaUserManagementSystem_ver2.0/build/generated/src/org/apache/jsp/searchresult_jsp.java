package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import jums.JumsHelper;
import jums.UserDataDTO;

public final class searchresult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    ArrayList<UserDataDTO> AL = (ArrayList<UserDataDTO>) hs.getAttribute("resultData");
//    UserDataDTO udd = (UserDataDTO)request.getAttribute("resultData");
    if (AL != null) {

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\"href=\"styleSheet1.css\">\r\n");
      out.write("        <title>JUMS検索結果画面</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"base\" align=\"center\">\r\n");
      out.write("            <h1>検索結果</h1>\r\n");
      out.write("            <table border=1 >\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>ID</th>\r\n");
      out.write("                    <th>名前</th>\r\n");
      out.write("                    <th>生年月日</th>\r\n");
      out.write("                    <th>種別</th>\r\n");
      out.write("                    <th>登録日時</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                    for (UserDataDTO udd : AL) {
                
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>");
      out.print( udd.getUserID());
      out.write("</td>\r\n");
      out.write("                    <td><a href=\"ResultDetail?id=");
      out.print( udd.getUserID());
      out.write('"');
      out.write('>');
      out.print( udd.getName());
      out.write("</a></td>\r\n");
      out.write("                    <td>");
      out.print( udd.getBirthday());
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( udd.getType());
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( udd.getNewDate());
      out.write("</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("            </table>\r\n");
      out.write("            ");
} else if (AL == null) {
      out.print("該当するデータがありません");
      out.write("<BR>\r\n");
      out.write("            <a href=\"search.jsp\">検索画面へ戻る</a><BR>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <div style=\"text-align: center\">\r\n");
      out.write("            ");
      out.print(jh.home());
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("            ");
}else{response.sendRedirect("index.jsp");}
      out.write("        \r\n");
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
