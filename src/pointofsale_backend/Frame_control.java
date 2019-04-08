/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_backend;

import Crud.*;
import pointofsale.NotAvailable;
import pointofsale.Popup_pilihan_meja;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class Frame_control extends SetGet{
    
    // method untuk tampil crud user aplikasi
    public static void tampilCrud_UserApp(){
        Form_crud_userAplikasi form_CrudUserApp = new Form_crud_userAplikasi();
        form_CrudUserApp.pack();
        form_CrudUserApp.setLocationRelativeTo(null);
        form_CrudUserApp.setVisible(true);
    }
    
    // method untuk tampil form laporan penjualan
    public static void tampilForm_LapPenjualan(){
        Form_laporan_penjualan form_laporanPenjualan = new Form_laporan_penjualan();
        form_laporanPenjualan.pack();
        form_laporanPenjualan.setLocationRelativeTo(null);
        form_laporanPenjualan.setVisible(true);
    }
    
    // method untuk tampil form bayar
    public static void tampilForm_bayar(){
        Form_bayar_tagihan form_bayar = new Form_bayar_tagihan();
        form_bayar.pack();
        form_bayar.setLocationRelativeTo(null);
        form_bayar.setVisible(true);
    }
    //method untuk tampil popup pilihan meja
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
        form_menu.pack();
        form_menu.setLocationRelativeTo(null);
        form_menu.setVisible(true);
    }
    
    //method untuk tampil form crud menu    
    public static void tampil_formCrudMenu(){
        Form_crud_menu form_crud_menu = new Form_crud_menu();
        //set biar di tengah         
        form_crud_menu.pack();
        form_crud_menu.setLocationRelativeTo(null);
        //munculin framenya
        form_crud_menu.setVisible(true);
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
    
    //method untuk tampil dialog NotAvailable
    public static void tampil_NotAvailable() {
        NotAvailable dialogNotAvailable = new NotAvailable();
        //set biar di tengah         
        dialogNotAvailable.pack();
        dialogNotAvailable.setLocationRelativeTo(null);
        //munculin framenya
        dialogNotAvailable.setVisible(true);
    }
    
}
