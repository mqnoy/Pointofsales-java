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

    public String orderCode;
    public String tanggalwaktu;

    public void generateOrder(String dateOrder, Integer noMeja) {
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
        buffer.append(noMeja);

        //System.out.println(buffer.toString()); 
        String codeOrder = buffer.toString();
        this.orderCode = codeOrder;
    }

    public void tanggalan() {
        TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(tz);
        //get current date time with Date()
        Date datetime = new Date();
        Calendar calendar = Calendar.getInstance();
        String strDate = dateFormat.format(datetime);
        //System.out.println(strDate);
        this.tanggalwaktu = strDate;

    }


    public static void main(String[] args) {
        Library lib = new Library();
        lib.tanggalan();
        String datetime = lib.tanggalwaktu;
        Integer nomeja = 1;
        lib.generateOrder(datetime, nomeja);
        byte[] encodedBytes = Base64.getEncoder().withoutPadding().encode("".getBytes());
        System.out.println("encodedBytes " + new String(encodedBytes));
        byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
        System.out.println("decodedBytes " + new String(decodedBytes));
//        System.out.println("currentmilis = " + rand);
    }
}
