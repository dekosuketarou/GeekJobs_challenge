/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.util.ArrayList;
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
public class DTOsel {

    ArrayList<String> returnMassage = new ArrayList<String>();

    public void select(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String url = "jdbc:mysql://localhost:3306/Challenge_db";
            String user = "root";
            String pass = "geekjobs";

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, user, pass);
            int selID=Integer.parseInt(request.getParameter("selID"));

            ps = con.prepareStatement("select * from profiles where profilesID>=? and profilesID<=?");
            ps.setInt(1,selID);
            ps.setInt(2,selID+9);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("profilesID");
                String name = rs.getString("name");
                String tell = rs.getString("tell");
                int age = rs.getInt("age");
                String birth = rs.getString("birthday");
                returnMassage.add(id + " " + name + " " + tell + " " + age + " " + birth);
            }
            con.close();
            ps.close();
            rs.close();

        } catch (Exception e) {

        }

    }

    public ArrayList<String> selData() {
        return returnMassage;

    }
}
