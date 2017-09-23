package jums;

import java.io.IOException;
import java.util.LinkedHashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertconfirm.jspと対応するサーブレット
 * フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

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
        try{
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            //UserDataBeansにフォームから得た情報を格納する
            UserDataBeans udb=new UserDataBeans();
            
            udb.setName(request);
            udb.setYear(request);
            udb.setMonth(request);
            udb.setDay(request);
            udb.setType(request);
            udb.setTell(request);
            udb.setComment(request);
            

            //情報を格納したUserDataBeansをsessionに登録する
            session.setAttribute("udb",udb);
   
            
            //setterで格納されるべき情報が "" だった場合、上記のUserDataBeansには格納されないので
            //下記にて通知処理を行うための登録をする
            LinkedHashMap<String,String> emptyStatus=new LinkedHashMap<String,String>();
            if(udb.getName().equals("")){emptyStatus.put("name","名前<BR>");}
            if(udb.getYear().equals("")){emptyStatus.put("yaer","年<BR>");}
            if(udb.getMonth().equals("")){emptyStatus.put("month","月<BR>");}
            if(udb.getDay().equals("")){emptyStatus.put("day","日<BR>");}
            if(udb.getType().equals("")){emptyStatus.put("type","種別<BR>");}
            if(udb.getTell().equals("")){emptyStatus.put("tell","電話番号<BR>");}
            if(udb.getComment().equals("")){emptyStatus.put("comment","自己紹介文<BR>");}
            //LinkedHasshMap型で保存した情報をsessionに登録する
            //利用場所(insertconfirm.jsp)
            session.setAttribute("emptyMessage", emptyStatus);
            
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
        }catch(Exception e){
            
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
