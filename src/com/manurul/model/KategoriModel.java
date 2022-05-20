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
import javax.swing.JOptionPane;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caesarhome
 */
public class KategoriModel extends DBConfig{
    
    // SET DATATABLE
    DefaultTableModel table_model = new DefaultTableModel();
    Connection conn = (Connection)getConnection();
    
    
    // SET INIT INPUT && MODIFYER
    String old_kode;
    String kode;
    String nama;
    String deskripsi;
    String created_at;
    String updated_at;
    String message;

    private void setOldKode(String Kode){
        this.old_kode = Kode;
    }
    
    private String getOldKode(){
        return this.old_kode;
    }
    
    public void setKode(String kode){
        this.kode =  kode;
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
        this.message = message;
    } 
    
    public String getMessage(){
        return this.message;
    }
    
    // setDataTable
    public void getDataTable(String Keyword, String Showing){
    
        table_model.setColumnCount(0);
        table_model.addColumn("No");
        table_model.addColumn("Kode");
        table_model.addColumn("Nama Kategori");
        table_model.addColumn("Deskripsi");

        Dashboard.TABLE_LIST_KATEGORI.setModel(table_model);
        table_model.setRowCount(0);
        
        String limited = "";
        if(!Showing.equals("Semua")){
            limited = " LIMIT " + Showing;
        }
        
        try{
        
            String sql = "SELECT kode, nama, deskripsi FROM ma_kategori WHERE kode LIKE '%"+Keyword+"%' OR nama LIKE '%"+Keyword+"%'"+ limited;
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            int i =1;
            while(res.next()){
                table_model.addRow(new Object[]{
                    i++,
                    res.getString("kode"),
                    res.getString("nama"),
                    res.getString("deskripsi"),
                });
            }
            
        }catch(SQLException error){
        
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    // insert data
    public boolean insertData(){
    
        try{
        
            String sql = "INSERT INTO ma_kategori(kode, nama, deskripsi, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getKode());
            pst.setString(2, getNama());
            pst.setString(3, getDeskripsi());
            pst.setTimestamp(4, new SqlTime().getTimeStamp());
            pst.setTimestamp(5, new SqlTime().getTimeStamp());
            
            if(pst.execute()){
                throw new SQLException("Gagal menambahakan kategori !");
            }
            
            setMessage("Berhasil menambahkan kategori "+ getNama());
            
            new LogModel().Action("TAMBAH KATEGORI", getMessage(), Dashboard.nama_user);
            
            return true;
            
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Kategori ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;
            
        }
        
    }
    
    // get Selected Data
    public void getSelectedData(String Kode){
        
        try{
        
            String sql = "SELECT * FROM ma_kategori WHERE kode = ?";
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
    
    // update data
    public boolean updatedData(){
    
        try{
        
            String sql = "UPDATE ma_kategori SET kode = ?, nama = ?, deskripsi = ?, updated_at = ? WHERE kode = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getKode());
            pst.setString(2, getNama());
            pst.setString(3, getDeskripsi());
            pst.setTimestamp(4, new SqlTime().getTimeStamp());
            pst.setString(5, getOldKode());
            
            int update = pst.executeUpdate();
            
            if(update == 0){
                throw new SQLException("Gagal memperbarui kategori !");
            }
            
            setMessage("Berhasil memperbarui kategori "+ getNama());
            
            new LogModel().Action("UPDATE KATEGORI", getMessage(), Dashboard.nama_user);
            
            return true;
            
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Kategori ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;
            
        }
        
    }
    
    // delete data
    public boolean deleteData(){
    
        try{
        
            String sql = "DELETE FROM ma_kategori WHERE kode= ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getOldKode());
            
            if(pst.execute()){
                throw new SQLException("Gagal menghapus kategori !");
            }
            
            setMessage("Berhasil menghapus kategori "+ getNama());
            
            new LogModel().Action("DELETE KATEGORI", getMessage(), Dashboard.nama_user);
            
            return true;
            
        }catch(SQLException error){
        
            setMessage(error.getMessage());
            
            return false;
            
        }
        
    }
    
}
