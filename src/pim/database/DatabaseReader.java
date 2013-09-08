/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.database;

import pim.contact.Contact;
import pim.exam.Exam;

/**
 *
 * @author lk
 */
public class DatabaseReader {

    public DatabaseReader() {
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
    
    
    public Contact[] getContacts() {
        Contact[] contacts = new Contact[10];
        
        contacts[0] = new Contact("Eugen Adam", "eugen.adam@gmail.com", "01639918433", null, null, null, null, null, null, null);
        contacts[1] = new Contact("Heinrich Amersdorffer", "heinrich.amersdorffer@gmail.com", "01527624202", null, null, null, null, null, null, null);
        contacts[2] = new Contact("Heike Kati Barath", "heike.barath@web.de", "01761249599", null, null, null, null, null, null, null);
        contacts[3] = new Contact("Karl Axmacher", "karl.axmacher@gmx.net", "01776301189", null, null, null, null, null, null, null);
        contacts[4] = new Contact("Hermann Albert", "hermann.albert@gmx.de", "01774523345", null, null, null, null, null, null, null);
        contacts[5] = new Contact("Elvira Bach", "elvira.bach@gmail.com", "01621001415", null, null, null, null, null, null, null);
        contacts[6] = new Contact("Anna Adam", "anna.adam@web.de", "01779119162", null, null, null, null, null, null, null);
        contacts[7] = new Contact("Johannes Maximilian Avenarius", "johannes.avenarius@.web.de", "01667400224", null, null, null, null, null, null, null);
        contacts[8] = new Contact("Fritz Bamberger", "fritz.bamberger@yahoo.com", "01909508811", null, null, null, null, null, null, null);
        contacts[9] = new Contact("Katharina Bamberg", "katharina.bamberg@gmailcom", "01761135805", "Telefon", "01639918433", "Wohnort", "Berlin", "Geschlecht", "männlich", null);
        
        return contacts;
    }
}