/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.calendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import pim.Settings;
import pim.Texts;

/**
 *
 * @author lk
 */
public class CalendarPopup extends javax.swing.JPopupMenu {
    
    private JMenuItem jMenuItemExam;
    private JMenuItem jMenuItemEvent;
    private JMenuItem jMenuItemNote;
    private JMenuItem jMenuItemChange;
    private JMenuItem jMenuItemDelete;
    private CalendarPanel cp;
    

    public CalendarPopup(CalendarPanel cp, boolean filled) {
        this.cp = cp;
        jMenuItemExam = new javax.swing.JMenuItem();
        jMenuItemEvent = new javax.swing.JMenuItem();
        jMenuItemNote = new javax.swing.JMenuItem();
        jMenuItemChange = new javax.swing.JMenuItem();
        jMenuItemDelete = new javax.swing.JMenuItem();
        
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                action(evt);
            }
        };
        
        jMenuItemExam.addActionListener(al);
        jMenuItemEvent.addActionListener(al);
        jMenuItemNote.addActionListener(al);
        jMenuItemChange.addActionListener(al);
        jMenuItemDelete.addActionListener(al);
        
        if (filled) {
            jMenuItemExam.setEnabled(false);
            jMenuItemEvent.setEnabled(false);
            jMenuItemNote.setEnabled(false);
        } else {
            jMenuItemChange.setEnabled(false);
            jMenuItemDelete.setEnabled(false);
        }
        
        setTexts(Settings.locale);
        
        
        add(jMenuItemExam);
        add(jMenuItemEvent);
        add(jMenuItemNote);
        add(new JPopupMenu.Separator());
        add(jMenuItemChange);
        add(jMenuItemDelete);
    }
    
    public void setTexts(String locale) {
        Properties texts = null;
        switch (locale) {
            case "en":
                texts = Texts.props_en;
                break;
            case "de":
                texts = Texts.props_de;
                break;
        }

        if (texts != null) {
            jMenuItemExam.setText(texts.getProperty("jMenuItemExam"));
            jMenuItemEvent.setText(texts.getProperty("jMenuItemEvent"));
            jMenuItemNote.setText(texts.getProperty("jMenuItemNote"));
            jMenuItemChange.setText(texts.getProperty("jMenuItemChange"));
            jMenuItemDelete.setText(texts.getProperty("jMenuItemDelete"));

        }

    }
    
    private void action(ActionEvent evt) {
        if (evt.getSource() == jMenuItemExam) {
            cp.insert(0);
        } else if (evt.getSource() == jMenuItemEvent) {
            cp.insert(1);
        } else if (evt.getSource() == jMenuItemNote) {
            cp.insert(2);
        } else if (evt.getSource() == jMenuItemChange) {
            cp.change();
        } else if (evt.getSource() == jMenuItemDelete) {
            cp.delete();
        }
    }
}
