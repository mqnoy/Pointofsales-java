/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class CrudModel extends ConfigDatabase {

    private static String sql;
    private static PreparedStatement ps;
            
    public CrudModel() throws SQLException {
        try {
            beginCon();
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static prepareStatement getUserapp_listDB() {
        try {
            sql = "SELECT * FROM tbl_master_user_application";
            ps = getConnection().prepareStatement(sql);
//            rs = ps.executeQuery();
            
            return ps;
//              while (rs.next()) {
//              System.out.println(rs.getString("id_user") + "  " + rs.getString("idaccess") + "  " + rs.getString("level"));
//              }
        } catch (SQLException ex) {
            Logger.getLogger(CrudModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {
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
