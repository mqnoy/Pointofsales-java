
import databases.CrudModel;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class TestQuery extends CrudModel{
    
    
    public static void main (String [] args){
        String kd_orderdetail = "DTL20190428MJ0012";
        select_OrderCustomer_menu(kd_orderdetail);
    }
    
}
