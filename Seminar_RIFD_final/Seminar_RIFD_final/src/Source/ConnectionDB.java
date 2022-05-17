/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mthuan
 */
public class ConnectionDB {
    private static String URL = "jdbc:mysql://localhost:3306/rfid_stu?zeroDateTimeBehavior=convertToNull&useUnicode=true&amp&characterEncoding=UTF-8";
    private static String USER = "root";
    private static String PASS = "";
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;

    
    
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    

    public ConnectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASS);
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến server");
            e.printStackTrace();
        }
    }

       
    public ResultSet sqlExcute(String qry){
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(qry);
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến server"+ e.getMessage());
        }
        return null;
    }
    
    public Boolean sqlUpdate(String qry) {
        try {
             stm = conn.createStatement();
            int Result = stm.executeUpdate(qry);
            
        } catch (Exception e) {
            e.printStackTrace();
           
            return false;
        }

        return true;
    }
    
    public static void main(String[] args) {
        ConnectionDB conn = new ConnectionDB();
        System.out.println(conn.getConn());
    }
}
