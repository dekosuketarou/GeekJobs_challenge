<%-- 
    Document   : Inputjsp
    Created on : 2017/09/16, 13:01:22
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="stylesheet1.css">
<!DOCTYPE html>
<html>
    <head>
        

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .left{
                min-width: 100px;
                height:100%;
                width:20%;
                float: right;
                background-color:antiquewhite;   
            }
            .center{
                min-width:500px;
                width:60%;
                float: right;
             ;
            }
            .right{
                min-width: 100px;
                height:100%;
                width:20%;
           
                background-color:antiquewhite;    
            }
            h1{
                height:30px;
                text-align: center;
            }
            .menuA{
                margin:0px;
                padding: 0px;
            }
            .menuA ul{
                margin:0px;
                padding:0px;
                font-size:0;
            }
            .menuA ul li{
               
                height:15px;
                width:25%;
                display:inline-block;
                list-style:none;
                text-align: center;
                font-size: 10px;
                color:white;
                background-color:aquamarine;
            }   

        </style>
        
        <title>JSP Page</title>
    </head>
    <body>
        <div class="left"></div>
        <div class="center">
           <%
                request.setCharacterEncoding("UTF-8");
                String flag=request.getParameter("name");
                if(request.getParameter("name")!=null){
                    out.print("氏名 "+request.getParameter("name")+"<BR>");
    
                    if(request.getParameter("gender")!=null){
                        out.print("性別 "+request.getParameter("gender")+"<BR>");
                    }

                    if(request.getParameter("gender")!=null){
                        out.print("趣味 "+request.getParameter("like")+"<BR>");
                    }
                }
           %>
            <h1>プログラマー生活n日目</h1>
            <div class="menuA">
                    <ul>
                        <li><a href="">項目０</a></li>
                        <li><a href="">項目１</a></li>
                        <li><a href="">項目２</a></li>
                        <li><a href="">項目３</a></li>
                    </ul>


            </div>
            <div>
                <form action="Inputjsp.jsp">
                    氏名<BR><input type="text" name="name"><BR><BR>
                    性別<BR><input type="radio" name="gender" value="男">男
                    <input type="radio" name="gender" value="女">女<BR><BR>

                    趣味を書いてください<BR>
                    <textarea name="like" cols="30" rows="5" value="aaa"></textarea><BR><BR>
                    <input type="submit" value="送信">
                    <input type="reset" value="reset">

                </form>
            </div>
        </div>
        <div class="right"></div>
    </body>
</html>
