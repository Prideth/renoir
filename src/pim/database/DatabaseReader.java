/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pim.contact.Contact;
import pim.exam.Exam;
import pim.notes.Note;
import java.util.Date;  //REMOVE ME
import javax.imageio.ImageIO;

/**
 *
 * @author lk
 */
public class DatabaseReader {

    private Connection con;
    
    public DatabaseReader(Connection con) {
        this.con = con;
    }

    
    public Exam[] getExams(int userid) throws SQLException {
                Exam[] exams = null;
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM exams WHERE userid = '" + userid + "'");
        rs.last();
        if (rs.getRow() > 0) {
            exams = new Exam[rs.getRow()];
            rs.beforeFirst();
            while (rs.next()) {
                String subject = rs.getString(2).isEmpty() ? null : rs.getString(2);
                String semester = rs.getString(3).isEmpty() ? null : rs.getString(3);
                int ects = rs.getInt(4);
                Date date = rs.getTimestamp(5);
                String room = rs.getString(6).isEmpty() ? null : rs.getString(7);
                double grade = Math.round(rs.getFloat(7) * 10d) / 10d;
                int numbers[] = new int[32];
                int students = 0;
                for (int i = 0; i < 32; i++) {
                    numbers[i] = rs.getInt(i + 8);
                    students += numbers[i];
                }
                Exam exam;
                if (students == 0) {
                    exam = new Exam(subject, semester, ects, date, room, grade, null);
                } else {
                    exam = new Exam(subject, semester, ects, date, room, grade, numbers);
                }
                exams[rs.getRow() - 1] = exam;
            }
        }
        return exams;
    }
    
    
    public Contact[] getContacts(int userid) throws SQLException {
        Contact[] contacts = null;
        String sql =  "SELECT * FROM contacts WHERE userid = '" + userid + "'";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            rs.last();
            if (rs.getRow() > 0) {
                contacts = new Contact[rs.getRow()];
                rs.beforeFirst();
                
                while (rs.next()) {
                    
                    String name = rs.getString(2).isEmpty() ? null : rs.getString(2);
                    String mail = rs.getString(3).isEmpty() ? null : rs.getString(3);
                    String number = rs.getString(4).isEmpty() ? null : rs.getString(4);
                    String description1 = rs.getString(5).isEmpty() ? null : rs.getString(5);
                    String content1 = rs.getString(6).isEmpty() ? null : rs.getString(6);
                    String description2 = rs.getString(7).isEmpty() ? null : rs.getString(7);
                    String content2 = rs.getString(8).isEmpty() ? null : rs.getString(8);
                    String description3 = rs.getString(9).isEmpty() ? null : rs.getString(9);
                    String content3 = rs.getString(10).isEmpty() ? null : rs.getString(10);
                    
                    Blob blob = rs.getBlob(11);
                    BufferedImage image = null;
                    if (blob != null) {
                        byte[] bytes = blob.getBytes(1, (int) blob.length());
                        try {
                            image = ImageIO.read(new ByteArrayInputStream(bytes));
                        } catch (IOException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    
                    Contact contact = new Contact(name, mail, number, description1, content1,
                            description2, content2, description3, content3, image);
                    
                    contacts[rs.getRow() - 1] = contact;
                }
            }
        }
        return contacts;
    }
    

    public Note[] getNotes(int userid) throws SQLException {
        Note[] notes = null;
        String sql =  "SELECT * FROM notes WHERE userid = '" + userid + "'";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            rs.last();
            if (rs.getRow() > 0) {
                notes = new Note[rs.getRow()];
                rs.beforeFirst();
                while (rs.next()) {
                    notes[rs.getRow() - 1] = new Note(0, rs.getString(2),
                            rs.getString(3), rs.getTimestamp(4));
                }
            }
        }
        return notes;
    }


}