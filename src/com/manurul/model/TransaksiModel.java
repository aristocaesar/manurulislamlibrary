/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.barcodelib.barcode.Linear;
import com.manurul.lib.DBConfig;
import com.manurul.lib.GenKode;
import com.manurul.lib.SqlTime;
import com.manurul.view.Dashboard;
import com.manurul.view.modal.getDaftarBukuTRANSAKSI;
import com.manurul.view.modal.getPeminjamTRANSAKSI;
import com.manurul.view.modal.konfirmasiBukuPengembalian;
import com.manurul.view.modal.konfirmasiTransaksiPinjam;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import javax.swing.Timer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author caesarhome
 */

public class TransaksiModel extends DBConfig{

    private Connection conn = (Connection)DBConfig.getConnection();

    // getPeminjamTransaksi
    DefaultTableModel table_model = new DefaultTableModel();


    // var global for data transaksi
    private String id_transaksi;
    private String nis;
    private String nama;
    private String kode_pengurus;
    private String jenis_buku;
    private String status_transaksi;
    private int jumlah_buku_dipinjam;
    private String createdAt;
    private String updatedAt;

    // SET SUCCESS ICON
    private ImageIcon successIcon = new ImageIcon(getClass().getResource("/com/manurul/src/ICON_SUCCESS.png"));

    private String message;

    public void setId(String id){
        this.id_transaksi = id;
    }

    public String getId(){
        return this.id_transaksi;
    }

    public void setNis(String nis){
        this.nis = nis;
    }

    public String getNis(){
        return this.nis;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return this.nama;
    }

    public void setKodePengurus(String id){
        this.kode_pengurus = id;
    }

    public String getKodePengurus(){
        return this.kode_pengurus;
    }

    public void setJenisBuku(String jenis){
        this.jenis_buku = jenis;
    }

    public String getJenisBuku(){
        return this.jenis_buku;
    }

    public void setStatusTransaksi(String status){
        this.status_transaksi = status;
    }

    public String getStatusTransksi(){
        return this.status_transaksi;
    }

    public void setJumlahBukuDipinjam(int jumlah){
        this.jumlah_buku_dipinjam = jumlah;
    }

    public int getJumlahBukuDipinjam(){
        return this.jumlah_buku_dipinjam;
    }

    public void setCreated(String created){
        this.createdAt = created;
    }

    public String getCreated(){
        return this.createdAt;
    }

    public void setUpdated(String updated){
        this.updatedAt = updated;
    }

    public String getUpdated(){
        return this.updatedAt;
    }

    public void setMessage(String msg){
        this.message = msg;
    }

    public String getMessage(){
        return this.message;
    }

    public static void setDateNowTransaksi(){

        Dashboard.PJ_INPUT_ID_TRANSAKSI.setText(GenKode.Transaksi());

    }

