/*
 * LICENSE BY DKODE Creative
 */
package com.manurul.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DKODE Creative
 */
public class Dashboard extends javax.swing.JFrame {

    // INIT STATE
    private String title = "Dahsboard";
    
    private int id_user;
    private String nama_user;
    /**
     * INIT FORM DASHBOARD
     */
    public Dashboard(int id_user, String nama_user) {
        initComponents();
        
        // SET STATE
        this.id_user = id_user;
        this.nama_user = nama_user;
        
        // SET TITLE
        setTitleApp("Dashboard");
        
        // SET TOP BAR
        setTopBarApp();
        
        // SET ICON WINDOWS
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../src/LOGO_MANURUL.png")));
        
        // JFRAME FULL SCREEN
        this.setExtendedState(MAXIMIZED_BOTH);
        
        // SET CENTER LOCATION
        this.setLocationRelativeTo(null);
        
        // SET MINIMUN SIZE
        this.setMinimumSize(new Dimension(1366, 768));
        
        // DEFAULT SIDEBAR ICON SELECTED
        BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY.png")));
        BTN_TRANSAKSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_TRANSAKSI_NON.png")));
        BTN_DATABUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DATABUKU_NON.png")));
        BTN_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USER_NON.png")));
        BTN_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_SETTING_NON.png")));
        
        // KONFIRMASI KELUAR APP ( WINDOWS CLOSING )
//         this.addWindowListener(new java.awt.event.WindowAdapter() {
//            @Override
//            public void windowClosing(java.awt.event.WindowEvent e) {
//                int close = JOptionPane.showOptionDialog(null, "Apakah yakin kamu ingin keluar ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
//                if(close == 0){
//                    System.exit(0);
//                }
//            }
//        });
        
        
    }
    
    /*
        SET TITLE APP
    */
    private void setTitleApp(String title){
        this.title = title;
        this.setTitle("MA Nurul Islam Library Management - " + title);
    }
    
    /*
        SET TOP BAR APP
    */
    private void setTopBarApp(){
        USERNAME.setText(this.nama_user);
    }
    
    /*
        SET SIDE BAR APP
    */
    private void setSideBarApp(String menuSelected){
        
        // SET LAYOUT TO MAIN CONTENT
        MAIN_CONTENT.removeAll();
        
        if(menuSelected.equals("DASHBOARD")){
            
            MAIN_CONTENT.add(DASHBOARD);
            
            // SET ICON ACTIVE
            BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY.png")));
            BTN_TRANSAKSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_TRANSAKSI_NON.png")));
            BTN_DATABUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DATABUKU_NON.png")));
            BTN_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USER_NON.png")));
            BTN_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_SETTING_NON.png")));
            
        }else if(menuSelected.equals("TRANSAKSI")){
            
            MAIN_CONTENT.add(TRANSAKSI);
            
            // SET ICON ACTIVE
            BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY_NON.png")));
            BTN_TRANSAKSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_TRANSAKSI.png")));
            BTN_DATABUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DATABUKU_NON.png")));
            BTN_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USER_NON.png")));
            BTN_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_SETTING_NON.png")));
            
        }else if(menuSelected.equals("DATABUKU")){
            
            MAIN_CONTENT.add(DATABUKU);
            
            // SET ICON ACTIVE
            BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY_NON.png")));
            BTN_TRANSAKSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_TRANSAKSI_NON.png")));
            BTN_DATABUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DATABUKU.png")));
            BTN_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USER_NON.png")));
            BTN_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_SETTING_NON.png")));
            
        }else if(menuSelected.equals("USER")){
        
            MAIN_CONTENT.add(USER);
            
            // SET ICON ACTIVE
            BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY_NON.png")));
            BTN_TRANSAKSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_TRANSAKSI_NON.png")));
            BTN_DATABUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DATABUKU_NON.png")));
            BTN_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USER.png")));
            BTN_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_SETTING_NON.png")));
            
        }else if(menuSelected.equals("PENGATURAN")){
        
            MAIN_CONTENT.add(SETTING);
            
            // SET ICON ACTIVE
            BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY_NON.png")));
            BTN_TRANSAKSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_TRANSAKSI_NON.png")));
            BTN_DATABUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DATABUKU_NON.png")));
            BTN_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USER_NON.png")));
            BTN_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_SETTING.png")));
        
        }
        
        MAIN_CONTENT.repaint();
        MAIN_CONTENT.revalidate();
    }   
    
