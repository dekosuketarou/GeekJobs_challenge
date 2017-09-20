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
public class Database2 {
    public static void main(String[]args){
        Connection con =null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String url="jdbc:mysql://localhost:3306/challenge_db";
        String username="root";
        String password="geekjobs";


        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con=DriverManager.getConnection(url,username,password);

        ps=con.prepareStatement("insert into profiles value(6,'山田 太郎','0120-55-5555',56,'1985-05-08')");
        ps.executeUpdate();
        ps=con.prepareStatement("select * from profiles");
        

        rs=ps.executeQuery();
        
        while(rs.next()){
            String id=rs.getString("profilesID");
            String name=rs.getString("name");
            String tell=rs.getString("tell");
            String age=rs.getString("age");
            String birthday=rs.getString("birthday");
            System.out.println("profilesID: " +id +" 名前: "+name+" 電話番号:"+tell+" 年齢:"+age+" 生年月日:"+birthday);
        }
        

        con.close();
        ps.close();
        rs.close();
        
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
