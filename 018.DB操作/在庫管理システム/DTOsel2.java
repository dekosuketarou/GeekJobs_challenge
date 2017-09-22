/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IVC;

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
public class DTOsel2 {

    ArrayList<String> returnMassage = new ArrayList<String>();

    public DTOsel2() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String url = "jdbc:mysql://localhost:3306/IVC";
            String user = "root";
            String pass = "geekjobs";

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, user, pass);


            ps = con.prepareStatement("select * from inventory");

            
            rs = ps.executeQuery();
            while (rs.next()) {
                int itemNo = rs.getInt("itemNo");
                String itemName = rs.getString("itemName");
                String count = rs.getString("count");
               
                returnMassage.add("商品番号     "+itemNo+"  商品名    "+itemName+"在庫数"+count+"<BR><BR>");
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
