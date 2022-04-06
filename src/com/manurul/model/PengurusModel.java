/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author caesarhome
 */
public class PengurusModel extends com.manurul.lib.DBConfig{
    
    public static Connection conn = (Connection)getConnection();
    
    private  String table = "ma_pengelola";
    private  int id;
    private  String nip;
    private  String nama_lengkap;
    private  String username;
    private  String password;
    private  String hak_akses;
    private  int status;
    private  String created_at;
    private  String updated_at;
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNip(String id){
        this.nip = nip;
    }
    
    public void setNamaLengkap(String nama_lengkap){
        this.nama_lengkap = nama_lengkap;
    }
    
    public String getNamaLengkap(){
        return this.nama_lengkap;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean loginCek(){
    
        try{
            String sql = "SELECT id,nama_lengkap,hak_akses FROM " + this.table + " WHERE username = ? && u_password = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, this.username);
            pst.setString(2, this.password);
            ResultSet res = pst.executeQuery();

            if(!res.next()){
                return false;
            }
            
            this.id = res.getInt("id");
            this.nama_lengkap = res.getString("nama_lengkap");
            this.hak_akses = res.getString("role");
            
            return true;
        }catch(SQLException err){
            return false;
        }
        
    }
    
}
