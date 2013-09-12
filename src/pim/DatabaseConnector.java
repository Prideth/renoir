/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author lk
 */
public class DatabaseConnector {
    
    public static Connection getConnection(Properties props) {
        Connection con = null;
        try {
            String database = props.getProperty("dbname");
            String port = props.getProperty("dbport");
            String connection = props.getProperty("dbserver");
            String user = props.getProperty("dbusername");
            String password = props.getProperty("dbpassword");
            String cstring = "jdbc:mysql://" + connection + ":" + port + "/" + database;
            
            System.out.print("connect... ");
            long start = System.currentTimeMillis();
            con = DriverManager.getConnection(cstring, user, password);
            System.out.println(System.currentTimeMillis() - start);
            
        } catch (SQLException e) {
            System.out.println("error");
            JOptionPane.showMessageDialog(null, "Es konnte keine Verbindung zur Datenbank hergestellt werden.", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
    
    
}
