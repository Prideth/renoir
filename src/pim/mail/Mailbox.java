/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.mail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.ContentType;

/**
 *
 * @author matthiaskiefer
 */
public class Mailbox {

    private ArrayList mMailbox;

    public Mailbox() {
        mMailbox = new ArrayList();
    }

    public void addMail(Message m) {
        try {
            String from = Arrays.toString(m.getFrom());
            Address[] recipientsTo = m.getRecipients(Message.RecipientType.TO);
            String subject = m.getSubject();
            Date sentDate = m.getSentDate();
            ContentType contentType = new ContentType(m.getContentType());
            Object content = m.getContent();
            
            Mail mMail = new Mail(from, recipientsTo, subject, sentDate, contentType, content);
            mMailbox.add(mMail);
        } catch (MessagingException | IOException ex) {
            Logger.getLogger(Mailbox.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public ArrayList getAllMails() {
        return mMailbox;
    }
}
