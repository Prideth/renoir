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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lk
 */
public class DatabaseConnector {
    
    private Connection con;
    
    private DatabaseConnector() {
        try {
            Properties props = new Properties();
            FileReader in = new FileReader("settings.properties");
            props.load(in);
            in.close();
            String database = props.getProperty("dbname");
            String port = props.getProperty("dbport");
            String connection = props.getProperty("dbserver");
            String user = props.getProperty("dbusername");
            String password = props.getProperty("dbpassword");
            String cstring = "jdbc:mysql://" + connection + ":" + port + "/" + database;
            con = DriverManager.getConnection(cstring, user, password);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Die Datei settings.properties konnte nicht geladen werden.", "Fehler", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Es konnte keine Verbindung zur Datenbank hergestellt werden.", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Connection getConnection() {
        return con;
    }
    
    public void close() {
        try {
            con.close();
        } catch (SQLException e) {}
    }
    
    public static DatabaseConnector getInstance() {
        return DatabaseConnectorHolder.INSTANCE;
    }
    
    private static class DatabaseConnectorHolder {
        private static final DatabaseConnector INSTANCE = new DatabaseConnector();
    }
}
