/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
import com.manurul.lib.SqlTime;
import com.manurul.view.Dashboard;
import com.manurul.view.modal.BukuDATABUKU;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caesarhome
 */
public class BukuModel extends DBConfig {
    
    // set state 
    String old_isbn;
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
    int stok;
    String rak;
    String deskripsi;
    String max_dipinjam;
    int dipinjam;
    String created_at;
    String updated_at;
    String message;
    
    Connection conn = (Connection)getConnection();
    DefaultTableModel table_model = new DefaultTableModel();
    
    public void setOldISBN(String ISBN){
        this.old_isbn = ISBN;
    }
    
    public String getOldISBN(){
        return this.old_isbn;
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
    
    public void setStok(int stok) {
        this.stok = stok;
    }
    
    public int getStok() {
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
    
    public void setMaxDipinjam(String jumlah) {
        this.max_dipinjam = jumlah;
    }
    
    public String getMaxDipinjam() {
        return this.max_dipinjam;
    }
    
    public void setDipinjam(int pinjam){
        this.dipinjam = pinjam;
    }
    
    public int getDipinjam(){
        return this.dipinjam;
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
    public String getKategoriModel(String Nama){
    
        try{
        
        String sql = "SELECT nama FROM ma_kategori";
        if(!Nama.equals("")){
        
            sql = "SELECT kode FROM ma_kategori WHERE nama = '" + Nama.toLowerCase()  + "'"; 
            
        }
        
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet res = pst.executeQuery();
        
        if(Nama.equals("")){

            while(res.next()){
                BukuDATABUKU.INPUT_KATEGORI.addItem(res.getString("nama"));
            }

        }else{

            if(res.next()){
                return res.getString("kode");
            }

        }
        
        return "";
        
        }catch(SQLException error){
        
            return error.getMessage();
            
        }
        
    }
    
    // get penerbit
    public String getPenerbitModel(String Nama){
    
        try{
            
            String sql = "SELECT nama FROM ma_penerbit";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            while(res.next()){
                BukuDATABUKU.INPUT_PENERBIT.addItem(res.getString("nama"));
            }

            return "";
            
        }catch(SQLException error){
        
            return error.getMessage();
            
        }
        
    }
    
    // get rak
    public String getRakModel(){
    
        try{

            String sql = "SELECT kode FROM ma_rak";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            while(res.next()){
                BukuDATABUKU.INPUT_RAK.addItem(res.getString("kode"));
            }
        
            return "";
        
        }catch(SQLException error){
        
            return error.getMessage();
            
        }
        
    }
    
    
    // setDataTable
    public void setDataTable(String Keyword, String Group, String Showing){
    
        table_model.setRowCount(0);
        table_model.addColumn("No");
        table_model.addColumn("ISBN");
        table_model.addColumn("Judul");
        table_model.addColumn("Kategori");
        table_model.addColumn("Jenis");
        table_model.addColumn("Rak");
        
        Dashboard.TABLE_LIST_BUKU.setModel(table_model);
        table_model.setRowCount(0);
        
        try{
        
            String GroupSelected;
            if(Group.equals("Semua")){
                GroupSelected = "isbn";
            }else{
                GroupSelected = Group;
            }

            String limited;
            if(Showing.equals("Semua")){
                limited = "";
            }else{
                limited = " LIMIT " + Showing;
            }
            
            String sql = "SELECT isbn, judul, kategori, jenis, rak FROM ma_buku WHERE"
                    + " isbn LIKE '%"+Keyword+"%' OR judul LIKE '%"+Keyword+"%'"
                    + " ORDER BY " + GroupSelected + limited;
            
            PreparedStatement pst =  conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            int i = 1;
            while(res.next()){
            
                table_model.addRow(new Object[]{
                    i++,
                    res.getString("isbn"),
                    res.getString("judul"),
                    res.getString("kategori"),
                    res.getString("jenis"),
                    res.getString("rak"),
                });
                
            }
            
            
        }catch(SQLException error){
        
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
            
        }
        
        
    }
    
    // insert data
    public boolean insertData(){
    
        try{
            
            String sql = "INSERT INTO ma_buku(isbn, judul, jenis, kategori, harga, tahun_terbit, penulis, penerbit, stok, rak, deskripsi, max_hari_pinjam, created_at, updated_at)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getIsbn());
            pst.setString(2, getJudul());
            pst.setString(3, getJenis());
            pst.setString(4, getKategoriModel(getKategori()));
            pst.setString(5, getHarga());
            pst.setString(6, getTahunTerbit());
            pst.setString(7, getPenulis());
            pst.setString(8, getPenerbit());
            pst.setInt(9, getStok());
            pst.setString(10, getRak());
            pst.setString(11, getDeskripsi());
            pst.setString(12, getMaxDipinjam());
            pst.setTimestamp(13, new SqlTime().getTimeStamp());
            pst.setTimestamp(14, new SqlTime().getTimeStamp());
            
            if(pst.execute()){
                throw new SQLException("Gagal menambahkan buku !");
            }
            
            // cetak log
            new LogModel().Action("TAMBAH BUKU", "Menambahkan buku "+ getJudul(), Dashboard.nama_user);
            
            // refresh
            new BukuModel().setDataTable(Dashboard.SEARCH_BUKU.getText(), Dashboard.KATEGORI_COMBOBOX_BUKU.getSelectedItem().toString(), Dashboard.TAMPILKAN_COMBOBOX_BUKU.getSelectedItem().toString());
            
            setMessage("Berhasil menambahkan buku " + getJudul());
            return true;
        
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Buku ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;
            
        }
        
    }
    
    // getSelectedData
    public void getSelectedData(String Kode){
    
        try{
        
            String sql =  "SELECT * FROM ma_buku WHERE isbn = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Kode);
            ResultSet res = pst.executeQuery();
            
            if(!res.next()){
                throw new SQLException("Gagal memuat data buku !");                        
            }
            
            setOldISBN(res.getString("isbn"));
            setIsbn(res.getString("isbn"));
            setJudul(res.getString("judul"));
            
                String sql_kategori = "SELECT nama FROM ma_kategori WHERE kode = ?";
                PreparedStatement pst_kategori = conn.prepareStatement(sql_kategori);
                pst_kategori.setString(1, res.getString("kategori"));
                ResultSet res_kategori = pst_kategori.executeQuery();

                if(!res_kategori.next()){
                    throw new SQLException("Gagal memuat kategori buku !");
                }
            
                setKategori(res_kategori.getString("nama"));
                
            setTahunTerbit(res.getString("tahun_terbit"));
            setHarga(res.getString("harga"));
            setJenis(res.getString("jenis"));
            setMaxDipinjam(res.getString("max_hari_pinjam"));
            setPenerbit(res.getString("penerbit"));
            setPenulis(res.getString("penulis"));
            setStok(res.getInt("stok"));
            setRak(res.getString("rak"));
            setDeskripsi(res.getString("deskripsi"));
            setDipinjam(res.getInt("jumlah_dipinjam"));
            
            setCreated(res.getString("created_at"));
            setUpdated(res.getString("updated_at"));
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    // update data
    public boolean updateData(){
    
        try{
        
            String sql = "UPDATE ma_buku SET isbn = ?, judul = ?, kategori = ?, harga = ?, tahun_terbit = ?, penulis = ?, "
                    + " penerbit = ?, stok = ?, rak = ?, deskripsi = ?, max_hari_pinjam = ?, updated_at = ?, jenis = ? WHERE isbn = ?";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getIsbn());
            pst.setString(2, getJudul());
            pst.setString(3, getKategoriModel(getKategori()));
            pst.setString(4, getHarga());
            pst.setString(5, getTahunTerbit());
            pst.setString(6, getPenulis());
            pst.setString(7, getPenerbit());
            pst.setInt(8, getStok());
            pst.setString(9, getRak());
            pst.setString(10, getDeskripsi());
            pst.setString(11, getMaxDipinjam());
            pst.setTimestamp(12, new SqlTime().getTimeStamp());
            pst.setString(13, getJenis());
            pst.setString(14, getOldISBN());
            
            int updated = pst.executeUpdate();
            
            if(updated == 0){
                throw new SQLException("Gagal memperbarui buku " + getJudul());
            }
            
            // cetak log
            new LogModel().Action("UPDATE BUKU", "Memperbarui buku "+ getJudul(), Dashboard.nama_user);
            
            setMessage("Berhasil memperbarui buku " + getJudul());
            return true;
            
        }catch(SQLException error){
            System.out.println(error.getMessage());
            if(error.getErrorCode() == 1062){
                setMessage("Buku ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;
        }
        
    }
    
    // delete data
    public boolean deleteData(){
        
        try{
            
            String sql = "DELETE FROM ma_buku WHERE isbn = ?";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getOldISBN());
            
            if(pst.execute()){
                throw new SQLException("Gagal menghapus buku " + getJudul());
            }
            
            // cetak log
            new LogModel().Action("DELETE BUKU", "Menghapus buku "+ getJudul(), Dashboard.nama_user);
            
            setMessage("Berhasil menghapus buku " + getJudul());
            return true;
        
        }catch(SQLException error){
            
            setMessage(error.getMessage());
            
            return false;
        }
        
    }
    
    
}
