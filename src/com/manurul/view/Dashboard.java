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
        USERNAME.setText(nama_user);
        
        // SET ICON WINDOWS
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../src/LOGO_MANURUL.png")));
        
        // JFRAME FULL SCREEN
        this.setExtendedState(MAXIMIZED_BOTH);
        
        // SET CENTER LOCATION
        this.setLocationRelativeTo(null);
        
        // SET MINIMUN SIZE
//        this.setMinimumSize(new Dimension(1366, 768));
        
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
            
            // SET TOP BAR
            USERNAME_USER.setText(this.nama_user);
            
            // SET ICON ACTIVE
            BTN_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AIRPLAY_NON.png")));
            BTN_TRANSAKSI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_TRANSAKSI_NON.png")));
            BTN_DATABUKU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_DATABUKU_NON.png")));
            BTN_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_USER.png")));
            BTN_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_SETTING_NON.png")));
            
        }else if(menuSelected.equals("PENGATURAN")){
        
            // SHOW PAGE SETTING
            MAIN_CONTENT.add(SETTING);
            
            // SET TOP BAR
            USERNAME_SETTING.setText(this.nama_user);
            
            // SET INPUT BORDER
            
            
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
    
        public void setUserPageSelected(String selected){
            
            FRAME_MAIN_USER.removeAll();
            
            if(selected.equals("ANGGOTA")){
            
                FRAME_MAIN_USER.add(F_U_ANGGOTA);
                
                T_U_ANGGOTA.setForeground(new Color(78, 204, 121));
                T_U_JURUSAN.setForeground(new Color(96, 96, 96));
                T_U_KELAS.setForeground(new Color(96, 96, 96));
                T_U_PENGURUS.setForeground(new Color(96, 96, 96));
                
            }else if(selected.equals("JURUSAN")){
                
                FRAME_MAIN_USER.add(F_U_JURUSAN);
                
                T_U_ANGGOTA.setForeground(new Color(96, 96, 96));
                T_U_JURUSAN.setForeground(new Color(78, 204, 121));
                T_U_KELAS.setForeground(new Color(96, 96, 96));
                T_U_PENGURUS.setForeground(new Color(96, 96, 96));
            
            }else if(selected.equals("KELAS")) {
                
                FRAME_MAIN_USER.add(F_U_KELAS);
            
                T_U_ANGGOTA.setForeground(new Color(96, 96, 96));
                T_U_JURUSAN.setForeground(new Color(96, 96, 96));
                T_U_KELAS.setForeground(new Color(78, 204, 121));
                T_U_PENGURUS.setForeground(new Color(96, 96, 96));
                
            } else {
                
                FRAME_MAIN_USER.add(F_U_PENGURUS);
                
                T_U_ANGGOTA.setForeground(new Color(96, 96, 96));
                T_U_JURUSAN.setForeground(new Color(96, 96, 96));
                T_U_KELAS.setForeground(new Color(96, 96, 96));
                T_U_PENGURUS.setForeground(new Color(78, 204, 121));
            
            }
            
            FRAME_MAIN_USER.repaint();
            FRAME_MAIN_USER.revalidate();
            
        }
    
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
        TOPBAR_USER = new RoundedPanel(15, Color.WHITE);
        T_U_ANGGOTA = new javax.swing.JLabel();
        T_U_JURUSAN = new javax.swing.JLabel();
        T_U_KELAS = new javax.swing.JLabel();
        T_U_PENGURUS = new javax.swing.JLabel();
        USERNAME_USER = new javax.swing.JLabel();
        ICON_U_USER = new javax.swing.JLabel();
        FRAME_MAIN_USER = new javax.swing.JPanel();
        F_U_ANGGOTA = new RoundedPanel(15, Color.WHITE);
        TITLE_FRAME_USER = new javax.swing.JLabel();
        ICON_EXPORT_USER = new javax.swing.JLabel();
        ICON_IMPORT_USER = new javax.swing.JLabel();
        ICON_ADD_USER = new javax.swing.JLabel();
        SEARCH_USER = new javax.swing.JTextField();
        TABLE_LIST_U_ANGGOTA = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        TAMPILKAN = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        F_U_JURUSAN = new javax.swing.JPanel();
        F_U_KELAS = new javax.swing.JPanel();
        F_U_PENGURUS = new javax.swing.JPanel();
        SETTING = new javax.swing.JPanel();
        TOPBAR_SETTING = new RoundedPanel(15, Color.WHITE);
        TITLE_SETTING = new javax.swing.JLabel();
        USERNAME_SETTING = new javax.swing.JLabel();
        ICON_SETTING = new javax.swing.JLabel();
        FRAME_MAIN_SETTING = new RoundedPanel(15, Color.WHITE);
        MAIN_TTILE = new javax.swing.JLabel();
        LABEL_SET_RP = new javax.swing.JLabel();
        LABEL_SET_1 = new javax.swing.JLabel();
        INPUT_SET_1 = new javax.swing.JTextField();
        LABEL_SET_2 = new javax.swing.JLabel();
        INPUT_SET_2 = new javax.swing.JSpinner();
        LABEL_SET_3 = new javax.swing.JLabel();
        BTN_SET_SIMAN = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addGap(23, 23, 23))
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
                        .addComponent(P_TOTAL_BUKU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addComponent(P_DIPINJAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addComponent(P_BERMASALAH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        TOPBAR_USER.setBackground(new java.awt.Color(239, 240, 245));
        TOPBAR_USER.setPreferredSize(new java.awt.Dimension(353, 70));

        T_U_ANGGOTA.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        T_U_ANGGOTA.setForeground(new java.awt.Color(96, 96, 96));
        T_U_ANGGOTA.setText("Anggota");
        T_U_ANGGOTA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        T_U_ANGGOTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_U_ANGGOTAMouseClicked(evt);
            }
        });

        T_U_JURUSAN.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        T_U_JURUSAN.setForeground(new java.awt.Color(96, 96, 96));
        T_U_JURUSAN.setText("Jurusan");
        T_U_JURUSAN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        T_U_JURUSAN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_U_JURUSANMouseClicked(evt);
            }
        });

        T_U_KELAS.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        T_U_KELAS.setForeground(new java.awt.Color(96, 96, 96));
        T_U_KELAS.setText("Kelas");
        T_U_KELAS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        T_U_KELAS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_U_KELASMouseClicked(evt);
            }
        });

        T_U_PENGURUS.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        T_U_PENGURUS.setForeground(new java.awt.Color(96, 96, 96));
        T_U_PENGURUS.setText("Pengurus");
        T_U_PENGURUS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        T_U_PENGURUS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_U_PENGURUSMouseClicked(evt);
            }
        });

        USERNAME_USER.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        USERNAME_USER.setForeground(new java.awt.Color(96, 96, 96));
        USERNAME_USER.setText("USERNAME");

        ICON_U_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AKUN_CIRCLE.png"))); // NOI18N

        javax.swing.GroupLayout TOPBAR_USERLayout = new javax.swing.GroupLayout(TOPBAR_USER);
        TOPBAR_USER.setLayout(TOPBAR_USERLayout);
        TOPBAR_USERLayout.setHorizontalGroup(
            TOPBAR_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TOPBAR_USERLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(T_U_ANGGOTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(T_U_JURUSAN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(T_U_KELAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(T_U_PENGURUS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(640, 640, 640)
                .addComponent(USERNAME_USER)
                .addGap(18, 18, 18)
                .addComponent(ICON_U_USER)
                .addGap(27, 27, 27))
        );
        TOPBAR_USERLayout.setVerticalGroup(
            TOPBAR_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TOPBAR_USERLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(TOPBAR_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T_U_ANGGOTA)
                    .addComponent(USERNAME_USER)
                    .addComponent(T_U_JURUSAN)
                    .addComponent(T_U_KELAS)
                    .addComponent(T_U_PENGURUS))
                .addContainerGap())
            .addGroup(TOPBAR_USERLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ICON_U_USER, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        FRAME_MAIN_USER.setBackground(new java.awt.Color(239, 240, 245));
        FRAME_MAIN_USER.setLayout(new java.awt.CardLayout());

        F_U_ANGGOTA.setBackground(new java.awt.Color(239, 240, 245));

        TITLE_FRAME_USER.setFont(new java.awt.Font("Trebuchet MS", 1, 26)); // NOI18N
        TITLE_FRAME_USER.setForeground(new java.awt.Color(96, 96, 96));
        TITLE_FRAME_USER.setText("Daftar Anggota");

        ICON_EXPORT_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_EXPORT.png"))); // NOI18N
        ICON_EXPORT_USER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ICON_IMPORT_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_IMPORT.png"))); // NOI18N
        ICON_IMPORT_USER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ICON_ADD_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_ADD.png"))); // NOI18N
        ICON_ADD_USER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        SEARCH_USER.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        SEARCH_USER.setForeground(new java.awt.Color(96, 96, 96));
        SEARCH_USER.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 96, 96)));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        TABLE_LIST_U_ANGGOTA.setViewportView(jTable3);

        TAMPILKAN.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TAMPILKAN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(96, 96, 96));
        jLabel7.setText("Tampilkan");

        jComboBox3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(96, 96, 96));
        jLabel8.setText("Kelas");

        javax.swing.GroupLayout F_U_ANGGOTALayout = new javax.swing.GroupLayout(F_U_ANGGOTA);
        F_U_ANGGOTA.setLayout(F_U_ANGGOTALayout);
        F_U_ANGGOTALayout.setHorizontalGroup(
            F_U_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, F_U_ANGGOTALayout.createSequentialGroup()
                .addGroup(F_U_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(F_U_ANGGOTALayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(TAMPILKAN, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(F_U_ANGGOTALayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(F_U_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TABLE_LIST_U_ANGGOTA)
                            .addGroup(F_U_ANGGOTALayout.createSequentialGroup()
                                .addComponent(TITLE_FRAME_USER)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 592, Short.MAX_VALUE)
                                .addComponent(SEARCH_USER, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ICON_ADD_USER, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ICON_IMPORT_USER, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ICON_EXPORT_USER)))))
                .addGap(27, 27, 27))
        );
        F_U_ANGGOTALayout.setVerticalGroup(
            F_U_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(F_U_ANGGOTALayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(F_U_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TITLE_FRAME_USER)
                    .addComponent(ICON_IMPORT_USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ICON_ADD_USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ICON_EXPORT_USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SEARCH_USER))
                .addGap(18, 18, 18)
                .addComponent(TABLE_LIST_U_ANGGOTA, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(F_U_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(F_U_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TAMPILKAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(jLabel8)
                    .addComponent(jComboBox3))
                .addGap(20, 20, 20))
        );

        FRAME_MAIN_USER.add(F_U_ANGGOTA, "card2");

        F_U_JURUSAN.setBackground(new java.awt.Color(255, 51, 153));

        javax.swing.GroupLayout F_U_JURUSANLayout = new javax.swing.GroupLayout(F_U_JURUSAN);
        F_U_JURUSAN.setLayout(F_U_JURUSANLayout);
        F_U_JURUSANLayout.setHorizontalGroup(
            F_U_JURUSANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1238, Short.MAX_VALUE)
        );
        F_U_JURUSANLayout.setVerticalGroup(
            F_U_JURUSANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        FRAME_MAIN_USER.add(F_U_JURUSAN, "card3");

        F_U_KELAS.setBackground(new java.awt.Color(0, 204, 102));

        javax.swing.GroupLayout F_U_KELASLayout = new javax.swing.GroupLayout(F_U_KELAS);
        F_U_KELAS.setLayout(F_U_KELASLayout);
        F_U_KELASLayout.setHorizontalGroup(
            F_U_KELASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1238, Short.MAX_VALUE)
        );
        F_U_KELASLayout.setVerticalGroup(
            F_U_KELASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        FRAME_MAIN_USER.add(F_U_KELAS, "card5");

        F_U_PENGURUS.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout F_U_PENGURUSLayout = new javax.swing.GroupLayout(F_U_PENGURUS);
        F_U_PENGURUS.setLayout(F_U_PENGURUSLayout);
        F_U_PENGURUSLayout.setHorizontalGroup(
            F_U_PENGURUSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1238, Short.MAX_VALUE)
        );
        F_U_PENGURUSLayout.setVerticalGroup(
            F_U_PENGURUSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        FRAME_MAIN_USER.add(F_U_PENGURUS, "card4");

        javax.swing.GroupLayout USERLayout = new javax.swing.GroupLayout(USER);
        USER.setLayout(USERLayout);
        USERLayout.setHorizontalGroup(
            USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, USERLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FRAME_MAIN_USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TOPBAR_USER, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        USERLayout.setVerticalGroup(
            USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(USERLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TOPBAR_USER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(FRAME_MAIN_USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        MAIN_CONTENT.add(USER, "card5");

        SETTING.setBackground(new java.awt.Color(239, 240, 245));

        TOPBAR_SETTING.setBackground(new java.awt.Color(239, 240, 245));
        TOPBAR_SETTING.setPreferredSize(new java.awt.Dimension(353, 70));

        TITLE_SETTING.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        TITLE_SETTING.setForeground(new java.awt.Color(78, 204, 121));
        TITLE_SETTING.setText("Pengaturan");

        USERNAME_SETTING.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        USERNAME_SETTING.setForeground(new java.awt.Color(96, 96, 96));
        USERNAME_SETTING.setText("USERNAME");

        ICON_SETTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_AKUN_CIRCLE.png"))); // NOI18N

        javax.swing.GroupLayout TOPBAR_SETTINGLayout = new javax.swing.GroupLayout(TOPBAR_SETTING);
        TOPBAR_SETTING.setLayout(TOPBAR_SETTINGLayout);
        TOPBAR_SETTINGLayout.setHorizontalGroup(
            TOPBAR_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TOPBAR_SETTINGLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(TITLE_SETTING)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(USERNAME_SETTING)
                .addGap(18, 18, 18)
                .addComponent(ICON_SETTING)
                .addGap(27, 27, 27))
        );
        TOPBAR_SETTINGLayout.setVerticalGroup(
            TOPBAR_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TOPBAR_SETTINGLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(TOPBAR_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TITLE_SETTING)
                    .addComponent(USERNAME_SETTING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(TOPBAR_SETTINGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ICON_SETTING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        FRAME_MAIN_SETTING.setBackground(new java.awt.Color(239, 240, 245));

        MAIN_TTILE.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        MAIN_TTILE.setForeground(new java.awt.Color(96, 96, 96));
        MAIN_TTILE.setText("Pengaturan");

        LABEL_SET_RP.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        LABEL_SET_RP.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_SET_RP.setText("Rp");

        LABEL_SET_1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_SET_1.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_SET_1.setText("Denda Terlambat Per Hari");

        INPUT_SET_1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        INPUT_SET_1.setForeground(new java.awt.Color(96, 96, 96));
        INPUT_SET_1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        INPUT_SET_1.setMaximumSize(new java.awt.Dimension(1360, 45));
        INPUT_SET_1.setPreferredSize(new java.awt.Dimension(340, 45));

        LABEL_SET_2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_SET_2.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_SET_2.setText("Max Pinjam Buku ( Buku Umum )");

        INPUT_SET_2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        INPUT_SET_2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        INPUT_SET_2.setBorder(null);

        LABEL_SET_3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_SET_3.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_SET_3.setText("Backup Database");

        BTN_SET_SIMAN.setBackground(new java.awt.Color(0, 171, 60));
        BTN_SET_SIMAN.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        BTN_SET_SIMAN.setForeground(new java.awt.Color(255, 255, 255));
        BTN_SET_SIMAN.setText("Simpan Perubahan");

        jComboBox1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(96, 96, 96));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Per 1 Jam", "Per 2 Jam", "Per 3 Jam" }));

        javax.swing.GroupLayout FRAME_MAIN_SETTINGLayout = new javax.swing.GroupLayout(FRAME_MAIN_SETTING);
        FRAME_MAIN_SETTING.setLayout(FRAME_MAIN_SETTINGLayout);
        FRAME_MAIN_SETTINGLayout.setHorizontalGroup(
            FRAME_MAIN_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FRAME_MAIN_SETTINGLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(FRAME_MAIN_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FRAME_MAIN_SETTINGLayout.createSequentialGroup()
                        .addComponent(LABEL_SET_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(254, 254, 254))
                    .addGroup(FRAME_MAIN_SETTINGLayout.createSequentialGroup()
                        .addGroup(FRAME_MAIN_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FRAME_MAIN_SETTINGLayout.createSequentialGroup()
                                .addComponent(LABEL_SET_RP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(INPUT_SET_1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(MAIN_TTILE))
                        .addGap(95, 95, 95)))
                .addGroup(FRAME_MAIN_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FRAME_MAIN_SETTINGLayout.createSequentialGroup()
                        .addComponent(LABEL_SET_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(214, 214, 214))
                    .addGroup(FRAME_MAIN_SETTINGLayout.createSequentialGroup()
                        .addComponent(INPUT_SET_2)
                        .addGap(82, 82, 82)))
                .addGroup(FRAME_MAIN_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_SET_SIMAN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(FRAME_MAIN_SETTINGLayout.createSequentialGroup()
                        .addComponent(LABEL_SET_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(232, 232, 232))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        FRAME_MAIN_SETTINGLayout.setVerticalGroup(
            FRAME_MAIN_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FRAME_MAIN_SETTINGLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(MAIN_TTILE)
                .addGap(29, 29, 29)
                .addGroup(FRAME_MAIN_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LABEL_SET_1)
                    .addComponent(LABEL_SET_2)
                    .addComponent(LABEL_SET_3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FRAME_MAIN_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(FRAME_MAIN_SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(INPUT_SET_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LABEL_SET_RP))
                    .addComponent(jComboBox1)
                    .addComponent(INPUT_SET_2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 398, Short.MAX_VALUE)
                .addComponent(BTN_SET_SIMAN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout SETTINGLayout = new javax.swing.GroupLayout(SETTING);
        SETTING.setLayout(SETTINGLayout);
        SETTINGLayout.setHorizontalGroup(
            SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SETTINGLayout.createSequentialGroup()
                .addGroup(SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SETTINGLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(FRAME_MAIN_SETTING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(SETTINGLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(TOPBAR_SETTING, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        SETTINGLayout.setVerticalGroup(
            SETTINGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SETTINGLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TOPBAR_SETTING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(FRAME_MAIN_SETTING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
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
        T_U_ANGGOTA.setForeground(new Color(78, 204, 121));
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

    private void T_U_ANGGOTAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_U_ANGGOTAMouseClicked
        setUserPageSelected("ANGGOTA");
    }//GEN-LAST:event_T_U_ANGGOTAMouseClicked

    private void T_U_JURUSANMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_U_JURUSANMouseClicked
        setUserPageSelected("JURUSAN");
    }//GEN-LAST:event_T_U_JURUSANMouseClicked

    private void T_U_KELASMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_U_KELASMouseClicked
        setUserPageSelected("KELAS");
    }//GEN-LAST:event_T_U_KELASMouseClicked

    private void T_U_PENGURUSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_U_PENGURUSMouseClicked
        setUserPageSelected("PENGURUS");
    }//GEN-LAST:event_T_U_PENGURUSMouseClicked

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
    private javax.swing.JButton BTN_SET_SIMAN;
    private javax.swing.JLabel BTN_TRANSAKSI;
    private javax.swing.JLabel BTN_USER;
    private javax.swing.JPanel DASHBOARD;
    private javax.swing.JPanel DATABUKU;
    private javax.swing.JPanel FRAME_MAIN_SETTING;
    private javax.swing.JPanel FRAME_MAIN_USER;
    private javax.swing.JPanel F_U_ANGGOTA;
    private javax.swing.JPanel F_U_JURUSAN;
    private javax.swing.JPanel F_U_KELAS;
    private javax.swing.JPanel F_U_PENGURUS;
    private javax.swing.JLabel ICON_ADD_USER;
    private javax.swing.JLabel ICON_ANGGOTA;
    private javax.swing.JLabel ICON_BERMASALAH;
    private javax.swing.JLabel ICON_DIPINJAM;
    private javax.swing.JLabel ICON_EXPORT_USER;
    private javax.swing.JLabel ICON_IMPORT_USER;
    private javax.swing.JLabel ICON_SETTING;
    private javax.swing.JLabel ICON_TOTAL_BUKU;
    private javax.swing.JLabel ICON_USER;
    private javax.swing.JLabel ICON_USER1;
    private javax.swing.JLabel ICON_USER2;
    private javax.swing.JLabel ICON_USER3;
    private javax.swing.JLabel ICON_USER4;
    private javax.swing.JLabel ICON_U_USER;
    private javax.swing.JTextField INPUT_SET_1;
    private javax.swing.JSpinner INPUT_SET_2;
    private javax.swing.JLabel LABEL_SET_1;
    private javax.swing.JLabel LABEL_SET_2;
    private javax.swing.JLabel LABEL_SET_3;
    private javax.swing.JLabel LABEL_SET_RP;
    private javax.swing.JPanel MAIN_CONTENT;
    private javax.swing.JLabel MAIN_TTILE;
    private javax.swing.JLabel MANURUL_LOGO;
    private javax.swing.JPanel P_ANGGOTA;
    private javax.swing.JPanel P_BERMASALAH;
    private javax.swing.JPanel P_DIPINJAM;
    private javax.swing.JPanel P_TABLE_LOG;
    private javax.swing.JPanel P_TOTAL_BUKU;
    private javax.swing.JTextField SEARCH_USER;
    private javax.swing.JPanel SETTING;
    private javax.swing.JPanel SIDEBAR;
    private javax.swing.JScrollPane TABLE_LIST_U_ANGGOTA;
    private javax.swing.JComboBox<String> TAMPILKAN;
    private javax.swing.JLabel TITLE_ANGGOTA;
    private javax.swing.JLabel TITLE_BERMASALAH;
    private javax.swing.JLabel TITLE_DASHBOARD;
    private javax.swing.JLabel TITLE_DASHBOARD1;
    private javax.swing.JLabel TITLE_DASHBOARD2;
    private javax.swing.JLabel TITLE_DASHBOARD3;
    private javax.swing.JLabel TITLE_DASHBOARD4;
    private javax.swing.JLabel TITLE_DIPINJAM;
    private javax.swing.JLabel TITLE_FRAME_USER;
    private javax.swing.JLabel TITLE_SETTING;
    private javax.swing.JLabel TITLE_TOTAL_BUKU;
    private javax.swing.JPanel TOPBAR;
    private javax.swing.JPanel TOPBAR1;
    private javax.swing.JPanel TOPBAR2;
    private javax.swing.JPanel TOPBAR3;
    private javax.swing.JPanel TOPBAR4;
    private javax.swing.JPanel TOPBAR_SETTING;
    private javax.swing.JPanel TOPBAR_USER;
    private javax.swing.JPanel TRANSAKSI;
    private javax.swing.JLabel T_U_ANGGOTA;
    private javax.swing.JLabel T_U_JURUSAN;
    private javax.swing.JLabel T_U_KELAS;
    private javax.swing.JLabel T_U_PENGURUS;
    private javax.swing.JPanel USER;
    private javax.swing.JLabel USERNAME;
    private javax.swing.JLabel USERNAME1;
    private javax.swing.JLabel USERNAME2;
    private javax.swing.JLabel USERNAME3;
    private javax.swing.JLabel USERNAME4;
    private javax.swing.JLabel USERNAME_SETTING;
    private javax.swing.JLabel USERNAME_USER;
    private javax.swing.JLabel VALUE_ANGGOTA;
    private javax.swing.JLabel VALUE_BERMASALAH;
    private javax.swing.JLabel VALUE_DIPINJAM;
    private javax.swing.JLabel VALUE_TOTAL_BUKU;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
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
