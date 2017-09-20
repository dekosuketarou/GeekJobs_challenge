/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;


/**
 *
 * @author DEKO
 */
public class Database1 {
    public static void main(String[]args){
        Connection con =null;
        
        String url="jdbc:mysql://localhost:3306/challenge_db";
        String username="root";
        String password="geekjobs";


        try{
            //mysql用のjdbcインスタンスを生成
            //生成と同時にDriverManagerにセットされる
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //セットされたインスタンスでDBへの接続を取得
            con=DriverManager.getConnection(url,username,password);

            //コネクションを切断
            con.close();


        }catch(ClassNotFoundException e){
            e.printStackTrace();            
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
               if(con !=null){
                   con.close();
                   System.out.println("コネクション切断に成功しました");
               }else{
                   System.out.println("コネクションはありません");
               }
            }catch(Exception e){
                e.printStackTrace();
            }


        }

    }
}
