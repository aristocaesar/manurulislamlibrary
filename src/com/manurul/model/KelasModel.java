/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
import com.manurul.lib.SqlTime;
import com.manurul.view.Dashboard;
import com.manurul.view.modal.KelasUSER;
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
public class KelasModel {
    
    private String table = "ma_kelas";
    
    private static Connection conn = (Connection)DBConfig.getConnection();
    private DefaultTableModel tabel_model = new DefaultTableModel();
    
    private int ID;
    private String kode;
    private String message;
    
    public void setID(int id){
        this.ID = id;
    }
    
    public int getID(){
        return this.ID;
    }
    
    public void setKode(String Kode){
        this.kode = Kode;
    }
    
    public String getKode(){
        return this.kode;
    }
    
    private void setMessage(String Message){
        this.message = Message;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public void getDataTable(String Key){
    
        tabel_model.setColumnCount(0);
        tabel_model.addColumn("No");
        tabel_model.addColumn("Kode");
        tabel_model.addColumn("Terakhir Diperbarui");
        
        Dashboard.TABLE_LIST_ITEM_KELAS.setModel(tabel_model);
        tabel_model.setRowCount(0);
        
        try{
            
            String sql = "SELECT * FROM " + table;
            if(!Key.equals("")){
                sql = "SELECT kode, updated_at FROM " +table+ " WHERE kode LIKE '%"+Key+"%'";
            }
            
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            int i = 1;
            while(res.next()){
                tabel_model.addRow(new Object[]{
                    i++,
                    res.getString("kode"),
                    res.getString("updated_at")
                });
            }
        
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void getSelected(String Kode){
    
        try{
            
            PreparedStatement pst = conn.prepareCall("SELECT * FROM "+this.table+" WHERE kode = ?");
            pst.setString(1, Kode);
            ResultSet res = pst.executeQuery();
            
            if(!res.next()){
                throw new SQLException("Gagal memuat data kelas!");
            }
            
            setID(res.getInt("id"));
            
            KelasUSER.INPUT_KODE_KELAS.setText(res.getString("kode"));
            KelasUSER.INPUT_LAST_UPDATED_KELAS.setText(res.getString("updated_at"));
            KelasUSER.INPUT_CREATED_KELAS.setText(res.getString("created_at"));
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public boolean insertData(){
        
        try{
        
            if(getKode().equals("")){
                throw new SQLException("Nilai input harus terisi!");
            }
            
            PreparedStatement pst = conn.prepareStatement("INSERT INTO "+this.table+" (kode, created_at, updated_at) VALUES (?, ?, ?)");
            pst.setString(1, getKode().toUpperCase());
            pst.setTimestamp(2, new SqlTime().getTimeStamp());
            pst.setTimestamp(3, new SqlTime().getTimeStamp());
            
            if(pst.execute()){
                throw new SQLException("Gagal menambahkan kelas!");
            }
            
            new LogModel().Action("TAMBAH KELAS", "Menambahkan kelas "+ getKode(), Dashboard.nama_user);
            
            setMessage("Berhasil menambahkan kelas!");
            return true;
            
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Kelas ini sudah tersedia !");
            }else if(error.getErrorCode() == 1406){
                setMessage("Nilai input melebihi kapasitas !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;

        }
    
    }
    
    public boolean updateData(){
        try{
            
            if(getID() == 0){
                throw new SQLException("Gagal memperbarui kelas!");
            }
        
            PreparedStatement pst =  conn.prepareStatement("UPDATE "+table+ " SET kode = ?, updated_at = ? WHERE id = ?");
            pst.setString(1, getKode().toUpperCase());
            pst.setTimestamp(2, new SqlTime().getTimeStamp());
            pst.setInt(3, getID());
            
            int updated = pst.executeUpdate();
            
            if(updated == 0){
                throw new SQLException("Gagal memperbarui kelas!");
            }
            
            new LogModel().Action("UPDATE KELAS", "Memperbarui kelas "+ getKode(), Dashboard.nama_user);
            
            setMessage("Berhasil memperbarui kelas " + getKode());
            return true;
            
        }catch(SQLException error){
            
            if(error.getErrorCode() == 1062){
                setMessage("Kelas ini sudah tersedia !");
            }else if(error.getErrorCode() == 1406){
                setMessage("Nilai input melebihi kapasitas !");
            }else{
                setMessage(error.getMessage());
            }
            return false;
        
        }
    
    }
    
    public boolean deleteData(String kode){
    
        try{
            
            if(getID() == 0){
                throw new SQLException("Gagal memperbarui kelas!");
            }
            
            PreparedStatement pst =  conn.prepareStatement("DELETE FROM "+table+" WHERE id = ?");
            pst.setInt(1, getID());
            
            boolean deleted = pst.execute();
            
            if(deleted){
                throw new SQLException("Gagal memperbarui kelas!");
            }
            
            new LogModel().Action("HAPUS KELAS", "Menghapus kelas "+ kode, Dashboard.nama_user);
        
            setMessage("Berhasil menghapus kelas "+ kode);
            return true;
            
        }catch(SQLException error){
            setMessage(error.getMessage());
            return false;
        }
        
    }
    
}
