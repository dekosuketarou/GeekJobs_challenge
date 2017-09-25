<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    if (session.getAttribute("ac") != null) {
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO) hs.getAttribute("result");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"href="styleSheet1.css">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <div class="base">
            <h1>詳細情報</h1>
            <table width="100%">
                <tr><th colspan="2">
                        <div class="oripad">
                            ID:<%= udd.getUserID()%><br>
                            名前:<%= udd.getName()%><br>
                            生年月日:<%= udd.getBirthday()%><br>
                            種別:<%= udd.getType()%><br>
                            電話番号:<%= udd.getTell()%><br>
                            自己紹介:<BR><%= udd.getComment()%><br>
                            登録日時:<%= udd.getNewDate()%><br>
                        </div>
                    </th></tr>
                <tr><td><BR>
                        <form action="Update" method="POST">
                            <input type="submit" name="update" value="ユーザー情報変更">
                        </form></td>
                    <td><BR>
                        <form action="Delete" method="POST">
                            <input type="submit" name="delete" value="ユーザー情報削除">
                        </form>
                    </td></tr></table>
        </div>
        <br>
        <div style="text-align: center">
            <%=jh.home()%>
        </div>
            <%}else{response.sendRedirect("index.jsp");}%>        
    </body>
</html>
