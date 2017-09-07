<%-- 
    Document   : WHILE1jsp
    Created on : 2017/09/06, 23:25:18
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
        double base=1000.0;
        while(!(base<=100)){
            base /=2;
        }
        
        //out.print(base);
        %>
    </body>
</html>