    // get realtime
    public void getDateRealTime(){

        Timer timer;

        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              String date = GenKode.TransaksiGetDate();
              Dashboard.PJ_INPUT_TGL_PINJAM.setText(date);
            }
        });

        timer.start();
    }

    // set datatable dashboad - pinjam
    public void setHeadTableDashboardPinjam(){

        DefaultTableModel table_pinjam_model = (DefaultTableModel)Dashboard.TABLE_LIST_PINJAM.getModel();

        table_pinjam_model.setColumnCount(0);
        table_pinjam_model.addColumn("ISBN");
        table_pinjam_model.addColumn("Judul Buku");
        table_pinjam_model.addColumn("Masa Pinjam");

        table_pinjam_model.setRowCount(0);
        table_pinjam_model.addRow(new String[]{
            "",
            "",
            ""
        });

        Dashboard.TABLE_LIST_PINJAM.setModel(table_pinjam_model);
    }

    // set datatable dashboard - pinjam - addrow
    public void setRowTableDashboardPinjam(String[] rowData, boolean started){

        DefaultTableModel addModel = (DefaultTableModel)Dashboard.TABLE_LIST_PINJAM.getModel();
        if(started){
            addModel.setRowCount(0);
        }
        addModel.addRow(rowData);

    }

    // set datatable from request
    public void setDataAnggota(String Keyword){

        // SET COLUMN TABLE
        table_model.setColumnCount(0);
        table_model.addColumn("NIS");
        table_model.addColumn("Nama");
        table_model.addColumn("Jurusan");
        table_model.addColumn("Skor");
        table_model.addColumn("Ksmptn Pinjam");

        table_model.setRowCount(0);

        try{

            String sql = "SELECT ma_anggota.nis, ma_anggota.nama_lengkap, ma_anggota.jurusan, ma_anggota.skor, "
                    + "ma_setting.max_pinjam_buku_umum - ma_anggota.jumlah_buku_dipinjam as kesempatan_pinjam FROM ma_anggota JOIN"
                    + " ma_setting"
                    + " WHERE ma_anggota.nis LIKE '%"+Keyword+"%' OR ma_anggota.nama_lengkap LIKE '%"+Keyword+"%'";
            if(Keyword.equals("")){
                sql = "SELECT ma_anggota.nis, ma_anggota.nama_lengkap, ma_anggota.jurusan, ma_anggota.skor,"
                        + " ma_setting.max_pinjam_buku_umum - ma_anggota.jumlah_buku_dipinjam as kesempatan_pinjam"
                        + " FROM ma_anggota JOIN ma_setting";
            }

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            while(res.next()){
                table_model.addRow(new Object[]{
                    res.getString("nis"),
                    res.getString("nama_lengkap"),
                    res.getString("jurusan"),
                    res.getString("skor"),
                    res.getString("kesempatan_pinjam"),
                });
            }

            getPeminjamTRANSAKSI.TABLE_LIST_PEMINJAM.setModel(table_model);

            int rowCount = getPeminjamTRANSAKSI.TABLE_LIST_PEMINJAM.getRowCount();

            if(rowCount > 0){
                getPeminjamTRANSAKSI.TABLE_LIST_PEMINJAM.setRowSelectionInterval(0, 0);
            }else{
                table_model.addRow(new Object[]{
                    "",
                    "Tidak Ditemukan",
                    "",
                    "",
                    ""
                });
                getPeminjamTRANSAKSI.TABLE_LIST_PEMINJAM.setModel(table_model);
            }

        }catch(SQLException error){

            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    //
    public void setDataBuku(String Keyword, String Jenis){

        // SET COLUMN TABLE
        table_model.setColumnCount(0);
        table_model.addColumn("ISBN");
        table_model.addColumn("Judul");
        table_model.addColumn("Kategori");
        table_model.addColumn("Maksimal Pinjam");

        table_model.setRowCount(0);

        try{

            String jenis = "'UMUM'";
            if(Jenis.contains("PAKET")){
                jenis = "'PAKET'";
            }

            String sql = "SELECT ma_buku.isbn, ma_buku.judul, ma_kategori.nama as kategori, ma_buku.max_hari_pinjam FROM ma_buku"
                    + " JOIN ma_kategori ON ma_buku.kategori = ma_kategori.kode"
                    + " WHERE isbn LIKE '%"+Keyword+"%' OR judul LIKE '%"+Keyword+"%' AND jenis = " + jenis + " AND stok != 0";
            if(Keyword.equals("")){
                sql = "SELECT ma_buku.isbn, ma_buku.judul, ma_kategori.nama as kategori, ma_buku.max_hari_pinjam"
                        + " FROM ma_buku JOIN ma_kategori ON ma_buku.kategori = ma_kategori.kode AND jenis = " + jenis + " AND stok != 0";
            }

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            while(res.next()){
                table_model.addRow(new Object[]{
                    res.getString("isbn"),
                    res.getString("judul"),
                    res.getString("kategori"),
                    res.getString("max_hari_pinjam") + " Hari"
                });
            }

            getDaftarBukuTRANSAKSI.TABLE_LIST_BUKU.setModel(table_model);

            int rowCount = getDaftarBukuTRANSAKSI.TABLE_LIST_BUKU.getRowCount();

            if(rowCount > 0){
                getDaftarBukuTRANSAKSI.TABLE_LIST_BUKU.setRowSelectionInterval(0, 0);
            }else{
                table_model.addRow(new Object[]{
                    "",
                    "Tidak Ditemukan",
                    "",
                    ""
                });
                getDaftarBukuTRANSAKSI.TABLE_LIST_BUKU.setModel(table_model);
            }

        }catch(SQLException error){

            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    // cetak transaksi pinjam
    public void konfirmasiTransaksiPinjam(){

        String id_transaksi = Dashboard.PJ_INPUT_ID_TRANSAKSI.getText();
        String nis_peminjam = Dashboard.TM.getNis();
        String nama_peminjam = Dashboard.TM.getNama();
        String jenis_buku = Dashboard.PJ_INPUT_JENIS_BUKU.getSelectedItem().toString();
        String nama_pengurus = Dashboard.nama_user;

        konfirmasiTransaksiPinjam formKonfirmasi = new konfirmasiTransaksiPinjam();
        formKonfirmasi.LABEL_ID_TRANSAKSI.setText("#" + id_transaksi);
        formKonfirmasi.INPUT_NAMA_PEMINJAM.setText(nis_peminjam + " - " + nama_peminjam);
        formKonfirmasi.INPUT_JENIS_BUKU.setText(jenis_buku);
        formKonfirmasi.LABEL_PENGURUS.setText(nama_pengurus);

        // get model table konfirmasi
        DefaultTableModel konfirmasi_model_pinjam = (DefaultTableModel)formKonfirmasi.TABLE_LIST_BUKU_PINJAM.getModel();

        // set row to null
        konfirmasi_model_pinjam.setRowCount(0);

        // set rows with max hari pinjam
        int countRowsMainPinjam = Dashboard.TABLE_LIST_PINJAM.getRowCount();
        for(int i = 0; i < countRowsMainPinjam; i++){
            konfirmasi_model_pinjam.addRow(new String[]{
                Dashboard.TABLE_LIST_PINJAM.getValueAt(i, 0).toString() + " -  " + Dashboard.TABLE_LIST_PINJAM.getValueAt(i, 1).toString(),
                Dashboard.TABLE_LIST_PINJAM.getValueAt(i, 2).toString(),
                getDateTglPengembalian(Dashboard.TABLE_LIST_PINJAM.getValueAt(i, 2).toString().replaceAll("[a-zA-Z]", "").trim())
            });
        }

        formKonfirmasi.setVisible(true);

    }

    public String getDateTglPengembalian(String date){

        SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");

        // get epoc now
        Long epoch = Long.parseLong(GenKode.getTimeMiliSecond());

        // merge epoc now with length pinjam
        Long hari = Long.parseLong(date);
        hari = (86400000 * hari) + epoch;

        Date max_hari_pinjam = new Date(hari);
        return dateFormater.format(max_hari_pinjam);

    }

    public Long getEpochTglPengembalian(String hari){

        // get epoc now
        Long epoch = Long.parseLong(GenKode.getTimeMiliSecond());

        Long jml_hari = Long.parseLong(hari);
        return (86400000 * jml_hari) + epoch;

    }

    public String getExistBukuInPeminjam(String isbn){

        try{

            String sql = "SELECT ma_detail_transaksi.status_buku AS status_buku FROM ma_detail_transaksi JOIN ma_transaksi " +
                         " ON ma_detail_transaksi.id_transaksi = ma_transaksi.id_transaksi WHERE ma_transaksi.nis_anggota = ? AND ma_detail_transaksi.isbn = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getNis());
            pst.setString(2, isbn);
            ResultSet res = pst.executeQuery();

            if(!res.next()){
                throw new SQLException("NOTFOUND");
            }

            return res.getString("status_buku");

        }catch(SQLException error){

            return error.getMessage();

        }

    }

    public boolean cetakPinjam(){
        
        String id_transaksi = Dashboard.PJ_INPUT_ID_TRANSAKSI.getText();
        String nis_peminjam = getNis();
        String jenis_buku = Dashboard.PJ_INPUT_JENIS_BUKU.getSelectedItem().toString();
        String kode_pengurus = Dashboard.id_kode;
        
        try{

            // insert transaksi
            
            Timestamp dateNow =  new SqlTime().getTimeStamp();

            String sql_transaksi = "INSERT INTO ma_transaksi VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst_transaksi = conn.prepareStatement(sql_transaksi);
            pst_transaksi.setString(1, id_transaksi);
            pst_transaksi.setString(2, nis_peminjam);
            pst_transaksi.setString(3, kode_pengurus);
            pst_transaksi.setString(4, null);

            if(jenis_buku.contains("UMUM")){
                jenis_buku = "UMUM";
            }else{
                jenis_buku = "PAKET";
            }

            pst_transaksi.setString(5, jenis_buku);
            pst_transaksi.setString(6, "DIPINJAM");
            pst_transaksi.setTimestamp(7, dateNow);
            pst_transaksi.setTimestamp(8, dateNow);

            if(pst_transaksi.execute()){

                throw new SQLException("Gagal menambahkan transaksi !");

            }else{

                // insert detail_transaksi

                int getCountDaftarBuku = Dashboard.TABLE_LIST_PINJAM.getRowCount();

                String sql_detail_transaksi = "INSERT INTO ma_detail_transaksi(id_transaksi, isbn, masa_pinjam ) VALUES (?, ?, ?)";
                PreparedStatement pst_detail_transaksi = conn.prepareStatement(sql_detail_transaksi);

                for(int i = 0; i < getCountDaftarBuku; i++){

                    pst_detail_transaksi.setString(1, id_transaksi);
                    pst_detail_transaksi.setString(2, Dashboard.TABLE_LIST_PINJAM.getValueAt(i, 0).toString());
                    pst_detail_transaksi.setLong(3, getEpochTglPengembalian(Dashboard.TABLE_LIST_PINJAM.getValueAt(i, 2).toString().replaceAll("[a-zA-Z]", "").trim()));

                    if(pst_detail_transaksi.execute()){
                        throw new SQLException("Gagal membuat transaksi !");
                    }
                    
                    updateDashboardBukuDipinjam("ADD");

                }

            }

            // print transaksi pinjam
            try{
                
                String barcodePath = null;
                File filePath = new File("src/com/manurul/report/barcode/"+id_transaksi+".png");
                // buat barcode 
                try{
                
                    Linear barcode = new Linear();
                    barcode.setType(Linear.CODE128B);
                    barcode.setData(id_transaksi);
                    barcode.setI(11.0f);
                    barcodePath = filePath.getAbsolutePath();
                    barcode.renderBarcode(barcodePath);
                    
                }catch(Exception error){
                
                    throw new SQLException(error.getMessage());
                    
                }
            
                String fileName = "/com/manurul/report/transaksi/reportPeminjaman.jasper";
                InputStream Report;
                Report = getClass().getResourceAsStream(fileName);

                HashMap hash = new HashMap();
                
                File logoPath = new File("src/com/manurul/src/LOGO_MANURUL.png");
                
                hash.put("logo", logoPath.getAbsolutePath());
                hash.put("id_transaksi", id_transaksi);
                hash.put("nama_lengkap", getNama());
                
                // get date 
                Date timeDate = new Date(dateNow.getTime());
                SimpleDateFormat timeFormat = new SimpleDateFormat("dd / MM / YYYY ");
                
                hash.put("tanggal_transaksi", timeFormat.format(timeDate));
                hash.put("pengurus", Dashboard.USERNAME.getText());
                hash.put("barcode", barcodePath);

                JasperPrint print;
                print = JasperFillManager.fillReport(Report, hash, conn);
                JasperPrintManager.printReport(print, false);
                new JasperViewer(print, false).setVisible(true);
                
            }catch(Exception error){
            
                throw new SQLException(error.getMessage());
                
            }
            
            // cetak log
            new LogModel().Action("MEMBUAT TRANSAKSI", "Berhasil membuat Transaksi " + id_transaksi, Dashboard.nama_user);

            resetForm("PINJAM");
            JOptionPane.showMessageDialog(null, "Transaksi #" + id_transaksi + " sukses !", "Sukses !", JOptionPane.INFORMATION_MESSAGE, this.successIcon);

            
            return true;
        }catch(SQLException error){

            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }


    // PENGEMBALIAN

    public void initTablePengembalian(){

        DefaultTableModel table_peminjaman = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN.getModel();

        table_peminjaman.setRowCount(0);
        table_peminjaman.setRowCount(1);
        
        DefaultTableModel table_peminjaman_1 = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN1.getModel();
        
        table_peminjaman_1.setRowCount(0);
        table_peminjaman_1.setRowCount(1);

    }

    public void getDataPinjam(String id_transaksi){

        DefaultTableModel table_detail_buku = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN.getModel();
        
        // reset form list buku yang dikembalikan
        DefaultTableModel table_list_buku_pengembalian = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN1.getModel();

        try{

            // SET DATA PENGEMBALIAN
            String sql = "SELECT "
                    + "ma_transaksi.id_transaksi AS id_transaksi"
                    + ",ma_transaksi.status_transaksi AS status_transaksi"
                    + ",ma_anggota.nis AS nis"
                    + ",ma_anggota.nama_lengkap AS nama_lengkap"
                    + ",ma_transaksi.jenis_buku AS jenis_buku"
                    + ",DATE_FORMAT(ma_transaksi.created_at, '%d/%M/%Y %H:%i:%S') AS tgl_pinjam"
                    + ",CONCAT(ma_pengurus.kode, ' - ' ,ma_pengurus.nama_lengkap) AS pengurus"
                    + " FROM ma_transaksi "
                    + "JOIN ma_anggota ON ma_transaksi.nis_anggota = ma_anggota.nis "
                    + "JOIN ma_pengurus ON ma_transaksi.kode_pengurus = ma_pengurus.kode "
                    + "WHERE ma_transaksi.id_transaksi = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "TR-" + id_transaksi);
            ResultSet res = pst.executeQuery();

            if(res.next()){
                
                if(res.getString("status_transaksi").equals("SELESAI")){
                    throw new SQLException("Transaksi Buku sudah berakhir !");
                }

                Dashboard.PJ_INPUT_PEMINJAM_PENGEMBALIAN.setText(res.getString("nis") + " - " + res.getString("nama_lengkap"));
                int jenisIndex = 0;
                if(res.getString("jenis_buku").contains("PAKET")){
                    jenisIndex = 1;
                }
                Dashboard.PJ_INPUT_JENIS_BUKU_PENGEMBALIAN.setSelectedIndex(jenisIndex);
                Dashboard.PJ_INPUT_TGL_PINJAM_PENGEMBALIAN.setText(res.getString("tgl_pinjam"));
                Dashboard.PJ_INPUT_PENGURUS_PENGEMBALIAN.setText(res.getString("pengurus"));

                // DATA LIST BUKU PENGEMBALIAN

                String sql_detail_transaksi = "SELECT "
                        + "ma_buku.isbn AS isbn,"
                        + "ma_buku.judul AS judul,"
                        + "ma_buku.harga,"
                        + "ma_detail_transaksi.masa_pinjam AS masa_pinjam,"
                        + "ma_detail_transaksi.status_buku AS status_buku,"
                        + "ma_detail_transaksi.status_masalah AS status_masalah,"
                        + "ma_detail_transaksi.jumlah_denda AS denda"
                        + " FROM"
                        + " ma_buku JOIN ma_detail_transaksi"
                        + " ON"
                        + " ma_buku.isbn = ma_detail_transaksi.isbn"
                        + " WHERE"
                        + " ma_detail_transaksi.id_transaksi = ?";
                
                PreparedStatement pst_detail = conn.prepareStatement(sql_detail_transaksi);
                pst_detail.setString(1, res.getString("id_transaksi"));
                ResultSet res_detail = pst_detail.executeQuery();

                table_detail_buku.setRowCount(0);
                table_list_buku_pengembalian.setRowCount(0);

                while(res_detail.next()){
                    
                    // cek apakah buku terlambat
                    Long epoch = Long.parseLong(GenKode.getTimeMiliSecond());
                    Long masa = Long.parseLong(res_detail.getString("masa_pinjam"));
                    
                    if(!res_detail.getString("status_buku").equals("Dikembalikan")){
                    
                        String masalah = "Dipinjam";
                        if(res_detail.getString("status_buku").equals("Bermasalah")){
                            masalah = res_detail.getString("status_buku") + " - " + res_detail.getString("status_masalah");
                        }
                        
                        table_detail_buku.addRow(new Object[]{
                            res_detail.getString("isbn"),
                            res_detail.getString("judul"),
                            masa <= epoch ? "Bermasalah - Terlambat" : masalah
                        });
                        
                    }else{
                    
                        table_list_buku_pengembalian.addRow(new Object[]{
                            res_detail.getString("isbn"),
                            res_detail.getString("judul"),
                            res_detail.getString("denda") != null ? "Dikembalikan - LUNAS" : "Dikembalikan - SELESAI"
                        });
                        
                    }
                    
                }
                
                if(table_detail_buku.getRowCount() == 0){
                    table_detail_buku.setRowCount(1);
                }
                if(table_list_buku_pengembalian.getRowCount() == 0){
                    table_list_buku_pengembalian.setRowCount(1);
                }

            }else{
                throw new SQLException("ID Transaksi tersebut tidak terdaftar !");
            }

        }catch(SQLException error){

                Dashboard.PJ_INPUT_ID_TRANSAKSI_PENGEMBALIAN.setText("");
                Dashboard.PJ_INPUT_PEMINJAM_PENGEMBALIAN.setText("");
                Dashboard.PJ_INPUT_JENIS_BUKU_PENGEMBALIAN.setSelectedIndex(0);
                Dashboard.PJ_INPUT_TGL_PINJAM_PENGEMBALIAN.setText("");
                Dashboard.PJ_INPUT_PENGURUS_PENGEMBALIAN.setText("");

                initTablePengembalian();

                JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);

        }

    }
    
    public void getDetailBukuPengembalian(String id_transaksi, String isbn, int row){
    
        try{
            
            String sql = "SELECT " +
                            "ma_detail_transaksi.id_transaksi AS id_transaksi," +
                            "ma_buku.judul AS judul," +
                            "ma_buku.harga AS harga," +
                            "ma_detail_transaksi.status_buku AS status," +
                            "ma_detail_transaksi.status_masalah AS detail_masalah," +
                            "ma_detail_transaksi.masa_pinjam AS masa_pinjam " +
                            "FROM ma_detail_transaksi JOIN ma_buku " +
                            "ON ma_detail_transaksi.isbn = ma_buku.isbn " +
                            "WHERE ma_detail_transaksi.id_transaksi = ? AND ma_detail_transaksi.isbn = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, id_transaksi);
            pst.setString(2, isbn);
            ResultSet res = pst.executeQuery();
            
            if(res.next()){
            
                konfirmasiBukuPengembalian.INPUT_JUDUL.setText(res.getString("judul"));
                konfirmasiBukuPengembalian.INPUT_STATUS.setSelectedItem(res.getString("status"));
                
                Long epoch = Long.parseLong(GenKode.getTimeMiliSecond());
                Long masa = Long.parseLong(res.getString("masa_pinjam"));
                
                if( masa <= epoch){
                    konfirmasiBukuPengembalian.INPUT_MASALAH.setSelectedItem("Terlambat");
                    
                    // HITUNG DENDA TERLAMBAT
                    
                        int jumlahHariTelat = 0;
                        // nilai epoch dikurangi masa pinjam, lalu bagi 86400000, dapat dibagi sampai berapa ?
                        Long hariSisa = epoch - masa;
                        
                        // kurangi dengan 86400000, jika hasil < dari 86400000, maka stop
                        int satuHari = 86400000;
                        if(hariSisa >= 86400000){
                        
                            while(hariSisa >= satuHari){
                                hariSisa = hariSisa - satuHari;
                                jumlahHariTelat++;
                            }
                            
                        }
                        // hasil dari bagi hari tersebut dikalikan dengan jumlah denda
                        int denda = jumlahHariTelat * 2000;
                    
                    
                    konfirmasiBukuPengembalian.HARI_TERLAMBAT = jumlahHariTelat;
                    konfirmasiBukuPengembalian.DENDA_TERLAMBAT = denda;
                }
                
                konfirmasiBukuPengembalian.HARGA_BUKU = res.getString("harga");
                
            }
            
        }catch(SQLException error){
        
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }
    
    public void updateBukuBermasalah(String id_transaksi, String isbn, String nominal, int row){
        
        try{
            
            String sql = "UPDATE ma_detail_transaksi SET status_buku = 'Dikembalikan', jumlah_denda = ? WHERE id_transaksi = ? AND isbn =  ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nominal);
            pst.setString(2, id_transaksi);
            pst.setString(3, isbn);
            
            if(pst.execute()){
                throw new Exception("Gagal memperbarui status buku !");
            }
            
            // UBAH ROW BUKU KE TABLE PENGEMBALIAN
            DefaultTableModel table_list_pinjam = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN.getModel();
            DefaultTableModel table_list_kembali = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN1.getModel();
            
            String col_isbn = table_list_pinjam.getValueAt(row, 0).toString();
            String col_judul = table_list_pinjam.getValueAt(row, 1).toString();
            String col_status_old = table_list_pinjam.getValueAt(row, 2).toString();
            String col_status = "Dikembalikan - LUNAS";
            
            if(table_list_kembali.getValueAt(0, 0) == null){
                table_list_kembali.setRowCount(0);
            }
            
            table_list_kembali.addRow(new String[]{col_isbn, col_judul, col_status});
            
            table_list_pinjam.removeRow(row);
            
            if(table_list_pinjam.getRowCount() == 0){
                table_list_pinjam.setRowCount(1);
            }
            
            // get nis
            String[] nis = Dashboard.PJ_INPUT_PEMINJAM_PENGEMBALIAN.getText().split("-");
            
            if(col_status_old.contains("Terlambat")){
                
                updateKesempatanPinjam(nis[0].trim(), "KURANG");
                updateSkorPeminjam(nis[0].trim(), "LESS");
                updateStokBuku(isbn, "TAMBAH");
                
                updateDashboardBukuDipinjam("LESS");
                
            }else{
                
                updateKesempatanPinjam(nis[0].trim(), "KURANG");
                updateSkorPeminjam(nis[0].trim(), "LESS");
                updateStokBuku(isbn, "BERMASALAH");
                
                updateDashboardBukuDipinjam("LESS");
                updateDashboardBukuBermasalah("LESS");
            
            }
            
            JOptionPane.showMessageDialog(null, "Pembayaran dan status berhasil diperbarui !", "Sukses !", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception error){
            
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
        
        }
        
    }
    
    public void updateStokBuku(String isbn, String action){
    
        try{
            
            if(action.equals("TAMBAH")){
            
                // update stok buku
                String sql = "UPDATE ma_buku SET stok = stok + 1 WHERE isbn = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, isbn);
                if(pst.execute()){
                    throw new SQLException("Gagal melakukan perubahan stok !");
                }
                
                // update stok jumlah dipinjam buku
                String sql_buku_dipinjam = "UPDATE ma_buku SET jumlah_dipinjam = jumlah_dipinjam - 1 WHERE isbn = ?";
                PreparedStatement pst_buku_dipinjam = conn.prepareStatement(sql_buku_dipinjam);
                pst_buku_dipinjam.setString(1, isbn);
                if(pst_buku_dipinjam.execute()){
                    throw new SQLException("Gagal melakukan perubahan data pinjam !");
                }
            
            }else if(action.equals("KURANG")){
            
                // update stok buku
                String sql = "UPDATE ma_buku SET stok = stok - 1 WHERE isbn = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, isbn);
                if(pst.execute()){
                    throw new SQLException("Gagal melakukan perubahan stok !");
                }
                
                // update stok buku
                String sql_buku_dipinjam = "UPDATE ma_buku SET jumlah_dipinjam = jumlah_dipinjam + 1 WHERE isbn = ?";
                PreparedStatement pst_buku_dipinjam = conn.prepareStatement(sql_buku_dipinjam);
                pst_buku_dipinjam.setString(1, isbn);
                if(pst_buku_dipinjam.execute()){
                    throw new SQLException("Gagal melakukan perubahan data pinjam !");
                }
            
            }else{
            
                // update stok jumlah dipinjam buku
                String sql_buku_dipinjam = "UPDATE ma_buku SET jumlah_dipinjam = jumlah_dipinjam - 1 WHERE isbn = ?";
                PreparedStatement pst_buku_dipinjam = conn.prepareStatement(sql_buku_dipinjam);
                pst_buku_dipinjam.setString(1, isbn);
                if(pst_buku_dipinjam.execute()){
                    throw new SQLException("Gagal melakukan perubahan data pinjam !");
                }
            
            }
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void updateSkorPeminjam(String nis, String mode){
    
        try{
            
            // jika skor lebih kecil 50 dan tidak lebih besar dari 100
            
            PreparedStatement getSkor = conn.prepareStatement("SELECT skor FROM ma_anggota WHERE nis = ?");
            getSkor.setString(1, nis);
            ResultSet res = getSkor.executeQuery();
            if(res.next()){
            
                if(res.getInt("skor") > 50 && res.getInt("skor") < 100){
                    String sql  = "UPDATE ma_anggota SET skor = skor + ? WHERE nis = ?";
                    if(mode.equals("LESS")){
                        sql  = "UPDATE ma_anggota SET skor = skor - ? WHERE nis = ?";
                    }

                    // perubahan skor
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setInt(1, 10);
                    pst.setString(2, nis);
                    if(pst.execute()){
                        throw new SQLException("Gagal melakukan perubahan skor peminjam");
                    }
                }
                
            }
        
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void updateKesempatanPinjam(String nis, String action){
        try{
            
            //update kesempatan pinjam
            String sql_peminjam = "UPDATE ma_anggota SET jumlah_buku_dipinjam = jumlah_buku_dipinjam + 1 WHERE nis = ?";
            if(action.equals("KURANG")){
                sql_peminjam = "UPDATE ma_anggota SET jumlah_buku_dipinjam = jumlah_buku_dipinjam - 1 WHERE nis = ?";
            }
            PreparedStatement pst_peminjam = conn.prepareStatement(sql_peminjam);
            pst_peminjam.setString(1, nis);
            if(pst_peminjam.execute()){
                throw new SQLException("Gagal melakukan perubahan status peminjam !");
            }
            
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
    public void cetakPengembalian(String id_transaksi_p, String status_transaksi){
    
        DefaultTableModel table_list_dipinjam = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN.getModel();
        DefaultTableModel table_list_dikembali = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN1.getModel();
        
        int rowDipinjam = table_list_dipinjam.getRowCount();
        int rowKembali = table_list_dikembali.getRowCount();
        
        try{
        
            // update status buku pada table pinjam
            if(table_list_dipinjam.getValueAt(0, 0) != null){
                
                for(int i = 0; rowDipinjam > i; i++){
                    
                    String status = table_list_dipinjam.getValueAt(i, 2).toString();
                    if(status.contains("Bermasalah")){
                    
                        String masalah[] = status.split("-");
                        
                        updateStatusBuku(id_transaksi_p, table_list_dipinjam.getValueAt(i, 0).toString(), masalah[0].trim(), masalah[1].trim());
                        
                        updateDashboardBukuBermasalah("ADD");
                    }
                    
                }
                
            }
            
            if(table_list_dikembali.getValueAt(0, 0) != null){
            
                for(int i = 0; rowKembali > i; i++){
                
                    String nis[] = Dashboard.PJ_INPUT_PEMINJAM_PENGEMBALIAN.getText().split("-");
                    
                    String isbn = table_list_dikembali.getValueAt(i, 0).toString();
                    String status = table_list_dikembali.getValueAt(i, 2).toString();
                    if(status.equals("Dikembalikan")){
                    
                        // rubah status transaksi
                        updateStatusBuku(id_transaksi_p, table_list_dikembali.getValueAt(i, 0).toString(), "Dikembalikan", "Tidak Bermasalah");
                        
                        // rubah stok buku, buku yang dipinjam
                        updateStokBuku(isbn, "TAMBAH");
                        
                        // rubah skor peminjam (+10) dan ma_anggota.jumlah_buku_dipinjam -= 1
                        updateSkorPeminjam(nis[0].trim(), "ADD");
                        updateKesempatanPinjam(nis[0].trim(), "KURANG");
                        
                        // rubah total peminjaman
                        updateDashboardBukuDipinjam("LESS");
                        
                    }
                    
                }
                
            }
           
            PreparedStatement pst = conn.prepareStatement("UPDATE ma_transaksi SET kode_pengurus_kembali = ?, status_transaksi = ?, updated_at = ? WHERE id_transaksi = ?");
            pst.setString(1, Dashboard.id_kode);
            pst.setString(2, status_transaksi);
            pst.setTimestamp(3, new SqlTime().getTimeStamp());
            pst.setString(4, id_transaksi_p);
            
            if(pst.execute()){
                throw new SQLException("Gagal melakukan pengembalian buku !");
            }
            
            cetakPengembalian(id_transaksi_p);
            
            resetForm("PENGEMBALIAN");
            JOptionPane.showMessageDialog(null, "Transaksi #" + id_transaksi_p + " diperbarui !", "Sukses !", JOptionPane.INFORMATION_MESSAGE, this.successIcon);

        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
                    
        }
        
    }
    
    public void updateStatusBuku(String id_transaksi, String isbn, String status, String detail_masalah){
    
        try{
       
            String sql = "UPDATE ma_detail_transaksi SET status_buku = ?, status_masalah = ?, updated_at = ? WHERE isbn = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, status);
            pst.setString(2, detail_masalah);
            pst.setTimestamp(3, new SqlTime().getTimeStamp());
            pst.setString(4, isbn);
            
            if(pst.execute()){
                throw new SQLException("Detail buku gagal diperbarui !");
            }
            
        }catch(SQLException error){
        
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }
    
    public void cetakPengembalian(String id_transaksi){
    
        try{
            
            String nama[] = Dashboard.PJ_INPUT_PEMINJAM_PENGEMBALIAN.getText().split("-");
            
            String barcodePath = null;
            File filePath = new File("src/com/manurul/report/barcode/"+id_transaksi+".png");
            // buat barcode 
            try{

                Linear barcode = new Linear();
                barcode.setType(Linear.CODE128B);
                barcode.setData(id_transaksi);
                barcode.setI(11.0f);
                barcodePath = filePath.getAbsolutePath();
                barcode.renderBarcode(barcodePath);

            }catch(Exception error){

                throw new SQLException(error.getMessage());

            }

            String fileName = "/com/manurul/report/transaksi/reportPengembalian.jasper";
            InputStream Report;
            Report = getClass().getResourceAsStream(fileName);

            HashMap hash = new HashMap();

            File logoPath = new File("src/com/manurul/src/LOGO_MANURUL.png");

            hash.put("logo", logoPath.getAbsolutePath());
            hash.put("id_transaksi", id_transaksi);
            hash.put("nama_lengkap", nama[1]);

            // get date 
            Date timeDate = new Date(new SqlTime().getTimeStamp().getTime());
            SimpleDateFormat timeFormat = new SimpleDateFormat("dd / MM / YYYY ");
            hash.put("tanggal_transaksi", timeFormat.format(timeDate));
            hash.put("pengurus", Dashboard.USERNAME.getText());
            hash.put("barcode", barcodePath);

            JasperPrint print;
            print = JasperFillManager.fillReport(Report, hash, conn);
            JasperPrintManager.printReport(print, false);
            new JasperViewer(print, false).setVisible(true);
            
            // cetak log
            new LogModel().Action("MEMPERBARUI TRANSAKSI", "Berhasil memperbarui Transaksi " + id_transaksi, Dashboard.nama_user);

        
        }catch(Exception error){
        
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
            
        }
    
    }
    
    public void updateDashboardBukuDipinjam(String action){
    
        try{
        
            String sql = "UPDATE ma_dashboard SET buku_dipinjam = buku_dipinjam - 1 WHERE id = 1";
            if(action.equals("ADD")){
                sql = "UPDATE ma_dashboard SET buku_dipinjam = buku_dipinjam + 1 WHERE id = 1";
            }
            
            PreparedStatement pst = conn.prepareStatement(sql);
            if(pst.execute()){
                throw new SQLException("Gagal melakukan perubahan buku pinjam !");
            }
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void updateDashboardBukuBermasalah(String action){
         try{
        
            String sql = "UPDATE ma_dashboard SET buku_bermasalah = buku_bermasalah - 1 WHERE id = 1";
            if(action.equals("ADD")){
                sql = "UPDATE ma_dashboard SET buku_bermasalah = buku_bermasalah + 1 WHERE id = 1";
            }
            
            PreparedStatement pst = conn.prepareStatement(sql);
            if(pst.execute()){
                throw new SQLException("Gagal melakukan perubahan buku masalah !");
            }
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void resetForm(String mode){

        if(mode.equals("PINJAM")){

            // reset form pinjam

            setNis(null);
            setNama(null);

            setDateNowTransaksi();
            Dashboard.PJ_INPUT_PEMINJAM.setText("");
            Dashboard.PJ_INPUT_PEMINJAM.requestFocus();
            DefaultTableModel form_model = (DefaultTableModel)Dashboard.TABLE_LIST_PINJAM.getModel();

            form_model.setRowCount(0);
            form_model.setRowCount(1);

        }else if(mode.equals("PENGEMBALIAN")){
        
            // reset form pengembalian
            
            DefaultTableModel table_pinjam = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN.getModel();
            DefaultTableModel table_kembali = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN1.getModel();
            
                // reset table
                table_pinjam.setRowCount(0);
                table_pinjam.setRowCount(1);
                
                table_kembali.setRowCount(0);
                table_kembali.setRowCount(1);
                
                // hapus value input
                Dashboard.PJ_INPUT_ID_TRANSAKSI_PENGEMBALIAN.setText("");
                Dashboard.PJ_INPUT_PEMINJAM_PENGEMBALIAN.setText("");
                Dashboard.PJ_INPUT_JENIS_BUKU_PENGEMBALIAN.setSelectedIndex(0);
                Dashboard.PJ_INPUT_TGL_PINJAM_PENGEMBALIAN.setText("");
                Dashboard.PJ_INPUT_PENGURUS_PENGEMBALIAN.setText("");
            
        }

    }

}
