/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * https://stackoverflow.com/questions/3753869/how-do-i-concatenate-two-strings-in-java
 * https://stackoverflow.com/questions/8694984/remove-part-of-string-in-java
 * https://www.javatpoint.com/java-date-to-string
 */
package pointofsale_backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class Library {

    public static String KodeOrder;
    public static String tanggalwaktu;
    
//    public Library(){
//        tanggalan();//generate tanggal sekarang 
//    }
    
    public static void generateOrder(String dateOrder, Integer idMeja) {
        String orderPrefix = "ODR";
        String digitMeja = "";
        String[] arrOfStr = dateOrder.split(" ", -2);
        String raw_dateOrder = arrOfStr[0].replace("-", "");
        String raw_timeOrder = arrOfStr[1].replace(":", "");
        int nilai_detik;
        Calendar calendar = Calendar.getInstance();
        nilai_detik = calendar.get(Calendar.SECOND);
        StringBuilder buffer = new StringBuilder();
        buffer.append(orderPrefix);
        buffer.append(raw_dateOrder.substring(2));
        buffer.append(nilai_detik);
        buffer.append(digitMeja);
        buffer.append(idMeja);

        //System.out.println(buffer.toString()); 
        String codeOrder = buffer.toString();
        Library.KodeOrder = codeOrder;
    }

    public static void tanggalan() {
        TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(tz);
        
        //get current date time with Date()
        Date datetime = new Date();
        Calendar calendar = Calendar.getInstance();
        String strDate = dateFormat.format(datetime);
        Library.tanggalwaktu = strDate;

    }


    public static void main(String[] args) {
        tanggalan();
//        Integer val_idMeja = 1;
//        generateOrder(tanggalwaktu, val_idMeja);
        System.out.println(tanggalwaktu);
    }
}
