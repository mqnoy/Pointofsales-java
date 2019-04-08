/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author digitized
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
    public ConfigDatabase(){
        try {
            setConf();
            ConfigDatabase.beginCon();
        } catch (SQLException ex) {
            Logger.getLogger(ConfigDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    
    public static void setConf() {
        ConfigDatabase.host = "";
        ConfigDatabase.username = "";
        ConfigDatabase.password = "";
        ConfigDatabase.driver = "mysql";
        ConfigDatabase.database = "poinofsale";
        ConfigDatabase.port = 3306;
        ConfigDatabase.urldb = "jdbc:"+driver+"://"+ConfigDatabase.host+":"+ConfigDatabase.port+"/"+ConfigDatabase.database;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public static void beginCon() throws SQLException {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConfigDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            connection = (Connection) DriverManager.getConnection(ConfigDatabase.urldb, ConfigDatabase.username, ConfigDatabase.password);
            System.out.println("koneksi sukses");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            ConfigDatabase confDB = new ConfigDatabase();
            confDB.beginCon();
        } catch (SQLException ex) {
            Logger.getLogger(ConfigDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
