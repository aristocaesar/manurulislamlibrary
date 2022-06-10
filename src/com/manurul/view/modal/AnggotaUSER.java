/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.view.modal;

import com.manurul.lib.Characters;
import com.manurul.lib.InputBorder;
import java.awt.Color;
import com.manurul.lib.RoundedPanel;
import com.manurul.model.AnggotaModel;
import com.manurul.model.SettingModel;
import static com.manurul.view.Dashboard.GROUP_COMBOBOX_USER;
import static com.manurul.view.Dashboard.SEARCH_USER;
import static com.manurul.view.Dashboard.TAMPILKAN_COMBOBOX_USER;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author DKODE Creative
 */
public class AnggotaUSER extends javax.swing.JFrame {

    /**
     * Creates new form ANGGOTA_MANAGED_USER
     */
    
    String title = "Edit";
    String action;
    
    String nis;
    String nama;
    String jurusan;
    String skor;
    
    private ImageIcon successIcon;
    
    AnggotaModel AM = new AnggotaModel();
    
    public AnggotaUSER(String Action, String nis) {
        initComponents();
        
        // SET STATE
        this.action = Action;
        
        // SET SIZE
        this.setSize(1040, 460);
        
        // SET CENTER LOCATION
        this.setLocationRelativeTo(null);
        
        // SET DISABLE RESIZESABLE
        this.setResizable(false);
        
        // INIT INPUT BORDER PADDING
        InputBorder.set(INPUT_NIS, 8);
        InputBorder.set(INPUT_NAMA_LENGKAP, 8);
        InputBorder.set(INPUT_CREATED, 8);
        InputBorder.set(INPUT_KESEMPATAN, 8);
        InputBorder.set(INPUT_UPDATED, 8);
        
        // GET DATA FROM Jurusan & Kelas
        AM.setJurusanKelas("");
        
        // VISIBLE COMPONECT BASED ON ACTION
        if(Action.equals("ADD")){
            
            this.title = "Tambah";
            this.setSize(1040, 400);
            
            SPINNER_SKOR.setValue(100);
            SPINNER_SKOR.setEnabled(false);
            
            LABEL_CREATED.setVisible(false);
            INPUT_CREATED.setVisible(false);
            LABEL_UPDATED.setVisible(false);
            INPUT_UPDATED.setVisible(false);
            LABEL_KESEMPATAN.setVisible(false);
            INPUT_KESEMPATAN.setVisible(false);
        
        }else{
            //get data selected
            AM.getSelectedData(nis);
            
            INPUT_NIS.setText(AM.getNis());
            INPUT_NAMA_LENGKAP.setText(AM.getNama());
            COMBO_BOX_JURUSAN.setSelectedItem(AM.getJurusan());
            SPINNER_SKOR.setValue(Integer.parseInt(AM.getSkor()));
            INPUT_CREATED.setText(AM.getCreated());
            INPUT_UPDATED.setText(AM.getUpdated());
            
            int buku_dipinjam = Integer.parseInt(AM.getJumlahBukuDipinjam());
            int max_pinjam = new SettingModel().getMaxPinjam();
            
            int kesempatan = max_pinjam - buku_dipinjam;
            
            INPUT_KESEMPATAN.setText(String.valueOf(kesempatan));
            
            this.nis = AM.getNis();
            this.nama = AM.getNama();
            this.jurusan = AM.getJurusan();
            this.skor = AM.getSkor();
            
        }
        
        // SET TITLE
        this.setTitle("MA Nurul Islam Library Management - "+this.title+" Anggota");
        
        // SET SUCCESS ICON
        ImageIcon successIcon = new ImageIcon(getClass().getResource("/com/manurul/src/ICON_SUCCESS.png"));
        this.successIcon = successIcon;
        
    }
    
    private boolean cekValidasi(){
        
        try{
        
            String nis = INPUT_NIS.getText().replaceAll("[a-zA-Z]", "");
            String nama = INPUT_NAMA_LENGKAP.getText().replaceAll("[0-9]", "");
            int skor = Integer.parseInt(SPINNER_SKOR.getValue().toString());
            
            if(nis.equals("")){
                throw new Exception("Nilai NIS harus terisi dan berupa angka !");
            }
            
            if(nama.equals("")){
                throw new Exception("Nilai nama harus terisi !");
            }
            
            if(skor <= 0){
                throw new Exception("Nilai skor terlalu rendah !");
            }
            
        }catch(Exception error){
            
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
            return false;
            
        }
        
        return true;
        
    }
    
