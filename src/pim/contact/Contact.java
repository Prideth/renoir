/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.contact;

import javax.swing.Icon;

/**
 *
 * @author lk
 */
public class Contact {
    
    //private int id;
    private String name;
    private String mail;
    private String mobil;
    private String fieldDescription1;
    private String fieldDescription2;
    private String fieldDescription3;
    private String fieldDescription4;
    private String fieldContent1;
    private String fieldContent2;
    private String fieldContent3;
    private String fieldContent4;
    private Icon icon;

    public Contact(String name, String mail, String mobil) {
        this.name = name;
        this.mail = mail;
        this.mobil = mobil;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getMobil() {
        return mobil;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

}
