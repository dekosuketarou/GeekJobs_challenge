package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            //リクエストパラメータの文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            //アクセスルートチェック
           
            if (session.getAttribute("ac") == null) {
                throw new Exception("不正なアクセスです");
            }else{
                request.setAttribute("ac",session.getAttribute("ac"));
            }
            UserDataBeans udb = new UserDataBeans();
            //update.jspからのフォームデータを取得しudbへ保管
            udb.setName(request.getParameter("name"));
            udb.setYear(request.getParameter("year"));
            udb.setMonth(request.getParameter("month"));
            udb.setDay(request.getParameter("day"));
            udb.setTell(request.getParameter("tell"));
            udb.setType(request.getParameter("type"));
            udb.setComment(request.getParameter("comment"));

            UserDataDTO udd = new UserDataDTO();
            //保管したデータをudd型に変換
            udb.UD2DTOMapping(udd);
            //searchで指定したユーザーのid番号をuddに保管
            udd.setUserID(Integer.parseInt((String) session.getAttribute("id")));
            //保管したidを参照してupdateIDメソッドを起動
            if (UserDataDAO.getInstance().updateID(udd)) {
                //idに対応するデータをUserDataDTO型で取得
                udd = UserDataDAO.getInstance().searchByID(udd);
                //requestにデータを登録
                request.setAttribute("update", udd);

                session.invalidate();
                request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/update.jsp").forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } finally {
            out.close();
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