    private void inputRevalidate(){
    
        INPUT_NIS.setText(this.nis);
        INPUT_NAMA_LENGKAP.setText(this.nama);
        COMBO_BOX_JURUSAN.setSelectedItem(this.jurusan);
        SPINNER_SKOR.setValue(Integer.parseInt(this.skor));
        
    }
    
    private void simpan(){
        if(cekValidasi()){
            
            AM.setNis(INPUT_NIS.getText().replaceAll("[a-zA-Z]", ""));
            AM.setNama(Characters.ucwords(INPUT_NAMA_LENGKAP.getText()));
            AM.setJurusan(COMBO_BOX_JURUSAN.getSelectedItem().toString());
            AM.setSkor("100");
            
            if(AM.insertData()){
                JOptionPane.showMessageDialog(null, AM.getMessage(), "Sukses!", JOptionPane.INFORMATION_MESSAGE, this.successIcon);
                
                new AnggotaModel().getDataTable(SEARCH_USER.getText(), GROUP_COMBOBOX_USER.getSelectedItem().toString(), TAMPILKAN_COMBOBOX_USER.getSelectedItem().toString());
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, AM.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private void update(){
        
        if(cekValidasi()){
            
            String nis = INPUT_NIS.getText(); 
            String nama = INPUT_NAMA_LENGKAP.getText();
            String jurusan = COMBO_BOX_JURUSAN.getSelectedItem().toString();
            String skor = SPINNER_SKOR.getValue().toString();
            
            // cek perubahan
            if(!nis.equals(this.nis)
                    || !nama.equals(this.nama)
                    || !jurusan.equals(this.jurusan)
                    || !skor.equals(this.skor)){
                
                AM.setNis(nis);
                AM.setNama(nama);
                AM.setJurusan(jurusan);
                AM.setSkor(skor);
                
                if(AM.updateData()){
                    JOptionPane.showMessageDialog(null, AM.getMessage(), "Sukses!", JOptionPane.INFORMATION_MESSAGE, this.successIcon);

                    new AnggotaModel().getDataTable(SEARCH_USER.getText(), GROUP_COMBOBOX_USER.getSelectedItem().toString(), TAMPILKAN_COMBOBOX_USER.getSelectedItem().toString());
                    
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, AM.getMessage(), "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
                    inputRevalidate();
                } 
                
            }else{
                JOptionPane.showMessageDialog(null, "Tidak ada perubahan !", "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE);
            }
            
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

        FRAME_MAIN_ANGGOTA = new javax.swing.JPanel();
        CONTAINER_ANGGOTA = new RoundedPanel(15, Color.WHITE);
        INPUT_NIS = new javax.swing.JTextField();
        INPUT_NAMA_LENGKAP = new javax.swing.JTextField();
        LABEL_NIS = new javax.swing.JLabel();
        LABEL_NAMA_LENGKAP = new javax.swing.JLabel();
        LABEL_JURUSAN = new javax.swing.JLabel();
        LABEL_SKOR = new javax.swing.JLabel();
        COMBO_BOX_JURUSAN = new javax.swing.JComboBox<>();
        LABEL_UPDATED = new javax.swing.JLabel();
        INPUT_UPDATED = new javax.swing.JTextField();
        LABEL_CREATED = new javax.swing.JLabel();
        INPUT_CREATED = new javax.swing.JTextField();
        SPINNER_SKOR = new javax.swing.JSpinner();
        INPUT_KESEMPATAN = new javax.swing.JTextField();
        LABEL_KESEMPATAN = new javax.swing.JLabel();
        BTN_SIMPAN_ANGGOTA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.POPUP);

        FRAME_MAIN_ANGGOTA.setBackground(new java.awt.Color(239, 240, 245));
        FRAME_MAIN_ANGGOTA.setPreferredSize(new java.awt.Dimension(1024, 414));

        CONTAINER_ANGGOTA.setBackground(new java.awt.Color(239, 240, 245));

        INPUT_NIS.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_NIS.setForeground(new java.awt.Color(96, 96, 96));
        INPUT_NIS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 96, 96)));

        INPUT_NAMA_LENGKAP.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_NAMA_LENGKAP.setForeground(new java.awt.Color(96, 96, 96));
        INPUT_NAMA_LENGKAP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 96, 96)));

        LABEL_NIS.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_NIS.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_NIS.setText("NIS");

        LABEL_NAMA_LENGKAP.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_NAMA_LENGKAP.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_NAMA_LENGKAP.setText("Nama Lengkap");

        LABEL_JURUSAN.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_JURUSAN.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_JURUSAN.setText("Jurusan");

        LABEL_SKOR.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_SKOR.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_SKOR.setText("Skor");

        COMBO_BOX_JURUSAN.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        COMBO_BOX_JURUSAN.setForeground(new java.awt.Color(96, 96, 96));
        COMBO_BOX_JURUSAN.setBorder(null);

        LABEL_UPDATED.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_UPDATED.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_UPDATED.setText("Terakhir Diperbarui");

        INPUT_UPDATED.setEditable(false);
        INPUT_UPDATED.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_UPDATED.setForeground(new java.awt.Color(96, 96, 96));
        INPUT_UPDATED.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 96, 96)));

        LABEL_CREATED.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_CREATED.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_CREATED.setText("Tanggal Register");

        INPUT_CREATED.setEditable(false);
        INPUT_CREATED.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_CREATED.setForeground(new java.awt.Color(96, 96, 96));
        INPUT_CREATED.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 96, 96)));

        SPINNER_SKOR.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        SPINNER_SKOR.setModel(new javax.swing.SpinnerNumberModel(100, 0, 100, 1));
        SPINNER_SKOR.setBorder(null);

        INPUT_KESEMPATAN.setEditable(false);
        INPUT_KESEMPATAN.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_KESEMPATAN.setForeground(new java.awt.Color(96, 96, 96));
        INPUT_KESEMPATAN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 96, 96)));

        LABEL_KESEMPATAN.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_KESEMPATAN.setForeground(new java.awt.Color(96, 96, 96));
        LABEL_KESEMPATAN.setText("Kesempatan Pinjam");

        javax.swing.GroupLayout CONTAINER_ANGGOTALayout = new javax.swing.GroupLayout(CONTAINER_ANGGOTA);
        CONTAINER_ANGGOTA.setLayout(CONTAINER_ANGGOTALayout);
        CONTAINER_ANGGOTALayout.setHorizontalGroup(
            CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONTAINER_ANGGOTALayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CONTAINER_ANGGOTALayout.createSequentialGroup()
                        .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LABEL_NIS, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                            .addComponent(INPUT_NIS))
                        .addGap(33, 33, 33)
                        .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LABEL_NAMA_LENGKAP, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(INPUT_NAMA_LENGKAP, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CONTAINER_ANGGOTALayout.createSequentialGroup()
                        .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(CONTAINER_ANGGOTALayout.createSequentialGroup()
                                .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LABEL_CREATED, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                    .addComponent(INPUT_CREATED))
                                .addGap(44, 44, 44)
                                .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(INPUT_UPDATED)
                                    .addComponent(LABEL_UPDATED, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(INPUT_KESEMPATAN, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LABEL_KESEMPATAN)))
                            .addGroup(CONTAINER_ANGGOTALayout.createSequentialGroup()
                                .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(COMBO_BOX_JURUSAN, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LABEL_JURUSAN, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SPINNER_SKOR, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                                    .addComponent(LABEL_SKOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(25, 25, 25))))
        );

        CONTAINER_ANGGOTALayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {INPUT_NAMA_LENGKAP, INPUT_NIS, LABEL_NAMA_LENGKAP, LABEL_NIS});

        CONTAINER_ANGGOTALayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {COMBO_BOX_JURUSAN, LABEL_JURUSAN, LABEL_SKOR, SPINNER_SKOR});

        CONTAINER_ANGGOTALayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {INPUT_CREATED, INPUT_KESEMPATAN, INPUT_UPDATED, LABEL_CREATED, LABEL_KESEMPATAN, LABEL_UPDATED});

        CONTAINER_ANGGOTALayout.setVerticalGroup(
            CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONTAINER_ANGGOTALayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LABEL_NIS)
                    .addComponent(LABEL_NAMA_LENGKAP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(INPUT_NAMA_LENGKAP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(INPUT_NIS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LABEL_JURUSAN)
                    .addComponent(LABEL_SKOR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(COMBO_BOX_JURUSAN, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(SPINNER_SKOR))
                .addGap(31, 31, 31)
                .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CONTAINER_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(CONTAINER_ANGGOTALayout.createSequentialGroup()
                            .addComponent(LABEL_UPDATED)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(INPUT_UPDATED, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(CONTAINER_ANGGOTALayout.createSequentialGroup()
                            .addComponent(LABEL_CREATED)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(INPUT_CREATED, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CONTAINER_ANGGOTALayout.createSequentialGroup()
                        .addComponent(LABEL_KESEMPATAN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(INPUT_KESEMPATAN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        CONTAINER_ANGGOTALayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {INPUT_NAMA_LENGKAP, INPUT_NIS});

        BTN_SIMPAN_ANGGOTA.setBackground(new java.awt.Color(0, 171, 60));
        BTN_SIMPAN_ANGGOTA.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        BTN_SIMPAN_ANGGOTA.setForeground(new java.awt.Color(255, 255, 255));
        BTN_SIMPAN_ANGGOTA.setText("Simpan");
        BTN_SIMPAN_ANGGOTA.setBorder(null);
        BTN_SIMPAN_ANGGOTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_SIMPAN_ANGGOTAMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FRAME_MAIN_ANGGOTALayout = new javax.swing.GroupLayout(FRAME_MAIN_ANGGOTA);
        FRAME_MAIN_ANGGOTA.setLayout(FRAME_MAIN_ANGGOTALayout);
        FRAME_MAIN_ANGGOTALayout.setHorizontalGroup(
            FRAME_MAIN_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FRAME_MAIN_ANGGOTALayout.createSequentialGroup()
                .addGroup(FRAME_MAIN_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FRAME_MAIN_ANGGOTALayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(CONTAINER_ANGGOTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(FRAME_MAIN_ANGGOTALayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_SIMPAN_ANGGOTA, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        FRAME_MAIN_ANGGOTALayout.setVerticalGroup(
            FRAME_MAIN_ANGGOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FRAME_MAIN_ANGGOTALayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(CONTAINER_ANGGOTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(BTN_SIMPAN_ANGGOTA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FRAME_MAIN_ANGGOTA, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FRAME_MAIN_ANGGOTA, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_SIMPAN_ANGGOTAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_SIMPAN_ANGGOTAMouseClicked
        
        if(this.action.equals("ADD")){
            simpan();
        }else{
            update();
        }
        
    }//GEN-LAST:event_BTN_SIMPAN_ANGGOTAMouseClicked

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
            java.util.logging.Logger.getLogger(AnggotaUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnggotaUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnggotaUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnggotaUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnggotaUSER("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_SIMPAN_ANGGOTA;
    public static javax.swing.JComboBox<String> COMBO_BOX_JURUSAN;
    private javax.swing.JPanel CONTAINER_ANGGOTA;
    private javax.swing.JPanel FRAME_MAIN_ANGGOTA;
    private javax.swing.JTextField INPUT_CREATED;
    private javax.swing.JTextField INPUT_KESEMPATAN;
    private javax.swing.JTextField INPUT_NAMA_LENGKAP;
    private javax.swing.JTextField INPUT_NIS;
    private javax.swing.JTextField INPUT_UPDATED;
    private javax.swing.JLabel LABEL_CREATED;
    private javax.swing.JLabel LABEL_JURUSAN;
    private javax.swing.JLabel LABEL_KESEMPATAN;
    private javax.swing.JLabel LABEL_NAMA_LENGKAP;
    private javax.swing.JLabel LABEL_NIS;
    private javax.swing.JLabel LABEL_SKOR;
    private javax.swing.JLabel LABEL_UPDATED;
    private javax.swing.JSpinner SPINNER_SKOR;
    // End of variables declaration//GEN-END:variables
    
}
