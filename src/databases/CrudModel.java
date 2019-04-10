/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import static Crud.Form_crud_userAplikasi.JTBL_userapp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class CrudModel extends ConfigDatabase {

//    public CrudModel() throws SQLException {
//        try {
//            beginCon();
//        } catch (SQLException ex) {
//            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    /*public static void getUserapp_listDB2() {
        
     //set datatable meta
            
            
     try {
            
            
     PreparedStatement ps = getConnection().prepareStatement(sql);
     ResultSet records = ps.executeQuery();
     while (records.next()) {
     //                System.out.println(records.getString("id_user") + "  " + records.getString("idaccess") + "  " + records.getString("level"));
     modelTbl_userapp.addRow(new Object[]{records.getString("id_user"),records.getString("idaccess"),records.getString("level")});
     }
     JTBL_userapp.setModel(tablemodel);
     } catch (SQLException ex) {
     Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
     }
        
     }*/
    public static void getUserapp_listDB() throws SQLException {
        //query area
        String sql = "SELECT * FROM tbl_master_user_application";
        try {
            Statement st = getConnection().createStatement();
            ResultSet hasil = st.executeQuery(sql);
            while (hasil.next()) {
                System.out.println(hasil.getString("id_user") + "  " + hasil.getString("idaccess") + "  " + hasil.getString("level"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        try {
            beginCon();
            getUserapp_listDB();
        } catch (SQLException ex) {
            Logger.getLogger(ConfigDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

/*

 SELECT *
 from tbl_order_customer tb_ordercust
 INNER join tbl_master_meja tb_meja
 ON tb_ordercust.meja_kd = tb_meja.kd_meja



 */
