/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.mail;

import java.io.Serializable;

/**
 *
 * @author kiefer.m
 */
public class MailAccount implements Serializable {

    private String outServer;
    private String inServer;
    private String name;
    private int smtpPort;
    private int imapPort;
    private String username;
    private char[] password;
    private String email;
    private String type;

    /**
     * Setzt die notwendigen Attribute des MailAccounts
     *
     * @param smtpHost - SMTP Host
     * @param smtpPort - Port
     * @param username - Benutzername
     * @param password - Passwort
     * @param email - Absender E-Mail
     */
    public MailAccount(String imapHost, String smtpHost, int smtpPort, int imapPort, String username, char[] password, String email, String name, String type) {
        this.outServer = smtpHost;
        this.inServer = imapHost;
        this.smtpPort = smtpPort;
        this.imapPort = imapPort;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.type = type;
    }
    
    public MailAuthenticator getPasswordAuthentication() {
        return new MailAuthenticator(getUsername(), getPassword());
    }

    /**
     * @return the outServer
     */
    public String getOutServer() {
        return outServer;
    }

    /**
     * @param outServer the outServer to set
     */
    public void setOutServer(String outServer) {
        this.outServer = outServer;
    }

    /**
     * @return the inServer
     */
    public String getInServer() {
        return inServer;
    }

    /**
     * @param inServer the inServer to set
     */
    public void setInServer(String inServer) {
        this.inServer = inServer;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the smtpPort
     */
    public int getSmtpPort() {
        return smtpPort;
    }

    /**
     * @param smtpPort the smtpPort to set
     */
    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    /**
     * @return the imapPort
     */
    public int getImapPort() {
        return imapPort;
    }

    /**
     * @param imapPort the imapPort to set
     */
    public void setImapPort(int imapPort) {
        this.imapPort = imapPort;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public char[] getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(char[] password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    
   
}
