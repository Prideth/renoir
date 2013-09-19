/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Texts {
    
    private static final String DE = "pim_de_DE.properties";
    private static final String EN = "pim_en_EN.properties";
    
    static private Texts instance = null;
    static public Properties props_de = null;
    static public Properties props_en = null;

    protected Texts() {
        try {
            props_de = new Properties();
            InputStream in = getClass().getResourceAsStream(DE);
            props_de.load(in);
        } catch (IOException e) {
        }
        try {
            props_en = new Properties();
            InputStream in = getClass().getResourceAsStream(EN);
            props_en.load(in);
        } catch (IOException e) {
        }
    }

    static public Texts instance() {
        if (instance == null) {
            instance = new Texts();
        }
        return instance;
    }
}
