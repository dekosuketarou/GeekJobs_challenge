<%-- 
    Document   : Databasejsp3
    Created on : 2017/09/20, 20:36:07
    Author     : DEKO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DB.DTO3,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            ArrayList<String> message=new ArrayList<String>();
            DTO3 dto=new DTO3();
            request.setCharacterEncoding("UTF-8");
            
            message=dto.selData();
            
            for(String str:message){
                out.print(str+("<BR>"));
            }        

            out.print("_____________________________________________________");
        %>
        
        
        <form action="DatabaseServ3" method="post">
            
            削除するIDを指定してください<BR>
            <input type="number" name="number"><BR>

            <input type="submit" value="送信">&nbsp&nbsp<input type="reset" value="リセット">
            
            
        </form>
    </body>
</html>
