<%-- 
    Document   : InputField1
    Created on : 2017/09/17, 14:59:00
    Author     : DEKO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           //文字形式を設定
           request.setCharacterEncoding("UTF-8");
           //sessionインスタンスを作成
           HttpSession hs= request.getSession();
           //input情報をsessionに登録
           hs.setAttribute("name",request.getParameter("name"));
           hs.setAttribute("gender",request.getParameter("gender"));
           hs.setAttribute("like",request.getParameter("like"));
           //input情報を各変数に代入
           String username=(String)hs.getAttribute("name");
           String usergender=(String)hs.getAttribute("gender");
           String userlike=(String)hs.getAttribute("like");
           //radioチェック用に文字列変数を用意
           String check1="";
           String check2="";
           
           //input情報により分岐するchecked出力を用意
           if(hs.getAttribute("gender")!=null){
               if(hs.getAttribute("gender").equals("男")){
                   check1="checked";
               }
               if(hs.getAttribute("gender").equals("女")){
                   check2="checked";
               }
               
           }
       
        %>        
        
        <form action="InputField1.jsp">
            <%--<%%>によりhtmlに出力、インデントも文字数に含まれるので注意--%>
            名前<BR><input type="text" name="name" 
                         value=<% if(username != null){out.print(username);}else{out.print("");}%>><BR><BR>
            
            <%--ifで分岐したcheckedを出力--%>
            性別<BR><input type="radio" name="gender" value="男" <%=check1%>>男
            <input type="radio" name="gender" value="女" <%=check2%>>女<BR><BR>
            趣味<BR><textarea cols="30" rows="5" name="like"><%if(userlike!=null){out.print(userlike);}else{out.print("");}%></textarea><BR><BR>
            <input type="submit" name="btnsubmit" value="送信">
            <input type="reset" name="reset" value="reset">

        </form>
    </body>
</html>
