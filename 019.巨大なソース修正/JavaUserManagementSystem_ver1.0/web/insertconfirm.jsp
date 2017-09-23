<%@page import="jums.UserDataBeans"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    //このページにアクセスした場合登録されている乱数で照合を行い
    //条件に合わない場合ページトップページへのリンクだけを出力する
    String accessCheck = request.getParameter("ac");
        if (accessCheck == null || (Integer) session.getAttribute("ac") != Integer.parseInt(accessCheck)) {
            out.print("アクセスが不正です");
        } else {
        LinkedHashMap<String, String> emptyMessage = new LinkedHashMap<String, String>();
        emptyMessage = (LinkedHashMap) hs.getAttribute("emptyMessage");
        
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% if (emptyMessage.size() == 0) {%>
        <%UserDataBeans udb=(UserDataBeans)hs.getAttribute("udb");%>
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <% } else { %>

        <%for (Map.Entry<String, String> errorMes : emptyMessage.entrySet()) {%>
        <%=errorMes.getValue()%><%}%>が入力されていません<BR>
        <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
    </body>
    <%}%><BR>
    <!--JumsHelperを利用し、トップ画面へのリンクをhtmlへ出力する-->
    <%=JumsHelper.getInstance().home()%>
</html>
