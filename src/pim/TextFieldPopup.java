/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;

import java.util.Properties;
import javax.swing.JMenuItem;

/**
 *
 * @author lk
 */
public class TextFieldPopup extends javax.swing.JPopupMenu {
    
    private JMenuItem jMenuItemCopy;
    private JMenuItem jMenuItemCut;
    private JMenuItem jMenuItemDelete;
    private JMenuItem jMenuItemPaste;
    private JMenuItem jMenuItemSelectall;
    private JMenuItem jMenuItemUndo;

    public TextFieldPopup() {
        jMenuItemUndo = new javax.swing.JMenuItem();
        jMenuItemCut = new javax.swing.JMenuItem();
        jMenuItemCopy = new javax.swing.JMenuItem();
        jMenuItemPaste = new javax.swing.JMenuItem();
        jMenuItemDelete = new javax.swing.JMenuItem();
        jMenuItemSelectall = new javax.swing.JMenuItem();
        
 
        Settings settings = Settings.instance();
        setTexts(settings.locale);
        
        jMenuItemUndo.setEnabled(false);
        
        add(jMenuItemUndo);
        add(new Separator());
        add(jMenuItemCut);
        add(jMenuItemCopy);
        add(jMenuItemPaste);
        add(jMenuItemDelete);
        add(new Separator());
        add(jMenuItemSelectall);
    }
    
    private void setTexts(String locale) {
        Properties texts = null;
        switch (locale) {
            case "en":
                texts = Texts.instance().props_en;
                break;
            case "de":
                texts = Texts.instance().props_de;
                break;
        }

        jMenuItemUndo.setText(texts.getProperty("jMenuItemUndo"));
        jMenuItemCut.setText(texts.getProperty("jMenuItemCut"));
        jMenuItemCopy.setText(texts.getProperty("jMenuItemCopy"));
        jMenuItemPaste.setText(texts.getProperty("jMenuItemPaste"));
        jMenuItemDelete.setText(texts.getProperty("jMenuItemDelete"));
        jMenuItemSelectall.setText(texts.getProperty("jMenuItemSelectall"));
    }
}
