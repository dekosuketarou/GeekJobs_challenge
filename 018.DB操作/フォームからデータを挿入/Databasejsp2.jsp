<%-- 
    Document   : Databasejsp2
    Created on : 2017/09/20, 18:33:06
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
        <form action="DatabaseServ2" method="post">
            <%-- DBの設定によってIDは連続番号にしているのでIDは入力しない --%>
            名前<BR>
            <input type="text" name="name"><BR>
            年齢<BR>
            <input type="number" name="age" maxlength="3"><BR>
            電話番号<BR>
            <input type="text" name="tell" ><BR>
            <p color="gray"> 記入例:0123-45-6789<BR></p>
            生年月日<BR>
            <input type="date" name="birth"><BR><BR>
            <input type="submit" value="送信">&nbsp&nbsp<input type="reset" value="リセット">
            
            
        </form>
    </body>
</html>
