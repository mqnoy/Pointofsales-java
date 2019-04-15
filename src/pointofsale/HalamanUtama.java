/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;
import static databases.CrudModel.getMeja_kode;
import static databases.CrudModel.insert_OrderCustomer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static pointofsale_backend.Frame_control.*;
/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class HalamanUtama extends javax.swing.JFrame {
   
    /**
     * Creates new form CobaLayout
     */
    public HalamanUtama() {
        giveAccess = true;
        if (giveAccess) {
            initComponents();
        }else{
            int result = JOptionPane.showConfirmDialog(this, "anda belum login !", this.getTitle(), JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){               
                    tampilLogin_UserApp();
                }else if (result == JOptionPane.NO_OPTION)   {
                    System.exit(0);
            }
        }
    }
    public static void mulaiOrder(int var_id_meja){
        try {
            mejaOrder_idMeja = var_id_meja;//set id meja order
            mejaOrder_kdMeja = getMeja_kode(mejaOrder_idMeja);//get kode meja order
            getKodeOrder();
            getKodeOrder_detail();
            System.out.println("kode order"+mejaOrder_kdOrder);
            System.out.println("kode detail order "+mejaOrder_kdOrder_detail);
            System.out.println("kdmeja @hal utama = "+mejaOrder_kdMeja);
            //insert data order now
            insert_OrderCustomer();
            tampil_Popup_pilMeja();

        } catch (SQLException ex) {
            Logger.getLogger(HalamanUtama.class.getName()).log(Level.SEVERE, null, ex);
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

        jpanel_header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        layout_meja_dan_menu = new javax.swing.JSplitPane();
        jpanel_meja = new javax.swing.JPanel();
        btn_meja1 = new javax.swing.JButton();
        btn_meja2 = new javax.swing.JButton();
        btn_meja3 = new javax.swing.JButton();
        btn_meja4 = new javax.swing.JButton();
        btn_meja5 = new javax.swing.JButton();
        btn_meja6 = new javax.swing.JButton();
        btn_meja7 = new javax.swing.JButton();
        btn_meja8 = new javax.swing.JButton();
        btn_meja9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jpanel_menu_kanan = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jButton14 = new javax.swing.JButton();
        tbl_keluar_sesi_1 = new javax.swing.JButton();
        layout_footer = new javax.swing.JSplitPane();
        jPanel_footer_kiri = new javax.swing.JPanel();
        jPanel_footer_kanan = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Point Of Sale");
        setName("frame_hal_utama"); // NOI18N
        setResizable(false);

        jpanel_header.setPreferredSize(new java.awt.Dimension(0, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("{name}");

        javax.swing.GroupLayout jpanel_headerLayout = new javax.swing.GroupLayout(jpanel_header);
        jpanel_header.setLayout(jpanel_headerLayout);
        jpanel_headerLayout.setHorizontalGroup(
            jpanel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_headerLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanel_headerLayout.setVerticalGroup(
            jpanel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_headerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        layout_meja_dan_menu.setBorder(null);
        layout_meja_dan_menu.setMinimumSize(new java.awt.Dimension(1024, 436));
        layout_meja_dan_menu.setPreferredSize(new java.awt.Dimension(1024, 436));

        jpanel_meja.setMinimumSize(new java.awt.Dimension(500, 69));
        jpanel_meja.setPreferredSize(new java.awt.Dimension(800, 400));
        jpanel_meja.setLayout(new java.awt.GridLayout(3, 3));

        btn_meja1.setText("MEJA1");
        btn_meja1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_meja1ActionPerformed(evt);
            }
        });
        jpanel_meja.add(btn_meja1);

        btn_meja2.setText("MEJA2");
        btn_meja2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_meja2ActionPerformed(evt);
            }
        });
        jpanel_meja.add(btn_meja2);

        btn_meja3.setText("MEJA3");
        jpanel_meja.add(btn_meja3);

        btn_meja4.setText("MEJA4");
        jpanel_meja.add(btn_meja4);

        btn_meja5.setText("MEJA5");
        jpanel_meja.add(btn_meja5);

        btn_meja6.setText("MEJA6");
        jpanel_meja.add(btn_meja6);

        btn_meja7.setText("MEJA7");
        btn_meja7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_meja7ActionPerformed(evt);
            }
        });
        jpanel_meja.add(btn_meja7);

        btn_meja8.setText("MEJA8");
        jpanel_meja.add(btn_meja8);

        btn_meja9.setText("MEJA9");
        btn_meja9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_meja9ActionPerformed(evt);
            }
        });
        jpanel_meja.add(btn_meja9);

        layout_meja_dan_menu.setLeftComponent(jpanel_meja);

        jPanel2.setPreferredSize(new java.awt.Dimension(200, 472));

        jpanel_menu_kanan.setMinimumSize(new java.awt.Dimension(205, 436));
        jpanel_menu_kanan.setPreferredSize(new java.awt.Dimension(205, 436));

        jButton11.setText("Laporan penjualan");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Manajemen Menu");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("keluar");

        jToggleButton3.setText("keluar");

        jButton14.setText("Manajemen Meja");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        tbl_keluar_sesi_1.setText("keluar");
        tbl_keluar_sesi_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbl_keluar_sesi_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel_menu_kananLayout = new javax.swing.GroupLayout(jpanel_menu_kanan);
        jpanel_menu_kanan.setLayout(jpanel_menu_kananLayout);
        jpanel_menu_kananLayout.setHorizontalGroup(
            jpanel_menu_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_kananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_menu_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_menu_kananLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbl_keluar_sesi_1))
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpanel_menu_kananLayout.setVerticalGroup(
            jpanel_menu_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_kananLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpanel_menu_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3)
                    .addComponent(tbl_keluar_sesi_1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpanel_menu_kanan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpanel_menu_kanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout_meja_dan_menu.setRightComponent(jPanel2);

        layout_footer.setMinimumSize(new java.awt.Dimension(1024, 150));
        layout_footer.setPreferredSize(new java.awt.Dimension(1024, 150));

        jPanel_footer_kiri.setMinimumSize(new java.awt.Dimension(700, 100));
        jPanel_footer_kiri.setPreferredSize(new java.awt.Dimension(700, 174));

        javax.swing.GroupLayout jPanel_footer_kiriLayout = new javax.swing.GroupLayout(jPanel_footer_kiri);
        jPanel_footer_kiri.setLayout(jPanel_footer_kiriLayout);
        jPanel_footer_kiriLayout.setHorizontalGroup(
            jPanel_footer_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel_footer_kiriLayout.setVerticalGroup(
            jPanel_footer_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        layout_footer.setLeftComponent(jPanel_footer_kiri);

        javax.swing.GroupLayout jPanel_footer_kananLayout = new javax.swing.GroupLayout(jPanel_footer_kanan);
        jPanel_footer_kanan.setLayout(jPanel_footer_kananLayout);
        jPanel_footer_kananLayout.setHorizontalGroup(
            jPanel_footer_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );
        jPanel_footer_kananLayout.setVerticalGroup(
            jPanel_footer_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        layout_footer.setRightComponent(jPanel_footer_kanan);

        jMenu2.setText("Bantuan");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu1.setText("Manajemen user");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel_header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addComponent(layout_footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(layout_meja_dan_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpanel_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 497, Short.MAX_VALUE)
                .addComponent(layout_footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(135, Short.MAX_VALUE)
                    .addComponent(layout_meja_dan_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(176, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleName("halaman_utama");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btn_meja9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_meja9ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_meja9ActionPerformed

    private void btn_meja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_meja1ActionPerformed
       mulaiOrder(1);
    }//GEN-LAST:event_btn_meja1ActionPerformed

    private void btn_meja7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_meja7ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_meja7ActionPerformed

    private void btn_meja2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_meja2ActionPerformed
        // TODO add your handling code here:
        mulaiOrder(2);
    }//GEN-LAST:event_btn_meja2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        tampilForm_LapPenjualan();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        tampil_formCrudMenu();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        tampil_NotAvailable();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        tampilCrud_UserApp();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        tampil_NotAvailable();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void tbl_keluar_sesi_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbl_keluar_sesi_1ActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Logout ?", this.getTitle(), JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){               
                    this.dispose();
                    setClean_sesi();//clean atribut value
                    tampilLogin_UserApp();
                }else if (result == JOptionPane.NO_OPTION)   {
                    this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
            }
    }//GEN-LAST:event_tbl_keluar_sesi_1ActionPerformed

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
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalamanUtama().setVisible(true);
                //set biar di tengah         
                
                //munculin framenya
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_meja1;
    private javax.swing.JButton btn_meja2;
    private javax.swing.JButton btn_meja3;
    private javax.swing.JButton btn_meja4;
    private javax.swing.JButton btn_meja5;
    private javax.swing.JButton btn_meja6;
    private javax.swing.JButton btn_meja7;
    private javax.swing.JButton btn_meja8;
    private javax.swing.JButton btn_meja9;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_footer_kanan;
    private javax.swing.JPanel jPanel_footer_kiri;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JPanel jpanel_header;
    private javax.swing.JPanel jpanel_meja;
    private javax.swing.JPanel jpanel_menu_kanan;
    private javax.swing.JSplitPane layout_footer;
    private javax.swing.JSplitPane layout_meja_dan_menu;
    private javax.swing.JButton tbl_keluar_sesi_1;
    // End of variables declaration//GEN-END:variables
}
