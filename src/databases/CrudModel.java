/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import Crud.Form_crud_userAplikasi;
import static Crud.Form_crud_userAplikasi.JTBL_userapp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class CrudModel extends ConfigDatabase {
    
    /*
    * method untuk select data user aplikasi dan data pegawai
    */
    public static void getUserapp_listDB() {
            DefaultTableModel tabmode;
            Object[] baris = {"no","Nip", "Nama pegawai", "level", "blokir"};
            tabmode = new DefaultTableModel(null, baris);
            JTBL_userapp.setModel(tabmode);
        try {    
            //query area
            String sql ="SELECT msp.pegawai_nama ,msp.pegawai_nip ,mup.level,mup.blokir from tbl_master_pegawai msp LEFT JOIN tbl_master_user_application mup on msp.user_id=mup.id_user";
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ResultSet hasil = ps.executeQuery();
            int NUMBERS = 1;
            while (hasil.next()) {
                String col1 = hasil.getString("msp.pegawai_nip");
                String col2 = hasil.getString("msp.pegawai_nama");
                String col3 = hasil.getString("mup.level");
                String col4 = hasil.getString("mup.blokir");
                Object[] data = {NUMBERS,col1, col2, col3 ,col4};
                tabmode.addRow(data);
                NUMBERS++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Form_crud_userAplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*

 SELECT *
 from tbl_order_customer tb_ordercust
 INNER join tbl_master_meja tb_meja
 ON tb_ordercust.meja_kd = tb_meja.kd_meja



 */
