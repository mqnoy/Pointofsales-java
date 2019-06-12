/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import static databases.CrudModel.deleteUserapp_listDB;
import static databases.CrudModel.getUserapp_listDB;
import static databases.CrudModel.getUserapp_listDB;
import static databases.CrudModel.insertUserapp_listDB;
import static databases.CrudModel.update_Userapp_listDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pointofsale_backend.SetGet;
import static pointofsale_backend.SetGet.notif_del_userapp;
import static pointofsale_backend.SetGet.notif_ins_userapp;
import static pointofsale_backend.SetGet.notif_upd_userapp;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class Form_crud_userAplikasi extends javax.swing.JFrame {

    public static String valNip;
    public static String valNmPegawai;
    public static String valLevel;
    public static String valBlokir;
    public static String valJabatan;

    /**
     * Creates new form Form_crud_userAplikasi
     */
    public Form_crud_userAplikasi() {
        initComponents();
        getUserapp_listDB(false,null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_blokAkses = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBL_userapp = new javax.swing.JTable();
        txt_pencarian_userKeywords = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_userapp_passwd = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        cb_userapp_levelakses = new javax.swing.JComboBox<String>();
        txt_idPengguna = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rdBlokir_yes = new javax.swing.JRadioButton();
        rdBlokir_no = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_userapp_nip = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_userapp_nmpegawai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cb_userapp_jabatan = new javax.swing.JComboBox<String>();
        jPanel3 = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        btn_mainmenu = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User aplikasi");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("List data"));

        JTBL_userapp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        JTBL_userapp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nip", "nama pegawai", "Jabatan", "level", "blokir"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTBL_userapp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTBL_userappMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTBL_userapp);
        if (JTBL_userapp.getColumnModel().getColumnCount() > 0) {
            JTBL_userapp.getColumnModel().getColumn(5).setResizable(false);
        }

        txt_pencarian_userKeywords.setText("min 3 karakter");
        txt_pencarian_userKeywords.setToolTipText("masukan nama karyawan atau username");
        txt_pencarian_userKeywords.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_pencarian_userKeywordsFocusGained(evt);
            }
        });
        txt_pencarian_userKeywords.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pencarian_userKeywordsKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_pencarian_userKeywords, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(txt_pencarian_userKeywords, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        jPanel2.setToolTipText("");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data akses pengguna"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Id pengguna : ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Kata sandi * :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Level akses * :");

        cb_userapp_levelakses.setBackground(new java.awt.Color(51, 51, 51));
        cb_userapp_levelakses.setForeground(new java.awt.Color(255, 255, 255));
        cb_userapp_levelakses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-pilih-", "operator", "superadmin" }));

        txt_idPengguna.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_idPengguna.setText("..........");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Blokir akses * :");

        buttonGroup_blokAkses.add(rdBlokir_yes);
        rdBlokir_yes.setText("yes");
        rdBlokir_yes.setActionCommand("y");

        buttonGroup_blokAkses.add(rdBlokir_no);
        rdBlokir_no.setText("no");
        rdBlokir_no.setToolTipText("");
        rdBlokir_no.setActionCommand("n");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_idPengguna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_userapp_passwd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_userapp_levelakses, javax.swing.GroupLayout.Alignment.LEADING, 0, 133, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(rdBlokir_yes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdBlokir_no)
                                .addGap(0, 55, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_idPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_userapp_passwd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_userapp_levelakses)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdBlokir_yes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdBlokir_no, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Data karyawan"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nip * : ");

        txt_userapp_nip.setPreferredSize(new java.awt.Dimension(41, 20));
        txt_userapp_nip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_userapp_nipKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Nama pegawai * : ");

        txt_userapp_nmpegawai.setPreferredSize(new java.awt.Dimension(41, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Jabatan * : ");

        cb_userapp_jabatan.setBackground(new java.awt.Color(51, 51, 51));
        cb_userapp_jabatan.setForeground(new java.awt.Color(255, 255, 255));
        cb_userapp_jabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- pilih -", "pelayan", "kepalakoki", "kasir" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cb_userapp_jabatan, 0, 203, Short.MAX_VALUE)
                    .addComponent(txt_userapp_nip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_userapp_nmpegawai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_userapp_nip, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_userapp_nmpegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_userapp_jabatan, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_tambah.setBackground(new java.awt.Color(51, 51, 51));
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_mainmenu.setBackground(new java.awt.Color(51, 51, 51));
        btn_mainmenu.setForeground(new java.awt.Color(255, 255, 255));
        btn_mainmenu.setText("Menu utama");
        btn_mainmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mainmenuActionPerformed(evt);
            }
        });

        btn_ubah.setBackground(new java.awt.Color(51, 51, 51));
        btn_ubah.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(51, 51, 51));
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_mainmenu, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mainmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_mainmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mainmenuActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Kembali ke halaman utama ?", this.getTitle(), JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
        } else if (result == JOptionPane.NO_OPTION) {
            this.setDefaultCloseOperation(Form_crud_userAplikasi.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_btn_mainmenuActionPerformed

    private void JTBL_userappMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBL_userappMouseClicked
        // TODO add your handling code here:
        int row = JTBL_userapp.getSelectedRow();
        valNip = JTBL_userapp.getModel().getValueAt(row, 1).toString();
        valNmPegawai = JTBL_userapp.getModel().getValueAt(row, 2).toString();
        valJabatan = JTBL_userapp.getModel().getValueAt(row, 3).toString();
        valLevel = JTBL_userapp.getModel().getValueAt(row, 4).toString();
        valBlokir = JTBL_userapp.getModel().getValueAt(row, 5).toString();

        cb_userapp_jabatan.setSelectedItem(valJabatan);
        cb_userapp_levelakses.setSelectedItem(valLevel);
        if (valBlokir.equals("n")) {
            rdBlokir_no.setSelected(true);
        } else if (valBlokir.equals("y")) {
            rdBlokir_yes.setSelected(true);
        } else {
            JOptionPane.showMessageDialog(null, "error no valBlokir");
        }

        txt_idPengguna.setText(valNip);
//        System.out.println("row a " + valNip);

        txt_userapp_nmpegawai.setText(valNmPegawai);
    }//GEN-LAST:event_JTBL_userappMouseClicked
    public int clearInput(JTextField val) {
        int a = val.getText().trim().length();
        return a;
    }
    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        boolean go_insert = false;
        if (clearInput(txt_userapp_nip) == 0) {
            JOptionPane.showMessageDialog(null, "txt_userapp_nip kosong");
        } else if (clearInput(txt_userapp_nmpegawai) == 0) {
            JOptionPane.showMessageDialog(null, "txt_userapp_nmpegawai kosong");
        } else if (clearInput(txt_userapp_passwd) == 0) {
            JOptionPane.showMessageDialog(null, "txt_userapp_passwd kosong");
        } else if (cb_userapp_levelakses.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "cb_userapp_levelakses kosong");
        } else if (cb_userapp_jabatan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "cb_userapp_jabatan kosong");
        } else if (buttonGroup_blokAkses.isSelected(null)) {
            JOptionPane.showMessageDialog(null, "buttonGroup_blokAkses kosong");
        } else {
            int check_exists_user = getUserapp_listDB(txt_userapp_nip.getText().trim());
            if (check_exists_user == 0) {
                go_insert = true;
            } else {
                JOptionPane.showMessageDialog(null, txt_userapp_nip.getText().trim() + " sudah ada");
            }
        }
        if (go_insert) {
            insertUserapp_listDB();
            if (notif_ins_userapp) {
                getUserapp_listDB(false,null);
                JOptionPane.showMessageDialog(null, "insert user aplikasi success");
            } else {
                JOptionPane.showMessageDialog(null, "insert user aplikasi failed");
            }
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "ubah");
        int id_user = getUserapp_listDB(valNip);
        update_Userapp_listDB(id_user);
        if (notif_upd_userapp) {
            getUserapp_listDB(false,null);
            JOptionPane.showMessageDialog(this, "update data berhasil ");
        } else {
            JOptionPane.showMessageDialog(this, "update data gagal ");
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Hapus \nnip : " + valNip.trim() + "\n" + valNmPegawai.trim(), this.getTitle(), JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            int id_user = getUserapp_listDB(valNip);

            System.out.println("id user" + this.getName() + valNip);
            deleteUserapp_listDB(id_user);
            if (notif_del_userapp) {
                getUserapp_listDB(false,null);
                JOptionPane.showMessageDialog(this, "hapus data berhasil ");
            } else {
                JOptionPane.showMessageDialog(this, "hapus data gagal ");
            }
        } else if (result == JOptionPane.NO_OPTION) {
            this.setDefaultCloseOperation(Form_crud_userAplikasi.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_userapp_nipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userapp_nipKeyReleased
        // TODO add your handling code here:
        String i_nip = txt_userapp_nip.getText();
        txt_idPengguna.setText(i_nip);
    }//GEN-LAST:event_txt_userapp_nipKeyReleased

    private void txt_pencarian_userKeywordsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pencarian_userKeywordsKeyReleased
        // TODO add your handling code here:
        if (!txt_pencarian_userKeywords.getText().isEmpty() && txt_pencarian_userKeywords.getText().length() > 3) {
            String keywords_userapp = txt_pencarian_userKeywords.getText();
            getUserapp_listDB(true,keywords_userapp);
        }else if(txt_pencarian_userKeywords.getText().isEmpty()){
            getUserapp_listDB(false,null);
        }
    }//GEN-LAST:event_txt_pencarian_userKeywordsKeyReleased

    private void txt_pencarian_userKeywordsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_pencarian_userKeywordsFocusGained
        // TODO add your handling code here:
        txt_pencarian_userKeywords.setText("");
    }//GEN-LAST:event_txt_pencarian_userKeywordsFocusGained

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_crud_userAplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_crud_userAplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_crud_userAplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_crud_userAplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_crud_userAplikasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable JTBL_userapp;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_mainmenu;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    public static javax.swing.ButtonGroup buttonGroup_blokAkses;
    public static javax.swing.JComboBox<String> cb_userapp_jabatan;
    public static javax.swing.JComboBox<String> cb_userapp_levelakses;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JRadioButton rdBlokir_no;
    public static javax.swing.JRadioButton rdBlokir_yes;
    private javax.swing.JLabel txt_idPengguna;
    private javax.swing.JTextField txt_pencarian_userKeywords;
    public static javax.swing.JTextField txt_userapp_nip;
    public static javax.swing.JTextField txt_userapp_nmpegawai;
    public static javax.swing.JPasswordField txt_userapp_passwd;
    // End of variables declaration//GEN-END:variables
}
