/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.calendar2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author lk
 */
public class CalendarPopup extends javax.swing.JPopupMenu {
    
    private JMenuItem jMenuItemExam;
    private JMenuItem jMenuItemToDo;
    private JMenuItem jMenuItemNote;
    private JMenuItem jMenuItemChange;
    private JMenuItem jMenuItemDelete;
    private CalendarPanel cp;
    

    public CalendarPopup(CalendarPanel cp, boolean filled) {
        this.cp = cp;
        jMenuItemExam = new javax.swing.JMenuItem();
        jMenuItemToDo = new javax.swing.JMenuItem();
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
        jMenuItemToDo.addActionListener(al);
        jMenuItemNote.addActionListener(al);
        jMenuItemChange.addActionListener(al);
        jMenuItemDelete.addActionListener(al);
        
        if (filled) {
            jMenuItemExam.setEnabled(false);
            jMenuItemToDo.setEnabled(false);
            jMenuItemNote.setEnabled(false);
        } else {
            jMenuItemChange.setEnabled(false);
            jMenuItemDelete.setEnabled(false);
        }
        
        jMenuItemExam.setText("Neue Klausur");
        jMenuItemToDo.setText("Neuer Termin");
        jMenuItemNote.setText("Neue Notiz");
        jMenuItemChange.setText("Ändern");
        jMenuItemDelete.setText("Löschen");
        
        add(jMenuItemExam);
        add(jMenuItemToDo);
        add(jMenuItemNote);
        add(new JPopupMenu.Separator());
        add(jMenuItemChange);
        add(jMenuItemDelete);
    }
    
    private void action(ActionEvent evt) {
        if (evt.getSource() == jMenuItemExam) {
            cp.insertExam();
        } else if (evt.getSource() == jMenuItemToDo) {
            
        } else if (evt.getSource() == jMenuItemNote) {
            cp.insertNote();
        } else if (evt.getSource() == jMenuItemChange) {
            
        } else if (evt.getSource() == jMenuItemDelete) {
            
        }
    }
}
