<%@page import="jums.JumsHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"href="styleSheet1.css">
        <title>error</title>
    </head>
    <body>   
        <div class="base">
            エラーが発生しました。以下の項目を確認してください。<br>
            <%=request.getAttribute("error")%><br><br>
        </div>
        <div style="text-align: center">
            <%=JumsHelper.getInstance().home()%>
        </div>
    </body>
</html>
