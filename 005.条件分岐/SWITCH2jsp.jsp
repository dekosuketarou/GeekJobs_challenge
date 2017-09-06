<%-- 
    Document   : SWITCH2jsp
    Created on : 2017/09/06, 18:25:52
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
              char lang='あ';  
                switch(lang){
                    case 'A':
                        out.print("英語");
                        break;
                    case 'あ':
                        out.print("日本語");
                        break;
                }

                %>
        </h1>
    </body>
</html>
