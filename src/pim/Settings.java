/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author lk
 */
public class Settings {

    private static final String FILE = "settings.properties";
    static private Settings instance = null;
    static private Properties props;
    static public String dbserver = null;
    static public String dbport = null;
    static public String dbusername = null;
    static public String dbpassword = null;
    static public String dbname = null;
    static public String username = null;
    static public String password = null;
    static public String locale = null;
    
    static public String mailName = null;
    static public String mailAdress = null;
    static public String mailType = null;
    static public String mailPassword = null;
    static public String mailAccount = null;
    static public String mailInPort = null;
    static public String mailOutPort = null;
    static public String mailInServer = null;
    static public String mailOutServer = null;

    protected Settings() {
        props = new Properties();
        File f = new File(FILE);
        if (!f.exists()) {
            InputStream in = getClass().getResourceAsStream(FILE);
            try {
                props.load(in);
                in.close();
                try (FileOutputStream out = new FileOutputStream(FILE)) {
                    props.store(out, null);
                }
            } catch (IOException e) {
            }
        } else {
            try {
                try (FileReader in = new FileReader(FILE)) {
                    props.load(in);
                }
            } catch (IOException e) {
            }
        }
        
        //Datenbank
        dbserver = props.getProperty("dbserver");
        dbport = props.getProperty("dbport");
        dbusername = props.getProperty("dbusername");
        dbpassword = props.getProperty("dbpassword");
        dbname = props.getProperty("dbname");
        username = props.getProperty("username");
        password = props.getProperty("password");
        locale = props.getProperty("locale");

        //MailAccount
        mailName = props.getProperty("mailName");
        mailAdress = props.getProperty("mailAdress");
        mailType = props.getProperty("mailType");
        mailPassword = props.getProperty("mailPassword");
        mailAccount = props.getProperty("mailAccount");
        mailInPort = props.getProperty("mailInPort");
        mailOutPort = props.getProperty("mailOutPort");
        mailInServer = props.getProperty("mailInServer");
        mailOutServer = props.getProperty("mailOutServer");


    }

    static public Settings instance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    static public void setProperties(String... values) {
        for (int i = 0; i < values.length; i += 2) {
            props.setProperty(values[i], values[i + 1]);
        }

        try {
            try (FileWriter out = new FileWriter("settings.properties")) {
                props.store(out, null);
            }
        } catch (IOException e) {
        }
        
        //Datenbank
        dbserver = props.getProperty("dbserver");
        dbport = props.getProperty("dbport");
        dbusername = props.getProperty("dbusername");
        dbpassword = props.getProperty("dbpassword");
        dbname = props.getProperty("dbname");
        username = props.getProperty("username");
        password = props.getProperty("password");
        locale = props.getProperty("locale");

        //MailAccount
        mailName = props.getProperty("mailName");
        mailAdress = props.getProperty("mailAdress");
        mailType = props.getProperty("mailType");
        mailPassword = props.getProperty("mailPassword");
        mailAccount = props.getProperty("mailAccount");
        mailInPort = props.getProperty("mailInPort");
        mailOutPort = props.getProperty("mailOutPort");
        mailInServer = props.getProperty("mailInServer");
        mailOutServer = props.getProperty("mailOutServer");
    }
}
