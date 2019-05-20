/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_backend;

import static databases.CrudModel.cek_Kode_orderanMeja;
import static databases.CrudModel.cek_Status_orderanMeja;
import static databases.CrudModel.getMeja_kode;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class SetGet {
    //atribut untuk aktifitas order
    public static boolean notif_ins_order_customer;
    public static boolean notif_del_order_customer;
    public static boolean notif_cek_order_tdklunas;
    public static boolean notif_cek_order_mejakode;
    public static boolean notif_ins_struk_for_koki;
        
    public static String tanggalSkrg;
    
    //atribut untuk notifikasi query
    public static boolean notif_ins_menulist;
    public static boolean notif_ins_found_menulist;
    public static boolean notif_updt_menulist;
    public static boolean notif_del_menulist;
    
    
    

    /*atribut user access aplikasi*/
    public static String userApp_idaccess = null;
    public static String userApp_level = null;
    public static String userApp_blokir = null;
    public static boolean giveAccess = false;
    
    /*atribut untuk user aplikasi dan pegawai*/
    public static boolean notif_ins_userapp;
    public static boolean notif_del_userapp;
    
    //error definisi
    public static String strError_code = null;

    //constructor
    public static void SetGet() {
               
        
    }
    
    public static String getKodeMeja(int idmeja){
        String kdmeja = null;
        try {
            kdmeja = getMeja_kode(idmeja);
        } catch (SQLException ex) {
            Logger.getLogger(SetGet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kdmeja;
    }
    public static boolean checkExists_kdorder(String kd_order){
        boolean kodeorder_ada = false;
        try {
            kodeorder_ada = cek_Kode_orderanMeja(kd_order);
        } catch (SQLException ex) {
            Logger.getLogger(SetGet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kodeorder_ada;
    }
   
    public static void getStatusMejaorder(String kd_meja){
        try {
            cek_Status_orderanMeja(kd_meja);
        } catch (SQLException ex) {
            Logger.getLogger(SetGet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static String get_existsRow_order(String kd_meja,String str_order){
        String getrow = null;
        try {
            Object[] cek_Status_orderanMeja = cek_Status_orderanMeja(kd_meja);
            if (str_order.equalsIgnoreCase("kode_order")) {
                getrow = cek_Status_orderanMeja[0].toString();
            }else if (str_order.equalsIgnoreCase("kode_orderdetail")) {
                getrow = cek_Status_orderanMeja[1].toString();
            }else if (str_order.equalsIgnoreCase("rp_total")) {
                getrow = cek_Status_orderanMeja[2].toString();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SetGet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getrow;
    }
    
     
    //
    public static String tgl_order;
    public static void set_tanggalOrder(String val_tgl_order){
        SetGet.tgl_order = val_tgl_order;
    }
    public static String get_tanggalOrder(){
        return SetGet.tgl_order;
    }
    
    //
    
    /*
     * method setter atribut login frame
     * alias : logout
     */

    public static void setClean_sesi() {
        userApp_idaccess = null;
        userApp_level = null;
        userApp_blokir = null;
        giveAccess = false;
    }
    /*  end of method logout    */
    
    
    
    /*  end of method set atribut    */
}
