<%-- 
    Document   : renso_hairetujsp
    Created on : 2017/09/06, 18:53:16
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
            HashMap<String,String> rennso=new HashMap<String,String>();
            rennso.put("1","AAA");
            rennso.put("hello","world");
            rennso.put("soeda","33");
            rennso.put("20","20");
            
            //out.print(rennso.get("20"));
            
            
            %>
            
            
        </h1>
    </body>
</html>
