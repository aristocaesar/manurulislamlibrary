/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
import com.manurul.lib.SqlTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author playerceluler
 */
public class LogModel extends DBConfig{
    
   public static Connection conn = (Connection)DBConfig.getConnection();
   public String error;
   
   
   public void Action(String Process, String Message, String Petugas){
       
       try{
           
           if(Process.equals("") || Message.equals("")){
            throw new SQLException("Terjadi kesalahan pada data aktifitas !");
           }
           
            PreparedStatement pst = conn.prepareStatement("INSERT INTO ma_log (process, message, petugas, created_at) VALUES (?, ?, ?, ?) ");
            pst.setString(1, Process);
            pst.setString(2, Message);
            pst.setString(3, Petugas);
            
            
            pst.setTimestamp(4, new SqlTime().getTimeStamp());
            
            
//            if(pst.execute()){
//                throw new SQLException("Terjadi kesalahan pada data aktifitas !");
//            }
            System.out.println(Process +" , "+ Message +" , "+ Petugas);
            
       }catch(SQLException error){
           this.error = error.getMessage();
       }
       
   }
   
   public String getError(){
       return this.error;
   }
   
}
