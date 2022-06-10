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
public class DashboardModel extends DBConfig {
    
    private Connection conn = (Connection)DBConfig.getConnection();
    
    public void getDashboardData(String limit){

        try{
            
            // GET TABLE MODEL AKTIFITAS
            DefaultTableModel table_aktifitas = (DefaultTableModel)Dashboard.TABLE_LIST_LOG.getModel();
            table_aktifitas.setRowCount(0);
            
            // SET DATA FOR VALUE PANEL
            String sql = "SELECT " +
                    "total_buku, " +
                    "buku_dipinjam, " +
                    "buku_bermasalah, " +
                    "total_anggota " +
                    "FROM " +
                    "ma_dashboard " +
                    "LIMIT 1";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            if(res.next()){
            
                Dashboard.VALUE_TOTAL_BUKU.setText(res.getString("total_buku"));
                Dashboard.VALUE_DIPINJAM.setText(res.getString("buku_dipinjam"));
                Dashboard.VALUE_BERMASALAH.setText(res.getString("buku_bermasalah"));
                Dashboard.VALUE_ANGGOTA.setText(res.getString("total_anggota"));
                
            }

            // SET DATA FOR TABLE
            String intLimit = " LIMIT " + limit;
            if(limit.equals("Semua")){
                intLimit = "";
            }
            String sql_aktifitas = "SELECT " +
                                    "process, " +
                                    "message, " +
                                    "pengurus, " +
                                    "created_at " +
                                    "FROM ma_log " +
                                    "ORDER BY created_at DESC " + intLimit;
            PreparedStatement pst_aktifitas = conn.prepareStatement(sql_aktifitas);
            ResultSet res_aktifitas = pst_aktifitas.executeQuery();
            while(res_aktifitas.next()){
            
                table_aktifitas.addRow(new String[]{
                    res_aktifitas.getString("process"),
                    res_aktifitas.getString("message"),
                    res_aktifitas.getString("pengurus"),
                    res_aktifitas.getString("created_at")
                });
                
            }
            
        }catch(SQLException error){
        
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }
    
}
