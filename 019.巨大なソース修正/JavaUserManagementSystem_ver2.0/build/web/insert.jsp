<%@page import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = null;
    boolean reinput = false;
    if (request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")) {
        reinput = true;
        udb = (UserDataBeans) hs.getAttribute("udb");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"href="styleSheet1.css">
        <title>JUMS登録画面</title>
    </head>
    <body>
        <div class="base">
            <h1>Jumsユーザー登録画面</h1>
            <div class="oripad">
                <form action="InsertConfirm" method="POST">
                    名前:
                    <input type="text" name="name" value="<% if (reinput) {
                    out.print(udb.getName());
                    }%>" maxlength="10">
                    <br><br>

                    生年月日:　
                    <select name="year">
                        <option value="">----</option>
                        <% for (int i = 1950; i <= 2010; i++) {%>
                        <option value="<%=i%>" <% if (reinput && udb.getYear() == i) {
                        out.print("selected = \"selected\"");
                    }%>><%=i%></option>
                        <% } %>
                    </select>年
                    <select name="month">
                        <option value="">--</option>
                        <% for (int i = 1; i <= 12; i++) {%>
                        <option value="<%=i%>" <% if (reinput && udb.getMonth() == i) {
                        out.print("selected = \"selected\"");
                    }%>><%=i%></option>
                        <% } %>
                    </select>月
                    <select name="day">
                        <option value="">--</option>
                        <% for (int i = 1; i <= 31; i++) {%>
                        <option value="<%=i%>"<% if (reinput && udb.getDay() == i) {
                        out.print("selected = \"selected\"");
                    }%>><%=i%></option>
                        <% } %>
                    </select>日
                    <br><br>

                    種別:
                    <br>
                    <% for (int i = 1; i <= 3; i++) {%>
                    <input type="radio" name="type" value="<%=i%>"<%if (reinput && udb.getType() == i) {
                            out.print("checked = \"checked\"");
                        }%>><%=jh.exTypenum(i)%><br>
                    <% } %>
                    <br>

                    電話番号:
                    <input type="text" name="tell" value="<% if (reinput) {
                    out.print(udb.getTell());
                }%>" maxlength="15">
                    <br><br>

                    自己紹介文
                    <br>
                    <textarea name="comment" rows=10 cols=35 style="resize:none" wrap="hard" maxlength="100"><% if (reinput) {
                    out.print(udb.getComment());
                }%></textarea><br><br>
                    </div>
                    <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                    <div style="text-align: center"><input type="submit" name="btnSubmit" value="確認画面へ" ></div>
                </form>
            </div>
            <br>
            <div style="text-align: center">
                <%=jh.home()%>
            </div>
    </body>
</html>
