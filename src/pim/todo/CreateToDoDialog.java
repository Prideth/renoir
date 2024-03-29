/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.todo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import pim.*;

/**
 * Class CreateToDoDialog to create new todos
 * 
 * @author Joerg Federspiel
 */
public class CreateToDoDialog extends javax.swing.JDialog {
    
    private ToDo toDo;
    Object priorityObject;
    String priorityString ;

    /**
     * Creates new form createToDo
     */
    public CreateToDoDialog(java.awt.Frame parent, boolean modal, ToDo toDo) {
        super(parent, modal);
        this.toDo = toDo;
        initComponents();
        
        TextFieldListener textFieldListener = new TextFieldListener();
        jTextFieldSubject.addMouseListener(textFieldListener);
        jTextFieldBeginDate.addMouseListener(textFieldListener);
        jTextFieldEndDate.addMouseListener(textFieldListener);
        jTextAreaComments.addMouseListener(textFieldListener);
        
        jComboBoxPriority.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                priorityObject = event.getSource();
                priorityString = priorityObject.toString();
            }
        });
        
               
        if (toDo != null) {
            jTextFieldSubject.setText(toDo.getSubject());
            jTextFieldBeginDate.setText(toDo.getBeginDate());
            jTextFieldEndDate.setText(toDo.getEndDate());
            jComboBoxPriority.setSelectedItem(priorityObject);
            jTextAreaComments.setText(toDo.getComments());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSubject = new javax.swing.JLabel();
        jLabelBeginDate = new javax.swing.JLabel();
        jLabelEndDate = new javax.swing.JLabel();
        jLabelPriority = new javax.swing.JLabel();
        jTextFieldSubject = new javax.swing.JTextField();
        jTextFieldBeginDate = new javax.swing.JTextField();
        jTextFieldEndDate = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jComboBoxPriority = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaComments = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelSubject.setText("Betreff:");

        jLabelBeginDate.setText("Beginn:");

        jLabelEndDate.setText("Ende:");

        jLabelPriority.setText("Priorität:");

        jButtonSave.setText("Speichern");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Abbrechen");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jComboBoxPriority.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Niedrig", "Normal", "Hoch" }));
        jComboBoxPriority.setSelectedIndex(1);

        jTextAreaComments.setColumns(20);
        jTextAreaComments.setRows(5);
        jScrollPane1.setViewportView(jTextAreaComments);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPriority)
                            .addComponent(jLabelEndDate)
                            .addComponent(jLabelBeginDate)
                            .addComponent(jLabelSubject))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldBeginDate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldEndDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(jTextFieldSubject)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSubject)
                    .addComponent(jTextFieldSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBeginDate)
                    .addComponent(jTextFieldBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEndDate)
                    .addComponent(jTextFieldEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPriority)
                    .addComponent(jComboBoxPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        String subject = jTextFieldSubject.getText().trim();
        if (!subject.isEmpty()) {
            String beginDate = jTextFieldBeginDate.getText().trim();
            String endDate = jTextFieldEndDate.getText().trim();
            String comments = jTextAreaComments.getText().trim();
            
            if (toDo == null) {
                toDo = new ToDo(subject, beginDate, endDate, priorityString, comments, priorityObject);
            } else {
                toDo.setSubject(subject);
                toDo.setBeginDate(beginDate);
                toDo.setEndDate(endDate);
                toDo.setPriorityString(priorityString);
                toDo.setComments(comments);
                toDo.setPriorityObject(priorityObject);
            }
            this.dispose();
        } else {
            jTextFieldSubject.setText("");
            jTextFieldSubject.requestFocus();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        toDo = null;
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    public ToDo getToDo() {
        return toDo;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxPriority;
    private javax.swing.JLabel jLabelBeginDate;
    private javax.swing.JLabel jLabelEndDate;
    private javax.swing.JLabel jLabelPriority;
    private javax.swing.JLabel jLabelSubject;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaComments;
    private javax.swing.JTextField jTextFieldBeginDate;
    private javax.swing.JTextField jTextFieldEndDate;
    private javax.swing.JTextField jTextFieldSubject;
    // End of variables declaration//GEN-END:variables
}
