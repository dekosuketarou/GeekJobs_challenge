/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IVC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author guest1Day
 */
public class IVCServ4 extends HttpServlet {

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
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            String url = "jdbc:mysql://localhost:3306/IVC";
            String user = "root";
            String pass = "geekjobs";

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(url, user, pass);

            request.setCharacterEncoding("UTF-8");
            int itemNo = Integer.parseInt(request.getParameter("itemNo"));
            String itemName = request.getParameter("itemName");
            String anything = request.getParameter("anything");
            int price = Integer.parseInt(request.getParameter("price"));

                ps = con.prepareStatement("update IVCitem set itemName=?,anything=?,price=? where itemNo=?");
                ps.setString(1,itemName);
                ps.setString(2,anything);
                
                ps.setInt(3,price);
                ps.setInt(4,itemNo);

                ps.executeUpdate();

                con.close();
                ps.close();
                rs.close();
            } catch (SQLException e_sql) {
                System.out.print("接続時にエラーが発生しました。" + e_sql.getMessage());
            } catch (Exception e) {
                System.out.print("接続時にエラーが発生しました。" + e.getMessage());
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e_con) {
                        System.out.println(e_con.getMessage());
                    }
                }
                response.sendRedirect("http://localhost:8080/IVC/IVCjsp2.jsp");
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
