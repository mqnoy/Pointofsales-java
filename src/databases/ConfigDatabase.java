/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    protected static Connection koneksi;

    ConfigDatabase() {
        setConf();
    }

    protected static void setConf() {
        ConfigDatabase.host = "192.168.137.1";
        ConfigDatabase.username = "root";
        ConfigDatabase.password = "123456";
        ConfigDatabase.driver = "mysql";
        ConfigDatabase.database = "pointofsale";
        ConfigDatabase.port = 3306;
        ConfigDatabase.urldb = "jdbc:" + driver + "://" + ConfigDatabase.host + ":" + ConfigDatabase.port + "/" + ConfigDatabase.database;
    }

    protected Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfigDatabase.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("driver not found");
            JOptionPane.showMessageDialog(null, "driver not found\n" + ex);
        }

        try {
            koneksi = DriverManager.getConnection(urldb, username, password);
            System.out.println("Berhasil Koneksi Database");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Koneksi Database\n" + ex);
            //System.out.println("Gagal Koneksi Database" + ex);
        }
        return koneksi;
    }
}
