<%-- 
    Document   : IVCjsp1
    Created on : 2017/09/22, 10:21:08
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*"%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .login{

                height: 100px;
                background: #ccc;
                padding: 100px;

                text-align:right;
            }
        </style>
    </head>
    <body>
        <%
            HttpSession session1 = request.getSession(true);

            Object status = session1.getAttribute("status");

            if (status != null) {
                session.setAttribute("status", null);
            }

        %>
        <div class="login">
            <form action="IVCServ1" method="post">

                account
                <input type="text" name="account"><BR>
                password</td></tr>
                <input type="password" name="password"><BR>
                <input type="submit" value="log_in">&nbsp;&nbsp;
                <input type="reset" value="reset">

            </form>
        </div>
    </body>
</html>
