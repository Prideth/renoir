/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lk
 */
public class CalendarPanel extends javax.swing.JPanel {
    
    private DefaultTableModel model;

    /**
     * Creates new form CalendarPanel
     */
    public CalendarPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooserComboCalendar = new datechooser.beans.DateChooserCombo();
        jLabelChooseDate = new javax.swing.JLabel();
        jScrollPaneCalendar = new javax.swing.JScrollPane();
        jTableCalendar = new javax.swing.JTable();
        jButtonCalendarNew = new javax.swing.JButton();
        jButtonCalendarChange = new javax.swing.JButton();
        jButtonCalendarDelete = new javax.swing.JButton();

        jDateChooserComboCalendar.setCalendarPreferredSize(new java.awt.Dimension(350, 200));

        jLabelChooseDate.setText("Wähle ein Datum");

        jTableCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Datum", "Uhrzeit", "Bezeichnung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCalendar.setColumnSelectionAllowed(true);
        jTableCalendar.getTableHeader().setReorderingAllowed(false);
        jScrollPaneCalendar.setViewportView(jTableCalendar);
        jTableCalendar.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCalendar.getColumnModel().getColumn(0).setMinWidth(70);
        jTableCalendar.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTableCalendar.getColumnModel().getColumn(0).setMaxWidth(70);
        jTableCalendar.getColumnModel().getColumn(1).setMinWidth(70);
        jTableCalendar.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTableCalendar.getColumnModel().getColumn(1).setMaxWidth(70);
        jTableCalendar.getColumnModel().getColumn(2).setResizable(false);
        jTableCalendar.getColumnModel().getColumn(2).setPreferredWidth(50);

        jButtonCalendarNew.setText("Termin hinzufügen");
        jButtonCalendarNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalendarNewActionPerformed(evt);
            }
        });

        jButtonCalendarChange.setText("Termin ändern");
        jButtonCalendarChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalendarChangeActionPerformed(evt);
            }
        });

        jButtonCalendarDelete.setText("Termin löschen");
        jButtonCalendarDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalendarDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCalendarNew)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonCalendarChange)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonCalendarDelete))
                    .addComponent(jDateChooserComboCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChooseDate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPaneCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabelChooseDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserComboCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCalendarNew)
                    .addComponent(jButtonCalendarChange)
                    .addComponent(jButtonCalendarDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalendarNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalendarNewActionPerformed
        JFrame rootWindow = getRootWindow();
        CreateDateDialog dialog = new CreateDateDialog(rootWindow, true, null);
        dialog.setTitle("Termin erstellen");
        dialog.setLocationRelativeTo(rootWindow);
        dialog.setVisible(true);
        Date date = dialog.getDate();
        if (date != null) {
            model.addRow(date.getTableRow());
            jTableCalendar.changeSelection(jTableCalendar.convertRowIndexToView(model.getRowCount() - 1), 0, true, false);
        }
    }//GEN-LAST:event_jButtonCalendarNewActionPerformed

    private void jButtonCalendarChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalendarChangeActionPerformed
        int index = jTableCalendar.getSelectedRow();
        if (index > -1) {
            Date date = (Date) model.getValueAt(index, 0);
            JFrame rootWindow = getRootWindow();
            CreateDateDialog dialog = new CreateDateDialog(rootWindow, true, date);
            dialog.setTitle("Termin ändern");
            dialog.setLocationRelativeTo(rootWindow);
            dialog.setVisible(true);
            date = dialog.getDate();
            if (date != null) {
                model.removeRow(index);
                model.insertRow(index, date.getTableRow());
                jTableCalendar.changeSelection(jTableCalendar.convertRowIndexToView(index), 0, true, false);
            }
        }
    }//GEN-LAST:event_jButtonCalendarChangeActionPerformed

    private void jButtonCalendarDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalendarDeleteActionPerformed
        int index = jTableCalendar.getSelectedRow();
        if (index > -1) {
            Date exam = (Date) model.getValueAt(index, 0);
            Object[] options = {"Ja", "Nein"};
            int n = JOptionPane.showOptionDialog(getRootWindow(),
                    "Termin wirklich löschen?",
                    "Löschen bestätigen",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            
            if (n == 0) {
                model.removeRow(index);
            }
        }
    }//GEN-LAST:event_jButtonCalendarDeleteActionPerformed
    
    private JFrame getRootWindow() {
        return (JFrame) SwingUtilities.getWindowAncestor(this.getParent());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalendarChange;
    private javax.swing.JButton jButtonCalendarDelete;
    private javax.swing.JButton jButtonCalendarNew;
    private datechooser.beans.DateChooserCombo jDateChooserComboCalendar;
    private javax.swing.JLabel jLabelChooseDate;
    private javax.swing.JScrollPane jScrollPaneCalendar;
    private javax.swing.JTable jTableCalendar;
    // End of variables declaration//GEN-END:variables
}
