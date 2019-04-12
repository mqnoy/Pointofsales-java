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
import static Crud.Form_crud_userAplikasi.JTBL_userapp;
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
    public static void getUserapp_listDB() {
        DefaultTableModel tabmode;
        Object[] baris = {"no", "Nip", "Nama pegawai", "Jabatan", "level", "blokir"};
        tabmode = new DefaultTableModel(null, baris);
        JTBL_userapp.setModel(tabmode);
        try {
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

        } catch (SQLException ex) {
            Logger.getLogger(Form_crud_userAplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /* end of method untuk select data user aplikasi dan data pegawai */

    /*
     * method untuk query select data master menu
     * overloading getMenulistDB()
     * @param var_kdmenu
     * @return ditemukan
     */
    public static void getMenulistDB() {

        DefaultTableModel tabmode = getDatatabel();
//            JTBL_listMenu.setModel(tabmode);
        try {
            //query area
            String sql = "SELECT * from tbl_master_item_menu";
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
    /* end of method untuk select data master menu */

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
            notif_ins_found_menulist=true;
        } else {
            int executeUpdate = ps.executeUpdate();
            if (executeUpdate > 0) {
                notif_ins_menulist = true;
            } else {
                notif_ins_menulist = false;
            }
        }

    }

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
