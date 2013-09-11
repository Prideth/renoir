/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.imageio.ImageIO;
import pim.contact.Contact;
import pim.exam.Exam;


/**
 *
 * @author lk
 */
public class DatabaseWriter {
    
    private Connection con;
    
    public DatabaseWriter() throws SQLException, IOException {
        Properties props = new Properties();
        FileReader in = new FileReader("settings.properties");
        props.load(in);
        in.close();
        String database = props.getProperty("db");
        String port = props.getProperty("port");
        String connection = props.getProperty("server");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String cstring = "jdbc:mysql://" + connection + ":" + port + "/" + database;
        con = DriverManager.getConnection(cstring, user, password);
    }

    public void writeContacts(Contact[] contacts) throws SQLException, IOException {
        Statement stmt = con.createStatement();
        stmt.executeUpdate("TRUNCATE TABLE contacts");
        stmt.close();
        
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
    
    public void writeExams(Exam[] exams) throws SQLException, IOException {
        Statement stmt = con.createStatement();
        stmt.addBatch("TRUNCATE TABLE exams");

        for (int i = 0; i < exams.length; i++) {
            
            String subject = exams[i].getSubject().replaceAll("'","\\\\'");
            String semester = exams[i].getSemester().replaceAll("'","\\\\'");
            int ects = exams[i].getEcts();
            String date = exams[i].getDate() == null ? "" : exams[i].getDate().replaceAll("'", "\\\\'");
            String time = exams[i].getTime() == null ? "" : exams[i].getTime().replaceAll("'", "\\\\'");
            String room = exams[i].getRoom() == null ? "" : exams[i].getRoom().replaceAll("'", "\\\\'");
            double grade = exams[i].getGrade();
            int[] numbers = exams[i].getNumbers();
            
            if (numbers == null) {
                 numbers = new int[32];
                 for (int j = 0; j < numbers.length; i++) {
                     numbers[j] = 0;
                 }
            }
            
            stmt.addBatch("INSERT INTO exams VALUES ('"
                    + subject + "', '" + semester + "', '"  + ects + "', '"
                    + date + "', '" + time + "', '" + room + "', '" + grade + "', '"
                    + numbers[0] + "', '" + numbers[1] + "', '" + numbers[2] + "', '"
                    + numbers[3] + "', '" + numbers[4] + "', '" + numbers[5] + "', '"
                    + numbers[6] + "', '" + numbers[7] + "', '" + numbers[8] + "', '"
                    + numbers[9] + "', '" + numbers[10] + "', '" + numbers[11] + "', '"
                    + numbers[12] + "', '" + numbers[13] + "', '" + numbers[14] + "', '"
                    + numbers[15] + "', '" + numbers[16] + "', '" + numbers[17] + "', '"
                    + numbers[18] + "', '" + numbers[19] + "', '" + numbers[20] + "', '"
                    + numbers[21] + "', '" + numbers[22] + "', '" + numbers[23] + "', '"
                    + numbers[24] + "', '" + numbers[25] + "', '" + numbers[26] + "', '"
                    + numbers[27] + "', '" + numbers[28] + "', '" + numbers[29] + "', '"
                    + numbers[30] + "', '" + numbers[31] + "')");
        }
        stmt.executeBatch();
        stmt.close();
        
    }

    
    public void closeConnection() throws SQLException {
        con.close();
    }
}
