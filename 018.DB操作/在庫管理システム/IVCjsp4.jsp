<%-- 
    Document   : IVCjsp4
    Created on : 2017/09/22, 17:47:06
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="IVC.DTOsel2,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            HttpSession session1 = request.getSession(true);
            Object status = session.getAttribute("login");
            if (status == null) {
                response.sendRedirect("IVCjsp1.jsp");
            }
        %>
    </head>
    <body>

        <%
            DTOsel2 dto = new DTOsel2();
            ArrayList<String> display = dto.selData();
            for (String str : display) {
                out.print(str);
            }

        %>
    </body>
</html>
