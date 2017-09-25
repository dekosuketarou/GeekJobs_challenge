<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper" %>
<%
    if (request.getAttribute("ac") != null) {
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) request.getAttribute("update");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"href="styleSheet1.css">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <div class="base">
            <h1>変更結果</h1><br>

            <table border=1 align="center" width="440px">
                <tr><th>ID</th>
                    <th>名前</th>
                    <th>生年月日</th>
                    <th>種別</th>
                    <th>電話番号</th>
                    
                </tr>

                <tr>
                    <td><%= udd.getUserID()%></td>
                    <td><%= udd.getName()%></a></td>
                    <td><%= udd.getBirthday()%></td>
                    <td><%= udd.getType()%></td>
                    <td><%= udd.getTell()%></td>
                </tr>
                <tr><th rowspan="1">自己紹介</th>
                <td colspan="4"><%= udd.getComment()%></td>
                </tr>
            </table>
                <h2>以上の内容で登録しました</h2>
        </div>
        <div style="text-align: center">
            <%=jh.home()%>
        </div>
            <%}else{response.sendRedirect("index.jsp");}%>        
    </body>

</html>
