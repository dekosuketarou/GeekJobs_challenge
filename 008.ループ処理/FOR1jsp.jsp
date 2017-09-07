<%-- 
    Document   : FOR1jsp
    Created on : 2017/09/06, 22:49:23
    Author     : DEKO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            long base=1l;
            final int eight=8;
            for(int i=0;i<20;i++){
            base *=eight;
        }
            out.print(base);

        %>
    </body>
</html>
