/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import pim.Settings;

/**
 *
 * @author matthiaskiefer
 */
public class MailFunction {

    public static void send(String recipient, String subject,
            String text) throws AddressException, MessagingException {
        // Properties über die Systemeigenschaften anlegen
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", Settings.mailOutServer);
        properties.setProperty("mail.smtp.port", Settings.mailOutPort);
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, new MailAuthenticator(Settings.mailAdress, Settings.mailPassword));
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(Settings.mailAdress));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            //InternetAddress.parse(recipient, false)
            msg.setSubject(subject);
            msg.setText(text);

            Transport.send(msg);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static ArrayList<Mail> receive() throws AddressException, MessagingException {
        ArrayList<Mail> mList;
        mList = new ArrayList<Mail>();
        mList.clear();
        // Properties über die Systemeigenschaften anlegen
        Properties properties = System.getProperties();
        properties.setProperty("mail.imaps.host", Settings.mailInServer);
        properties.setProperty("mail.imaps.port", Settings.mailInPort);
        properties.setProperty("mail.store.protocol", "imaps");

        Session session = Session.getDefaultInstance(properties, new MailAuthenticator(Settings.mailAdress, Settings.mailPassword));
        //Gibt in der Console Debug-Meldungen zum Verlauf aus
        session.setDebug(false);

        //Store: dient dem zum Ablegen der Nachrichten
        Store store = session.getStore("imaps");
        store.connect();

        //Folder: ist ein Ordner-Object für Mails
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        Message message[] = folder.getMessages();

        for (int i = 0; i < message.length; i++) {
            try {
                Message msg = message[i];
                System.out.println("E-Mail: " + i);
                //Nachricht ist eine einfache Text- bzw. HTML-Nachricht
                if (msg.isMimeType("text/plain")) {
                    mList.add(new Mail(Arrays.toString(msg.getFrom()), msg.getRecipients(Message.RecipientType.TO), msg.getSubject(), msg.getSentDate(), new ContentType(msg.getContentType()), msg.getContent(), msg.isMimeType("text/plain")));
                } else {
                    Multipart mp = (Multipart) msg.getContent();

                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < mp.getCount(); j++) {
                        Part part = mp.getBodyPart(j);
                        String disposition = part.getDisposition();

                        if (disposition == null) {
                            MimeBodyPart mimePart = (MimeBodyPart) part;

                            if (mimePart.isMimeType("text/plain")) {
                                BufferedReader in = new BufferedReader(new InputStreamReader(mimePart.getInputStream()));

                                for (String line; (line = in.readLine()) != null;) {
                                    sb.append(line);
                                    sb.append("\n");
                                }
                            }
                        }
                    }
                    mList.add(new Mail(Arrays.toString(msg.getFrom()), msg.getRecipients(Message.RecipientType.TO), msg.getSubject(), msg.getSentDate(), new ContentType(msg.getContentType()), sb.toString(), msg.isMimeType("text/plain")));
                }//if Multipart
            } catch (IOException ex) {
                Logger.getLogger(MailFunction.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        folder.close(false);
        store.close();
        return mList;
    }
}
