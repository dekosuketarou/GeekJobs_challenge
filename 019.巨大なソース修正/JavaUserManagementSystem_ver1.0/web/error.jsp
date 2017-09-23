<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.JumsHelper" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error</title>
    </head>
    <body>
        エラーが発生しました。以下の項目を確認してください。<br>
        <%if(request.getAttribute("error")!=null){%><%=request.getAttribute("error")%><%}else{%>トップページ以外からのアクセス<%}%>
    </body>
    <BR>
    <%=JumsHelper.getInstance().home()%>
</html>