    /*
    ------------------------
        DASHBOARD
    ------------------------
    */
    
        // code
    
    /*
    ------------------------
    */
    
    /*
    ------------------------
        USERS
    ------------------------
    */
    
        // code
    
    /*
    ------------------------
    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SIDEBAR = new javax.swing.JPanel();
        MANURUL_LOGO = new javax.swing.JLabel();
        BTN_DASHBOARD = new javax.swing.JLabel();
        BTN_TRANSAKSI = new javax.swing.JLabel();
        BTN_DATABUKU = new javax.swing.JLabel();
        BTN_USER = new javax.swing.JLabel();
        BTN_SETTING = new javax.swing.JLabel();
        BTN_EXIT = new javax.swing.JLabel();
        MAIN_CONTENT = new javax.swing.JPanel();
        DASHBOARD = new javax.swing.JPanel();
        TOPBAR = new RoundedPanel(15, Color.WHITE);
        TITLE_DASHBOARD = new javax.swing.JLabel();
        USERNAME = new javax.swing.JLabel();
        ICON_USER = new javax.swing.JLabel();
        P_TOTAL_BUKU = new RoundedPanel(15, Color.WHITE);
        ICON_TOTAL_BUKU = new javax.swing.JLabel();
        TITLE_TOTAL_BUKU = new javax.swing.JLabel();
        VALUE_TOTAL_BUKU = new javax.swing.JLabel();
        P_DIPINJAM = new RoundedPanel(15, Color.WHITE);
        ICON_DIPINJAM = new javax.swing.JLabel();
        TITLE_DIPINJAM = new javax.swing.JLabel();
        VALUE_DIPINJAM = new javax.swing.JLabel();
        P_BERMASALAH = new RoundedPanel(15, Color.WHITE);
        ICON_BERMASALAH = new javax.swing.JLabel();
        VALUE_BERMASALAH = new javax.swing.JLabel();
        TITLE_BERMASALAH = new javax.swing.JLabel();
        P_ANGGOTA = new RoundedPanel(15, Color.WHITE);
        TITLE_ANGGOTA = new javax.swing.JLabel();
        VALUE_ANGGOTA = new javax.swing.JLabel();
        ICON_ANGGOTA = new javax.swing.JLabel();
        P_TABLE_LOG = new RoundedPanel(15, Color.WHITE);
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TRANSAKSI = new javax.swing.JPanel();
        jPanel1 = new RoundedPanel(15, Color.WHITE);
        DATABUKU = new javax.swing.JPanel();
        USER = new javax.swing.JPanel();
        SETTING = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SIDEBAR.setBackground(new java.awt.Color(255, 255, 255));

        MANURUL_LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/LOGO_MANURUL_SIDEBAR.png"))); // NOI18N

        BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY_NON.png"))); // NOI18N
        BTN_DASHBOARD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_DASHBOARD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_DASHBOARDMouseClicked(evt);
            }
        });

        BTN_TRANSAKSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_TRANSAKSI_NON.png"))); // NOI18N
        BTN_TRANSAKSI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_TRANSAKSI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_TRANSAKSIMouseClicked(evt);
            }
        });

        BTN_DATABUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DATABUKU_NON.png"))); // NOI18N
        BTN_DATABUKU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_DATABUKU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_DATABUKUMouseClicked(evt);
            }
        });

        BTN_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USER_NON.png"))); // NOI18N
        BTN_USER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_USER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_USERMouseClicked(evt);
            }
        });

        BTN_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_SETTING_NON.png"))); // NOI18N
        BTN_SETTING.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_SETTING.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_SETTINGMouseClicked(evt);
            }
        });

        BTN_EXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_EXIT.png"))); // NOI18N
        BTN_EXIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_EXIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_EXITMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout SIDEBARLayout = new javax.swing.GroupLayout(SIDEBAR);
        SIDEBAR.setLayout(SIDEBARLayout);
        SIDEBARLayout.setHorizontalGroup(
            SIDEBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SIDEBARLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(SIDEBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MANURUL_LOGO)
                    .addGroup(SIDEBARLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(SIDEBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BTN_TRANSAKSI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_DASHBOARD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_DATABUKU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_SETTING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_EXIT))
                        .addGap(12, 12, 12)))
                .addGap(19, 19, 19))
        );
        SIDEBARLayout.setVerticalGroup(
            SIDEBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SIDEBARLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MANURUL_LOGO)
                .addGap(46, 46, 46)
                .addComponent(BTN_DASHBOARD)
                .addGap(46, 46, 46)
                .addComponent(BTN_TRANSAKSI)
                .addGap(46, 46, 46)
                .addComponent(BTN_DATABUKU)
                .addGap(46, 46, 46)
                .addComponent(BTN_USER)
                .addGap(46, 46, 46)
                .addComponent(BTN_SETTING)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_EXIT)
                .addGap(46, 46, 46))
        );

        MAIN_CONTENT.setBackground(new java.awt.Color(239, 240, 245));
        MAIN_CONTENT.setLayout(new java.awt.CardLayout());

        DASHBOARD.setBackground(new java.awt.Color(239, 240, 245));

        TOPBAR.setBackground(new java.awt.Color(239, 240, 245));
        TOPBAR.setPreferredSize(new java.awt.Dimension(353, 70));

        TITLE_DASHBOARD.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        TITLE_DASHBOARD.setForeground(new java.awt.Color(78, 204, 121));
        TITLE_DASHBOARD.setText("Dashboard");

        USERNAME.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        USERNAME.setForeground(new java.awt.Color(96, 96, 96));
        USERNAME.setText("USERNAME");

        ICON_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AKUN_CIRCLE.png"))); // NOI18N

        javax.swing.GroupLayout TOPBARLayout = new javax.swing.GroupLayout(TOPBAR);
        TOPBAR.setLayout(TOPBARLayout);
        TOPBARLayout.setHorizontalGroup(
            TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TOPBARLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(TITLE_DASHBOARD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(USERNAME)
                .addGap(18, 18, 18)
                .addComponent(ICON_USER)
                .addGap(27, 27, 27))
        );
        TOPBARLayout.setVerticalGroup(
            TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TOPBARLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TITLE_DASHBOARD)
                    .addComponent(USERNAME))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(TOPBARLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ICON_USER, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        P_TOTAL_BUKU.setBackground(new java.awt.Color(239, 240, 245));
        P_TOTAL_BUKU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P_TOTAL_BUKU.setPreferredSize(new java.awt.Dimension(290, 143));

        ICON_TOTAL_BUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_BOOK.png"))); // NOI18N

        TITLE_TOTAL_BUKU.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        TITLE_TOTAL_BUKU.setForeground(new java.awt.Color(204, 204, 204));
        TITLE_TOTAL_BUKU.setText("Total Buku");

        VALUE_TOTAL_BUKU.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        VALUE_TOTAL_BUKU.setForeground(new java.awt.Color(96, 96, 96));
        VALUE_TOTAL_BUKU.setText("14578");

        javax.swing.GroupLayout P_TOTAL_BUKULayout = new javax.swing.GroupLayout(P_TOTAL_BUKU);
        P_TOTAL_BUKU.setLayout(P_TOTAL_BUKULayout);
        P_TOTAL_BUKULayout.setHorizontalGroup(
            P_TOTAL_BUKULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_TOTAL_BUKULayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(ICON_TOTAL_BUKU)
                .addGap(18, 18, 18)
                .addGroup(P_TOTAL_BUKULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TITLE_TOTAL_BUKU)
                    .addComponent(VALUE_TOTAL_BUKU))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        P_TOTAL_BUKULayout.setVerticalGroup(
            P_TOTAL_BUKULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_TOTAL_BUKULayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(P_TOTAL_BUKULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(P_TOTAL_BUKULayout.createSequentialGroup()
                        .addComponent(TITLE_TOTAL_BUKU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VALUE_TOTAL_BUKU)
                        .addGap(5, 5, 5))
                    .addComponent(ICON_TOTAL_BUKU))
                .addGap(34, 34, 34))
        );

        P_DIPINJAM.setBackground(new java.awt.Color(239, 240, 245));
        P_DIPINJAM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P_DIPINJAM.setPreferredSize(new java.awt.Dimension(290, 143));

        ICON_DIPINJAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DIPINJAM.png"))); // NOI18N

        TITLE_DIPINJAM.setBackground(new java.awt.Color(204, 204, 204));
        TITLE_DIPINJAM.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        TITLE_DIPINJAM.setForeground(new java.awt.Color(204, 204, 204));
        TITLE_DIPINJAM.setText("Dipinjam");

        VALUE_DIPINJAM.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        VALUE_DIPINJAM.setForeground(new java.awt.Color(96, 96, 96));
        VALUE_DIPINJAM.setText("1256");

        javax.swing.GroupLayout P_DIPINJAMLayout = new javax.swing.GroupLayout(P_DIPINJAM);
        P_DIPINJAM.setLayout(P_DIPINJAMLayout);
        P_DIPINJAMLayout.setHorizontalGroup(
            P_DIPINJAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_DIPINJAMLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(ICON_DIPINJAM)
                .addGap(18, 18, 18)
                .addGroup(P_DIPINJAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TITLE_DIPINJAM)
                    .addComponent(VALUE_DIPINJAM))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        P_DIPINJAMLayout.setVerticalGroup(
            P_DIPINJAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P_DIPINJAMLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(P_DIPINJAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_DIPINJAMLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(TITLE_DIPINJAM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VALUE_DIPINJAM))
                    .addComponent(ICON_DIPINJAM))
                .addGap(34, 34, 34))
        );

        P_BERMASALAH.setBackground(new java.awt.Color(239, 240, 245));
        P_BERMASALAH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P_BERMASALAH.setPreferredSize(new java.awt.Dimension(290, 143));

        ICON_BERMASALAH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_BERMASALAH.png"))); // NOI18N

        VALUE_BERMASALAH.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        VALUE_BERMASALAH.setForeground(new java.awt.Color(96, 96, 96));
        VALUE_BERMASALAH.setText("25");

        TITLE_BERMASALAH.setBackground(new java.awt.Color(204, 204, 204));
        TITLE_BERMASALAH.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        TITLE_BERMASALAH.setForeground(new java.awt.Color(204, 204, 204));
        TITLE_BERMASALAH.setText("Bermasalah");

        javax.swing.GroupLayout P_BERMASALAHLayout = new javax.swing.GroupLayout(P_BERMASALAH);
        P_BERMASALAH.setLayout(P_BERMASALAHLayout);
        P_BERMASALAHLayout.setHorizontalGroup(
            P_BERMASALAHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_BERMASALAHLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(ICON_BERMASALAH)
                .addGap(18, 18, 18)
                .addGroup(P_BERMASALAHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TITLE_BERMASALAH)
                    .addComponent(VALUE_BERMASALAH))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        P_BERMASALAHLayout.setVerticalGroup(
            P_BERMASALAHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P_BERMASALAHLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(P_BERMASALAHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_BERMASALAHLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(TITLE_BERMASALAH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VALUE_BERMASALAH))
                    .addComponent(ICON_BERMASALAH))
                .addContainerGap())
        );

        P_ANGGOTA.setBackground(new java.awt.Color(239, 240, 245));
        P_ANGGOTA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P_ANGGOTA.setPreferredSize(new java.awt.Dimension(290, 143));

        TITLE_ANGGOTA.setBackground(new java.awt.Color(204, 204, 204));
        TITLE_ANGGOTA.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        TITLE_ANGGOTA.setForeground(new java.awt.Color(204, 204, 204));
        TITLE_ANGGOTA.setText("Anggota");

        VALUE_ANGGOTA.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        VALUE_ANGGOTA.setForeground(new java.awt.Color(96, 96, 96));
        VALUE_ANGGOTA.setText("2450");

        ICON_ANGGOTA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USERS.png"))); // NOI18N

        javax.swing.GroupLayout P_ANGGOTALayout = new javax.swing.GroupLayout(P_ANGGOTA);
        P_ANGGOTA.setLayout(P_ANGGOTALayout);
        P_ANGGOTALayout.setHorizontalGroup(
            P_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P_ANGGOTALayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(ICON_ANGGOTA)
                .addGap(18, 18, 18)
                .addGroup(P_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TITLE_ANGGOTA)
                    .addComponent(VALUE_ANGGOTA))
                .addGap(54, 54, 54))
        );
        P_ANGGOTALayout.setVerticalGroup(
            P_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_ANGGOTALayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(P_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_ANGGOTALayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(TITLE_ANGGOTA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VALUE_ANGGOTA))
                    .addComponent(ICON_ANGGOTA))
                .addGap(34, 34, 34))
        );

        P_TABLE_LOG.setBackground(new java.awt.Color(239, 240, 245));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(96, 96, 96));
        jLabel2.setText("Transaksi Terbaru");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Tampilkan");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout P_TABLE_LOGLayout = new javax.swing.GroupLayout(P_TABLE_LOG);
        P_TABLE_LOG.setLayout(P_TABLE_LOGLayout);
        P_TABLE_LOGLayout.setHorizontalGroup(
            P_TABLE_LOGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_TABLE_LOGLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(P_TABLE_LOGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(P_TABLE_LOGLayout.createSequentialGroup()
                        .addGroup(P_TABLE_LOGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
        );
        P_TABLE_LOGLayout.setVerticalGroup(
            P_TABLE_LOGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_TABLE_LOGLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DASHBOARDLayout = new javax.swing.GroupLayout(DASHBOARD);
        DASHBOARD.setLayout(DASHBOARDLayout);
        DASHBOARDLayout.setHorizontalGroup(
            DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DASHBOARDLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(P_TABLE_LOG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DASHBOARDLayout.createSequentialGroup()
                        .addComponent(P_TOTAL_BUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(P_DIPINJAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(P_BERMASALAH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(P_ANGGOTA, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                    .addComponent(TOPBAR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        DASHBOARDLayout.setVerticalGroup(
            DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DASHBOARDLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TOPBAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(P_ANGGOTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P_DIPINJAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P_BERMASALAH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P_TOTAL_BUKU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(P_TABLE_LOG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        MAIN_CONTENT.add(DASHBOARD, "card2");

        TRANSAKSI.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1238, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout TRANSAKSILayout = new javax.swing.GroupLayout(TRANSAKSI);
        TRANSAKSI.setLayout(TRANSAKSILayout);
        TRANSAKSILayout.setHorizontalGroup(
            TRANSAKSILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TRANSAKSILayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        TRANSAKSILayout.setVerticalGroup(
            TRANSAKSILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TRANSAKSILayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(678, Short.MAX_VALUE))
        );

        MAIN_CONTENT.add(TRANSAKSI, "card3");

        DATABUKU.setBackground(new java.awt.Color(239, 240, 245));

        javax.swing.GroupLayout DATABUKULayout = new javax.swing.GroupLayout(DATABUKU);
        DATABUKU.setLayout(DATABUKULayout);
        DATABUKULayout.setHorizontalGroup(
            DATABUKULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1278, Short.MAX_VALUE)
        );
        DATABUKULayout.setVerticalGroup(
            DATABUKULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        MAIN_CONTENT.add(DATABUKU, "card4");

        USER.setBackground(new java.awt.Color(239, 240, 245));

        javax.swing.GroupLayout USERLayout = new javax.swing.GroupLayout(USER);
        USER.setLayout(USERLayout);
        USERLayout.setHorizontalGroup(
            USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1278, Short.MAX_VALUE)
        );
        USERLayout.setVerticalGroup(
            USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        MAIN_CONTENT.add(USER, "card5");

        SETTING.setBackground(new java.awt.Color(239, 240, 245));

        javax.swing.GroupLayout SETTINGLayout = new javax.swing.GroupLayout(SETTING);
        SETTING.setLayout(SETTINGLayout);
        SETTINGLayout.setHorizontalGroup(
            SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1278, Short.MAX_VALUE)
        );
        SETTINGLayout.setVerticalGroup(
            SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        MAIN_CONTENT.add(SETTING, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SIDEBAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MAIN_CONTENT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SIDEBAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MAIN_CONTENT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_DASHBOARDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_DASHBOARDMouseClicked
        // SET TITLE
        setTitleApp("Dashboard");
        
        // TAMPILKAN LAYOUT DASHBOARD
        setSideBarApp("DASHBOARD");
        
    }//GEN-LAST:event_BTN_DASHBOARDMouseClicked

    private void BTN_TRANSAKSIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_TRANSAKSIMouseClicked
        // UBAH TITLE
        setTitleApp("Transaksi");
        
        // TAMPILKAN LAYOUT TRANSAKSI
        setSideBarApp("TRANSAKSI");
        
    }//GEN-LAST:event_BTN_TRANSAKSIMouseClicked

    private void BTN_DATABUKUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_DATABUKUMouseClicked
        // UBAH TITLE
        setTitleApp("Data Buku");
        
        // TAMPILKAN LAYOUT DATA BUKU
        setSideBarApp("DATABUKU");
    }//GEN-LAST:event_BTN_DATABUKUMouseClicked

    private void BTN_USERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_USERMouseClicked
        // UBAH TITLE
        setTitleApp("User");
        
        // TAMPILKAN LAYOUT USER
        setSideBarApp("USER");
    }//GEN-LAST:event_BTN_USERMouseClicked

    private void BTN_SETTINGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_SETTINGMouseClicked
        // UBAH TITLE
        setTitleApp("Pengaturan");
        
        // TAMPILKAN LAYOUT SETTING
        setSideBarApp("PENGATURAN");
    }//GEN-LAST:event_BTN_SETTINGMouseClicked

    private void BTN_EXITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_EXITMouseClicked
        // CLOSE APLIKASI
        int close = JOptionPane.showConfirmDialog(this, "Apakah yakin kamu ingin keluar ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if(close == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_BTN_EXITMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(0, "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BTN_DASHBOARD;
    private javax.swing.JLabel BTN_DATABUKU;
    private javax.swing.JLabel BTN_EXIT;
    private javax.swing.JLabel BTN_SETTING;
    private javax.swing.JLabel BTN_TRANSAKSI;
    private javax.swing.JLabel BTN_USER;
    private javax.swing.JPanel DASHBOARD;
    private javax.swing.JPanel DATABUKU;
    private javax.swing.JLabel ICON_ANGGOTA;
    private javax.swing.JLabel ICON_BERMASALAH;
    private javax.swing.JLabel ICON_DIPINJAM;
    private javax.swing.JLabel ICON_TOTAL_BUKU;
    private javax.swing.JLabel ICON_USER;
    private javax.swing.JPanel MAIN_CONTENT;
    private javax.swing.JLabel MANURUL_LOGO;
    private javax.swing.JPanel P_ANGGOTA;
    private javax.swing.JPanel P_BERMASALAH;
    private javax.swing.JPanel P_DIPINJAM;
    private javax.swing.JPanel P_TABLE_LOG;
    private javax.swing.JPanel P_TOTAL_BUKU;
    private javax.swing.JPanel SETTING;
    private javax.swing.JPanel SIDEBAR;
    private javax.swing.JLabel TITLE_ANGGOTA;
    private javax.swing.JLabel TITLE_BERMASALAH;
    private javax.swing.JLabel TITLE_DASHBOARD;
    private javax.swing.JLabel TITLE_DIPINJAM;
    private javax.swing.JLabel TITLE_TOTAL_BUKU;
    private javax.swing.JPanel TOPBAR;
    private javax.swing.JPanel TRANSAKSI;
    private javax.swing.JPanel USER;
    private javax.swing.JLabel USERNAME;
    private javax.swing.JLabel VALUE_ANGGOTA;
    private javax.swing.JLabel VALUE_BERMASALAH;
    private javax.swing.JLabel VALUE_DIPINJAM;
    private javax.swing.JLabel VALUE_TOTAL_BUKU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    // OVERRIDE ROUNDED PANEL
    class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;
        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }
        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
            
        }
        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
            graphics.setColor(getForeground());           
        }
    }
}
