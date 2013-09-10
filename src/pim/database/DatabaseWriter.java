/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import pim.contact.Contact;


/**
 *
 * @author lk
 */
public class DatabaseWriter {
    
    private Connection con;
    
    public DatabaseWriter() throws SQLException {
        String database = "db_9a9d99_pim";
        String connection = "jdbc:mysql://MYSQL5002.Smarterasp.net";
    	String user = "9a9d99_pim";
        String password = "pim12345";
        con = DriverManager.getConnection(connection, user, password);
        try (Statement stmt = con.createStatement()) {
            stmt.execute("USE `" + database + "`");
        }
    }
    
    public void writeContacts(Contact[] contacts) throws SQLException, IOException {
        try (Statement stmt = con.createStatement()) {
            
            stmt.executeUpdate("TRUNCATE TABLE contacts");
            for (int i = 0; i < contacts.length; i++) {
                
                PreparedStatement pstmt = con.prepareStatement(
                        "INSERT INTO contacts VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                
                pstmt.setString(1, contacts[i].getName() == null ? "" : contacts[i].getName());
                pstmt.setString(2, contacts[i].getMail() == null ? "" : contacts[i].getMail());
                pstmt.setString(3, contacts[i].getNumber() == null ? "" : contacts[i].getNumber());
                pstmt.setString(4, contacts[i].getDescription1() == null ? "" : contacts[i].getDescription1());
                pstmt.setString(5, contacts[i].getContent1() == null ? "" : contacts[i].getContent1());
                pstmt.setString(6, contacts[i].getDescription2() == null ? "" : contacts[i].getDescription2());
                pstmt.setString(7, contacts[i].getContent2() == null ? "" : contacts[i].getContent2());
                pstmt.setString(8, contacts[i].getDescription3() == null ? "" : contacts[i].getDescription3());
                pstmt.setString(9, contacts[i].getContent3() == null ? "" : contacts[i].getContent3());
                
                BufferedImage image = contacts[i].getImage();
                if (image != null) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();  
                    ImageIO.write(image, "png", out); 
                    byte[] buf = out.toByteArray();
                    ByteArrayInputStream inStream = new ByteArrayInputStream(buf);
                    pstmt.setBinaryStream(10, inStream, out.size());
                } else {
                    pstmt.setBinaryStream(10, null, 0);
                }
                pstmt.executeUpdate(); 
                pstmt.close();
            }
        }
    }

    
    public void closeConnection() throws SQLException {
        con.close();
    }
        
    
}
