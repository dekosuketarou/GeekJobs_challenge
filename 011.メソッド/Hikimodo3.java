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

import java.util.ArrayList;
/**
 *
 * @author guest1Day
 */
public class Hikimodo3 extends HttpServlet {   
    
    ArrayList<String[]> profilist(){
         //個人情報を登録する
        String[] profiling1 ={"1","玉城裕也","1989/9/22","足立区"};
        String[] profiling2 ={"2","滝廉太郎","1964/4/12",null};
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
        
        //格納したString[]を保有したArrayListを戻り値としてリターンする
        return ALpro;
    } 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //String[]を格納した配列ArrayList<String[]>をメソッドで取得
            //その取得した情報をALFileに記録
            
            ArrayList<String[]> ALFile=profilist();
            //Integer型の整数２を設定
            Integer limit=2;
            
            //ALFile(ArrayList型の配列)の要素数を取得し
            //その要素数分forで繰り返し処理を行う
            for(int x = 0;x<ALFile.size();x++){
            
                //limitで記述した整数とxが同値になったとき本処理は終了する
                if(limit==x){
                  break;
              }
              //添え番号0から要素数ぶんだけ要素を取り出す  
              String[]ALroop=ALFile.get(x);
                
                //取り出した要素も配列なので配列の要素数を取得し
                //取得した要素数分だけforで繰り返し処理を行う
                for(int y = 1;y<ALroop.length;y++){
                    
                 //要素の内容がnullだったばあい、記述処理は行われず次の処理に移る   
                 if(ALroop[y]==null){
                     continue;
                 }else{
                 //要素の内容がnullではなくString型の記述であった場合
                 //画面表示として出力する
                     out.print(ALroop[y]+"<BR>");
                 }  
                 
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
