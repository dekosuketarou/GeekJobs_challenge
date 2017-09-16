<%-- 
    Document   : questling2
    Created on : 2017/09/16, 15:33:55
    Author     : guest1Day
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
            request.setCharacterEncoding("UTF-8");
            
            int total=   Integer.parseInt(request.getParameter("total"));
            int count=   Integer.parseInt(request.getParameter("count"));
            int type=    Integer.parseInt(request.getParameter("type"));

            if(type==1){
                out.print("雑貨<BR>");
            }else if(type==2){
                out.print("生鮮食品<BR>");
            }else{
                out.print("その他<BR>");                
            }
            int price=total/count;
            out.print("１個当たりの値段は"+price+"です<BR><BR>");
            
            out.print("今回付与されたポイントは");
            
            if(total>=5000){
                int point=(int)(total*0.04);
                out.print(point+"ポイントです、またのご利用お待ちしております。");
            }else if(total>=3000){
                int point=(int)(total*0.03);
                out.print(point+"ポイントです、またのご利用お待ちしております。");
            }else{
                out.print("ありませんでした、またのご利用お待ちしております。");
            }

            %>
    </body>
</html>
