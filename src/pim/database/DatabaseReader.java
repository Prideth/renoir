/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pim.contact.Contact;
import pim.exam.Exam;
import pim.notes.Note;
import java.util.Date;  //REMOVE ME
import java.util.Properties;
import javax.imageio.ImageIO;
import pim.todo.ToDo;

/**
 *
 * @author lk
 */
public class DatabaseReader {

    private Connection con;

    public DatabaseReader() throws SQLException, IOException {
        Properties props = new Properties();
        FileReader in = new FileReader("settings.properties");
        props.load(in);
        in.close();
        String database = props.getProperty("db");
        String connection = "jdbc:mysql://" + props.getProperty("server");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        con = DriverManager.getConnection(connection, user, password);
        try (Statement stmt = con.createStatement()) {
            stmt.execute("USE `" + database + "`");
        }
    }

    
    public Exam[] getExams() {
        Exam[] exams = new Exam[28];
        
        exams[0] = new Exam("Betriebssystemeinführung", "WS 10/11", 2, null, null, null, 2.6,
                new int[]{1, 0, 0, 3, 0, 0, 0, 2, 1, 1, 5, 0, 2, 6, 1, 2, 1, 6, 0, 0, 3, 0, 1, 2, 0, 1, 2, 6, 2, 0, 8, 14});
        exams[1] = new Exam("Betriebswirtschaftslehre I", "WS 10/11", 5, null, null, null, 2.3,
                new int[]{2, 0, 0, 5, 0, 2, 0, 5, 1, 0, 2, 0, 0, 5, 0, 2, 0, 3, 5, 0, 4, 0, 0, 5, 0, 1, 0, 1, 1, 0, 12, 4});
        exams[2] = new Exam("Englisch I", "WS 10/11", 2, null, null, null, 3.0,
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 7, 0, 2, 0, 3, 3, 0, 9, 0, 0, 8, 0, 2, 0, 8, 2, 0, 18, 3});
        exams[3] = new Exam("Informatikgrundlagen", "WS 10/11", 5, null, null, null, 3.3,
                new int[]{0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1, 0, 0, 3, 0, 1, 0, 2, 0, 0, 4, 0, 0, 2, 0, 2, 0, 3, 4, 0, 16, 23});
        exams[4] = new Exam("Mathematik I", "WS 10/11", 8, null, null, null, 2.8,
                new int[]{2, 0, 0, 3, 0, 1, 0, 2, 0, 0, 2, 0, 0, 4, 0, 0, 0, 1, 1, 0, 1, 0, 0, 3, 0, 2, 0, 1, 2, 0, 11, 23});
        exams[5] = new Exam("Programmierung I", "WS 10/11", 8, null, null, null, 1.7,
                new int[]{4, 0, 0, 2, 0, 0, 0, 3, 1, 0, 3, 0, 0, 3, 0, 0, 0, 5, 4, 0, 4, 0, 0, 0, 0, 4, 0, 2, 0, 0, 6, 13});
        exams[6] = new Exam("Betriebswirtschaftslehre II", "SS 11", 5, null, null, null, 2.5,
                new int[]{1, 0, 0, 1, 0, 0, 0, 3, 3, 0, 6, 0, 0, 6, 0, 6, 0, 1, 1, 0, 3, 0, 0, 3, 0, 0, 0, 3, 0, 0, 3, 6});
        exams[7] = new Exam("Englisch II", "SS 11", 2, null, null, null, 3.5,
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 2, 0, 3, 0, 4, 2, 0, 8, 0, 0, 3, 0, 5, 0, 1, 1, 0, 9, 10});
        exams[8] = new Exam("Graphentheorie", "SS 11", 5, null, null, null, 3.0,
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 2, 0, 1, 0, 0, 5, 0, 0, 8, 0, 1, 0, 4, 3, 0, 9, 8});
        exams[9] = new Exam("Mathematik II", "SS 11", 7, null, null, null, 2.7,
                new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 0, 0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 1, 2, 0, 10, 16});
        exams[10] = new Exam("Datenbanken", "WS 11/12", 5, null, null, null, 2.3,
                new int[]{0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 3, 0, 0, 3, 0, 1, 0, 3, 1, 0, 4, 0, 0, 5, 0, 6, 0, 0, 0, 0, 3, 8});
        exams[11] = new Exam("Digitaltechnik", "WS 11/12", 3, null, null, null, 4.0,
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 4, 8});
        exams[12] = new Exam("Englisch III", "WS 11/12", 2, null, null, null, 3.3,
                new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 2, 0, 0, 5, 0, 2, 0, 3, 2, 0, 2, 0, 0, 8, 0, 1, 0, 3, 1, 0, 7, 4});
        exams[13] = new Exam("Softwaretechnik I", "WS 11/12", 5, null, null, null, 1.0,
                new int[]{7, 0, 0, 5, 0, 3, 0, 0, 5, 0, 3, 0, 0, 4, 0, 2, 0, 1, 1, 0, 2, 0, 0, 2, 0, 0, 0, 2, 0, 0, 1, 2});
        exams[14] = new Exam("Wirtschaftsinformatik II", "WS 11/12", 3, null, null, null, 3.5,
                new int[]{0, 0, 0, 1, 0, 2, 0, 3, 0, 0, 7, 0, 0, 10, 0, 2, 0, 0, 1, 0, 5, 0, 0, 3, 0, 2, 0, 1, 1, 0, 3, 3});
        exams[15] = new Exam("Mathematik III", "SS 12", 5, null, null, null, 3.9,
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 6});
        exams[16] = new Exam("Programmierung II", "SS 12", 8, null, null, null, 2.5,
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 1, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 4, 6});
        exams[17] = new Exam("Wirtschaftsinformatik I", "SS 12", 5, null, null, null, 3.3,
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 3, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 2});
        exams[18] = new Exam("Rechnerarchitektur", "WS 12/13", 5, null, null, null, 4.0,
                new int[]{2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 3, 0, 2, 0, 2, 4, 0, 2, 0, 0, 3, 0, 1, 0, 0, 0, 0, 5, 8});
        exams[19] = new Exam("Betriebssysteme", "SS 12", 4, null, null, null, 2.8,
                new int[]{3, 0, 0, 0, 0, 0, 0, 5, 0, 0, 2, 0, 0, 2, 0, 0, 0, 1, 2, 0, 3, 0, 0, 2, 0, 1, 0, 3, 2, 0, 6, 14});
        exams[20] = new Exam("Projektarbeit", "SS 12", 10, null, null, null, 1.0,
                new int[]{10, 0, 0, 8, 0, 13, 0, 1, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 4});
        exams[21] = new Exam("Rechnernetze", "SS 12", 4, null, null, null, 3.8,
                new int[]{1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 1, 0, 2, 0, 0, 1, 0, 0, 0, 1, 2, 0, 12, 10});
        exams[22] = new Exam("Systemarchitektur", "WS 12/13", 5, null, null, null, 2.3,
                new int[]{0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 5, 0, 0, 5, 0, 0, 0, 1, 1, 0, 3, 0, 0, 3, 0, 1, 0, 2, 1, 0, 3, 5});
        exams[23] = new Exam("Theoretische Informatik", "WS 12/13", 5, null, null, null, 3.0,
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 3, 0, 0, 4, 0, 0, 0, 2, 0, 0, 4, 0, 0, 4, 0, 0, 0, 3, 2, 0, 2, 2});
        exams[24] = new Exam("Verteilte Systeme I", "WS 12/13", 4, null, null, null, 1.5,
                new int[]{4, 11, 0, 0, 0, 0, 0, 7, 6, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        exams[25] = new Exam("Wirtschaftsinformatik III", "WS 12/13", 3, null, null, null, 3.5,
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0});
        exams[26] = new Exam("Metasprachen", "SS 13", 5, null, null, null, 2.0,
                new int[]{1, 0, 0, 0, 1, 2, 4, 1, 0, 0, 2, 0, 1, 3, 0, 1, 0, 2, 3, 2, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 3, 1});
        exams[27] = new Exam("Entwurfsmuster", "SS 13", 3, null, null, null, 1.5,
                new int[]{5, 0, 0, 1, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0});

        return exams;
    }
    
    
    public Contact[] getContacts() throws SQLException, IOException {
        Contact[] contacts = null;
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM contacts");
        rs.last();
        if (rs.getRow() > 0) {
            contacts = new Contact[rs.getRow()];
            rs.beforeFirst();
            
            while (rs.next()) {
                
                String name = rs.getString(1).isEmpty() ? null : rs.getString(1);
                String mail = rs.getString(2).isEmpty() ? null : rs.getString(2);
                String number = rs.getString(3).isEmpty() ? null : rs.getString(3);
                String description1 = rs.getString(4).isEmpty() ? null : rs.getString(4);
                String content1 = rs.getString(5).isEmpty() ? null : rs.getString(5);
                String description2 = rs.getString(6).isEmpty() ? null : rs.getString(6);
                String content2 = rs.getString(7).isEmpty() ? null : rs.getString(7);
                String description3 = rs.getString(8).isEmpty() ? null : rs.getString(8);
                String content3 = rs.getString(9).isEmpty() ? null : rs.getString(9);
                
                Blob blob = rs.getBlob(10);
                BufferedImage image = null;
                if (blob != null) {
                    byte[] bytes = blob.getBytes(1, (int) blob.length());
                    image = ImageIO.read(new ByteArrayInputStream(bytes));
                }
 
                Contact contact = new Contact(name, mail, number, description1, content1,
                        description2, content2, description3, content3, image);

                
                contacts[rs.getRow() - 1] = contact;
            }
        }
        rs.close();
        stmt.close();
        return contacts;
    }
    
    
    /*
    public Contact[] getContacts() {
        Contact[] contacts = new Contact[16];
        contacts[0] = new Contact("Ronald Pofalla", "ronald.pofalla@bundestag.de", "03018 400-0", "Amt", "Besondere Aufgaben", null, null, null, null, null);
        contacts[1] = new Contact("Dirk Niebel", "dirk.niebel@bundestag.de", "03018 535-0", "Amt", "Wirtschaftliche Zusammenarbeit und Entwicklung", null, null, null, null, null);
        contacts[2] = new Contact("Johanna Wanka", "johanna.wanka@bundestag.de", "03018 57-0", "Amt", "Bildung und Forschung", null, null, null, null, null);
        contacts[3] = new Contact("Peter Altmaier", "peter.altmaier@bundestag.de", "03018 305-0", "Amt", "Umwelt, Naturschutz und Reaktorsicherheit", null, null, null, null, null);
        contacts[4] = new Contact("Peter Ramsauer", "peter.ramsauer@bundestag.de", "03018 300-0", "Amt", "Verkehr, Bau und Stadtentwicklung", null, null, null, null, null);
        contacts[5] = new Contact("Daniel Bahr", "daniel.bahr@bundestag.de", "03018 441-0", "Amt", "Gesundheit", null, null, null, null, null);
        contacts[6] = new Contact("Kristina Schröder", "kristina.schröder@bundestag.de", "03018 555-0", "Amt", "Familie, Senioren, Frauen und Jugend", null, null, null, null, null);
        contacts[7] = new Contact("Thomas de Maizière", "thomas.demaiziere@bundestag.de", "03018 24-000", "Amt", "Verteidigung", null, null, null, null, null);
        contacts[8] = new Contact("Ilse Aigner", "ilse.aigner@bundestag.de", "022899 529-0", "Amt", "Ernährung, Landwirtschaft und Verbraucherschutz", null, null, null, null, null);
        contacts[9] = new Contact("Ursula von der Leyen", "ursula.vonderleyen@bundestag.de", "03018 527-0", "Amt", "Arbeit und Soziales", null, null, null, null, null);
        contacts[10] = new Contact("Wolfgang Schäuble", "wolfgang.schaeuble@bundestag.de", "03018 682-0", "Amt", "Finanzen", null, null, null, null, null);
        contacts[11] = new Contact("Sabine Leutheusser-Schnarrenberger", "sls@bundestag.de", "03018 580-0", "Amt", "Justiz", null, null, null, null, null);
        contacts[12] = new Contact("Hans-Peter Friedrich", "hans-peter.friedrich@bundestag.de", "03018 681-0", "Amt", "Inneres", null, null, null, null, null);
        contacts[13] = new Contact("Guido Westerwelle", "guido.westerwelle@bundestag.de", "03018 17-0", "Amt", "Auswärtiges", null, null, null, null, null);
        contacts[14] = new Contact("Philipp Rösler", "philipp.roesler@bundestag.de", "03018 615-0", "Amt", "Wirtschaft und Technologie", null, null, null, null, null);
        contacts[15] = new Contact("Angela Merkel", "angela.merkel@bundestag.de", "03018 400-0", "Amt", "Bundeskanzler", null, null, null, null, null);
        return contacts;
    }
    */

    public Note[] getNotes() {
        
        Note[] notes = new Note[5];
        
        Date d = new Date();
        
        
        notes[0] = new Note(0, "Note1", "Content Note 1", d);
        notes[1] = new Note(0, "Note2", "Content Note 2", d);
        notes[2] = new Note(0, "Note3", "Content Note 3", d);
        notes[3] = new Note(0, "Note4", "Content Note 4", d);
        notes[4] = new Note(0, "Note5", "Content Note 5", d);
        
        
        return notes;
    }

    public ToDo[] getToDos() {
        ToDo[] toDos = new ToDo[100];
        
        return toDos;
    }
    
    
     public void closeConnection() throws SQLException {
        con.close();
    }
}