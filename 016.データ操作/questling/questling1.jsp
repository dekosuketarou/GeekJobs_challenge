<%-- 
    Document   : questling1
    Created on : 2017/09/16, 15:12:55
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
        <form action="questling2.jsp">
            <select  name="total">    
                <option disabled="disabled">値段を選択してください</option>
                <option value="1500">1500円</option>
                <option value="3000">3000円</option>
                <option value="4500">4500円</option>
                <option value="10000">10000円</option>
                <option value="100000">100000円</option>
            </select>
            <BR><BR>
            <select name="count">    
                <option disabled="disabled">個数を選択してください</option>
                <option value="5">5個</option>
                <option value="10">10個</option>
                <option value="15">15</option>
                <option value="25">25</option>
                <option value="50">50</option>
            </select>
            <BR><BR>
            <input type="radio" name="type" value="1">雑貨
            <input type="radio" name="type" value="2">生鮮食品
            <input type="radio" name="type" value="3">その他
           <BR><BR>
            <input type="submit" name="btnsubmit" value="送信">
            
     
        </form>
    </body>
</html>
