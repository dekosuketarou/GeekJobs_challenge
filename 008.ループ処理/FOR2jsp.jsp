<%-- 
    Document   : FOR2jsp
    Created on : 2017/09/06, 23:16:24
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
        String Aatumaru="";
        String Adainyu="A";
        
        for(int i=0;i<30;i++){
            Aatumaru +=Adainyu;
        }
        
        //out.print(Aatumaru.length());
        %>
    </body>
</html>
