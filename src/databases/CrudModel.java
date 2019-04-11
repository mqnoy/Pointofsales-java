/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

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
    public static ResultSet SQLselectAll(String query) throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet data = stmt.executeQuery(query);
        return data;
    }
    /* end of method untuk query select all data  */
    
    /*
    * method untuk query select user akses aplikasi 
    */
    public static void getUserapp_accessDB(String idaccess,String password) throws SQLException{
        String sql = "SELECT * FROM tbl_master_user_application WHERE idaccess=? AND password=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, idaccess);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            String is_blocked = rs.getString("blokir");
            
            if (is_blocked.equals("y")) {
                System.out.println("akun di blokir !");
                strGive_access ="error800";
            }else{
                System.out.println("akun valid ");
                //seter untuk menggunakan aplikasi dengan idakses yang validr
                userApp_idaccess = rs.getString("idaccess");
                userApp_level=rs.getString("level");
                userApp_blokir=rs.getString("blokir");
                giveAccess=true;
            }
            
        }else{
            System.out.println("id access atau password salah !");
            strGive_access ="error801";
        }
    }
    /* end of method untuk query select all data  */
    
    /*
    * method untuk select data user aplikasi dan data pegawai
    */
    public static void getUserapp_listDB() {
            DefaultTableModel tabmode;
            Object[] baris = {"no","Nip", "Nama pegawai","Jabatan", "level", "blokir"};
            tabmode = new DefaultTableModel(null, baris);
            JTBL_userapp.setModel(tabmode);
        try {    
            //query area
            String sql ="SELECT msp.pegawai_nama ,msp.pegawai_nip ,msp.pegawai_jabatan ,mup.level,mup.blokir from tbl_master_pegawai msp LEFT JOIN tbl_master_user_application mup on msp.user_id=mup.id_user";
            ResultSet hasil = SQLselectAll(sql);
            int NUMBERS = 1;
            while (hasil.next()) {
                String col1 = hasil.getString("msp.pegawai_nip");
                String col2 = hasil.getString("msp.pegawai_nama");
                String col3 = hasil.getString("msp.pegawai_jabatan");
                String col4 = hasil.getString("mup.level");
                String col5 = hasil.getString("mup.blokir");
                Object[] data = {NUMBERS,col1, col2, col3 ,col4,col5};
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
    */
    public static void getMenulistDB() {
            
            DefaultTableModel tabmode = getDatatabel();
//            JTBL_listMenu.setModel(tabmode);
        try {    
            //query area
            String sql ="SELECT * from tbl_master_item_menu";
            ResultSet hasil = SQLselectAll(sql);
            int NUMBERS = 1;
            while (hasil.next()) {
                String col1 = hasil.getString("kd_menu");
                String col2 = hasil.getString("item_menu_nama");
                String col3 = hasil.getString("menu_kategory");
                String col4 = hasil.getString("item_menu_harga");
                Object[] data = {NUMBERS,col1, col2, col3 ,col4};
                tabmode.addRow(data);
                NUMBERS++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Form_crud_userAplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /* end of method untuk select data master menu */
    
    
    public static DefaultTableModel getDatatabel(){
        
        DefaultTableModel tabmode = null;
        if (tableName.equals(JTBL_listMenu)) {
            Object[] baris = {"No", "kd menu", "Nama menu", "kategory menu", "harga(Rp)"};
            tabmode = new DefaultTableModel(null, baris);
            JTBL_listMenu.setModel(tabmode);
            
        } else  if (tableName.equals(JTBL_listMenu_crud)) {
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
