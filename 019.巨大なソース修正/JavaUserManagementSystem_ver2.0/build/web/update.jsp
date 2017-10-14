<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper" %>
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
        <link rel="stylesheet" href="styleSheet1.css" type="text/css">
        <title>JUMS変更画面</title>
    </head>
    <body>
        <div class="base">
            <h1>ユーザー情報変更</h1>
            <div class="oripad">
                変更するユーザー情報<BR><BR>
                ID:<%=udd.getUserID()%><br>
                名前:<%= udd.getName()%><br>
                生年月日:<%= udd.getBirthday()%><br>
                種別:<%= udd.getType()%><br>
                電話番号:<%= udd.getTell()%><br>
                自己紹介:<%= udd.getComment()%><br><br>

                ユーザー情報の変更箇所を入力してください<br><br>
                <form action="UpdateResult" method="POST">
                    名前:
                    <input type="text" name="name" maxlength="10">
                    <br><br>

                    生年月日:　
                    <select name="year">
                        <option value="">----</option>
                        <% for (int i = 1950; i <= 2010; i++) {%>
                        <option value="<%=i%>" ><%=i%></option>
                        <% } %>
                    </select>年
                    <select name="month">
                        <option value="">--</option>
                        <% for (int i = 1; i <= 12; i++) {%>
                        <option value="<%=i%>" ><%=i%></option>
                        <% } %>
                    </select>月
                    <select name="day">
                        <option value="">--</option>
                        <% for (int i = 1; i <= 31; i++) {%>
                        <option value="<%=i%>"><%=i%></option>
                        <% } %>
                    </select>日
                    <br><br>

                    種別:
                    <br>
                    <% for (int i = 1; i <= 3; i++) {%>
                    <input type="radio" name="type" value="<%=i%>"><%=jh.exTypenum(i)%><br>
                    <% }%>
                    <br>

                    電話番号:
                    <input type="text" name="tell" maxlength="10">
                    <br><br>

                    自己紹介文
                    <br>
                    <textarea name="comment" rows=10 cols=35 style="resize:none" wrap="hard" maxlength="100"></textarea><br><br>
                    </div>
                    <div style="text-align: center"><input type="submit" name="btnSubmit" value="確認画面へ"></div>
                </form>
            </div>
            <br>
            <div style="text-align: center">
                <%=jh.home()%>
            </div>
            <%}else{response.sendRedirect("index.jsp");}%>             
    </body>
</html>
