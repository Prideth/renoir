/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;

import java.util.Date;
import javax.swing.JFrame;

/**
 * Alle Panels müssen dieses Interface erfüllen, damit der Kalender
 * mit ihnen umgehen kann
 */
public interface PanelInterface {
    
    public void updateValues(Object[] values);
    public void insertValue(Object value);
    public Object[] getValues();
    public void changeValue(Object value);
    public void deleteValue(Object value);
    
    public void showAddDialog(Date date, JFrame rootWindow);
    public void showChangeDialog(Object value, JFrame rootWindow);
    public void showDeleteDialog(Object value, JFrame rootWindow);
}
