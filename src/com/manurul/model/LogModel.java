/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author playerceluler
 */
public class LogModel extends DBConfig{
    
   public static Connection conn = (Connection)DBConfig.getConnection();
   
   public void Action(String Process, String Message){
       
       try{
           
           if(Process.equals("") && Message.equals("")){
            throw new SQLException("Terjadi kesalahan pada data aktifitas !");
           }
           
            PreparedStatement pst = conn.prepareStatement("INSERT INTO ma_log (process, message, created_at) VALUES (?, ?, ?)");
            pst.setString(1, Process);
            pst.setString(2, Message);
            
            Calendar cal = Calendar.getInstance();
            Timestamp updated_at = new java.sql.Timestamp(cal.getTimeInMillis());
            
            pst.setTimestamp(3, updated_at);
            
            
            if(pst.execute()){
                throw new SQLException("Terjadi kesalahan pada data aktifitas !");
            }
            
            System.out.println("ok");
            
       }catch(SQLException error){
       
           System.out.println(error);
           
       }
       
   }
   
    public static void main(String[] args) {
        new LogModel().Action("", "test massej");
    }
   
}
