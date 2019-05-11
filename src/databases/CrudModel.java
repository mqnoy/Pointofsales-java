/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import static Crud.Form_bayar_tagihan.JTBL_bayar_tagihan;
import static Crud.Form_crud_menu.*;
import static Crud.Form_crud_menu.JTBL_listMenu_crud;
import static Crud.Form_list_menu.JTBL_listMenu;
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
import static Crud.Form_list_menu.JTBL_draft_order;
import static Crud.Form_order.JTBL_form_order;
import static pointofsale_backend.Library.generateOrder;
import static pointofsale_backend.Library.tanggalan;
import static pointofsale_backend.Library.lib_tanggalwaktu;
import static pointofsale_backend.Library.strTo_MD5;
import static pointofsale_backend.SetGet.*;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class CrudModel extends ConfigDatabase {

    protected static final Connection conn = new ConfigDatabase().connect();
    //public static JTable tableName;
    public static Connection getConn(){
        return conn;
    }
    /*
     * method untuk query select all data 
     */
    public static ResultSet SQLselectAll(String query) {
        ResultSet data = null;

        try {
            Statement stmt = conn.createStatement();
            data = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;

    }

    /* end of method untuk query select all data  */
    //--------------------------------------------------------------------------
    /*
     * method untuk query select meja order berdasarkan id/nomor meja yg didefinisi 
     * di halaman utama
     * @param idmeja
     * @return kd_meja
     */
    public static String getMeja_kode(int idmeja) throws SQLException {
        String sql = "SELECT * FROM tbl_master_meja WHERE id_meja=?";
        String kd_meja = "", ktg_meja = "";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idmeja);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            kd_meja = rs.getString("kd_meja");
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
    public static void getUserapp_listDB() {
        DefaultTableModel tabmode;
        Object[] baris = {"no", "Nip", "Nama pegawai", "Jabatan", "level", "blokir"};
        tabmode = new DefaultTableModel(null, baris);
        JTBL_userapp.setModel(tabmode);
        //query area
        String sql = "SELECT msp.pegawai_nama ,msp.pegawai_nip ,msp.pegawai_jabatan ,mup.level,mup.blokir from tbl_master_pegawai msp LEFT JOIN tbl_master_user_application mup on msp.user_id=mup.id_user";
        ResultSet hasil = SQLselectAll(sql);
        try {

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
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* end of method untuk select data user aplikasi dan data pegawai */

 /*
     * method untuk insert user aplikasi dan data pegawai
     */
    public static void insertUserapp_listDB() {
        boolean check_kdmenu;
        int last_insert_id, id_user_app;
        tanggalan();
        String str_blokir = buttonGroup_blokAkses.getSelection().getActionCommand();
        //make password makePassword(var pass)
        String val_paswd_userapp = strTo_MD5(new String(txt_userapp_passwd.getPassword()));
        String sql = "INSERT INTO tbl_master_user_application (idaccess, password, level, blokir, date_registered) VALUES (?,?,?,?,?)";
        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txt_userapp_nip.getText());
            ps.setString(2, val_paswd_userapp);
            ps.setString(3, cb_userapp_levelakses.getSelectedItem().toString());
            ps.setString(4, str_blokir);
            ps.setString(5, lib_tanggalwaktu);
            int executeIns_userapp_user = ps.executeUpdate();
            if (executeIns_userapp_user > 0) {
                id_user_app = getUserapp_listDB(txt_userapp_nip.getText());

                String sql2 = "INSERT INTO tbl_master_pegawai (pegawai_nip, pegawai_nama, pegawai_jabatan,user_id ) VALUES (?, ?, ?, ?)";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, txt_userapp_nip.getText());
                ps2.setString(2, txt_userapp_nmpegawai.getText());
                ps2.setString(3, cb_userapp_jabatan.getSelectedItem().toString());
                ps2.setInt(4, id_user_app);

                int executeIns_userapp_pegawai = ps2.executeUpdate();
                boolean ano = executeIns_userapp_pegawai > 0 ? true : false;

                notif_ins_userapp = ano;
            } else {
                notif_ins_userapp = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* end of method untuk insert data user aplikasi dan data pegawai */

 /*
     * method untuk delete user aplikasi dan data pegawai
     */
    public static void deleteUserapp_listDB(int id_user) {
        String query_del_userapp = "DELETE FROM tbl_master_user_application INNER JOIN tbl_master_pegawai ON tbl_master_user_application.id_user = tbl_master_pegawai.user_id WHERE tbl_master_user_application.id_user = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query_del_userapp);
            ps.setInt(1, id_user);
            int executeDel_userapp_user = ps.executeUpdate();
            System.out.println("id user = " + id_user);
            System.out.println(query_del_userapp);
            if (executeDel_userapp_user > 0) {
                notif_del_userapp = true;
            } else {
                notif_del_userapp = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* end of method untuk delete data user aplikasi dan data pegawai */
    public static int getUserapp_listDB(String var_idaccess) {
        int val_id_userapp = 0;
        String sql = "SELECT id_user FROM tbl_master_user_application WHERE idaccess=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, var_idaccess);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                val_id_userapp = rs.getInt("id_user");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val_id_userapp;

    }

    /*
     * method untuk query select data master menu
     * overloading getMenulistDB() - check kd_me duplicate or not
     * @param var_kdmenu
     * @return ditemukan
     */
    public static void getMenulistDB(String var_selected, String var_keywords,JTable table) {
        DefaultTableModel tabmode = getDatatabel(table);
        String sql = null;
        try {
            //JTBL_listMenu.setModel(tabmode);
            if (var_selected != null && var_keywords != null) {
                //query search
                sql = "SELECT * FROM tbl_master_item_menu WHERE item_menu_nama LIKE '%" + var_keywords + "%' AND menu_kategory='" + var_selected + "' AND hide_menu='n'";
            } else {
                //query select smua data menu
                sql = "SELECT * from tbl_master_item_menu WHERE hide_menu='n'";
            }
            System.out.println(sql);

            ResultSet hasil;

            hasil = SQLselectAll(sql);

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
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
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
    public static boolean cek_Kode_orderanMeja(String kd_order) throws SQLException {
        boolean ditemukan;
        String query = "SELECT kd_order FROM tbl_order_customer WHERE kd_order='" + kd_order + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            ditemukan = true;
        } else {
            ditemukan = false;
        }
        return ditemukan;
    }

    public static String getDB_Kode_orderanMeja(String kd_order) throws SQLException {
        String str_kd_order = null;
        String query = "SELECT kd_order FROM tbl_order_customer WHERE kd_order='" + kd_order + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            str_kd_order = rs.getString("kd_order");
        }
        return str_kd_order;
    }

    //jika belum lunas dan kdmeja ditemukan akan tampil kd ordernya
    public static Object[] cek_Status_orderanMeja(String kd_meja) throws SQLException {
        String lunas = "n";
        String db_kd_order = null;
        String db_kd_orderdetail = null;
        int db_rp_total = 0;

        String query = "SELECT c.kd_meja,a.lunas,a.total_tagihan,b.kd_order,b.detail_order_kd FROM tbl_transaksi_pesanan a \n"
                + "LEFT JOIN tbl_order_customer b on a.order_kd = b.kd_order\n"
                + "LEFT JOIN tbl_master_meja c ON b.meja_id = c.id_meja\n"
                + "WHERE c.kd_meja ='" + kd_meja + "' AND a.lunas ='" + lunas + "'";
//        System.out.println(query);
        Statement stmt = conn.createStatement();
        ResultSet data = stmt.executeQuery(query);

        if (data.next()) {
            //ditemukan kode meja dan tidak lunas
            notif_cek_order_tdklunas = true;
            notif_cek_order_mejakode = true;
            db_rp_total = data.getInt("a.total_tagihan");
            db_kd_order = data.getString("b.kd_order");
            db_kd_orderdetail = data.getString("b.detail_order_kd");
            System.out.println("ditemukan : " + db_kd_order);

        } else {
            notif_cek_order_mejakode = false;
            notif_cek_order_tdklunas = false;
            System.out.println("tidak ditemukan");
        }

        Object[] arr_data = {db_kd_order, db_kd_orderdetail, db_rp_total};
        return arr_data;
    }

    /*
     * method untuk insert data transaksi
     */
    public static void insert_OrderCustomer(int mejaid) {
        int computerPOS_id = 1;
        int order_idDB = 0;
        int pegawai_id = 1;
        String bungkus = "n";
        String lunas = "n";
        String kd_order = null;
        String kd_orderdetail = null;
        boolean go_insert = true;

        if (go_insert) {
            try {
                tanggalan();
                kd_order = generateOrder(lib_tanggalwaktu, mejaid, "generate_order");
                kd_orderdetail = generateOrder(lib_tanggalwaktu, mejaid, "generate_detail_order");

                String query_insert_order = "INSERT INTO tbl_order_customer (kd_order, detail_order_kd, meja_id, tanggal_order) VALUES (?,?,?,?)";
                String query_insert_transaksi = "INSERT INTO tbl_transaksi_pesanan (order_kd, total_tagihan, nominal_pembayaran, kembalian, payment_type_id, lunas, bungkus, pos_computer_id, id_pegawai, tgl_pembayaran) VALUES (?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(query_insert_order);
                ps.setString(1, kd_order);
                ps.setString(2, kd_orderdetail);
                ps.setInt(3, mejaid);
                ps.setString(4, lib_tanggalwaktu);

                PreparedStatement ps3 = conn.prepareStatement(query_insert_transaksi);
                ps3.setString(1, kd_order);//order_kd
                ps3.setInt(2, 0);//total_tagihan
                ps3.setInt(3, 0);//nominal_pembayaran
                ps3.setInt(4, 0);//kembalian
                ps3.setInt(5, -1);//payment_type_id
                ps3.setString(6, lunas);//lunas
                ps3.setString(7, bungkus);//bungkus
                ps3.setInt(8, computerPOS_id);//pos_computer_id
                ps3.setInt(9, pegawai_id);//id_pegawai
                ps3.setString(10, null);//null karna belum ada pesanan

                int executeUpdate = ps.executeUpdate();
                //int executeUpdate2 = ps2.executeUpdate();

                int executeUpdate3 = ps3.executeUpdate();

                if (executeUpdate > 0 && executeUpdate3 > 0) {
                    notif_ins_order_customer = true;
                    System.out.println("insert data transaksi sukses");
                } else {
                    notif_ins_order_customer = false;
                    System.out.println("insert data transaksi gagal");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /* end of method untuk insert data transaksi */
 /* end of method untuk insert data transaksi */
    private static Integer get_id_menu(String kd_menu) {
        int id_menu = 0;
        String query_select_menu = "SELECT id_item_menu from tbl_master_item_menu WHERE kd_menu='" + kd_menu + "'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query_select_menu);
            if (rs.next()) {
                id_menu = rs.getInt("id_item_menu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_menu;
    }

    public static void insert_OrderCustomer_menu(String kd_orderdetail) {
        int tot_draft_orderMenu = JTBL_draft_order.getRowCount();

        String query_insert_detail_order = "INSERT into tbl_detail_order_customer (kd_detail_order,item_menu_id,qty) VALUES (?,?,?)";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps2 = conn.prepareStatement(query_insert_detail_order);

            for (int row = 0; row < tot_draft_orderMenu; row++) {
                //"no", "kode menu", "qty", "subtotall"

                String str_kdmenu = (String) JTBL_draft_order.getValueAt(row, 1);
                Integer int_qty = (Integer) JTBL_draft_order.getValueAt(row, 2);
                int int_kdmenu = get_id_menu(str_kdmenu);

                ps2.setString(1, kd_orderdetail);
                ps2.setInt(2, int_kdmenu);
                ps2.setInt(3, int_qty);

                ps2.addBatch();
                System.out.println(query_insert_detail_order);
            }
            int[] executeUpdate2 = ps2.executeBatch();
            conn.commit();

            for (int row = 0; row < tot_draft_orderMenu; row++) {
                if (executeUpdate2[row] > 0) {
                    notif_ins_order_customer = true;
                    System.out.println("insert data transaksi sukses");
                } else {
                    notif_ins_order_customer = false;
                    System.out.println("insert data transaksi gagal");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* end of method untuk insert data transaksi */

    public static void select_OrderCustomer_menu(String kd_orderdetail) {
        DefaultTableModel tabmode = getDatatabel(JTBL_form_order);
        String query_select_ordercustomer_menu = "SELECT tdoc.qty,tdoc.id_detail_order,tmim.item_menu_nama,(tdoc.qty * tmim.item_menu_harga) as subtotal FROM tbl_detail_order_customer tdoc \n"
                + "LEFT JOIN tbl_master_item_menu tmim ON tmim.id_item_menu = tdoc.item_menu_id \n"
                + "WHERE tdoc.kd_detail_order='" + kd_orderdetail + "'";
//        System.out.println(query_select_ordercustomer_menu);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query_select_ordercustomer_menu);
            int NUMBERS = 1;
            while (rs.next()) {
                //"no", ,"#id" "nama menu", "qty", "subtotall"
                int a = rs.getInt("tdoc.id_detail_order");
                String b = rs.getString("tmim.item_menu_nama");
                int c = rs.getInt("tdoc.qty");
                int d = rs.getInt("subtotal");
                Object[] data = {NUMBERS, a, b, c ,d};
                tabmode.addRow(data);
                NUMBERS++;
            }
//            System.out.println(query_select_ordercustomer_menu);

        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* end of method untuk insert data transaksi */

 /*
     * method untuk delete data ke table tbl_order_customer
     */
    public static void delete_OrderCustomer(String kd_order, String kd_orderdetail, boolean del_detail) {
        String sql = "DELETE FROM tbl_order_customer WHERE kd_order=? ";
        String query_delete_detail_order = "DELETE FROM tbl_detail_order_customer WHERE kd_detail_order=? ";
        String query_delete_transaksi_order = "DELETE FROM tbl_transaksi_pesanan WHERE order_kd=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kd_order);

            PreparedStatement ps3 = conn.prepareStatement(query_delete_transaksi_order);
            ps3.setString(1, kd_order);
            
            int executeUpdate2 = 0;
            if (del_detail) {
                PreparedStatement ps2 = conn.prepareStatement(query_delete_detail_order);
                ps2.setString(1, kd_orderdetail);
                executeUpdate2 = ps2.executeUpdate();
                System.out.println(query_delete_detail_order);
            }
            int executeUpdate = ps.executeUpdate();
            int executeUpdate3 = ps3.executeUpdate();

            notif_del_order_customer = executeUpdate > 0 && executeUpdate3 > 0; //tidak delete tbl_transaksi_pesanan
            
            if (executeUpdate2 > 0 && del_detail == true){ 
                //delete tbl_transaksi_pesanan
                notif_del_order_customer = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* end of method delete data ke table tbl_order_customer */
 /*
     * method untuk select data untuk daftar pesanan @Form_bayar_tagihan
     */
    public static void select_Daftarpesanan(String kd_order) {
        //get tanggal order
        select_Tanggalpesanan(kd_order);

        DefaultTableModel tabmode = getDatatabel(JTBL_bayar_tagihan);
        String query_select = "SELECT tmim.item_menu_nama,tdoc.qty,(tdoc.qty * tmim.item_menu_harga) as subtotal FROM tbl_order_customer  toc\n"
                + "LEFT JOIN tbl_detail_order_customer tdoc ON tdoc.kd_detail_order = toc.detail_order_kd\n"
                + "LEFT JOIN tbl_master_meja tmj ON tmj.id_meja =  toc.meja_id\n"
                + "LEFT JOIN tbl_master_item_menu tmim ON tmim.id_item_menu = tdoc.item_menu_id\n"
                + "WHERE toc.kd_order = ?";
        //"WHERE toc.kd_order = \"ODR20190428MJ0012\"";
//        System.out.println(query_select);

        try {
            PreparedStatement ps = conn.prepareStatement(query_select);
            ps.setString(1, kd_order);
            ResultSet rs = ps.executeQuery();
            int NUMBERS = 1;
            while (rs.next()) {
                String a = rs.getString("tmim.item_menu_nama");
                int b = rs.getInt("tdoc.qty");
                int c = rs.getInt("subtotal");
                Object[] data = {NUMBERS, a, b, c};
                tabmode.addRow(data);
                NUMBERS++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // method select tanggal order @Form_bayar_tagihan
    public static void select_Tanggalpesanan(String kd_order) {
        String query_select = "SELECT tanggal_order FROM tbl_order_customer WHERE kd_order = ?";
//        System.out.println(query_select);
        try {
            PreparedStatement ps = conn.prepareStatement(query_select);
            ps.setString(1, kd_order);
            ResultSet rs = ps.executeQuery();
            int NUMBERS = 1;
            if (rs.next()) {
                String a = rs.getString("tanggal_order");
                set_tanggalOrder(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //end of method select tanggal order @Form_bayar_tagihan
    /*
     =======
     >>>>>>> parent of 349bfe7... working kode order and detail kode order insert method @bug when no record
     * here for interact to library (SELECT * FROM `tbl_order_customer` order by id_order_cust DESC limit 1)
     */
    public static int select_lastOrderId() throws SQLException {
        int idorderDB = -1;
        String query = "SELECT id_order_cust FROM tbl_order_customer order by id_order_cust DESC limit 1";
        Statement stmt = conn.createStatement();
        ResultSet data = stmt.executeQuery(query);
        if (data.next()) {
            idorderDB = data.getInt("id_order_cust");
        } else {
            idorderDB = -1;
        }
        return idorderDB;
    }

    /*end of here for interact to library*/
    //--------------------------------------------------------------------------
    /*
     * method untuk mengambil dan mencocokan variabel JTable
     */
    public static DefaultTableModel getDatatabel(JTable tableName) {

        DefaultTableModel tabmode = null;
        if (tableName.equals(JTBL_listMenu)) {
            Object[] baris = {"No", "kd menu", "Nama menu", "kategory menu", "harga(Rp)"};
            tabmode = new DefaultTableModel(null, baris);
            JTBL_listMenu.setModel(tabmode);

        } else if (tableName.equals(JTBL_listMenu_crud)) {
            Object[] baris = {"No", "kd menu", "Nama menu", "kategory menu", "harga(Rp)"};
            tabmode = new DefaultTableModel(null, baris);
            JTBL_listMenu_crud.setModel(tabmode);

        } else if (tableName.equals(JTBL_bayar_tagihan)) {
            Object[] baris = {"No", "Nama menu", "qty", "subtotal(Rp)"};
            tabmode = new DefaultTableModel(null, baris);
            JTBL_bayar_tagihan.setModel(tabmode);

        } else if (tableName.equals(JTBL_form_order)) {
            Object[] baris = {"No", "#id" ,"Nama menu", "qty", "subtotal(Rp)"};
            tabmode = new DefaultTableModel(null, baris);
            JTBL_form_order.setModel(tabmode);

        }

        return tabmode;
    }
    
    public static void close(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
