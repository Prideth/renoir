/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.mail;

import java.util.Date;
import javax.mail.Address;
import javax.mail.internet.ContentType;

/**
 *
 * @author matthiaskiefer
 */
public class Mail {

    private String from;
    private Address[] recipientsTo;
    private String subject;
    private Date sentDate;
    private ContentType contentType;
    private Object content;
    private boolean msgType;

    public Mail(String from, Address[] recipientsTo, String subject, Date sentDate, ContentType contentType, Object content, boolean msgType) {
        this.from = from;
        this.content = content;
        this.subject = subject;
        this.contentType = contentType;
        this.recipientsTo = recipientsTo;
        this.sentDate = sentDate;
         this.msgType = msgType;

    
    }

     public boolean getMsgType() {
        return msgType;
    }
     
 
    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the recipientsTo
     */
    public Address[] getRecipientsTo() {
        return recipientsTo;
    }

    /**
     * @param recipientsTo the recipientsTo to set
     */
    public void setRecipientsTo(Address[] recipientsTo) {
        this.recipientsTo = recipientsTo;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the sentDate
     */
    public Date getSentDate() {
        return sentDate;
    }

    /**
     * @param sentDate the sentDate to set
     */
    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    /**
     * @return the contentType
     */
    public ContentType getContentType() {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    /**
     * @return the content
     */
    public Object getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(Object content) {
        this.content = content;
    }
}
