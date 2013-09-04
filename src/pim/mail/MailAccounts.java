/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.mail;

/**
 *
 * @author matthiaskiefer
 */
public enum MailAccounts {
    // Hier bitte die ensprechenden Attribute jeweils anpassen

    GOOGLEMAIL("imap.gmail.com", "smtp.gmail.com", 587, 993, "renoirprog3", "pimprog3", "renoirprog3@gmail.com"), // Hier können weitere E-Mail Accounts als ENUM angelegt werden
;
    private String smtpHost;
    private String imapHost;
    private int smtpPort;
    private int imapPort;
    private String username;
    private String password;
    private String email;

    /**
     * Setzt die notwendigen Attribute des MailAccounts
     *
     * @param smtpHost - SMTP Host
     * @param smtpPort - Port
     * @param username - Benutzername
     * @param password - Passwort
     * @param email - Absender E-Mail
     */
    private MailAccounts(String imapHost, String smtpHost, int smtpPort, int imapPort, String username, String password, String email) {
        this.smtpHost = smtpHost;
        this.imapHost = imapHost;
        this.smtpPort = smtpPort;
        this.imapPort = imapPort;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getPort() {
        return smtpPort;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public MailAuthenticator getPasswordAuthentication() {
        return new MailAuthenticator(username, password);
    }

    public String getEmail() {
        return email;
    }

    public int getImapPort() {
        return imapPort;
    }

    public String getImapHost() {
        return imapHost;
    }
}