/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
import com.manurul.lib.SqlTime;
import com.manurul.view.Dashboard;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caesarhome
 */
public class RakModel extends DBConfig {
    
    private String old_kode;
    private String kode;
    private String nama;
    private String deskripsi;
    private String created_at;
    private String updated_at;
    
    private String message;
    
    private Connection conn = (Connection)getConnection();
    DefaultTableModel table_model = new DefaultTableModel();
    
    public void setOldKode(String Kode){
        this.old_kode = Kode;
    }
    
    public String getOldKode(){
        return this.old_kode;
    }
    
    public void setKode(String Kode){
        this.kode = Kode;
    }
    
    public String getKode(){
        return this.kode;
    }
    
    public void setNama(String Nama){
        this.nama = Nama;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public void setDeskripsi(String desk){
        this.deskripsi = desk;
    }
    
    public String getDeskripsi(){
        return this.deskripsi;
    }
    
    public void setCreated(String tgl){
        this.created_at = tgl;
    }
    
    public String getCreated(){
        return this.created_at;
    }
    
    public void setUpdated(String tgl){
        this.updated_at = tgl;
    }
    
    public String getUpdated(){
        return this.updated_at;
    }
    
    public void setMessage(String message){
        this.message =  message;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    
    public void getDataTable(String Keyword, String Showing){
        
        table_model.setColumnCount(0);
        table_model.addColumn("No");
        table_model.addColumn("Kode");
        table_model.addColumn("Nama");
        table_model.addColumn("Deskripsi");

        Dashboard.TABLE_LIST_RAK.setModel(table_model);
        table_model.setRowCount(0);
    
        String limited = "";
        if(Showing.equals("Semua")){
            limited = "";
        }else{
            limited = "LIMIT " + Showing;
        }
        
        try{
        
            String sql = "SELECT kode, nama, deskripsi FROM ma_rak WHERE "
                    + "kode LIKE '%"+Keyword+"%' OR "
                    + "nama LIKE '%"+Keyword+"%' " + limited;
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            int i = 1;
            while(res.next()){
                table_model.addRow(new Object []{
                    i++,
                    res.getString("kode"),
                    res.getString("nama"),
                    res.getString("deskripsi")
                });
            }
            
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        
        }
        
    }
    
    public boolean insertData(){
    
        try{
            
            String sql = "INSERT INTO ma_rak(kode, nama, deskripsi, created_at, updated_at)"
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getKode());
            pst.setString(2, getNama());
            pst.setString(3, getDeskripsi());
            pst.setTimestamp(4, new SqlTime().getTimeStamp());
            pst.setTimestamp(5, new SqlTime().getTimeStamp());
            
            boolean insert = pst.execute();
            
            if(insert){
                throw new SQLException("Gagal memnambahkan Rak !");
            }
            
            setMessage("Berhasil menambahkan Rak " + getKode());
            
            // cetak log
            new LogModel().Action("TAMBAH RAK", "Menambahkan rak "+ getNama(), Dashboard.nama_user);
            
            return true;
        
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Rak ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;
            
        }
        
    }
    
    public void getSelectedData(String Kode){
    
        try{
        
            String sql = "SELECT * FROM ma_rak WHERE kode = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Kode);
            ResultSet res = pst.executeQuery();
            
            if(res.next()){
            
                setOldKode(res.getString("kode"));
                setKode(res.getString("kode"));
                setNama(res.getString("nama"));
                setDeskripsi(res.getString("deskripsi"));
                setCreated(res.getString("created_at"));
                setUpdated(res.getString("updated_at"));
                
            }
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public boolean updatedData(){
    
        try{
            
            String sql = "UPDATE ma_rak SET kode = ?, nama = ?, deskripsi = ?, updated_at = ? WHERE kode = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getKode());
            pst.setString(2, getNama());
            pst.setString(3, getDeskripsi());
            pst.setTimestamp(4, new SqlTime().getTimeStamp());
            pst.setString(5, getOldKode());
            
            int updated = pst.executeUpdate();
            
            if(updated == 0){
                throw new SQLException("Gagal memperbarui Rak !");
            }
            
            setMessage("Berhasil memperbarui Rak " + getKode());
            
            // cetak log
            new LogModel().Action("UPDATE RAK", "Memperbarui rak "+ getNama(), Dashboard.nama_user);
            
            return true;
            
        }catch(SQLException error){
            
            if(error.getErrorCode() == 1062){
                setMessage("Rak ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;
            
        }
        
    }
    
    public boolean deleteData(){
    
        try{
            
            String sql = "DELETE FROM ma_rak WHERE kode = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getOldKode());
            
            boolean deleted = pst.execute();
            
            if(deleted){
                throw new SQLException("Gagal menghapus RAK !");
            }
            
            setMessage("Berhasil menghapus Rak " + getKode());
            
            // cetak log
            new LogModel().Action("HAPUS RAK", "Menghapus rak "+ getNama(), Dashboard.nama_user);
            
            return true;
            
        }catch(SQLException error){
            setMessage(error.getMessage());
            
            return false;
        }
        
    }
    
}
