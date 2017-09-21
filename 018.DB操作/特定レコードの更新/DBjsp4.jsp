<%-- 
    Document   : DBjsp4
    Created on : 2017/09/21, 15:02:24
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DB.DTOsel,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <%
        
        DTOsel dtosel=new DTOsel();
        dtosel.select(request);
        ArrayList<String>result=dtosel.selData();
        for(String str:result){
            out.print(str+"<BR>");
        }
        
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="DBjsp4.jsp">
            入力した番号から10軒先のID情報を表示します<BR>
            <input type="number" name="selID"><BR>
            <input type="submit"value="表示"><BR><BR><BR>
        </form>
        <form action="DBServ4" method="post">
            ID番号<BR>
            <input type="number" name="id"><BR>
            名前<BR>
            <input type="text" name="name" required="required"><BR>
            電話番号<BR>
            <input type="number" name="tell" required="required"><BR>
            年齢<BR>
            <input type="number" name="age" required="required"><BR>
            生年月日<BR>
            記入例:1989/9/22の場合1989-09-22と記入してください<BR>
            <input type="text" name="birthday" required="required"><BR>
            <input type="submit" value="submit">
            
        </form>
    </body>
</html>
