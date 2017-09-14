/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modori;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class Modori2 extends HttpServlet {

    String[] profiling4(String id,String name,String birth,String live){
        //returnに使うString配列を作成
        //戻り値の指定要素数は４つなので配列の要因を４に設定
        String[] str=new String[4];
        //引数で引き渡された値を配列に組み込む
        str[0]=id;
        str[1]=name;
        str[2]=birth;
        str[3]=live;
        
        //out.print(str[0]+"・・・メソッド内id<br>");
        //String配列を戻り値として返す
        return str;
    }
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
          //String配列にメソッドで作成した配列のアドレスを参照させる  
          String[] profile=profiling4("55","玉城裕也","1989/9/22","足立区");
          out.print("名前："+profile[1]+"<br>生年月日:"+profile[2]+"<br>住所:"+profile[3]);
          //out.print(profile[0]+"・・・戻り値取得一度目id<br>");
          //String[] profile2=profiling4("66","足立雅也","1965/9/22","沖縄県",out);
          //out.print(profile2[0]+"・・・戻り値取得二度目<br>");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
