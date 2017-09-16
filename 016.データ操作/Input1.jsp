<%-- 
    Document   : Input1
    Created on : 2017/09/16, 14:48:44
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
         <form action="Input1.jsp">
            氏名<BR><input type="text" name="name"><BR><BR>
            性別<BR><input type="radio" name="gender" value="男">男
            <input type="radio" name="gender" value="女">女<BR><BR>

            趣味を書いてください<BR>
            <textarea name="like" cols="30" rows="5" value="aaa"></textarea><BR><BR>
            <input type="submit" value="送信">
            <input type="reset" value="reset">

        </form>
    </body>
</html>
