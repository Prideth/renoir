/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.contact;

import java.awt.image.BufferedImage;

/**
 *
 * @author lk
 */
public class Contact {
    
    //private int id;
    private String name;
    private String mail;
    private String number;
    private String description1;
    private String content1;
    private String description2;
    private String content2;
    private String description3;
    private String content3;
    private BufferedImage image;

    public Contact(String name, String mail, String number, String description1,
            String content1, String description2, String content2,
            String description3, String content3, BufferedImage image) {
        this.name = name;
        this.mail = mail;
        this.number = number;
        this.description1 = description1;
        this.content1 = content1;
        this.description2 = description2;
        this.content2 = content2;
        this.description3 = description3;
        this.content3 = content3;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription1() {
        return description1;
    }

    public String getContent1() {
        return content1;
    }

    public String getDescription2() {
        return description2;
    }

    public String getContent2() {
        return content2;
    }

    public String getDescription3() {
        return description3;
    }

    public String getContent3() {
        return content3;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
