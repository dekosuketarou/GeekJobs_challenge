/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Random;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import org.camp.servlet.ResultData;
/**
 *
 * @author guest1Day
 */
public class FortuneTelling extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
                String[] luckList={"大吉","中吉","吉","半吉","末小吉","凶","小凶","半凶","末凶","凶","大凶"};
            
            //Randomメソッドでインスタンスを作成
            Random rand=new Random();
            //lucklistの要員数を調べ、その数の中から数字をランダムに取得
            Integer index =rand.nextInt(luckList.length);
                
                //同パッケージにあるResultDataのインスタンスを作成
                ResultData data=new ResultData();
                
                //ResultDataのsetterを呼び出し、Dateを記述
                //new Dateは日時の取得の意味
                data.setD(new Date());
                //下記と上記は同一の意味
                //Date date=new Date();
                //data.setD(date);
                
                //ResultDataのメソッドsetLuckでフィールドのluckを設定
                //luckList[index]のindexは上記にある乱数の名前
                data.setLuck(luckList[index]);
                
                //setAttributeで占いの結果dataを"DATA"としてリクエストスコープに登録
                request.setAttribute("DATA",data);
                
                //String resultにファイルパスを設定
                //今回の場合本記述の下部にあるrequest.getRequestDispatcher()の引数
                final String result="WEB-INF/jsp/FortuneTellingResult.jsp";
                
                //引数を指定してその指定したパスに対してRequestDispatcherオブジェクトを生成
                RequestDispatcher rd=request.getRequestDispatcher(result);
                //上記で生成したRequestDispatcherオブジェクトの情報をforwardで
                //servletクラスからjspクラスへ処理を移行
                rd.forward(request,response);
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FortuneTelling</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FortuneTelling at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
