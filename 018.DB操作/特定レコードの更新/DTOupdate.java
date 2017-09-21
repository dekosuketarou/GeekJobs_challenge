/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author guest1Day
 */
public class DTOupdate {
    public void update(HttpServletRequest request,PrintWriter out) throws UnsupportedEncodingException{
            request.setCharacterEncoding("UTF-8");
            
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            
            String url="jdbc:mysql://localhost:3306/Challenge_db";
            String user="root";
            String pass="geekjobs";
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con=DriverManager.getConnection(url,user,pass);
                
                String name=request.getParameter("name");
                String tell=request.getParameter("tell");
                int age=Integer.parseInt(request.getParameter("age"));
                String birthday=request.getParameter("birthday");
                int id=Integer.parseInt(request.getParameter("id"));
                
                ps=con.prepareStatement("update profiles set age=?,name=?,tell=?,birthday=? where profilesID=?");
                ps.setInt(1, age);
                ps.setString(2, name);
                ps.setString(3,tell);
                ps.setString(4,birthday);
                ps.setInt(5, id);
                
                ps.executeUpdate();
                
                con.close();
                ps.close();
                rs.close();
                
                
                
            }catch(ClassNotFoundException e){
                
            }catch(Exception e){
                
            }
        
        
        
        
        
    }
}
