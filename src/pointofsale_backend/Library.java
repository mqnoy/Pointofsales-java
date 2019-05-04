/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * https://stackoverflow.com/questions/3753869/how-do-i-concatenate-two-strings-in-java
 * https://stackoverflow.com/questions/8694984/remove-part-of-string-in-java
 * https://www.javatpoint.com/java-date-to-string
 */
package pointofsale_backend;

import static databases.CrudModel.getMeja_kode;
import static databases.CrudModel.getUserapp_listDB;
import static databases.CrudModel.select_lastOrderId;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class Library {

    public static String lib_tanggalwaktu;

//    public Library(){
//        tanggalan();//generate tanggal sekarang 
//    }
    public static String generateOrder(String dateOrder, Integer idMeja, String generateFor) {
        int order_idDB = 0;
        String orderPrefix = "", kodeMejaDB = "";
        StringBuilder buffer = new StringBuilder();

        try {
            kodeMejaDB = getMeja_kode(idMeja);

            //ambil dari database select 1 row order desc terus ambil idnya . jika belum ada
            //maka bernilai 1 ,jika ada akan di tambah 1
            int lastOrderid = select_lastOrderId();
            if (lastOrderid != -1) {
                order_idDB = lastOrderid + 1;
            } else {
                order_idDB = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (generateFor.equals("generate_order")) {
            orderPrefix = "ODR";
        } else if (generateFor.equals("generate_detail_order")) {
            orderPrefix = "DTL";
        }
        //2019-04-15 00:42:34
        String[] arrOfStr = dateOrder.split(" ", -2);
        String raw_dateOrder = arrOfStr[0].replace("-", "");
        String raw_timeOrder = arrOfStr[1].replace(":", "");

        //http://www.java2s.com/Code/JavaAPI/java.util/CalendarMILLISECOND.htm
        //int nilai_detik;
        //Calendar calendar = Calendar.getInstance();
        //nilai_detik = calendar.get(Calendar.SECOND);
        //int  nilai_millisecon = calendar.get(Calendar.MILLISECOND);
        buffer.append(orderPrefix);
        buffer.append(raw_dateOrder);
        //buffer.append(nilai_millisecon);//.substring(2)
        buffer.append(kodeMejaDB);
        buffer.append(order_idDB);
        
        String codeOrder = buffer.toString();

        //Library.lib_KodeOrder = codeOrder;
        return codeOrder;

    }

    public static void tanggalan() {
        TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(tz);

        //get current date time with Date()
        Date datetime = new Date();
        Calendar calendar = Calendar.getInstance();
        String strDate = dateFormat.format(datetime);
        Library.lib_tanggalwaktu = strDate;
    }

    /*
     * method untuk konvert text ke MD5
     * thx for  : https://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash
     */
    public static String strTo_MD5(String var_text) {
        return DigestUtils.md5Hex(var_text);
    }
    /* end of method untuk konvert text ke MD5 */
    

    public static void main(String[] args) {
//        tanggalan();
//        String generateOrder = generateOrder(lib_tanggalwaktu, 1,"generate_order");
        System.out.println(strTo_MD5("admin"));

    }

}
