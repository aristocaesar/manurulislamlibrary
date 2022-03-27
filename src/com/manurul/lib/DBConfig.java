/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author DKODE Creative
 */
class DBConfig {
    
    public static Connection getConnection(){
        String user = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost:3306/manurulislam";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find database driver class");
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
        }
        return conn;
    }
    
    public static void main(String[] args) {
        new Get("MA_Kelas").All();
    }
    
}

class Get extends DBConfig {

    private static Connection conn = (Connection)DBConfig.getConnection();
    private String table;
    
    public Get(String table){
        this.table = table;
    }
    
    public void All(){
    
        
        try{
            
            Object arr[] = {}; 
            String element[] = new String[]{"1", "dsda"};
            
            int add = 1;
//            if(arr.length == 0){
//                add = 0;
//            }
            
            Object arrNew[] = Arrays.copyOf(arr, arr.length + add);
            
            arrNew[arr.length] = arrNew;
            
            for(Object data : arrNew){
                System.out.println(data);
            }
            
            String sql = "SELECT * FROM " + this.table;
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
        
//            while(rs.next()){
//                Result.add(new String[]{
//                    rs.getString(1),
//                    rs.getString(2),
//                    rs.getString(3),
//                    rs.getString(4),
//                });
//            }

            
            
            
            
        }catch(SQLException error){
            System.out.println(error);
        }
        
    }
    
}