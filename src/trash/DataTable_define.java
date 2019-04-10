/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trash;


/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class DataTable_define {

//    public static DefaultTableModel modelTbl_userapp;

    public static void LoadDataTabel_Userapp() {
        modelTbl_userapp = new DefaultTableModel();
        Object columnData[] = {"id user", "nip", "nama pegawai", "level", "blokir"};
        modelTbl_userapp.setColumnIdentifiers(columnData);
        try {
           getUserapp_listDB();
            
            

        } catch (SQLException ex) {
            Logger.getLogger(DataTable_define.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
