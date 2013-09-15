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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import pim.contact.Contact;
import pim.exam.Exam;


/**
 *
 * @author lk
 */
public class DatabaseWriter {
    
    private Connection con;
    
    public DatabaseWriter(Connection con) {
        this.con = con;
    }

    public void writeContacts(Contact[] contacts, int userid) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("DELETE FROM contacts WHERE userid = '" + userid + "'");
        }
        
        for (int i = 0; i < contacts.length; i++) {
            try (PreparedStatement pstmt = con.prepareStatement(
                         "INSERT INTO contacts VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                pstmt.setInt(1, userid);
                pstmt.setString(2, contacts[i].getName() == null ? "" : contacts[i].getName());
                pstmt.setString(3, contacts[i].getMail() == null ? "" : contacts[i].getMail());
                pstmt.setString(4, contacts[i].getNumber() == null ? "" : contacts[i].getNumber());
                pstmt.setString(5, contacts[i].getDescription1() == null ? "" : contacts[i].getDescription1());
                pstmt.setString(6, contacts[i].getContent1() == null ? "" : contacts[i].getContent1());
                pstmt.setString(7, contacts[i].getDescription2() == null ? "" : contacts[i].getDescription2());
                pstmt.setString(8, contacts[i].getContent2() == null ? "" : contacts[i].getContent2());
                pstmt.setString(9, contacts[i].getDescription3() == null ? "" : contacts[i].getDescription3());
                pstmt.setString(10, contacts[i].getContent3() == null ? "" : contacts[i].getContent3());

                BufferedImage image = contacts[i].getImage();
                if (image != null) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    try {
                        ImageIO.write(image, "png", out);
                        byte[] buf = out.toByteArray();
                        ByteArrayInputStream inStream = new ByteArrayInputStream(buf);
                        pstmt.setBinaryStream(11, inStream, out.size());
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                        pstmt.setBinaryStream(11, null, 0);
                    }
                } else {
                    pstmt.setBinaryStream(11, null, 0);
                }
                
                pstmt.executeUpdate();
            }
        }
    }
    
    
    public void writeExams(Exam[] exams, int userid) throws SQLException {
        SimpleDateFormat f= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder("INSERT INTO exams VALUES ");
        for (int i = 0; i < exams.length; i++) {
            sb.append("(")
              .append(userid)
              .append(",'")
              .append(exams[i].getSubject().replaceAll("'", "\\\\'"))
              .append("','")
              .append(exams[i].getSemester().replaceAll("'", "\\\\'"))
              .append("','")
              .append(exams[i].getEcts())
              .append("',")
              .append(exams[i].getDate() == null ? "null" : "'" + f.format(exams[i].getDate()) + "'")
              .append(",'")
              .append(exams[i].getRoom() == null ? "" : exams[i].getRoom().replaceAll("'", "\\\\'"))
              .append("',")
              .append(exams[i].getGrade())
              .append(",");

            int[] numbers = exams[i].getNumbers();
            if (numbers == null) {
                sb.append("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0");
            } else {
                for (int j = 0; j < numbers.length; j++) {
                    sb.append(numbers[j]);
                    if (j < numbers.length - 1) {
                        sb.append(",");
                    }
                }
            }
            
            if (i < exams.length - 1) {
                sb.append("),");
            } else {
                sb.append(")");
            }
        }
        try (Statement stmt = con.createStatement()) {
            stmt.addBatch("DELETE FROM exams WHERE userid = '" + userid + "'");
            stmt.addBatch(sb.toString());
            stmt.executeBatch();
        }
    }
    
    
}
