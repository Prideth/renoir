/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

/**
 *
 * @author matthiaskiefer
 */
public class Mail {

    public static void send(MailAccounts acc, String recipient, String subject,
            String text) throws AddressException, MessagingException {
        // Properties über die Systemeigenschaften anlegen
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", acc.getSmtpHost());
        properties.setProperty("mail.smtp.port", String.valueOf(acc.getPort()));
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, acc.getPasswordAuthentication());

        MimeMessage msg = new MimeMessage(session);

        // Von wem kommt die E-Mail?
        msg.setFrom(new InternetAddress(acc.getEmail()));

        // Wohin soll die Reise gehen?
        // CC geht beispielsweise an Message.RecipientType.CC
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));

        msg.setSubject(subject);
        msg.setText(text);

        Transport.send(msg);
    }

    public static void receive(MailAccounts acc) throws AddressException, MessagingException {

            // Properties über die Systemeigenschaften anlegen
                   Properties properties = System.getProperties();
        properties.setProperty("mail.imaps.host", acc.getImapHost());
        properties.setProperty("mail.imaps.port", String.valueOf(acc.getImapPort()));
        properties.setProperty("mail.store.protocol", "imaps");

            Session session = Session.getDefaultInstance(properties, acc.getPasswordAuthentication());
            //Gibt in der Console Debug-Meldungen zum Verlauf aus
            session.setDebug(false);

            //Store: dient dem zum Ablegen der Nachrichten
            Store store = session.getStore("imaps");
            store.connect();

           //Folder: ist ein Ordner-Object für Mails
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            Message message[] = folder.getMessages();

            for (int i = 0; i < 10; i++) {
                try {
                    Message m = message[i];

                    System.out.println("-----------------------\nNachricht: " + i);
                    System.out.println("Von: " + Arrays.toString(m.getFrom()));
                    System.out.println("Betreff: " + m.getSubject());
                    System.out.println("Gesendet am: " + m.getSentDate());
                    System.out.println("ContentType: " + new ContentType(m.getContentType()));
                    System.out.println("Content: " + m.getContent());

                    //Nachricht ist eine einfache Text- bzw. HTML-Nachricht
                    if (m.isMimeType("text/plain")) {
                        System.out.println(m.getContent());
                    }

                    //Nachricht ist eine Multipart-Nachricht (besteht aus mehreren Teilen)
                    if (m.isMimeType("multipart/*")) {
                        Multipart mp = (Multipart) m.getContent();

                        for (int j = 0; j < mp.getCount(); j++) {
                            Part part = mp.getBodyPart(j);
                            String disposition = part.getDisposition();

                            if (disposition == null) {
                                MimeBodyPart mimePart = (MimeBodyPart) part;

                                if (mimePart.isMimeType("text/plain")) {
                                    BufferedReader in = new BufferedReader(new InputStreamReader(mimePart.getInputStream()));

                                    for (String line; (line = in.readLine()) != null;) {
                                        System.out.println(line);
                                    }
                                }
                            }
                        }
                    }//if Multipart
                } catch (IOException ex) {
                    Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            folder.close(false);
            store.close();

    }
}
