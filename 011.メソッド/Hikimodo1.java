/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hikimodo;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author guest1Day
 */
public class Hikimodo1 extends HttpServlet {   
    
    String[] profilist(int i){
         //個人情報を登録する
        String[] profiling1 ={"1","玉城裕也","1989/9/22","足立区"};
        String[] profiling2 ={"2","滝廉太郎","1964/4/12","世田谷区"};
        String[] profiling3 ={"3","滝川クリステル","1834/4/3","並河区"};  
        /*
        String[] profiling4 ={"4","川クリテル","1634/4/4","並河区"};   
        String[] profiling5 ={"5","滝川スル","1434/4/5","並河区"};   
        String[] profiling6 ={"6","滝リステル","1334/4/6","並河区"}; 
        */
        //上記個人情報をナンバリングするためArrayListにて管理
        ArrayList<String[]>ALpro=new ArrayList<String[]>();
        ALpro.add(profiling1);
        ALpro.add(profiling2);
        ALpro.add(profiling3);
        /*
        ALpro.add(profiling4);
        ALpro.add(profiling5);
        ALpro.add(profiling6);
        */
        
        //ArrayList化して保管していたString[]を取り出して戻り値としてリターンする
        return ALpro.get(i);
    }
    String[]myProfile(String id){
        try{
           //取得したString型の値を整数か確かめる   
            int i=Integer.parseInt(id);
           //errが出なかったのでprofilistメソッドから個人情報を戻り値として取得する 
            String[]str=profilist(i);
           //取得したString[]データを戻り値としリターンする 
            return str;
        }catch(NumberFormatException e){
           //引数が整数でなかった場合そのまま終了
            return null;
        }
        
       
        
     
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //欲しい個人情報のナンバリング(id)を指定する
            String[]result=myProfile("0");
            //取得した個人情報を画面に表示する
            out.print("名前："+result[1]+"<br>生年月日:"+result[2]+"<br>住所:"+result[3]);
       
            
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
