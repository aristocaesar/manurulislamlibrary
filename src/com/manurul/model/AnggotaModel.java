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
public class AnggotaModel extends DBConfig{
    
    //init state
    private String table = "ma_anggota";
    
    private int id;
    private String nis;
    private String nama_lengkap;
    private String jurusan;
    private String kelas;
    private String jumlah_buku_dipinjam;
    private String skor;
    
    private String message;
    
    private Connection conn = (Connection)getConnection();
    DefaultTableModel table_model = new DefaultTableModel();
    
    //init modifier
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNis(String nis){
        this.nis = nis;
    }
    
    public String getNis(){
        return this.nis;
    }
    
    public void setNama(String nama){
        this.nama_lengkap = nama;
    }
    
    public String getNama(){
        return this.nama_lengkap;
    }
    
    public void setJurusan(String jurusan){
        this.jurusan = jurusan;
    }
    
    public String getJurusan(){
        return this.jurusan;
    }
    
    public void setKelas(String kelas){
        this.kelas = kelas;
    }
    
    public String getKelas(){
        return this.kelas;
    }
    
    public String getJumlahBukuDipinjam(){
        return this.jumlah_buku_dipinjam;
    }
    
    public void setJumlahBukuDipinjam(String jumlah){
        this.jumlah_buku_dipinjam = jumlah;
    }
    
    public void setSkor(String skor){
        this.skor = skor;
    }
    
    public String getSkor(){
        return this.skor;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    private String getMessage(){
        return this.message;
    }
    
    
    //getDataTable
    public void getDataTable(String Key, String Group, String Showing){
    
        table_model.setColumnCount(0);
        table_model.addColumn("No");
        table_model.addColumn("NIS");
        table_model.addColumn("Nama Lengkap");
        table_model.addColumn("Jurusan");
        table_model.addColumn("Kelas");
        
        Dashboard.TABLE_LIST_ANGGOTA.setModel(table_model);
        table_model.setRowCount(0);
        
        try{
            
            String GroupSelected;
            if(Group.equals("Semua")){
                GroupSelected = "ma_anggota.id";
            }else{
                GroupSelected = Group;
            }

            String limited;
            if(Showing.equals("Semua")){
                limited = "";
            }else{
                limited = " LIMIT " + Showing;
            }
            
            String sql = "SELECT ma_anggota.nis, ma_anggota.nama_lengkap, ma_jurusan.kode AS jurusan, ma_jurusan.nama AS nama_jurusan, ma_kelas.kode AS kode_kelas "
                    + "FROM ma_anggota JOIN ma_jurusan ON ma_anggota.jurusan = ma_jurusan.id "
                    + "JOIN ma_kelas ON ma_anggota.kelas = ma_kelas.id WHERE ma_anggota.nis LIKE '%"+Key+"%' OR ma_anggota.nama_lengkap LIKE '%"+Key+"%' GROUP BY "+GroupSelected+limited;
            
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            int i = 1;
            while(res.next()){
                table_model.addRow(new Object[]{
                    i++,
                    res.getString("nis"),
                    res.getString("nama_lengkap"),
                    res.getString("jurusan"),
                    res.getString("kode_kelas")
                });
            }
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    //insert data
    public boolean insertData(){
    
        try{
            
            PreparedStatement pst = conn.prepareStatement("INSERT INTO ma_anggota (nis, nama_lengkap, jurusan, kelas, jumlah_buku_dipinjam, skor, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, getNis());
            pst.setString(2, getNama());
            pst.setString(3, getJurusan());
            pst.setString(4, getKelas());
            pst.setString(5, getJumlahBukuDipinjam());
            pst.setInt(6, Integer.parseInt(getSkor()));
            pst.setTimestamp(7, new SqlTime().getTimeStamp());
            pst.setTimestamp(8, new SqlTime().getTimeStamp());
            
            if(pst.execute()){
                throw new SQLException("Gagal menambahkan jurusan!");
            }
            
            setMessage("Berhasil menambahkan anggota!");
            return true;
        
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Anggota ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;
            
        }
        
    }
    
    //getSelected
    
    //update data
    
    //delete data
    
}
