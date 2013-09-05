/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.exam;

import javax.swing.JCheckBoxMenuItem;

/**
 *
 * @author lk
 */
public class HeaderPopup extends javax.swing.JPopupMenu {
    
    private JCheckBoxMenuItem jMenuItemSubject;
    private JCheckBoxMenuItem jMenuItemSemester;
    private JCheckBoxMenuItem jMenuItemEcts;
    private JCheckBoxMenuItem jMenuItemDate;
    private JCheckBoxMenuItem jMenuItemTime;
    private JCheckBoxMenuItem jMenuItemRoom;
    private JCheckBoxMenuItem jMenuItemGrade;
    private JCheckBoxMenuItem jMenuItemAverage;

    public HeaderPopup() {
        jMenuItemSubject = new JCheckBoxMenuItem();
        jMenuItemSemester = new JCheckBoxMenuItem();
        jMenuItemEcts = new JCheckBoxMenuItem();
        jMenuItemDate = new JCheckBoxMenuItem();
        jMenuItemTime = new JCheckBoxMenuItem();
        jMenuItemRoom = new JCheckBoxMenuItem();
        jMenuItemGrade = new JCheckBoxMenuItem();
        jMenuItemAverage = new JCheckBoxMenuItem();
        
        jMenuItemSubject.setText("Fach");
        jMenuItemSemester.setText("Semester");
        jMenuItemEcts.setText("ECTS");
        jMenuItemDate.setText("Datum");
        jMenuItemTime.setText("Uhrzeit");
        jMenuItemRoom.setText("Raum");
        jMenuItemGrade.setText("Note");
        jMenuItemAverage.setText("Schnitt");
    
        jMenuItemSubject.setSelected(true);
        jMenuItemSemester.setSelected(true);
        jMenuItemEcts.setSelected(true);
        jMenuItemDate.setSelected(true);
        jMenuItemTime.setSelected(true);
        jMenuItemRoom.setSelected(true);
        jMenuItemGrade.setSelected(true);
        jMenuItemAverage.setSelected(true);

        add(jMenuItemSubject);
        add(jMenuItemSemester);
        add(jMenuItemEcts);
        add(jMenuItemDate);
        add(jMenuItemTime);
        add(jMenuItemRoom);
        add(jMenuItemGrade);
        add(jMenuItemAverage);
    }
}
