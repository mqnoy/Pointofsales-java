/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import static Crud.Form_crud_menu.*;
import static Crud.Form_crud_menu.JTBL_listMenu_crud;
import static Crud.Form_list_menu.JTBL_listMenu;
import Crud.Form_crud_userAplikasi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static Crud.Form_crud_userAplikasi.*;
import static Crud.Form_order.lbl_kodeOrder;
import static Crud.Form_order.lbl_kodeOrder_detail;
import static pointofsale_backend.Library.strTo_MD5;
import static pointofsale_backend.Library.tanggalan;
import static pointofsale_backend.Library.lib_tanggalwaktu;
import static pointofsale_backend.SetGet.*;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class CrudModel extends ConfigDatabase {

    private static final Connection conn = new ConfigDatabase().connect();
    public static JTable tableName;

    /*
     * method untuk query select all data 
     */
    public static ResultSet SQLselectAll(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet data = stmt.executeQuery(query);
        return data;
    }

    /* end of method untuk query select all data  */

    //--------------------------------------------------------------------------
    /*
     * method untuk query select meja order berdasarkan id/nomor meja yg didefinisi 
     * di halaman utama
     * @param id_orderMeja
     * @return kd_meja
     */
    public static String getMeja_kode(int id_orderMeja) throws SQLException {
        String sql = "SELECT * FROM tbl_master_meja WHERE id_meja=?";
        String kd_meja = "", ktg_meja = "";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id_orderMeja);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            kd_meja = rs.getString("kd_meja");
            ktg_meja = rs.getString("kategori_meja");
            setId_meja(rs.getInt("id_meja"));
        }
        return kd_meja;
    }

    /* end of method query select meja order */

 /*
     * method untuk query select user akses aplikasi 
     */
    public static void getUserapp_accessDB(String idaccess, String password) throws SQLException {
        String sql = "SELECT * FROM tbl_master_user_application WHERE idaccess=? AND password=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, idaccess);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String is_blocked = rs.getString("blokir");

            if (is_blocked.equals("y")) {
                System.out.println("akun di blokir !");
                strError_code = "error800";
            } else {
                System.out.println("akun valid ");
                //seter untuk menggunakan aplikasi dengan idakses yang validr
                userApp_idaccess = rs.getString("idaccess");
                userApp_level = rs.getString("level");
                userApp_blokir = rs.getString("blokir");
                giveAccess = true;
            }

        } else {
            System.out.println("id access atau password salah !");
            strError_code = "error801";
        }
    }

    /* end of method untuk query select all data  */

 /*
     * method untuk select data user aplikasi dan data pegawai
     */
    public static void getUserapp_listDB() throws SQLException {
        DefaultTableModel tabmode;
        Object[] baris = {"no", "Nip", "Nama pegawai", "Jabatan", "level", "blokir"};
        tabmode = new DefaultTableModel(null, baris);
        JTBL_userapp.setModel(tabmode);
            //query area
            String sql = "SELECT msp.pegawai_nama ,msp.pegawai_nip ,msp.pegawai_jabatan ,mup.level,mup.blokir from tbl_master_pegawai msp LEFT JOIN tbl_master_user_application mup on msp.user_id=mup.id_user";
            ResultSet hasil = SQLselectAll(sql);
            int NUMBERS = 1;
            while (hasil.next()) {
                String col1 = hasil.getString("msp.pegawai_nip");
                String col2 = hasil.getString("msp.pegawai_nama");
                String col3 = hasil.getString("msp.pegawai_jabatan");
                String col4 = hasil.getString("mup.level");
                String col5 = hasil.getString("mup.blokir");
                Object[] data = {NUMBERS, col1, col2, col3, col4, col5};
                tabmode.addRow(data);
                NUMBERS++;
            }

        
    }

    /* end of method untuk select data user aplikasi dan data pegawai */

    /*
     * method untuk insert user aplikasi dan data pegawai
     */
    public static void insertUserapp_listDB() throws SQLException {
        boolean check_kdmenu;
        int last_insert_id,id_user_app;
        tanggalan();
        String str_blokir = buttonGroup_blokAkses.getSelection().getActionCommand();
                
        //make password makePassword(var pass)
        String val_paswd_userapp = strTo_MD5(new String(txt_userapp_passwd.getPassword()));
        
        String sql = "INSERT INTO tbl_master_user_application (idaccess, password, level, blokir, date_registered) VALUES (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, txt_userapp_nip.getText());
        ps.setString(2, val_paswd_userapp);
        ps.setString(3, cb_userapp_levelakses.getSelectedItem().toString());
        ps.setString(4, str_blokir);
        ps.setString(5, lib_tanggalwaktu);

        int executeIns_userapp_user = ps.executeUpdate();
        if (executeIns_userapp_user > 0 ) {
            id_user_app = getUserapp_listDB(txt_userapp_nip.getText());

            String sql2="INSERT INTO tbl_master_pegawai (pegawai_nip, pegawai_nama, pegawai_jabatan,user_id ) VALUES (?, ?, ?, ?)";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, txt_userapp_nip.getText());
            ps2.setString(2, txt_userapp_nmpegawai.getText());
            ps2.setString(3, cb_userapp_jabatan.getSelectedItem().toString());
            ps2.setInt(4, id_user_app);
            
            int executeIns_userapp_pegawai = ps2.executeUpdate() ;
            boolean ano =  executeIns_userapp_pegawai  > 0 ? true : false;
            
            notif_ins_userapp = ano;
        } else {
            notif_ins_userapp = false;
        }
    }
    public static int getUserapp_listDB(String var_idaccess) throws SQLException {
        int val_id_userapp = 0;
        String sql = "SELECT id_user FROM tbl_master_user_application WHERE idaccess=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, var_idaccess);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            val_id_userapp = rs.getInt("id_user");
        }
        return val_id_userapp;
    }
    

    /* end of method untuk insert data user aplikasi dan data pegawai */


 /*
     * method untuk query select data master menu
     * overloading getMenulistDB() - check kd_me duplicate or not
     * @param var_kdmenu
     * @return ditemukan
     */
    public static void getMenulistDB() {

        DefaultTableModel tabmode = getDatatabel();
//            JTBL_listMenu.setModel(tabmode);
        try {
            //query area
            String sql = "SELECT * from tbl_master_item_menu WHERE hide_menu='n'";
            ResultSet hasil = SQLselectAll(sql);
            int NUMBERS = 1;
            while (hasil.next()) {
                String col1 = hasil.getString("kd_menu");
                String col2 = hasil.getString("item_menu_nama");
                String col3 = hasil.getString("menu_kategory");
                String col4 = hasil.getString("item_menu_harga");
                Object[] data = {NUMBERS, col1, col2, col3, col4};
                tabmode.addRow(data);
                NUMBERS++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Form_crud_userAplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean getMenulistDB(String var_kdmenu) throws SQLException {
        boolean ditemukan = false;
        String sql = "SELECT kd_menu FROM tbl_master_item_menu WHERE kd_menu=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, var_kdmenu);
        //ResultSet rs = ps.getGeneratedKeys();
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            ditemukan = true;
        } else {
            ditemukan = false;
        }
        return ditemukan;
    }

    public static int getMenulistDB(boolean bool_getidmenu, String var_kdmenu) throws SQLException {
        int val_id_item_menu = 0;
        String sql = "SELECT id_item_menu FROM tbl_master_item_menu WHERE kd_menu=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, var_kdmenu);
        //ResultSet rs = ps.getGeneratedKeys();
        ResultSet rs = ps.executeQuery();
        if (rs.next() && bool_getidmenu) {
            val_id_item_menu = rs.getInt("id_item_menu");
        }
        return val_id_item_menu;
    }

    /* end of method untuk select data master menu */

 /*
     * method untuk insert data menu
     */
    public static void insert_MenulistDB() throws SQLException {
        boolean check_kdmenu;
        String sql = "INSERT INTO tbl_master_item_menu (item_menu_nama,item_menu_harga,kd_menu,menu_kategory) VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, txt_menunama.getText());
        ps.setDouble(2, Double.parseDouble(txt_menuharga.getText()));
        ps.setString(3, txt_menukode.getText());
        ps.setString(4, cb_menukategory.getSelectedItem().toString());

        check_kdmenu = getMenulistDB(txt_menukode.getText());
        if (check_kdmenu) {
            notif_ins_found_menulist = true;
        } else {
            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notif_ins_menulist = true;
            } else {
                notif_ins_menulist = false;
            }
        }
    }

    /* end of method untuk insert data menu */

 /*
     * method untuk ubah data menu
     */
    public static void update_MenulistDB(String var_kd_menu) throws SQLException {
        int val_menuid = getMenulistDB(true, var_kd_menu);
        String sql = "UPDATE tbl_master_item_menu SET item_menu_nama=?,item_menu_harga=?,kd_menu=?,menu_kategory=? WHERE id_item_menu=" + val_menuid;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, txt_menunama.getText());
        ps.setDouble(2, Double.parseDouble(txt_menuharga.getText()));
        ps.setString(3, txt_menukode.getText());
        ps.setString(4, cb_menukategory.getSelectedItem().toString());

        int executeUpdate = ps.executeUpdate();
        if (executeUpdate > 0) {
            notif_updt_menulist = true;
        } else {
            notif_updt_menulist = false;
        }
    }

    /* end of method untuk ubah data menu */

 /*
     * method untuk hapus 1 data menu
     */
    public static void delete_MenulistDB(String var_kd_menu) throws SQLException {
        int val_menuid = getMenulistDB(true, var_kd_menu);
        String sql = "UPDATE tbl_master_item_menu SET hide_menu='y' WHERE id_item_menu=" + val_menuid;
        PreparedStatement ps = conn.prepareStatement(sql);

        int executeUpdate = ps.executeUpdate();
        if (executeUpdate > 0) {
            notif_del_menulist = true;
        } else {
            notif_del_menulist = false;
        }
    }

    /* end of method untuk hapus 1 data menu */
    
    /*
<<<<<<< HEAD
     * method untuk insert data ke table tbl_order_customer
     */
    public static void insert_OrderCustomer() throws SQLException {
        String sql = "INSERT INTO tbl_order_customer (kd_order, detail_order_kd, meja_id, tanggal_transaksi) VALUES (?,?,?,?)";
        String query_insert_detail_order = "INSERT INTO tbl_detail_order_customer (kd_detail_order, item_menu_id, qty, subtotal) VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, mejaOrder_kdOrder);
        ps.setString(2, mejaOrder_kdOrder_detail);
        ps.setInt(3, mejaOrder_idMeja);
        ps.setString(4, lib_tanggalwaktu);
        
        int executeUpdate = ps.executeUpdate();
        if (executeUpdate > 0) {
            PreparedStatement ps2 = conn.prepareStatement(query_insert_detail_order);
            ps2.setString(1, mejaOrder_kdOrder_detail);
            ps2.setInt(2, 0);
            ps2.setInt(3, 0);
            ps2.setDouble(4, 0);
            
            int executeUpdate2 = ps2.executeUpdate();
            notif_ins_order_customer = executeUpdate2 > 0 ? true:false;
        } else {
            notif_ins_order_customer = false;
        }
    }

    /* end of method untuk insert data ke table tbl_order_customer */
    
    /*
     * method untuk delete data ke table tbl_order_customer
     */
    public static void delete_OrderCustomer() throws SQLException {
        String sql = "DELETE FROM tbl_order_customer WHERE kd_order=? ";
        String query_delete_detail_order = "DELETE FROM tbl_detail_order_customer WHERE kd_detail_order=? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, lbl_kodeOrder.getText());

        int executeUpdate = ps.executeUpdate();
        if (executeUpdate > 0) {
            PreparedStatement ps2 = conn.prepareStatement(query_delete_detail_order);
            ps2.setString(1, lbl_kodeOrder_detail.getText());
            int executeUpdate2 = ps.executeUpdate();
            notif_del_order_customer = executeUpdate2 > 0 ? true:false;
        } else {
            notif_del_order_customer = false;
        }
    }

    /* end of method delete insert data ke table tbl_order_customer */
      /*

 SELECT *
 from tbl_order_customer tb_ordercust
 INNER join tbl_master_meja tb_meja
 ON tb_ordercust.meja_kd = tb_meja.kd_meja



 */  
    /*
     * here for check ketersediaan meja 
    */
    public static boolean select_checkAvailibleMeja(int var_idmeja) throws SQLException{
        boolean return_str = false;
        String query = "SELECT * FROM tbl_order_customer tb_ordercust LEFT JOIN tbl_master_meja tb_meja on tb_ordercust.meja_id=tb_meja.id_meja WHERE tb_ordercust.meja_id="+var_idmeja+" AND tb_ordercust.sedang_dipakai='n'";
        Statement stmt = conn.createStatement();
        ResultSet data = stmt.executeQuery(query);
        if (data.next()) {
            mejaOrder_idMeja =  data.getInt("id_meja");
            mejaOrder_kdOrder = data.getString("tb_ordercust.kd_order");
            mejaOrder_kdOrder_detail = data.getString("tb_ordercust.detail_order_kd");
            mejaOrder_kdMeja = data.getString("tb_meja.kd_meja");
            return_str = true;
        }else {
            return_str = false;
        }
        return return_str;
    }
    /*end of here for check ketersediaan meja  */


    /*
=======
>>>>>>> parent of 349bfe7... working kode order and detail kode order insert method @bug when no record
     * here for interact to library (SELECT * FROM `tbl_order_customer` order by id_order_cust DESC limit 1)
    */
    public static boolean select_lastOrderId() throws SQLException{
        boolean return_str = false;
        String query = "SELECT id_order_cust FROM tbl_order_customer  order by id_order_cust DESC limit 1";
        Statement stmt = conn.createStatement();
        ResultSet data = stmt.executeQuery(query);
        if (data.next()) {
            idorderDB =  data.getInt("id_order_cust");
            return_str = true;
        }else {
            return_str = false;
        }
        return return_str;
    }
    /*end of here for interact to library*/

    //--------------------------------------------------------------------------
    /*
     * method untuk mengambil dan mencocokan variabel JTable
     */
    public static DefaultTableModel getDatatabel() {

        DefaultTableModel tabmode = null;
        if (tableName.equals(JTBL_listMenu)) {
            Object[] baris = {"No", "kd menu", "Nama menu", "kategory menu", "harga(Rp)"};
            tabmode = new DefaultTableModel(null, baris);
            JTBL_listMenu.setModel(tabmode);

        } else if (tableName.equals(JTBL_listMenu_crud)) {
            Object[] baris = {"No", "kd menu", "Nama menu", "kategory menu", "harga(Rp)"};
            tabmode = new DefaultTableModel(null, baris);
            JTBL_listMenu_crud.setModel(tabmode);

        }
        return tabmode;
    }

}

/*

 SELECT *
 from tbl_order_customer tb_ordercust
 INNER join tbl_master_meja tb_meja
 ON tb_ordercust.meja_kd = tb_meja.kd_meja



 */
