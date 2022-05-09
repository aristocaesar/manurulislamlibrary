/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
import com.manurul.view.Dashboard;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caesarhome
 */
public class BukuModel extends DBConfig {
    
    // set state 
    int id;
    String isbn;
    String judul;
    String jenis;
    String kategori;
    String harga;
    String lebar_panjang;
    String jumlah_halaman;
    String tahun_terbit;
    String penulis;
    String penerbit;
    String stok;
    String rak;
    String deskripsi;
    String jumlah_dipinjam;
    String created_at;
    String updated_at;
    String message;
    
    Connection conn = (Connection)getConnection();
    DefaultTableModel table_model = new DefaultTableModel();
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    
    public String getIsbn(){
        return this.isbn;
    }
    
    public void setJudul(String judul){
        this.judul = judul;
    }
    
    public String getJudul(){
        return this.judul;
    }
    
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public String getJenis() {
        return this.jenis;
    }
    
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
    public String getKategori() {
        return this.kategori;
    }
    
    public void setHarga(String harga) {
        this.harga = harga;
    }
    
    public String getHarga() {
        return this.harga;
    }
    
    public void setLebarPanjang(String lb) {
        this.lebar_panjang = lb;
    }
    
    public String getLebarPanjang() {
        return this.lebar_panjang;
    }
    
    public void setJumlahHalaman(String halaman) {
        this.jumlah_halaman = halaman;
    }
    
    public String getHalaman() {
        return this.jumlah_halaman;
    }
    
    public void setTahunTerbit(String tahun) {
        this.tahun_terbit = tahun;
    }
    
    public String getTahunTerbit() {
        return this.tahun_terbit;
    }
    
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }
    
    public String getPenulis() {
        return this.penulis;
    }
    
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
    
    public String getPenerbit() {
        return this.penerbit;
    }
    
    public void setStok(String stok) {
        this.stok = stok;
    }
    
    public String getStok() {
        return this.stok;
    }
    
    public void setRak(String rak) {
        this.rak = rak;
    }
    
    public String getRak() {
        return this.rak;
    }
    
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public String getDeskripsi() {
        return this.deskripsi;
    }
    
    public void setJumlahPinjam(String jumlah) {
        this.jumlah_dipinjam = jumlah;
    }
    
    public String getJumlahPinjam() {
        return this.jumlah_dipinjam;
    }
    
    public void setCreated(String tgl) {
        this.created_at = tgl;
    }
    
    public String getCreated() {
        return this.created_at;
    }
    
    public void setUpdated(String tgl) {
        this.updated_at = tgl;
    }
    
    public String getUpdated() {
        return this.updated_at;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    // get kategori
    private String getKategori(String id){
    
        try{
            
        String sql = "SELECT kode FROM ma_kategori WHERE id = ?";
        
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        if(res.next()){
            return res.getString("kode");
        }
        
        return "";
        
        }catch(SQLException error){
        
            return error.getMessage();
            
        }
        
    }
    
    // get penerbit
    private String getPenerbit(String id){
    
        try{
            
        String sql = "SELECT nama FROM ma_penerbit WHERE id = ?";
        
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        if(res.next()){
            return res.getString("nama");
        }
        
        return "";
        
        }catch(SQLException error){
        
            return error.getMessage();
            
        }
        
    }
    
    // get rak
    private String getRak(String id){
    
        try{
            
        String sql = "SELECT kode FROM ma_rak WHERE id = ?";
        
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, id);
        ResultSet res = pst.executeQuery();
        
        if(res.next()){
            return res.getString("kode");
        }
        
        return "";
        
        }catch(SQLException error){
        
            return error.getMessage();
            
        }
        
    }
    
    
    // setDataTable
    public void setDataTable(){
    
        table_model.setRowCount(0);
        table_model.addColumn("No");
        table_model.addColumn("ISBN");
        table_model.addColumn("Judul");
        table_model.addColumn("Kategori");
        table_model.addColumn("Jenis");
        table_model.addColumn("Rak");
        
        Dashboard.TABLE_LIST_BUKU.setModel(table_model);
        table_model.setColumnCount(0);
        
//        String sql = "SELECT ma_buku.isbn, ma_buku.judul, ma_kategori.nama, ma_buku.jenis FROM "
        
    }
    
    // insert data
    
    // getSelectedData
    
    // update data
    
    // delete data
    
    
}
