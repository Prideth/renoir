/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author lk
 */
public class TextFieldListener extends MouseAdapter {

    TextFieldPopup popup;

    public TextFieldListener() {
        popup = new TextFieldPopup();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        showPopup(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        showPopup(e);
    }

    private void showPopup(MouseEvent e) {
        if (e.isPopupTrigger()) {
            popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    
}

