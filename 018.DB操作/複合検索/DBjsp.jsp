<%-- 
    Document   : DBjsp
    Created on : 2017/09/21, 19:06:31
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
        
        <form action="DBServ" method=post>
            名前<BR>
            <input type="text" name="name"><BR>
            年齢<BR>
            <input type="number" name="age"><BR>
            生年月日<BR>
            <input type="text" name="birthday"><BR>
            <input type="submit" value="検索">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" value="リセット">
            
            
        </form> 
    </body>
</html>
