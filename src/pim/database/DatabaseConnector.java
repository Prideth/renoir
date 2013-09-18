/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;
import pim.Settings;

/**
 *
 * @author lk
 */
public class DatabaseConnector {
    
    public static Connection getConnection(Connection con) {
        if (con == null) {
            con = connect();
        } else {
            try {
                System.out.print("ping... ");
                long start = System.currentTimeMillis();
                try (Statement stmt = con.createStatement()) {
                    ResultSet rs = stmt.executeQuery("SELECT 1");
                    rs.close();
                }
                System.out.println(System.currentTimeMillis() - start);
            } catch (SQLException e) {
                con = connect();
            }
        }
        return con;
    }
    
    private static Connection connect() {
        Connection con = null;
        try {
            String database = Settings.dbname;
            String port = Settings.dbport;
            String connection = Settings.dbserver;
            String user = Settings.dbusername;
            String password = Settings.dbpassword;
            String cstring = "jdbc:mysql://" + connection + ":" + port + "/" + database;
            
            System.out.print("connect... ");
            long start = System.currentTimeMillis();
            con = DriverManager.getConnection(cstring, user, password);
            System.out.println(System.currentTimeMillis() - start);
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Es konnte keine Verbindung zur Datenbank hergestellt werden.", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
    
    
}
