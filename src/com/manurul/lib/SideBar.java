/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.lib;

import com.manurul.model.BukuModel;
import com.manurul.view.Dashboard;
import java.awt.Color;

/**
 *
 * @author caesarhome
 */
public class SideBar {
    
    public  void setBar(String Bar){
        
        Dashboard.MAIN_FRAME.removeAll();

        Dashboard.BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY_NON.png")));
        Dashboard.BTN_TRANSAKSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_TRANSAKSI_NON.png")));
        Dashboard.BTN_DATABUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DATABUKU_NON.png")));
        Dashboard.BTN_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USER_NON.png")));
        Dashboard.BTN_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_SETTING_NON.png")));
        
        if(Bar.equals("DASHBOARD")){
            
            Dashboard.BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY.png")));
            
            Dashboard.MAIN_FRAME.add(Dashboard.DASHBOARD);
        
        }else if (Bar.equals("TRANSAKSI")) {
            
            Dashboard.USERNAME_TRANSAKSI.setText(Dashboard.nama_user);
            
            Dashboard.BTN_TRANSAKSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_TRANSAKSI.png")));
        
            Dashboard.MAIN_FRAME.add(Dashboard.TRANSAKSI);
            
            setTransaksiPageSelected(Bar);
            
        }else if (Bar.equals("DATABUKU")) {
            
            Dashboard.USERNAME_DATABUKU.setText(Dashboard.nama_user);
            
            Dashboard.BTN_DATABUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DATABUKU.png")));   
     
            Dashboard.MAIN_FRAME.add(Dashboard.DATABUKU);
            
            new BukuModel().setDataTable(Dashboard.SEARCH_BUKU.getText(), Dashboard.KATEGORI_COMBOBOX_BUKU.getSelectedItem().toString(), Dashboard.TAMPILKAN_COMBOBOX_BUKU.getSelectedItem().toString());
            
        }else if (Bar.equals("USER")){
            
            Dashboard.USERNAME_USER.setText(Dashboard.nama_user);
            
            Dashboard.BTN_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USER.png")));     
        
            Dashboard.MAIN_FRAME.add(Dashboard.USER);
        
        }else if (Bar.equals("PENGATURAN")){
            
            Dashboard.USERNAME_SETTING.setText(Dashboard.nama_user);
            
            Dashboard.BTN_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_SETTING.png")));
        
            Dashboard.MAIN_FRAME.add(Dashboard.SETTING);
        
        }else{
            
            Dashboard.BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY.png")));        
        
            Dashboard.MAIN_FRAME.add(Dashboard.DASHBOARD);
        
        }
        
        Dashboard.MAIN_FRAME.repaint();
        Dashboard.MAIN_FRAME.revalidate();
        
        
    }
    
    
    // TRANSAKSI
    
    public void setTransaksiPageSelected(String selected){
            
            Dashboard.FRAME_TRANSAKSI.removeAll();
            
            Dashboard.T_TR_PINJAM.setForeground(new Color(96, 96, 96));
            Dashboard.T_TR_KEMBALI.setForeground(new Color(96, 96, 96));
            Dashboard.T_TR_LAPORAN.setForeground(new Color(96, 96, 96));
            
            if(selected.equals("PINJAM")){
                
                Dashboard.FRAME_TRANSAKSI.add(Dashboard.F_TR_PINJAM);
                
                Dashboard.T_TR_PINJAM.setForeground(new Color(78, 204, 121));
                
            }else if(selected.equals("KEMBALI")){
            
                Dashboard.FRAME_TRANSAKSI.add(Dashboard.F_TR_KEMBALI);
                
                Dashboard.T_TR_KEMBALI.setForeground(new Color(78, 204, 121));
                
            }else{
            
                Dashboard.FRAME_TRANSAKSI.add(Dashboard.F_TR_LAPORAN);
                
                Dashboard.T_TR_LAPORAN.setForeground(new Color(78, 204, 121));
                
            }
            
            Dashboard.FRAME_TRANSAKSI.repaint();
            Dashboard.FRAME_TRANSAKSI.revalidate();
        
        }
    
    // BUKU
    
    public void setBukuPageSelected(String selected){
            
            Dashboard.FRAME_DATABUKU.removeAll();
            
            Dashboard.T_DB_BUKU.setForeground(new Color(96, 96, 96));
            Dashboard.T_DB_KATEGORI.setForeground(new Color(96, 96, 96));
            Dashboard.T_DB_PENERBIT.setForeground(new Color(96, 96, 96));
            Dashboard.T_DB_RAK.setForeground(new Color(96, 96, 96));
            
            if(selected.equals("BUKU")){
                
                Dashboard.FRAME_DATABUKU.add(Dashboard.F_DB_BUKU);
                
                Dashboard.T_DB_BUKU.setForeground(new Color(78, 204, 121));
                
                new BukuModel().setDataTable(Dashboard.SEARCH_BUKU.getText(), Dashboard.KATEGORI_COMBOBOX_BUKU.getSelectedItem().toString(), Dashboard.TAMPILKAN_COMBOBOX_BUKU.getSelectedItem().toString());
            
            }else if(selected.equals("KATEGORI")){
            
                Dashboard.FRAME_DATABUKU.add(Dashboard.F_DB_KATEGORI);
                
                
                Dashboard.T_DB_KATEGORI.setForeground(new Color(78, 204, 121));
                
            }else if(selected.equals("PENERBIT")){
            
                Dashboard.FRAME_DATABUKU.add(Dashboard.F_DB_PENERBIT);
                
                Dashboard.T_DB_PENERBIT.setForeground(new Color(78, 204, 121));
                
            }else{
                
                Dashboard.FRAME_DATABUKU.add(Dashboard.F_DB_RAK);
                
                Dashboard.T_DB_RAK.setForeground(new Color(78, 204, 121));
                
            }
            
            Dashboard.FRAME_DATABUKU.repaint();
            Dashboard.FRAME_DATABUKU.revalidate();
        
    }
    
    public void setUserPageSelected(String selected){
        
//            new AnggotaModel().getDataTable("", "Semua", 25);
            
            Dashboard.FRAME_USER.removeAll();
            
            Dashboard.T_U_ANGGOTA.setForeground(new Color(96, 96, 96));
            Dashboard.T_U_JURUSAN.setForeground(new Color(96, 96, 96));
            Dashboard.T_U_PENGURUS.setForeground(new Color(96, 96, 96));
            
            if(selected.equals("ANGGOTA")){
            
                Dashboard.FRAME_USER.add(Dashboard.F_U_ANGGOTA);
                
                Dashboard.T_U_ANGGOTA.setForeground(new Color(78, 204, 121));
                
                
            }else if(selected.equals("JURUSAN")){
                
                Dashboard.FRAME_USER.add(Dashboard.F_U_JURUSAN);
                
                
                Dashboard.T_U_JURUSAN.setForeground(new Color(78, 204, 121));
            
            }else {
                
                Dashboard.FRAME_USER.add(Dashboard.F_U_PENGURUS);
                
                Dashboard.T_U_PENGURUS.setForeground(new Color(78, 204, 121));
            
            }
            
            Dashboard.FRAME_USER.repaint();
            Dashboard.FRAME_USER.revalidate();
            
    }
}
