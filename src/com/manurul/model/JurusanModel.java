/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
import com.manurul.lib.SqlTime;
import com.manurul.view.Dashboard;
import com.manurul.view.modal.JurusanUSER;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author playerceluler
 */
public class JurusanModel extends DBConfig{
    
    private final String table = "ma_jurusan";
    
    private String kode = "";
    private String nama = "";
    private String message;
    
    public void setKode(String kode){
        this.kode = kode;
    }
    
    public String getKode(){
        return this.kode;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    private void setMessage(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    private static Connection conn = (Connection)DBConfig.getConnection();
    private DefaultTableModel tabel_model = new DefaultTableModel();
    
    public void getDataTable(String Key){
        
        tabel_model.setColumnCount(0);
        tabel_model.addColumn("No");
        tabel_model.addColumn("Kode");
        tabel_model.addColumn("Nama");
        
        Dashboard.TABLE_LIST_ITEM_JURUSAN.setModel(tabel_model);
        tabel_model.setRowCount(0);
   
        try{
            
            String sql = "SELECT * FROM " + table;
            if(!Key.equals("")){
                sql = "SELECT kode, nama FROM " +table+ " WHERE kode LIKE '%"+Key+"%' OR nama LIKE '%"+Key+"%'";
            }
            
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            int i = 1;
            while(res.next()){
                tabel_model.addRow(new Object[]{
                    i++,
                    res.getString("kode"),
                    res.getString("nama")
                });
            }
        
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void getSelected(String Kode){
        
        try{
            
            PreparedStatement pst = conn.prepareCall("SELECT * FROM ma_jurusan WHERE kode = ?");
            pst.setString(1, Kode);
            ResultSet res = pst.executeQuery();
            
            if(!res.next()){
                throw new SQLException("Gagal memuat data jurusan!");
            }
            
            setKode(res.getString("kode"));
            setNama(res.getString("nama"));
            
            JurusanUSER.INPUT_KODE_JUR.setText(res.getString("kode"));
            JurusanUSER.INPUT_NAMA_JUR.setText(res.getString("nama"));
            JurusanUSER.INPUT_LAST_UPDATE_JUR.setText(res.getString("updated_at"));
            JurusanUSER.INPUT_CREATED_JUR.setText(res.getString("created_at"));
        
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public boolean insertData(){
        
        try{
        
            if(getKode().equals("") && getNama().equals("")){
                throw new SQLException("Nilai input harus terisi!");
            }
            
            PreparedStatement pst = conn.prepareStatement("INSERT INTO ma_jurusan (kode, nama) VALUES (?, ?)");
            pst.setString(1, getKode().toUpperCase());
            pst.setString(2, getNama());
            
            if(pst.execute()){
                throw new SQLException("Gagal menambahkan jurusan!");
            }
            
            setMessage("Berhasil menambahkan jurusan!");
            return true;
            
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Jurusan ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;

        }
    
    }
    
    public boolean updateData(String KodeLama){
    
        try{
        
            PreparedStatement pst = conn.prepareCall("UPDATE ma_jurusan SET kode = ?, nama = ?, updated_at = ? WHERE kode = ?");
            pst.setString(1, getKode().toUpperCase());
            pst.setString(2, getNama());
            pst.setTimestamp(3, new SqlTime().getTimeStamp());
            pst.setString(4, KodeLama);
            
            int updated = pst.executeUpdate();
            
            if(updated == 0){
                throw new SQLException("Gagal memperbarui jurusan!");
            }
            
            setMessage("Berhasil memperbarui jurusan!");
            return true;
            
        }catch(SQLException error){
            
            if(error.getErrorCode() == 1062){
                setMessage("Jurusan ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            return false;
        
        }
    
    }
    
    public boolean deleteData(){
    
        try{
        
            PreparedStatement pst = conn.prepareCall("DELETE FROM ma_jurusan WHERE kode = ?");
            pst.setString(1, getKode());
            
            if(pst.execute()){
                throw new SQLException("Gagal menghapus jurusan!");
            }
            
            setMessage("Berhasil menghapus jurusan!");
            return true;
            
        }catch(SQLException error){
            
            setMessage(error.getMessage());
            return false;
        
        }
        
    }
    
}
