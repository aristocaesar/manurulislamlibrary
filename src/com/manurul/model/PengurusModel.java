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
    
    private  String table = "ma_pengurus";
    private  String id;
    private  String nip;
    private  String nama_lengkap;
    private  String username;
    private  String password;
    private  String hak_akses;
    private  String status;
    private  String created_at;
    private  String updated_at;
    
    private String error;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setNip(String id){
        this.nip = nip;
    }
    
    public String getNip(){
        return this.nip;
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
    
    public String getUsername(){
        return this.username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setHakAkses(String hak_akses){
        this.hak_akses = hak_akses;
    }
    
    public String getHakAkses(){
        return this.hak_akses;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public void setError(String error){
        this.error = error;
    }
    
    public String getError(){
        return this.error;
    }
    
    public boolean loginCek(){
    
        try{
            String sql = "SELECT id,nama_lengkap,hak_akses,status FROM " + this.table + " WHERE username = ? && password = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, this.username);
            pst.setString(2, this.password);
            ResultSet res = pst.executeQuery();

            if(!res.next()){
                throw new SQLException("Username atau Password salah !");
            }else if(!res.getString("status").equals("AKTIF")) {
                throw new SQLException("Akses anda sedang dinonaktifkan !");
            }
            
            setId(res.getString("id"));
            setNamaLengkap(res.getString("nama_lengkap"));
            setHakAkses(res.getString("hak_akses"));
            setStatus(res.getString("status"));
            
            new LogModel().Action("Login", "Akses login berhasil", res.getString("nama_lengkap"));
            
            return true;
        }catch(SQLException err){
            this.error = err.getMessage();
            return false;
        }
        
    }
    
}
