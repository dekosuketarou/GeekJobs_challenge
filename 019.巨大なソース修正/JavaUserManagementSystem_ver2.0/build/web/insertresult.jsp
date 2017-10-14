<%@page import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    if (request.getAttribute("ac") != null) {    
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans) request.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styleSheet1.css" type="text/css">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <div class="base">
            <h1>登録結果</h1><br>
            <table align="center"><tr><td style="text-align: left">
            名前:<%= udb.getName()%><br>
            生年月日:<%= udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日"%><br>
            種別:<%= jh.exTypenum(udb.getType())%><br>
            電話番号:<%= udb.getTell()%><br>
            自己紹介:<br><%= udb.getComment()%><br>
            以上の内容で登録しました。<br><br>
                    </td></tr></table>
        </div>
        <br>
        <div style="text-align: center">
            <%=jh.home()%>
        </div>
        <%}else{response.sendRedirect("index.jsp");}%>
    </body>
</html>
