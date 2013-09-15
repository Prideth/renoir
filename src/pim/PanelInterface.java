/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;

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
    
}
