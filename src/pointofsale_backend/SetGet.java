/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_backend;

import javax.swing.JTable;
import static pointofsale_backend.Library.*;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class SetGet {
    //atribut untuk aktifitas order
    public static Integer mejaOrder_idMeja;
    public static String mejaOrder_kdMeja;
    public static String mejaOrder_kdOrder;
    public static String mejaOrder_kdOrder_detail;
    public static Integer idorderDB;

        
    public static String tanggalSkrg;
    public static String no_Order;
    
    //atribut untuk notifikasi query
    public static boolean notif_ins_menulist;
    public static boolean notif_ins_found_menulist;
    public static boolean notif_updt_menulist;
    public static boolean notif_del_menulist;
    
    public static boolean notif_ins_userapp;
    
    //Jtable
    public static JTable Jtablename;

    /*atribut user access aplikasi*/
    public static String userApp_idaccess = null;
    public static String userApp_level = null;
    public static String userApp_blokir = null;
    public static boolean giveAccess = false;
    
    //error definisi
    public static String strError_code = null;

    //constructor
    public static void SetGet() {
               
        
    }
    
    public static void setId_meja(int val_idMeja){
        mejaOrder_idMeja = val_idMeja;
    }
    public static void getKodeOrder(){
        tanggalan();//generate tanggal sekarang 
        generateOrder(lib_tanggalwaktu, mejaOrder_idMeja,"generate_order");
        mejaOrder_kdOrder = lib_KodeOrder;
    }
    public static void getKodeOrder_detail(){
        tanggalan();//generate tanggal sekarang 
        generateOrder(lib_tanggalwaktu, mejaOrder_idMeja,"generate_detail_order");
        mejaOrder_kdOrder_detail = lib_KodeOrder;
    }
    
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
    
    
    /*
     * method getter untuk pencocokan variabel JTable
     *
     */
    public static JTable getTableName() {
        return Jtablename;
    }
    /*  end of method set atribut    */
}
