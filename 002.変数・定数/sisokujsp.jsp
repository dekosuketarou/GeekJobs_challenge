<%-- 
    Document   : sisokujsp
    Created on : 2017/09/06, 17:41:10
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
        <h1>
            <%
              final int num1=100;
              int num2=10;
              
              int tasu=num1+num2;   //足し算
              int hiku=num1-num2;   //引き算
              int kakeru=num1*num2; //掛け算
              int waru=num1/num2;   //割り算
              
              out.print(num1+"足す"+num2+"は"+tasu+"<br>");  
              out.print(num1+"引く"+num2+"は"+hiku+"<br>");    
              out.print(num1+"掛ける"+num2+"は"+kakeru+"<br>");    
              out.print(num1+"割る"+num2+"は"+waru+"<br>");    
                
           
            %>
        </h1>
    </body>
</html>
