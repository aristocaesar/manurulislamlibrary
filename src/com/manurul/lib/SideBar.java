/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.lib;

import com.manurul.view.Dashboard;

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
            
            
            Dashboard.BTN_TRANSAKSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_TRANSAKSI.png")));
        
            Dashboard.MAIN_FRAME.add(Dashboard.TRANSAKSI);
            
        }else if (Bar.equals("DATABUKU")) {
            
            Dashboard.BTN_DATABUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DATABUKU.png")));   
     
            Dashboard.MAIN_FRAME.add(Dashboard.DATABUKU);
            
        }else if (Bar.equals("USER")){
            
            Dashboard.BTN_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USER.png")));     
        
            Dashboard.MAIN_FRAME.add(Dashboard.USER);
        
        }else if (Bar.equals("PENGATURAN")){
            
            Dashboard.BTN_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_SETTING.png")));
        
            Dashboard.MAIN_FRAME.add(Dashboard.SETTING);
        
        }else{
            
            Dashboard.BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY.png")));        
        
            Dashboard.MAIN_FRAME.add(Dashboard.DASHBOARD);
        
        }
        
        Dashboard.MAIN_FRAME.repaint();
        Dashboard.MAIN_FRAME.revalidate();
        
        
    }
    
}
