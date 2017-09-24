<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>

<%
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
        <title>JSP Page</title>
    </head>
    <body>
            <div class="base">
        <h1>削除確認</h1>
        <table align="center">
            <tr><th colspan="2" align="left">
        以下の内容を削除します。よろしいですか？<br>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= udd.getType()%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<br><%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>
                </th></tr>
            <tr><td>
        <form action="DeleteResult" method="POST">
            <input type="submit" name="YES" value="はい">
        </form>
                </td><td>
        <form action="ResultDetail" method="POST">
            <input type="submit" name="NO" value="詳細画面に戻る">
        </form>
                </td></tr></table>
            </div>
        <br>
        <div style="text-align: center">
        <%=jh.home()%>
        </div>
    </body>
</html>
