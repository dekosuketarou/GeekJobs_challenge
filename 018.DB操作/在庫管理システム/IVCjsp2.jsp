<%-- 
    Document   : IVCjsp2
    Created on : 2017/09/22, 10:21:27
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            HttpSession session1 = request.getSession(true);
            Object status = session.getAttribute("login");
            if (status == null) {
                response.sendRedirect("http://localhost:8080/IVC/IVCjsp1.jsp");
            }
        %>
        <style>
            .center{
                text-align: center;
            }
            .color1{
                background-color:lightcyan;
            }
            .color2{
                background-color:lemonchiffon;
            }
            .color3{
                background-color:navajowhite;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <iframe src="IVCjsp3.jsp" name="inline" width="100%" height="100px"></iframe>
        <table width="100%"><tr><td valign="top" class="color1">
                    <h3>商品情報登録フォーム</h3>
                    <form action="IVCServ2" method="post">
                        商品番号<BR>
                        <input type="number" name="itemNo"><BR>            
                        商品名<BR>
                        <input type="text" name="itemName"><BR>

                        値段<BR>
                        <input type="number" name="price" ><BR>

                        商品説明<BR>
                        <textarea name="anything"value=" "></textarea><BR>
                        <input type="submit" value="商品登録">&nbsp&nbsp<input type="reset" value="リセット">          
                    </form>
                </td>
                <td valign="top" class="color2">
                    <h3>商品情報変更フォーム</h3>
                    <form action="IVCServ4" method="post">
                        商品番号<BR>
                        <input type="number" name="itemNo"><BR>            
                        商品名<BR>
                        <input type="text" name="itemName"><BR>

                        値段<BR>
                        <input type="number" name="price" ><BR>

                        商品説明<BR>
                        <textarea name="anything"value=" "></textarea><BR>
                        <input type="submit" value="商品情報更新">&nbsp&nbsp<input type="reset" value="リセット">     
                    </form>

                </td>
                <td valign="top" class="color3">
                    <h3>商品情報削除フォーム</h3>
                    <form action="IVCServ3"method="post">
                        削除するIDを指定してください<BR><BR>
                        <input type="number" name="deleteNum"><BR><BR>

                        <input type="submit" value="削除申請">&nbsp&nbsp<input type="reset" value="リセット">

                    </form></td></tr></table>
        <BR>
        <iframe src="IVCjsp4.jsp" name="inline" width="100%" height="100px"></iframe>

        <table width="100%"><tr><td valign="top" class="color1">
                    <h3>在庫情報登録フォーム</h3>
                    <form action="IVCServ5" method="post">
                        商品番号<BR>
                        <input type="number" name="itemNo"><BR>            
                        商品名<BR>
                        <input type="text" name="itemName"><BR>

                        在庫数<BR>
                        <input type="number" name="count" ><BR>


                        <input type="submit" value="商品登録">&nbsp&nbsp<input type="reset" value="リセット">          
                    </form>
                </td>
                <td valign="top" class="color2">
                    <h3>在庫情報変更フォーム</h3>
                    <form action="IVCServ7" method="post">
                        商品番号<BR>
                        <input type="number" name="itemNo"><BR>            
                        商品名<BR>
                        <input type="text" name="itemName"><BR>

                        在庫数<BR>
                        <input type="number" name="count" ><BR>


                        <input type="submit" value="商品情報更新">&nbsp&nbsp<input type="reset" value="リセット">     
                    </form>

                </td>
                <td valign="top" class="color3">
                    <h3>在庫情報削除フォーム</h3>
                    <form action="IVCServ6"method="post">
                        削除するIDを指定してください<BR><BR>
                        <input type="number" name="deleteNum"><BR><BR>

                        <input type="submit" value="削除申請">&nbsp&nbsp<input type="reset" value="リセット">

                    </form></td></tr></table>
        <BR>






        <form action="IVCjsp1.jsp" class="center">
            <input type="submit" name="logout" value="ログアウト">
        </form>
    </body>
</html>