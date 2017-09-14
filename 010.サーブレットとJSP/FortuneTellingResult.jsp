<%-- 
    Document   : FortuneTellingResult
    Created on : 2017/09/08, 15:50:32
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.camp.servlet.ResultData" %>
<!DOCTYPE html>
<html>
    <head>
        <%
        //ResultData型でリクエストスコープに登録していた"DATA"を取得
        //その後取得した情報をResultData型にキャスト
        ResultData data = (ResultData)request.getAttribute("DATA");
        
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            //上部で取得した情報を出力
            if(data != null){
        out.print("<h1>あなたの"+ data.getD() + "の運勢は、"
                   +data.getLuck() +"です</h1>");
            }
        %>

    </body>
</html>
