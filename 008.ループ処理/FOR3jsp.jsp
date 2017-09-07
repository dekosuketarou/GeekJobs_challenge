<%-- 
    Document   : FOR3jsp
    Created on : 2017/09/06, 23:21:52
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
        int math=0;
        
        for(int i=0;i<=100;i++){
            math +=i;
        }
        //out.print(math);
        %>
    </body>
</html>
