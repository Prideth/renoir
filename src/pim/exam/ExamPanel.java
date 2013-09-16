/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.exam;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import pim.PanelInterface;

/**
 *
 * @author lk
 */
public class ExamPanel extends JPanel implements PanelInterface {
    
    private DefaultTableModel model;
    private TableRowSorter sorter;
    
    
    /**
     * Creates new form ExamPanel
     */
    public ExamPanel() {
        initComponents();
        model = (DefaultTableModel) jTableExams.getModel();
        sorter = new TableRowSorter(model);
        sorter.setComparator(1, new sortBySemester());
        jTableExams.setRowSorter(sorter);
        jTableExams.getTableHeader().addMouseListener(new HeaderListener());
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxView = new javax.swing.JComboBox();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabelView = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableExams = new javax.swing.JTable();
        jLabelEctsTitle = new javax.swing.JLabel();
        jLabelEcts = new javax.swing.JLabel();
        jLabelAverageTitle = new javax.swing.JLabel();
        jLabelAverage = new javax.swing.JLabel();
        jButtonResult = new javax.swing.JButton();
        jButtonChange = new javax.swing.JButton();

        jComboBoxView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxViewActionPerformed(evt);
            }
        });

        jButtonAdd.setText("Erstellen");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Löschen");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabelView.setText("Anzeige:");

        jTableExams.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fach", "Semester", "ECTS", "Datum", "Uhrzeit", "Raum", "Note", "Schnitt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableExams.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableExams);

        jLabelEctsTitle.setText("Erreichte ECTS:");

        jLabelEcts.setText("0");

        jLabelAverageTitle.setText("Notendurchschnitt:");

        jLabelAverage.setText("0,0 / 0,0");

        jButtonResult.setText("Ergebnis");
        jButtonResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResultActionPerformed(evt);
            }
        });

        jButtonChange.setText("Ändern");
        jButtonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonChange, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonResult, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxView, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabelEctsTitle)
                .addGap(3, 3, 3)
                .addComponent(jLabelEcts)
                .addGap(18, 18, 18)
                .addComponent(jLabelAverageTitle)
                .addGap(3, 3, 3)
                .addComponent(jLabelAverage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonResult)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonChange)
                    .addComponent(jButtonAdd)
                    .addComponent(jLabelView)
                    .addComponent(jComboBoxView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEctsTitle)
                    .addComponent(jLabelEcts)
                    .addComponent(jLabelAverageTitle)
                    .addComponent(jLabelAverage))
                .addGap(0, 0, 0))
        );

        String[] values = new String[Exam.SEMESTER.length + 2];
        values[0] = "Alle Klausuren";
        values[1] = "Ohne Ergebnis";
        for (int i = 2; i < Exam.SEMESTER.length + 2; i++) {
            values[i] = Exam.SEMESTER[i-2];
        }
        jComboBoxView.setModel(new javax.swing.DefaultComboBoxModel(values));
    }// </editor-fold>//GEN-END:initComponents

    
    private void initColumnSizes() {
        TableColumn column;
        Component comp;
        int headWidth;
        int cellWidth;

        TableCellRenderer render = jTableExams.getTableHeader().getDefaultRenderer();

        int colNum = jTableExams.getColumnCount();
        int rowNum = jTableExams.getRowCount();

        for (int i = 0; i < (colNum); i++) {
            column = jTableExams.getColumnModel().getColumn(i);
            comp = render.getTableCellRendererComponent(
                    null, column.getHeaderValue(), false, false, 0, 0);
            headWidth = comp.getPreferredSize().width;
            cellWidth = 0;

            for (int j = 0; j < (rowNum); j++) {
                comp = render.getTableCellRendererComponent(
                        jTableExams, jTableExams.getValueAt(j, i), false, false, j, i);
                cellWidth = Math.max(cellWidth, comp.getPreferredSize().width);
            }
            column.setPreferredWidth(Math.max(headWidth, cellWidth));
        }
    }

    @Override
    public void updateValues(Object[] values) {
        Exam[] exams = (Exam[]) values;
        if (exams != null) {
            for (int i = jTableExams.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            for (int i = 0; i < exams.length; i++) {
                model.addRow(exams[i].getTableRow());
            }
            initColumnSizes();
            calculateAverage();
        } else {
            for (int i = jTableExams.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            jLabelEcts.setText("0");
            jLabelAverage.setText("0.0 / 0.0");
        }
    }

    @Override
    public void insertValue(Object value) {
        Exam exam = (Exam) value;
        model.addRow(exam.getTableRow());
        jTableExams.changeSelection(jTableExams.convertRowIndexToView(model.getRowCount() - 1), 0, true, false);
        calculateAverage();
    }

    @Override
    public Object[] getValues() {
        Exam[] exams = new Exam[model.getRowCount()];
        for (int i = 0; i < exams.length; i++) {
            exams[i] = (Exam) model.getValueAt(i, 0);
        }
        return exams;
    }

    @Override
    public void changeValue(Object value) {
        Exam exam = (Exam) value;
        int index = getIndex(exam);
        model.removeRow(index);
        model.insertRow(index, exam.getTableRow());
        jTableExams.changeSelection(jTableExams.convertRowIndexToView(index), 0, true, false);
        calculateAverage();
    }

    @Override
    public void deleteValue(Object value) {
        Exam exam = (Exam) value;
        int index = getIndex(exam);
        model.removeRow(index);
        calculateAverage();
    }
    
    @Override
    public void showAddDialog(JFrame rootWindow) {
        CreateExamDialog dialog = new CreateExamDialog(rootWindow, true, null);
        dialog.setTitle("Klausur erstellen");
        dialog.setLocationRelativeTo(rootWindow);
        dialog.setVisible(true);
        Exam exam = dialog.getExam();
        if (exam != null) {
            insertValue(exam);
        }
    }

    @Override
    public void showChangeDialog(Object value, JFrame rootWindow) {
        Exam exam = (Exam) value;
        CreateExamDialog dialog = new CreateExamDialog(rootWindow, true, exam);
        dialog.setTitle(exam.getSubject());
        dialog.setLocationRelativeTo(rootWindow);
        dialog.setVisible(true);
        exam = dialog.getExam();
        if (exam != null) {
            changeValue(exam);
        }
    }

    @Override
    public void showDeleteDialog(Object value, JFrame rootWindow) {
        Exam exam = (Exam) value;
        Object[] options = {"Ja", "Nein"};
        int n = JOptionPane.showOptionDialog(rootWindow,
                "Klausur \"" + exam.getSubject() + "\" löschen?",
                "Löschen bestätigen",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        
        if (n == 0) {
            deleteValue(exam);
        }
    }

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        JFrame rootWindow = getRootWindow();
        showAddDialog(rootWindow);
    }//GEN-LAST:event_jButtonAddActionPerformed
    
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        JFrame rootWindow = getRootWindow();
        int index = getSelectedRow();
        if (index > -1) {
            Exam exam = (Exam) model.getValueAt(index, 0);
            showDeleteDialog(exam, rootWindow);
        } else {
             JOptionPane.showMessageDialog(rootWindow, "Es ist keine Klausur ausgewählt.");
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResultActionPerformed
        int index = getSelectedRow();
        JFrame rootWindow = getRootWindow();
        if (index > -1) {
            Exam exam = (Exam) model.getValueAt(index, 0);
            GradesDialog dialog = new GradesDialog(rootWindow, true, exam);
            dialog.setTitle(exam.getSubject());
            dialog.setLocationRelativeTo(rootWindow);
            dialog.setVisible(true);
            exam = dialog.getExam();
            if (exam != null) {
                model.removeRow(index);
                model.insertRow(index, exam.getTableRow());
                jTableExams.changeSelection(jTableExams.convertRowIndexToView(index), 0, true, false);
                calculateAverage();
            }
        } else {
             JOptionPane.showMessageDialog(rootWindow, "Es ist keine Klausur ausgewählt.");
        }
    }//GEN-LAST:event_jButtonResultActionPerformed

    
    private void jButtonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeActionPerformed
        JFrame rootWindow = getRootWindow();
        int index = getSelectedRow();
        if (index > -1) {
            Exam exam = (Exam) model.getValueAt(index, 0);
            if (exam != null) {
                showChangeDialog(exam, rootWindow);
            }
        } else {
             JOptionPane.showMessageDialog(rootWindow, "Es ist keine Klausur ausgewählt.");
        }
    }//GEN-LAST:event_jButtonChangeActionPerformed

    private int getIndex(Exam exam) {
        int index = -1;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (exam == model.getValueAt(i, 0)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    
    private void jComboBoxViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxViewActionPerformed
        if (jComboBoxView.getSelectedIndex() == 0) {
            sorter.setRowFilter(null);
        } else if (jComboBoxView.getSelectedIndex() == 1) {
            sorter.setRowFilter(RowFilter.regexFilter("^$", 6));
        } else {
            sorter.setRowFilter(RowFilter.regexFilter((String) jComboBoxView.getSelectedItem(), 1));
        }
    }//GEN-LAST:event_jComboBoxViewActionPerformed

    
    private void calculateAverage() {
        int ects1 = 0;
        int ects2 = 0;
        double sum1 = 0d;
        double sum2 = 0d; 
        for (int i = 0; i < model.getRowCount(); i++) {
            Exam exam = (Exam)model.getValueAt(i, 0);
            if (exam.getGrade() > 0.0 && exam.getGrade() < 5.0) {
                sum1 += exam.getEcts() * exam.getGrade();
                ects1 += exam.getEcts();
                if (exam.getAverage() > 0.0) {
                    sum2 += exam.getEcts() * exam.getAverage();
                    ects2 += exam.getEcts();
                }
            }
        }
        double average1 = Math.round((sum1 / ects1) * 10d) / 10d;
        double average2 = Math.round((sum2 / ects2) * 10d) / 10d;
        jLabelEcts.setText(ects1 + "");
        jLabelAverage.setText(average1 + " / " + average2);
    }
    
    
    
    private int getSelectedRow() {
        int index = jTableExams.getSelectedRow();
        if (index >= 0) {
            index = jTableExams.convertRowIndexToModel(index);
        }
        return index;
    }

    private JFrame getRootWindow() {
        return (JFrame) SwingUtilities.getWindowAncestor(this.getParent());
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonChange;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonResult;
    private javax.swing.JComboBox jComboBoxView;
    private javax.swing.JLabel jLabelAverage;
    private javax.swing.JLabel jLabelAverageTitle;
    private javax.swing.JLabel jLabelEcts;
    private javax.swing.JLabel jLabelEctsTitle;
    private javax.swing.JLabel jLabelView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableExams;
    // End of variables declaration//GEN-END:variables

}
