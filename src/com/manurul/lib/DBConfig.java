/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            System.out.println("Could not find database driver class");
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
        }
        return conn;
    }
    
}