/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.barcodelib.barcode.Linear;
import com.manurul.lib.DBConfig;
import com.manurul.lib.SqlTime;
import com.manurul.view.Dashboard;
import com.manurul.view.modal.DetailLaporanTransaksi;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author caesarhome
 */
public class LaporanModel extends DBConfig {
    
    private Connection conn = (Connection)DBConfig.getConnection();
    private String id_tr;
    
    public void getLaporanTransaksi(String id_transaksi, String limit){
        try{
            
            DefaultTableModel table_transaksi = (DefaultTableModel)Dashboard.TABLE_LAPORAN_TRANSAKSI.getModel();
            
            table_transaksi.setRowCount(0);
        
            String sql  = "SELECT " +
                            "ma_transaksi.id_transaksi AS id_transaksi, " +
                            "ma_anggota.nama_lengkap AS nama_lengkap, " +
                            "(SELECT COUNT(ma_detail_transaksi.id_transaksi) FROM ma_detail_transaksi WHERE id_transaksi = ma_transaksi.id_transaksi) AS jumlah_buku, " +
                            "ma_transaksi.status_transaksi AS status " +
                            "FROM ma_transaksi " +
                            "JOIN ma_anggota " +
                            "ON ma_transaksi.nis_anggota = ma_anggota.nis " +
                            "JOIN ma_detail_transaksi " +
                            "ON ma_transaksi.id_transaksi = ma_detail_transaksi.id_transaksi " +
                            "WHERE ma_transaksi.id_transaksi LIKE '%"+id_transaksi+"%' " +
                            "GROUP BY id_transaksi ";
            
            if(!limit.equals("Semua")){
                sql  = "SELECT " +
                            "ma_transaksi.id_transaksi AS id_transaksi, " +
                            "ma_anggota.nama_lengkap AS nama_lengkap, " +
                            "(SELECT COUNT(ma_detail_transaksi.id_transaksi) FROM ma_detail_transaksi WHERE id_transaksi = ma_transaksi.id_transaksi) AS jumlah_buku, " +
                            "ma_transaksi.status_transaksi AS status " +
                            "FROM ma_transaksi " +
                            "JOIN ma_anggota " +
                            "ON ma_transaksi.nis_anggota = ma_anggota.nis " +
                            "JOIN ma_detail_transaksi " +
                            "ON ma_transaksi.id_transaksi = ma_detail_transaksi.id_transaksi " +
                            "WHERE ma_transaksi.id_transaksi LIKE '%"+id_transaksi+"%' " +
                            "GROUP BY id_transaksi " +
                            "LIMIT " + limit + "";
            }
            
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            while(res.next()){

                table_transaksi.addRow(new String[]{
                    res.getString("id_transaksi"),
                    res.getString("nama_lengkap"),
                    res.getString("jumlah_buku"),
                    res.getString("status")
                });
                
            }
            
        }catch(SQLException error){
        
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
        
        }
        
    
    }
    
    public void getDetailLaporanTransaksi(String id_transaksi){
    
        this.id_tr = id_transaksi;
        
        try{
        
            String sql = "SELECT " +
                            "ma_transaksi.id_transaksi AS id_transaksi, " +
                            "ma_transaksi.nis_anggota AS nis, " +
                            "ma_anggota.nama_lengkap AS nama, " +
                            "ma_anggota.jurusan AS jurusan, " +
                            "ma_transaksi.kode_pengurus AS pengurus, " +
                            "ma_transaksi.status_transaksi AS status, " +
                            "DATE_FORMAT(ma_transaksi.created_at, '%d/%m/%Y') AS tgl_dicetak, " +
                            "DATE_FORMAT(ma_transaksi.updated_at, '%d/%m/%Y') AS tgl_diperbarui " +
                            "FROM ma_transaksi JOIN ma_anggota " +
                            "ON ma_transaksi.nis_anggota = ma_anggota.nis " +
                            "WHERE ma_transaksi.id_transaksi = ?";
        
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id_transaksi);
            ResultSet res = pst.executeQuery();
            if(res.next()){
                
                DetailLaporanTransaksi.ID_TRANSAKSI.setText("#" + res.getString("id_transaksi") + " - [" + res.getString("status") + "]");
                DetailLaporanTransaksi.INPUT_PEMINJAM.setText(res.getString("nis") + " - " + res.getString("nama") + " - " + res.getString("jurusan"));
                DetailLaporanTransaksi.INPUT_PENGURUS.setText(res.getString("pengurus"));
                DetailLaporanTransaksi.INPUT_TGL_DICETAK.setText(res.getString("tgl_dicetak"));
                DetailLaporanTransaksi.INPUT_TGL_DIPERBARUI.setText(res.getString("tgl_diperbarui"));
                
                DefaultTableModel table_pinjam = (DefaultTableModel)DetailLaporanTransaksi.TABLES_LIST_BUKU.getModel();
                table_pinjam.setRowCount(0);
                
                String sql_detail = "SELECT " +
                                        "ma_buku.judul AS judul, " +
                                        "ma_detail_transaksi.status_buku AS status " +
                                        "FROM ma_buku JOIN ma_detail_transaksi " +
                                        "ON ma_buku.isbn = ma_detail_transaksi.isbn " +
                                        "WHERE ma_detail_transaksi.id_transaksi = ?";
                PreparedStatement pst_detail = conn.prepareStatement(sql_detail);
                pst_detail.setString(1, res.getString("id_transaksi"));
                ResultSet res_detail = pst_detail.executeQuery();
                while(res_detail.next()){
                    
                    table_pinjam.addRow(new String[]{
                        res_detail.getString("judul"),
                        res_detail.getString("status")
                    });
                
                }
            
            }
            
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }
    
    public void cetakDetailTransaksi() throws JRException{
    
        try{
        
            String barcodePath = null;
            File filePath = new File("src/com/manurul/report/barcode/"+this.id_tr+".png");
            
            // buat barcode 
            try{

                Linear barcode = new Linear();
                barcode.setType(Linear.CODE128B);
                barcode.setData(this.id_tr);
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
            hash.put("id_transaksi", this.id_tr);
            
            String[] nama = DetailLaporanTransaksi.INPUT_PENGURUS.getText().split("-");
            
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
            
            //
            
            // cetak log
            new LogModel().Action("MENCETAK LAPORAN TRANSAKSI", "Berhasil mencetak laporan Transaksi " + this.id_tr, Dashboard.nama_user);
            
            
        }catch(SQLException error){
        
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }
    
}
