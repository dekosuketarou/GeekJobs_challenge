<%@page 
    import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"href="styleSheet1.css">
        <title>JUMSユーザー情報検索画面</title>
    </head>
    <body>
        <div class="base">
            <h1>ユーザー情報検索</h1>
            <div class="oripad">
                <form action="SearchResult" method="POST">
                    名前:
                    <input type="text" name="name">
                    <br><br>

                    生年:　
                    <select name="year">
                        <option value="">----</option>
                        <% for (int i = 1950; i <= 2010; i++) {%>
                        <option value="<%=i%>"><%=i%></option>
                        <% } %>
                    </select>年生まれ
                    <br><br>

                    種別:
                    <br>
                    <% for (int i = 1; i <= 3; i++) {%>
                    <input type="radio" name="type" value="<%=i%>"><%=jh.exTypenum(i)%><br>
                    <% }%>
                    </div>
                    <br>

                    <div style="text-align: center"><input type="submit" name="btnSubmit" value="検索"></div>
                    <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                </form>
            </div>
            <br>
            <div style="text-align: center">
                <%=jh.home()%>
            </div>
    </body>
</html>
