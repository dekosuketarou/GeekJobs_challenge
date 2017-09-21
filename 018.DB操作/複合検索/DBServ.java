/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 *
 * @author guest1Day
 */
public class DBServ extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            
            String url="jdbc:mysql://localhost:3306/challenge_db";
            String user="root";
            String pass="geekjobs";            
            
            try{
                String name=request.getParameter("name");
                int age=Integer.parseInt(request.getParameter("age"));
                String birthday=request.getParameter("birthday");
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con=DriverManager.getConnection(url,user,pass);
                
                ps=con.prepareStatement("select * from profiles where name=? or age=? or birthday=?");
                ps.setString(1,name);
                ps.setInt(2, age);
                ps.setString(3,birthday);
                
                rs=ps.executeQuery();
                while(rs.next()){
                    String id=rs.getString("profilesID");
                    String n=rs.getString("name");
                    String a=rs.getString("age");
                    String t=rs.getString("tell");
                    String b=rs.getString("birthday");
                    out.print("ID:"+id+"<BR>名前:"+n+"<BR>電話番号:"+t+"<BR>年齢:"+a+"<BR>生年月日:"+b+"<BR>");
                    
                }
                
                con.close();
                ps.close();
                rs.close();
                
            }catch(IllegalAccessException e){
                
            }catch(Exception e){
                try{
                    if(con!=null){
                        out.print("コネクション切断に成功しました");
                    }else{
                        con.close();
                    }
                }catch(SQLException ex){
                    out.print("コネクション切断にしっぱいｓ");
                }    
                    
            }
                
            
            
            
            
            
            
            
            
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
