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
 * @author DEKO
 */
public class DatabaseServ1 extends HttpServlet {

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
            
            
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            
            String url="jdbc:mysql://localhost:3306/challenge_db";
            String user="deko";
            String pass="geekjobs";
      
            try{
                
                request.setCharacterEncoding("UTF-8");
                String keyword=request.getParameter("keyword");
                out.print(keyword);
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con=DriverManager.getConnection(url,user,pass);
                
                ps=con.prepareStatement("select * from profiles where name like ? ");
                
                //setStringで上記sqlのパラメータに代入するときは''で囲まれるので記述の必要はない
                ps.setString(1,"%" + keyword + "%");
                
                rs=ps.executeQuery();
                
                while(rs.next()){
                    int id=rs.getInt("profilesID");
                    String name=rs.getString("name");
                    String tell=rs.getString("tell");
                    int age=rs.getInt("age");
                    String birth=rs.getString("birthday");
                    out.print(" "+id+" "+name+" "+tell+" "+age+" "+birth);
                }
                
                con.close();
                ps.close();
                rs.close();
            }catch(IllegalAccessException e){
                out.print("予期せぬ接続エラーが発生しました"+e.getMessage());
            }catch(ClassNotFoundException e){
                out.print("接続エラーが発生しました"+e.getMessage());
                
            }catch(InstantiationException e){
                out.print("予期せぬエラーが発生しました"+e.getMessage());
                
            }catch(SQLException e){
                out.print("接続エラーが発生しました"+e.getMessage());
                
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
