/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author DEKO
 */
public class DTO3 {
    ArrayList<String> returnMassage=new ArrayList<String>();
    
    public DTO3(){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            
            String url="jdbc:mysql://localhost:3306/Challenge_db";
            String user="root";
            String pass="geekjobs";
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con=DriverManager.getConnection(url,user,pass);
            
            ps=con.prepareStatement("select * from profiles");
            rs=ps.executeQuery();
            while(rs.next()){
                    int id=rs.getInt("profilesID");
                    String name=rs.getString("name");
                    String tell=rs.getString("tell");
                    int age=rs.getInt("age");
                    String birth=rs.getString("birthday");
                    returnMassage.add(id+" "+name+" "+tell+" "+age+" "+birth);
            }
            con.close();
            ps.close();
            rs.close();
            
        }catch(Exception e){
            
        }
        
        
    }
        public ArrayList<String> selData(){
            return returnMassage;
        }
    
    
    
    
}
