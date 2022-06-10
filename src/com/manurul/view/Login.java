/*
 * LICENSE BY DKODE Creative
 */
package com.manurul.view;

import com.manurul.model.PengurusModel;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author DKODE Creative
 */
public class Login extends javax.swing.JFrame {

    /**
     * INIT FORM LOGIN
     */
    public Login() {
        initComponents();
        
        // SET TITLE
        this.setTitle("MA Nurul Islam Library Management");
        // SET SIZE
        this.setSize(1024, 650);
        this.setMaximumSize(new Dimension(1024, 650));
        this.setMinimumSize(new Dimension(1024, 650));
        // SET CENTER LOCATION
        this.setLocationRelativeTo(null);
        // SET DISABLE RESIZESABLE
        this.setResizable(false);
        
        // SET BORDER INPUT
        INPUT_USERNAME.setBorder(BorderFactory.createCompoundBorder(INPUT_USERNAME.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 0)));
        INPUT_PASSWORD.setBorder(BorderFactory.createCompoundBorder(INPUT_PASSWORD.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 0)));

        // FIELD AUTO FOKUS
        INPUT_USERNAME.requestFocus();
        
    }
    
    public void LoginAction(){
        
        try{
        
            // CHECK VALIDASI TEXTFIELD
            if(!INPUT_USERNAME.getText().equals("") && !INPUT_PASSWORD.getText().equals("")){
                
                // CHECK DENGAN MODEL 
                PengurusModel PM = new PengurusModel();
                PM.setUsername(INPUT_USERNAME.getText());
                PM.setPassword(INPUT_PASSWORD.getText());
                if(PM.loginCek()){
                     new Dashboard(PM.getKode(), PM.getNamaLengkap(), PM.getHakAkses()).setVisible(true);
                     this.dispose();
                }else{
                    throw new Exception(PM.getMessage());
                }
                
            }else{
                throw new Exception("Username atau Password salah!");
            }
            
        }catch(Exception error){
            JOptionPane.showMessageDialog(this, error.getMessage(), "Terjadi Kesalahan !",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PANEL_1 = new javax.swing.JPanel();
        BACKGROUND = new javax.swing.JLabel();
        PANEL_2 = new javax.swing.JPanel();
        LOGO = new javax.swing.JLabel();
        APP_TITLE = new javax.swing.JLabel();
        LABEL_USERNAME = new javax.swing.JLabel();
        INPUT_USERNAME = new javax.swing.JTextField();
        LABEL_PASSWORD = new javax.swing.JLabel();
        INPUT_PASSWORD = new javax.swing.JPasswordField();
        BTN_LOGIN = new javax.swing.JButton();
        TEXT_COPYRIGHT_1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TEXT_COPYRIGHT_2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PANEL_1.setBackground(new java.awt.Color(204, 204, 204));

        BACKGROUND.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/LIBRARY_IMAGE.png"))); // NOI18N

        javax.swing.GroupLayout PANEL_1Layout = new javax.swing.GroupLayout(PANEL_1);
        PANEL_1.setLayout(PANEL_1Layout);
        PANEL_1Layout.setHorizontalGroup(
            PANEL_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BACKGROUND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PANEL_1Layout.setVerticalGroup(
            PANEL_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BACKGROUND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PANEL_2.setBackground(new java.awt.Color(255, 255, 255));

        LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/LOGO_MANURUL.png"))); // NOI18N

        APP_TITLE.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        APP_TITLE.setForeground(new java.awt.Color(96, 96, 96));
        APP_TITLE.setText("MA Nurul Islam Library Management");

        LABEL_USERNAME.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_USERNAME.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_USERNAME.setText("Username");

        INPUT_USERNAME.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_USERNAME.setForeground(new java.awt.Color(96, 96, 96));
        INPUT_USERNAME.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(96, 96, 96), 1, true));
        INPUT_USERNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                INPUT_USERNAMEKeyPressed(evt);
            }
        });

        LABEL_PASSWORD.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_PASSWORD.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_PASSWORD.setText("Password");

        INPUT_PASSWORD.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_PASSWORD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(96, 96, 96), 1, true));
        INPUT_PASSWORD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                INPUT_PASSWORDKeyPressed(evt);
            }
        });

        BTN_LOGIN.setBackground(new java.awt.Color(0, 171, 60));
        BTN_LOGIN.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        BTN_LOGIN.setForeground(new java.awt.Color(255, 255, 255));
        BTN_LOGIN.setText("LOGIN");
        BTN_LOGIN.setBorder(null);
        BTN_LOGIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_LOGINMouseClicked(evt);
            }
        });
        BTN_LOGIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BTN_LOGINKeyPressed(evt);
            }
        });

        TEXT_COPYRIGHT_1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TEXT_COPYRIGHT_1.setForeground(new java.awt.Color(96, 96, 96));
        TEXT_COPYRIGHT_1.setText("Build With");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/manurul/src/ICON_LOVE.png"))); // NOI18N

        TEXT_COPYRIGHT_2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TEXT_COPYRIGHT_2.setForeground(new java.awt.Color(96, 96, 96));
        TEXT_COPYRIGHT_2.setText("By DKODE Creative");

        javax.swing.GroupLayout PANEL_2Layout = new javax.swing.GroupLayout(PANEL_2);
        PANEL_2.setLayout(PANEL_2Layout);
        PANEL_2Layout.setHorizontalGroup(
            PANEL_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_2Layout.createSequentialGroup()
                .addGroup(PANEL_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_2Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(LOGO))
                    .addGroup(PANEL_2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(PANEL_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANEL_2Layout.createSequentialGroup()
                                .addComponent(TEXT_COPYRIGHT_1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TEXT_COPYRIGHT_2))
                            .addGroup(PANEL_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LABEL_PASSWORD)
                                .addComponent(LABEL_USERNAME)
                                .addComponent(APP_TITLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(INPUT_USERNAME)
                                .addComponent(INPUT_PASSWORD)
                                .addComponent(BTN_LOGIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        PANEL_2Layout.setVerticalGroup(
            PANEL_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(LOGO)
                .addGap(38, 38, 38)
                .addComponent(APP_TITLE)
                .addGap(30, 30, 30)
                .addComponent(LABEL_USERNAME)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(INPUT_USERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LABEL_PASSWORD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(INPUT_PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTN_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PANEL_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TEXT_COPYRIGHT_1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TEXT_COPYRIGHT_2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(87, 87, 87))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PANEL_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PANEL_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PANEL_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PANEL_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_LOGINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_LOGINMouseClicked
        // LAKUKAN AUTHTENTIKASI
        LoginAction();
    }//GEN-LAST:event_BTN_LOGINMouseClicked

    private void INPUT_USERNAMEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_INPUT_USERNAMEKeyPressed
        // LAKUKAN AUTHTENTIKASI
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            LoginAction();
        }
    }//GEN-LAST:event_INPUT_USERNAMEKeyPressed

    private void INPUT_PASSWORDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_INPUT_PASSWORDKeyPressed
        // LAKUKAN AUTHTENTIKASI
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            LoginAction();
        }
    }//GEN-LAST:event_INPUT_PASSWORDKeyPressed

    private void BTN_LOGINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTN_LOGINKeyPressed
        // LAKUKAN AUTHTENTIKASI
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            LoginAction();
        }
    }//GEN-LAST:event_BTN_LOGINKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel APP_TITLE;
    private javax.swing.JLabel BACKGROUND;
    private javax.swing.JButton BTN_LOGIN;
    private javax.swing.JPasswordField INPUT_PASSWORD;
    private javax.swing.JTextField INPUT_USERNAME;
    private javax.swing.JLabel LABEL_PASSWORD;
    private javax.swing.JLabel LABEL_USERNAME;
    private javax.swing.JLabel LOGO;
    private javax.swing.JPanel PANEL_1;
    private javax.swing.JPanel PANEL_2;
    private javax.swing.JLabel TEXT_COPYRIGHT_1;
    private javax.swing.JLabel TEXT_COPYRIGHT_2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
