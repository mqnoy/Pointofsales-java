/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_backend;

import Crud.*;
import pointofsale.Popup_pilihan_meja;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class Frame_control extends SetGet{
    
    
    //method untuk tampil form cari tagihan
    public static void tampil_Popup_pilMeja() {
        Popup_pilihan_meja PopupPilMeja = new Popup_pilihan_meja();
        //set biar di tengah         
        PopupPilMeja.pack();
        PopupPilMeja.setLocationRelativeTo(null);
        //munculin framenya
        PopupPilMeja.setVisible(true);
    }
    
    //method untuk tampil form cari tagihan
    public static void tampil_formOrder() {
        Form_order form_menu = new Form_order();
        System.out.println("tanggalan=" + tanggalSkrg);
//        Library pustaka = new Library();
//        pustaka.generateOrder(tanggalSkrg, noMeja);//generate no order
//        SetGet.no_Order = pustaka.orderCode;

//        form_menu.setNo_order(no_Order);
        form_menu.setNo_meja(noMeja);
//        System.out.println("no meja @form order="+noMeja);
        System.out.println("no meja @form order="+noMeja);
        form_menu.setVisible(true);
    }
    
    //method untuk tampil form cari tagihan    
    public static void tampil_formCrtagihan(){
        Form_cari_tagihan form_cr_tagihan = new Form_cari_tagihan();
        //set biar di tengah         
        form_cr_tagihan.pack();
        form_cr_tagihan.setLocationRelativeTo(null);
        //munculin framenya
        form_cr_tagihan.setVisible(true);
    }
    
    //method untuk tampil list menu
    public static void tampil_form_list_menu() {
        Form_list_menu form_list_menu = new Form_list_menu();
        //set biar di tengah         
        form_list_menu.pack();
        form_list_menu.setLocationRelativeTo(null);
        //munculin framenya
        form_list_menu.setVisible(true);
    }
}
