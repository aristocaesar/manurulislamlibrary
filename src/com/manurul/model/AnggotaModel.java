/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
import com.manurul.lib.SqlTime;
import com.manurul.view.Dashboard;
import com.manurul.view.modal.AnggotaUSER;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
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
    private String kode;
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
    
    public void setKode(String kode){
        this.kode = kode;
    }
    
   public String getKode(){
       return this.kode;
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
    
    public String getMessage(){
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
            
            String sql = "SELECT ma_anggota.nis, ma_anggota.nama_lengkap, ma_jurusan.nama AS jurusan, ma_kelas.kode AS kode_kelas "
                    + "FROM ma_anggota JOIN ma_jurusan ON ma_anggota.jurusan = ma_jurusan.id "
                    + "JOIN ma_kelas ON ma_anggota.kelas = ma_kelas.id WHERE ma_anggota.nis LIKE '%"+Key+"%' OR ma_anggota.nama_lengkap LIKE '%"+Key+"%' ORDER BY "+GroupSelected+limited;
            
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
    
    public void setJurusanKelas(String Jurusan, String Kelas){
    
        try{
            
            //set jurusan
            PreparedStatement pst_jur = conn.prepareStatement("SELECT nama FROM ma_jurusan");
            ResultSet res = pst_jur.executeQuery();
            
            while(res.next()){
                AnggotaUSER.COMBO_BOX_JURUSAN.addItem(res.getString("nama"));
            }
            
                if(!Jurusan.equals("")){
                    AnggotaUSER.COMBO_BOX_JURUSAN.setSelectedItem(Jurusan);
                }
            
            //set kelas
            PreparedStatement pst_kelas = conn.prepareStatement("SELECT kode FROM ma_kelas");
            ResultSet res_kelas = pst_kelas.executeQuery();
            
            while(res_kelas.next()){
                AnggotaUSER.COMBO_BOX_KELAS.addItem(res_kelas.getString("kode"));
            }
                
                if(!Kelas.equals("")){
                    AnggotaUSER.COMBO_BOX_KELAS.setSelectedItem(Kelas);
                }
            
            
        }catch(SQLException error){
        
        }
        
    }
    
    //insert data
    public boolean insertData(){
    
        try{
            
            PreparedStatement pst = conn.prepareStatement("INSERT INTO ma_anggota (kode, nis, nama_lengkap, jurusan, kelas, "
                    + " skor, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ? )");
            
            pst.setString(1, getKode());
            pst.setString(2, getNis());
            pst.setString(3, getNama());
            
            // get id jurusan
            PreparedStatement getJurId = conn.prepareStatement("SELECT id FROM ma_jurusan WHERE nama = '"+ getJurusan() + "'");
            ResultSet ResJur = getJurId.executeQuery();
            if(ResJur.next()){
                pst.setString(4, ResJur.getString("id"));
            }
            
            // get id kelas
            PreparedStatement getKelasId = conn.prepareStatement("SELECT id FROM ma_kelas WHERE kode = '" + getKelas() + "'");
            ResultSet ResKel = getKelasId.executeQuery();
            if(ResKel.next()){
                pst.setString(5, ResKel.getString("id"));
            }
            
            pst.setInt(6, Integer.parseInt(getSkor()));
            pst.setTimestamp(7, new SqlTime().getTimeStamp());
            pst.setTimestamp(8, new SqlTime().getTimeStamp());
            
            if(pst.execute()){
                throw new SQLException("Gagal menambahkan anggota!");
            }
            
            // cetak log
            new LogModel().Action("TAMBAH ANGGIOTA", "Menambahkan anggota "+ getNama(), Dashboard.nama_user);
            
            // refresh
            new AnggotaModel().getDataTable(Dashboard.SEARCH_USER.getText(), Dashboard.GROUP_COMBOBOX_USER.getSelectedItem().toString(), Dashboard.TAMPILKAN_COMBOBOX_USER.getSelectedItem().toString());
            
            setMessage("Berhasil menambahkan anggota !");
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
