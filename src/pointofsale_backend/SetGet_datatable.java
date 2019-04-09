/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_backend;

import static Crud.Form_crud_userAplikasi.JTBL_userapp;
import databases.CrudModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class SetGet_datatable {

    public static DefaultTableModel modelTbl_userapp;

    public static void LoadDataTabel_Userapp() {
        modelTbl_userapp = new DefaultTableModel();
        Object columnData[] = {"id user", "nip", "nama pegawai", "level", "blokir"};
        modelTbl_userapp.setColumnIdentifiers(columnData);
        try {
//            CrudModel CM = new CrudModel();
            ResultSet  hasil = CrudModel.getUserapp_listDB();
            while (hasil.next()) {
                //  System.out.println(rs.getString("id_user") + "  " + rs.getString("idaccess") + "  " + rs.getString("level"));              
                modelTbl_userapp.addRow(new Object[]{
                    hasil.getString("id_user"),
                    hasil.getString("idaccess"),
                    hasil.getString("level")
                });
            }
            JTBL_userapp.setModel(modelTbl_userapp);

        } catch (SQLException ex) {
            Logger.getLogger(SetGet_datatable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
