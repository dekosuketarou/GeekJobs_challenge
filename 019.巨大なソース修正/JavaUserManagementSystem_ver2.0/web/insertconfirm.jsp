<%@page import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();

    if (session.getAttribute("ac") != null) {

        UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");
        ArrayList<String> chkList = udb.chkproperties();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styleSheet1.css" type="text/css">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <div class="base">
            <% if (chkList.size() == 0) {%>
            <div class="oripad">
                <h1>登録確認</h1>
                名前:<%= udb.getName()%><br>
                生年月日:<%= udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日"%><br>
                種別:<%= jh.exTypenum(udb.getType())%><br>
                電話番号:<%= udb.getTell()%><br>
                自己紹介:<br><%= udb.getComment()%><br><br>
                上記の内容で登録しますが、よろしいですか？<br><br>
            </div>
            <table width="100%">
                <tr><td>
                        <form action="InsertResult" method="POST">
                            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                            <input type="submit" name="yes" value="はい" >
                        </form>
                    </td>
                    <td>
                        <form action="Insert" method="POST">
                            <input type="submit" name="no" value="登録画面に戻る">
                            <input type="hidden" name="mode" value="REINPUT">
                        </form>
                    </td></tr>
            </table>
            <% } else {%>
            <h1>入力が不完全です</h1>
            <table width="100%">
                <tr><td>
                        <%=jh.chkinput(chkList)%></td></tr><tr><td>
                        <BR>
                        <form action="Insert" method="POST">
                            <input type="submit" name="no" value="登録画面に戻る">
                            <input type="hidden" name="mode" value="REINPUT">
                        </form>
                    </td></tr>
            </table>
            <% }%>
        </div>
        <BR>
        <div style="text-align: center">
            <%=jh.home()%>
        </div>
            <%}else{response.sendRedirect("index.jsp");}%>
    </body>
</html>
