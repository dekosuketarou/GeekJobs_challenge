<%@page import="jums.JumsHelper"%>

<%
    JumsHelper jh = JumsHelper.getInstance();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"href="styleSheet1.css">
        <title>削除結果画面</title>
    </head>
    <body>    <div class="base">

            <h1>指定したデータを削除しました</h1>

        </div>
        <br>
        <div style="text-align: center">
            <%=jh.home()%>
        </div>
    </body>

</html>
