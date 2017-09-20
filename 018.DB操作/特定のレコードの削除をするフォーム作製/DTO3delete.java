/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DEKO
 */
public class DTO3delete {
    public DTO3delete(){
    }
    public void deleteID(int i){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            
            String url="jdbc:mysql://localhost:3306/Challenge_db";
            String user="root";
            String pass="geekjobs";
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con=DriverManager.getConnection(url,user,pass);
            
            ps=con.prepareStatement("delete from profiles where profilesID =?");
            ps.setInt(1,i);
            ps.executeUpdate();

            con.close();
            ps.close();
            rs.close();
            
        }catch(Exception e){
            
        }
    }
}
    