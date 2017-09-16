<%-- 
    Document   : Input2
    Created on : 2017/09/16, 14:50:12
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
<%
    request.setCharacterEncoding("UTF-8");
    //nameの情報を変数へ代入
    String flag=request.getParameter("name");
    //if(中身がnullでも""でもなければ)
    if(request.getParameter("name")!=null){
        //氏名を表示
        out.print("氏名 "+request.getParameter("name")+"<BR>");
        //中身があれば性別を表示
        if(request.getParameter("gender")!=null){
            out.print("性別 "+request.getParameter("gender")+"<BR>");
        }
        //中身があれば趣味の記述を表示
        if(request.getParameter("gender")!=null){
            out.print("趣味 "+request.getParameter("like")+"<BR>");
        }
    }
%>
    </body>
</html>
