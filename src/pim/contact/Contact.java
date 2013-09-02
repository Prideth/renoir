/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.contact;

/**
 *
 * @author lk
 */
public class Contact {
    
    //private int id;
    private String name;
    private String mail;
    private String mobil;

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
