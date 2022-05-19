/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
import com.manurul.lib.GenKode;
import com.manurul.view.Dashboard;
import com.manurul.view.modal.getPeminjamTRANSAKSI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.Timer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caesarhome
 */

public class TransaksiModel extends DBConfig{
    
    private Connection conn = (Connection)DBConfig.getConnection();
   
    DefaultTableModel table_model = new DefaultTableModel();
    
    private String message;
    
    public void setMessage(String msg){
        this.message = msg;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public static void setDateNowTransaksi(){
    
        Dashboard.PJ_INPUT_ID_TRANSAKSI.setText(GenKode.Transaksi());
        
    }
    
    public void getDateRealTime(){
    
        Timer timer;
        
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              Dashboard.PJ_INPUT_TGL_PINJAM.setText(GenKode.TransaksiGetDate());
            }
        });
        
        timer.start();
    }
    
    public void setDataAnggota(String Keyword){
        // SET COLUMN TABLE
        table_model.setColumnCount(0);
        table_model.addColumn("NIS");
        table_model.addColumn("Nama");
        table_model.addColumn("Jurusan");
        table_model.addColumn("Skor");
        
        table_model.setRowCount(0);
        
        try{
        
            String sql = "SELECT nis, nama_lengkap, jurusan, skor FROM ma_anggota WHERE nis LIKE '%"+Keyword+"%' OR nama_lengkap LIKE '%"+Keyword+"%'";
            if(Keyword.equals("")){
                sql = "SELECT nis, nama_lengkap, jurusan, skor FROM ma_anggota ";
            }
            
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                table_model.addRow(new Object[]{
                    res.getString("nis"),
                    res.getString("nama_lengkap"),
                    res.getString("jurusan"),
                    res.getString("skor")
                });
            }
            
            getPeminjamTRANSAKSI.TABLE_LIST_PEMINJAM.setModel(table_model);
//            getPeminjamTRANSAKSI.TABLE_LIST_PEMINJAM.setColumnSelectionInterval(0, 0);
            
        }catch(SQLException error){
            System.out.println(error.getMessage());
        }
        
    }
}
