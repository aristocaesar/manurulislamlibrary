/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.Characters;
import com.manurul.lib.SqlTime;
import com.manurul.view.Dashboard;
import com.manurul.view.modal.PengurusUSER;
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
public class PengurusModel extends com.manurul.lib.DBConfig{
    
    private static Connection conn = (Connection)getConnection();
    private DefaultTableModel tabel_model = new DefaultTableModel();
    
    private  String table = "ma_pengurus";
    private  String id;
    private  String kode;
    private  String nip;
    private  String nama_lengkap;
    private  String username;
    private  String password;
    private  String hak_akses;
    private  String status;
    
    private String message;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setKode(String Kode){
        this.kode = Kode;
    }
    
    public String getKode(){
        return this.kode;
    }
    
    public void setNip(String Nip){
        this.nip = Nip;
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
    
    public void setMessage(String Message){
        this.message = Message;
    }
    
    public String getMessage(){
        return this.message;
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
            
//            new LogModel().Action("LOGIN", "Akses login berhasil", res.getString("nama_lengkap"));
            
            return true;
        }catch(SQLException err){
            this.message = err.getMessage();
            return false;
        }
        
    }
    
    public void getDataTable(String Key){
    
        tabel_model.setRowCount(0);
        tabel_model.addColumn("No");
        tabel_model.addColumn("Kode");
        tabel_model.addColumn("Nip");
        tabel_model.addColumn("Nama Lengkap");
        tabel_model.addColumn("Username");
        tabel_model.addColumn("Hak Akses");
        tabel_model.addColumn("Status");
        
        Dashboard.TABLE_LIST_ITEM_PENGURUS.setModel(tabel_model);
        tabel_model.setRowCount(0);
        
        try{
            
            String sql = "SELECT * FROM " + table;
            if(!Key.equals("")){
                sql = "SELECT * FROM " +table+ " WHERE kode LIKE '%"+Key+"%' OR nama_lengkap LIKE '%"+Key+"%'";
            }
            
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            int i = 1;
            while(res.next()){
                tabel_model.addRow(new Object[]{
                    i++,
                    res.getString("kode"),
                    res.getString("nip"),
                    res.getString("nama_lengkap"),
                    res.getString("username"),
                    res.getString("hak_akses"),
                    res.getString("status")
                });
            }
        
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public boolean insertData(){
        
        try{
            
            PreparedStatement pst = conn.prepareStatement("INSERT INTO "+this.table+" (kode, nip, username, password, nama_lengkap, hak_akses, status, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
           
            pst.setString(1, getKode());
            pst.setString(2, getNip().replaceAll("[a-zA-Z]", ""));
            pst.setString(3, getUsername().replaceAll("[0-9]", "").toLowerCase().replaceAll(" ", ""));
            pst.setString(4, getPassword());
            
            String nama = Characters.ucwords(getNamaLengkap().replaceAll("[0-9]", ""));
            pst.setString(5, nama);
            
            pst.setString(6, getHakAkses().toUpperCase());
            pst.setString(7, getStatus().toUpperCase());
            pst.setTimestamp(8, new SqlTime().getTimeStamp());
            pst.setTimestamp(9, new SqlTime().getTimeStamp());
            
            if(pst.execute()){
                throw new SQLException("Gagal menambahkan pengurus !");
            }
            
            setMessage("Berhasil menambahkan pengurus !");
            return true;
            
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Pengurus ini sudah tersedia !");
            }else if(error.getErrorCode() == 1406){
                setMessage("Terdapat nilai input yang melebihi kapasitas !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;

        }
    
    }
    
    public void getSelected(String Kode){
    
       try{
       
           PreparedStatement pst = conn.prepareStatement("SELECT * FROM "+this.table+" WHERE kode = ?");
           pst.setString(1, Kode);
           ResultSet res = pst.executeQuery();
           
           if(!res.next()){
               throw new SQLException("Gagal memuat data pengurus !");
           }
           
           setId(res.getString("id"));
           PengurusUSER.INPUT_ID_PENGURUS.setText(res.getString("kode"));
           
           setUsername(res.getString("username"));
           PengurusUSER.INPUT_USERNAME.setText(res.getString("username"));
           
           setNip(res.getString("nip"));
           PengurusUSER.INPUT_NIP.setText(res.getString("nip"));
           
           setNamaLengkap(res.getString("nama_lengkap"));
           PengurusUSER.INPUT_NAMA.setText(res.getString("nama_lengkap"));
           
           setPassword(res.getString("password"));
           PengurusUSER.INPUT_PASSWORD.setText(res.getString("password"));
           
           String HakAkses = Characters.ucwords(res.getString("hak_akses"));
           setHakAkses(HakAkses);
           PengurusUSER.COMBOBOX_HAK_AKSES.setSelectedItem(HakAkses);
           
           String Status = Characters.ucwords(res.getString("status"));
           setStatus(Status);
           PengurusUSER.COMBOBOX_STATUS.setSelectedItem(Status);
           
           PengurusUSER.INPUT_CREATED.setText(res.getString("created_at"));
           PengurusUSER.INPUT_UPDATED.setText(res.getString("updated_at"));
           
       }catch(SQLException error){
           JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
       }
            
    }
    
    public boolean updateData(){
    
        try{
            
            PreparedStatement pst = conn.prepareStatement("UPDATE "+this.table+" SET nip = ?, username = ?, password = ?, nama_lengkap = ?, hak_akses = ?, status = ?, updated_at = ? WHERE id = ?");
            pst.setString(1, getNip().replaceAll("[a-zA-Z]", ""));
            pst.setString(2, getUsername().replaceAll("[0-9]", "").replaceAll(" ", ""));
            pst.setString(3, getPassword());
            
            String NamaLengkap = Characters.ucwords(getNamaLengkap());
            pst.setString(4, NamaLengkap);
            
            pst.setString(5, getHakAkses());
            pst.setString(6, getStatus());
            pst.setTimestamp(7, new SqlTime().getTimeStamp());
            pst.setInt(8, Integer.parseInt(getId()));
            
            int updated = pst.executeUpdate();
            
            if(updated == 0){
                throw new SQLException("Gagal memperbarui pengurus !");
            }
            
            setMessage("Berhasil memperbarui pengurus !");
            return true;
        
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Pengurus ini sudah tersedia !");
            }else if(error.getErrorCode() == 1406){
                setMessage("Nilai input melebihi kapasitas !");
            }else{
                setMessage(error.getMessage());
            }
            return false;
            
        }
        
    }
    
    
    public boolean deleteData(){
    
        try{
        
            PreparedStatement pst = conn.prepareStatement("DELETE FROM "+this.table+" WHERE id = ?");
            pst.setString(1, getId());
            
            boolean deleted = pst.execute();
            
            if(deleted){
                throw new SQLException("Gagal menghapus pengurus !");
            }
        
            setMessage("Berhasil menghapus pengurus !");
            return true;
            
        }catch(SQLException error){
            setMessage(error.getMessage());
            return false;
        }
    
    }
}
