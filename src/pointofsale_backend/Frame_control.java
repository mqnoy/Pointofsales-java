/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_backend;

import Crud.*;
import pointofsale.HalamanLogin;
import pointofsale.HalamanUtama;
import pointofsale.NotAvailable;
import pointofsale.Popup_pilihan_meja;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class Frame_control extends SetGet{
    
    // method untuk tampil halaman login user aplikasi
    public static void tampilLogin_UserApp(){
        HalamanLogin frame_loginApp = new HalamanLogin();
        frame_loginApp.setVisible(true);
    }
    // method untuk tampil halaman utama aplikasi
    public static void tampilhalUtama_UserApp(){
        HalamanUtama frame_halUtama = new HalamanUtama();
        frame_halUtama.setVisible(true);
    }
    
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
    public static void tampilForm_bayar(String kd_meja ,String kd_order, String kd_orderdetail, String rp_tagihan){
        Form_bayar_tagihan form_bayar = new Form_bayar_tagihan();
        form_bayar.lbl_bt_kdMeja.setText(kd_meja);
        form_bayar.lbl_bt_kodeOrder.setText(kd_order);
        form_bayar.lbl_bt_rpTagihan.setText(rp_tagihan);
        form_bayar.pack();
        form_bayar.setLocationRelativeTo(null);
        form_bayar.setVisible(true);
    }
    //method untuk tampil popup pilihan meja
    public static void tampil_Popup_pilMeja(String kd_meja ,String kd_order, String kd_orderdetail, String rp_tagihan , String set_text_tombol,boolean set_tombol_bayar) {
        Popup_pilihan_meja PopupPilMeja = new Popup_pilihan_meja();
        PopupPilMeja.lbl_ppm_kdmeja.setText(kd_meja);        
        PopupPilMeja.lbl_ppm_kode_order.setText(kd_order);
        PopupPilMeja.lbl_ppm_kode_orderdetail.setText(kd_orderdetail);
        PopupPilMeja.lbl_ppm_rp_total.setText(rp_tagihan);
        PopupPilMeja.btn_ppm_Order.setText(set_text_tombol);
        PopupPilMeja.btn_ppm_Bayar.setEnabled(set_tombol_bayar);
        //set biar di tengah         
        //PopupPilMeja.pack();
        //PopupPilMeja.setLocationRelativeTo(null);
        //munculin framenya
        PopupPilMeja.setVisible(true);
    }
    public static void tutup_Popup_pilMeja(){
        Popup_pilihan_meja PopupPilMeja = new Popup_pilihan_meja();
        PopupPilMeja.setVisible(false);
    }
    
    //method untuk tampil form cari tagihan
    public static void tampil_formOrder(String kd_meja ,String kd_order,String kd_orderdetail,String rp_total) {
        Form_order form_order = new Form_order();
        System.out.println("tanggalan=" + tanggalSkrg);
        form_order.lbl_kodemeja.setText(kd_meja);        
        form_order.lbl_kodeOrder.setText(kd_order);
        form_order.lbl_kodeOrder_detail.setText(kd_orderdetail);
        form_order.lbl_total_rp_order.setText(rp_total);

        System.out.println("no meja @form order="+kd_meja);
        System.out.println("no meja @form order="+kd_order);
        form_order.pack();
        form_order.setLocationRelativeTo(null);
        form_order.setVisible(true);
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
