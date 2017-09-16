<%-- 
    Document   : analysis
    Created on : 2017/09/16, 17:55:42
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
            
            
            //取得したパラメータの中身がnullでないか確かめる
            if(request.getParameter("number")!=null){
                //パラメータをintに変換
                int num=Integer.parseInt(request.getParameter("number")); 
                boolean bl=true;
                //元の数値を出力する
                out.print("元の値: "+num+"<BR>");
                out.print("素因数: ");
                
                if(num==1){
                    out.print("<BR>残りの値"+1);
                    bl=false;      
                }
                
                //最初の素数2からスタート
                while(num%2==0){
                            out.print(2+" ");
                            num =num/2;
                }
                while(num%3==0){
                            out.print(3+" ");
                            num =num/3;
                }
                for(int i =3;i<=num;){
                    //2ずつ増えていく   
                    i+=2;
                    //今回の条件は１桁の素数なのでここで条件を決める
                    if(i>=10){
                        break;
                    }
                    //4などの素数でない数字は2,3で割っていくのでなくなる
                    while(num%i==0){
                        out.print(i+" ");
                        num =num/i;
                    }
                  }
                //残りの数値が1の時割り切ったことになる

                if(num > 1) out.print("<BR>残りの値: "+num+"<BR>"); 
                if(num==1&&bl==true)out.print("<BR>割り切れました<BR>");

            }
            
            
        %>
        <form action="analysis.jsp">
            数字を入力してください<BR>
            <input type="number" name="number" maxlength="9"><BR><BR>
            <input type="submit" value="送信">            
            
        </form>
    </body>
</html>
