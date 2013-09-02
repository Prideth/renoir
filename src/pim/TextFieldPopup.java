/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;

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
        
        jMenuItemUndo.setText("Rückgängig");
        jMenuItemCut.setText("Ausschneiden");
        jMenuItemCopy.setText("Kopieren");
        jMenuItemPaste.setText("Einfügen");
        jMenuItemDelete.setText("Löschen");
        jMenuItemSelectall.setText("Alles markieren");
        
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
}
