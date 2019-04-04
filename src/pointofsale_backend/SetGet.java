/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_backend;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class SetGet {

    public static Integer noMeja;
    public static String tanggalSkrg;
    public static String orderCode;
    public static String no_Order;
//    public static Integer kdmeja;
//    public static Integer kdmeja;
//    public static Integer kdmeja;

    //constructor
    public static void SetGet() {
        Library pustaka = new Library();
        pustaka.tanggalan();//generate tanggal sekarang 
        SetGet.tanggalSkrg = pustaka.tanggalwaktu;
    }
    /*
    * method setter atribut
    *
    */
    /*
    * @param noMeja 
    */ 
    public static void setNoMeja(Integer noMeja) {
        SetGet.noMeja = noMeja;
        System.out.println("no meja @setNoMeja()" +noMeja);
    }
    /* end of method set atribut    */
    
    /*
    * method getter atribut
    *
    */
//    public static Integer getNoMeja() {
//        return noMeja;
//    }
    /*  end of method set atribut    */
    
    

}
