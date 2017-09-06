<%-- 
    Document   : introduction_jsp
    Created on : 2017/09/06, 17:19:41
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
            int age=27;
            String name ="玉城裕也";
            out.print("こんにちは、私の名前は" + name +"です。<br>" );
            out.print("歳は"+ age + "の独身なので絶賛彼女募集中！<br>");
            out.print("これからはキャンプ生として精進していきたいと思いますので<br>"
                    + "何卒よろしくお願い致します");


        
                
        %>
        </h1>
        
    </body>
</html>
