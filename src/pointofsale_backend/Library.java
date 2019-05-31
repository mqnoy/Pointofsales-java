/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
package pointofsale_backend;

import static databases.CrudModel.conn;
import static databases.CrudModel.getMeja_kode;
import static databases.CrudModel.select_lastOrderId;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class Library {

    public static String lib_tanggalwaktu;
    public static String Jasper_QueryCustom;

    public Library(){
        tanggalan();//generate tanggal sekarang 
        System.out.println("constructors");
    }
    /**
     * 
     * https://stackoverflow.com/questions/3753869/how-do-i-concatenate-two-strings-in-java
     * https://stackoverflow.com/questions/8694984/remove-part-of-string-in-java
     * @param dateOrder
     * @param idMeja
     * @param generateFor
     * @return 
     */
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
    /**
     * method custom jasper/ireport 
     * thx for : https://www.youtube.com/watch?v=kB67jL8-DO0
     * https://stackoverflow.com/questions/24183129/dynamic-sql-query-for-jasper-report
     * error compailing : solved import http://www.java2s.com/example/jar/e/download-ecj431jar-file.html
     * @param reportPath
     * @param query
     */
     public static void generate_CustomReport(String reportPath,String query){
            try{
                JasperDesign jd = JRXmlLoader.load(reportPath);
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(query);
                jd.setQuery(newQuery);
                
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
                JasperViewer.viewReport(jp);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
    }
    public static void set_CustomReportQuery(String Query){
        Jasper_QueryCustom = Query;
    }
    public static String get_CustomReportQuery(){
        return Jasper_QueryCustom;
    }
    
    /**/
    
    /**
    *  method untuk parsing jdatepicker  untuk date di sql
     * @param raw_date
     * @param raw_format
     * @return 
    */
    public static String parsing_Jdate(Date raw_date,String raw_format){
        DateFormat sdf = new SimpleDateFormat(raw_format);
        return sdf.format(raw_date);
    }
    /**/
    
    /**
     * https://www.javatpoint.com/java-date-to-string
     */
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
     * @param var_text
     * @return 
     */
    public static String strTo_MD5(String var_text) {
        return DigestUtils.md5Hex(var_text);
    }
    /* end of method untuk konvert text ke MD5 */
    

    public static void main(String[] args) {
        Library library = new Library();

//        tanggalan();
        String generateOrder = generateOrder(lib_tanggalwaktu, 1,"generate_order");
        System.out.println(generateOrder);
//        System.out.println(strTo_MD5("admin"));
        //    Date tanggalAwal_rpt = rpt_tanggal_awal.getDate();
//        Date tanggalAkhir_rpt = rpt_tanggal_akhir.getDate();
//        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String final_tanggalAwal_rpt = sdf.format(tanggalAwal_rpt);
//        String final_tanggalAkhir_rpt = sdf.format(tanggalAkhir_rpt);
//         Date datetime = new Date();
//        String rawformat = "yyyy-MM-dd 00:00:00";
//        String anuan = parsing_Jdate(datetime,rawformat);
//        System.out.println(lib_tanggalwaktu);
    }

}
