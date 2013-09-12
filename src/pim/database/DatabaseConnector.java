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

/**
 *
 * @author lk
 */
public class DatabaseConnector {
    
    public static Connection getConnection(Properties props, Connection con) {
        if (con == null) {
            con = connect(props);
        } else {
            try {
                System.out.print("ping... ");
                long start = System.currentTimeMillis();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT 1");
                rs.close();
                System.out.println(System.currentTimeMillis() - start);
            } catch (SQLException e) {
                con = connect(props);
            }
        }
        return con;
    }
    
    private static Connection connect(Properties props) {
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
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Es konnte keine Verbindung zur Datenbank hergestellt werden.", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
    
    
}
