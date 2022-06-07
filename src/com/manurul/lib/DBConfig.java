
package com.manurul.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DKODE Creative
 */
public class DBConfig {
    
    public static Connection getConnection(){
        String user = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost:3306/manurulislam";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver database tidak ditemukan !", "Terjadi Kesalahan!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Konfigurasi database tidak valid !", "Terjadi Kesalahan!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return conn;
    }
    
}