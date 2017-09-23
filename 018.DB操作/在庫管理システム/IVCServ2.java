package IVC;

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
public class IVCServ2 extends HttpServlet {

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
            int itemNo = Integer.parseInt(request.getParameter("itemNo"));
            String itemName = request.getParameter("itemName");
            String anything = request.getParameter("anything");
            int price = Integer.parseInt(request.getParameter("price"));

            Connection con = null;
            PreparedStatement ps = null;

            String url = "jdbc:mysql://localhost:3306/IVC";
            String user = "root";
            String pass = "geekjobs";

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(url, user, pass);

                ps = con.prepareStatement("insert into IVCitem (itemNo,itemName,anything,price)value(?,?,?,?)");
                ps.setInt(1, itemNo);
                ps.setString(2, itemName);
                ps.setString(3, anything);
                ps.setInt(4, price);

                ps.executeUpdate();

                con.close();
                ps.close();

            } catch (IllegalAccessException e) {
                out.print("予期せぬ接続エラーが発生しました" + e.getMessage());
            } catch (ClassNotFoundException e) {
                out.print("接続エラーが発生しました" + e.getMessage());

            } catch (InstantiationException e) {
                out.print("予期せぬエラーが発生しました" + e.getMessage());

            } catch (SQLException e) {
                try {
                    con.close();
                } catch (Exception e_con) {
                    System.out.println(e_con.getMessage());
                }
                out.print("接続エラーが発生しました" + e.getMessage());

            } finally {
                try {
                    con.close();
                } catch (Exception e_con) {
                    System.out.println(e_con.getMessage());
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
