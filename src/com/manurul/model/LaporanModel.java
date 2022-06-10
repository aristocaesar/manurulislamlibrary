/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
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
public class LaporanModel extends DBConfig {
    
    private Connection coon = (Connection)DBConfig.getConnection();
    
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
            
            PreparedStatement pst = coon.prepareStatement(sql);
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
    
}
