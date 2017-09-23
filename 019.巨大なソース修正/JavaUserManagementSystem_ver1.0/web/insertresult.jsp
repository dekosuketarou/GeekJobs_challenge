<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<!--sessionを取得し、保存された情報を初期値として出力する-->
<%
    HttpSession hs = request.getSession();
    //insertconfirm同様アクセス条件を照合する
     String accessCheck = request.getParameter("ac");
    if (accessCheck == null || (Integer) session.getAttribute("ac") != Integer.parseInt(accessCheck)) {
        out.print("アクセスが不正です");
    } else {
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        <%UserDataBeans udb=(UserDataBeans)hs.getAttribute("udb");%>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        以上の内容で登録しました。<br>
    </body>
<%}%><BR>
    <%
    //セッションの破棄
    hs.removeAttribute("ac");
    hs.removeAttribute("udb");
    hs.removeAttribute("emptyMessage");
    %>
    <%=JumsHelper.getInstance().home()%>
</html>
