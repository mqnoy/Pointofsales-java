/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rifky
 */
public class ConfigDatabase {

    static String host;
    static String username;
    static String password;
    static String driver;
    static String database;
    static Integer port;
    static String urldb;
    private Connection koneksi;

//    ConfigDatabase (){
//        connect();
//    }
    protected static void setConf() {
        ConfigDatabase.host = "imzazmi.com";
        ConfigDatabase.username = "dev_imza";
        ConfigDatabase.password = "dev_imza";
        ConfigDatabase.driver = "mysql";
        ConfigDatabase.database = "pointofsale";
        ConfigDatabase.port = 3306;
        ConfigDatabase.urldb = "jdbc:" + driver + "://" + ConfigDatabase.host + ":" + ConfigDatabase.port + "/" + ConfigDatabase.database;
    }

    public Connection connect() {
        setConf();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfigDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("driver not found");
        }

        try {
            koneksi = DriverManager.getConnection(urldb, username, password);
            System.out.println("Berhasil Koneksi Database");
        } catch (SQLException ex) {
            System.out.println("Gagal Koneksi Database" + ex);
        }
        return koneksi;
    }
}
