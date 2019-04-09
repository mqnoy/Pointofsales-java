/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rifky
 */
public class ConfigDatabase {
    private static String host;
    private static String username;
    private static String password;
    private static String driver;
    private static String database;
    private static Integer port;
    private static String urldb = "";
    
    private static Connection connection;
   
    
    //construktor 
//    public ConfigDatabase() throws SQLException{
//            setConf();
//    };
    
    public static void setConf() {
        ConfigDatabase.host = "localhost";
        ConfigDatabase.username = "root";
        ConfigDatabase.password = "123456";
        ConfigDatabase.driver = "mysql";
        ConfigDatabase.database = "pointofsale";
        ConfigDatabase.port = 3306;
        ConfigDatabase.urldb = "jdbc:"+driver+"://"+ConfigDatabase.host+":"+ConfigDatabase.port+"/"+ConfigDatabase.database;
    }
    
    public static Connection getConnection() {
        return connection;
    }
    
    public static void beginCon() throws SQLException {
        try {
            try {
                setConf();
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConfigDatabase.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("driver problem");
            }
            
            connection = (Connection) DriverManager.getConnection(ConfigDatabase.urldb, ConfigDatabase.username, ConfigDatabase.password);
            System.out.println("koneksi sukses");
        } catch (SQLException e) {
            System.out.println(e);
            Logger.getLogger(ConfigDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
}
