<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    if (session.getAttribute("ac") == null) {
        response.sendRedirect("index.jsp");
    } else {
        JumsHelper jh = JumsHelper.getInstance();
        HttpSession hs = request.getSession();
        ArrayList<UserDataDTO> AL = (ArrayList<UserDataDTO>) hs.getAttribute("resultData");
//    UserDataDTO udd = (UserDataDTO)request.getAttribute("resultData");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styleSheet1.css" type="text/css">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <div class="base" align="center">
            <h1>検索結果</h1>
            <% if (AL != null) {%>
            <table border=1 >
                <tr>
                    <th>ID</th>
                    <th>名前</th>
                    <th>生年月日</th>
                    <th>種別</th>
                    <th>登録日時</th>
                </tr>
                <%
                    for (UserDataDTO udd : AL) {
                %>
                <tr>
                    <td><%= udd.getUserID()%></td>
                    <td><a href="ResultDetail?id=<%= udd.getUserID()%>"><%= udd.getName()%></a></td>
                    <td><%= udd.getBirthday()%></td>
                    <td><%= udd.getType()%></td>
                    <td><%= udd.getNewDate()%></td>
                </tr>
                <%}%>
            </table>
            <%} else if (AL == null) {%><%="該当するデータがありません"%><BR>
            <a href="search.jsp">検索画面へ戻る</a><BR>
            <%}%>
        </div>
        <br>
        <div style="text-align: center">
            <%=jh.home()%>
        </div>
        <%}%>        
    </body>
</html>
