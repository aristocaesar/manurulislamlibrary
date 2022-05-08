/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
import com.manurul.lib.SqlTime;
import com.manurul.view.Dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caesarhome
 */
public class PenerbitModel extends DBConfig {
    
    Connection conn = (Connection)getConnection();
    DefaultTableModel table_model = new DefaultTableModel();
    
    // SET STATE && MODIFYIER
    
    int id;
    String nama;
    String kontak;
    String created_at;
    String updated_at;
    
    String message;
    
    private void setId(int ID){
        this.id = ID;
    }
    
    private int getId(){
        return this.id;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public void setKontak(String kontak){
        this.kontak = kontak;
    }
    
    public String getKontak(){
        return this.kontak;
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
        this.message = message;
    } 
    
    public String getMessage(){
        return this.message;
    }
            
    // showing data in table
    public void getDataTable(String Keyword, String Showing){
    
        table_model.setColumnCount(0);
        table_model.addColumn("No");
        table_model.addColumn("Nama Penerbit");
        table_model.addColumn("Kontak");

        Dashboard.TABLE_LIST_PENERBIT.setModel(table_model);
        table_model.setRowCount(0);
        
        String limited = "";
        if(!Showing.equals("Semua")){
            limited = " LIMIT " + Showing;
        }
        
        try{
        
            String sql = "SELECT nama, kontak FROM ma_penerbit WHERE nama LIKE '%"+Keyword+"%' OR kontak LIKE '%"+Keyword+"%'"+ limited;
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            int i =1;
            while(res.next()){
                table_model.addRow(new Object[]{
                    i++,
                    res.getString("nama"),
                    res.getString("kontak"),
                });
            }
            
        }catch(SQLException error){
        
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    // insert data
    public boolean insertData(){
    
        try{
        
            String sql = "INSERT INTO ma_penerbit(nama, kontak, created_at, updated_at) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getNama());
            pst.setString(2, getKontak());
            pst.setTimestamp(3, new SqlTime().getTimeStamp());
            pst.setTimestamp(4, new SqlTime().getTimeStamp());
            
            if(pst.execute()){
                throw new SQLException("Gagal menambahakan penerbit !");
            }
            
            setMessage("Berhasil menambahkan "+ getNama() +" sebagai penerbit");
            
            new LogModel().Action("TAMBAH PENERBIT", getMessage(), Dashboard.nama_user);
            
            return true;
            
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Penerbit ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;
            
        }
        
    }
    
    // get selected data
    
    public void getSelectedData(String Nama){
        
        try{
        
            String sql = "SELECT * FROM ma_penerbit WHERE nama = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Nama);
            ResultSet res = pst.executeQuery();
            
            if(res.next()){
                setId(res.getInt("id"));
                setNama(res.getString("nama"));
                setKontak(res.getString("kontak"));
                setCreated(res.getString("created_at"));
                setUpdated(res.getString("updated_at"));
            }
            
        }catch(SQLException error){
        
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    // update data
    public boolean updatedData(){
    
        try{
        
            String sql = "UPDATE ma_penerbit SET nama = ?, kontak = ?, updated_at = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getNama());
            pst.setString(2, getKontak());
            pst.setTimestamp(3, new SqlTime().getTimeStamp());
            pst.setInt(4, getId());
            
            int update = pst.executeUpdate();
            
            if(update == 0){
                throw new SQLException("Gagal memperbarui penerbit");
            }
            
            setMessage("Berhasil memperbarui penerbit "+ getNama());
            
            new LogModel().Action("UPDATE PENERBIT", getMessage(), Dashboard.nama_user);
            
            return true;
            
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Penerbit ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;
            
        }
        
    }
    
    // delete data
    public boolean deleteData(){
    
        try{
        
            String sql = "DELETE FROM ma_penerbit WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, getId());
            
            if(pst.execute()){
                throw new SQLException("Gagal menghapus penerbit !");
            }
            
            setMessage("Berhasil menghapus penerbit "+ getNama());
            
            new LogModel().Action("DELETE PENERBIT", getMessage(), Dashboard.nama_user);
            
            return true;
            
        }catch(SQLException error){
        
            setMessage(error.getMessage());
            
            return false;
            
        }
        
    }
    
}
