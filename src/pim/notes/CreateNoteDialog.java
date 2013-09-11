/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.notes;

import java.text.SimpleDateFormat;
import java.util.Date;
import pim.TextFieldListener;

/**
 *
 * @author Beware
 */
public class CreateNoteDialog extends javax.swing.JDialog {

    private Note note;
    
    /**
     * Creates new form CreateNoteDialog
     */
    public CreateNoteDialog(java.awt.Frame parent, boolean modal, Note note) {
        super(parent, modal);
        this.note = note;
        initComponents();
        
        TextFieldListener textFieldListener = new TextFieldListener();
        jTextFieldName.addMouseListener(textFieldListener);
        jTextAreaNote.addMouseListener(textFieldListener);
        
        if (note != null) {
            jTextFieldName.setText(note.getTitle());
            jTextAreaNote.setText(note.getNoteContent());
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

        jLabelNote = new javax.swing.JLabel();
        jButtonCancel = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jButtonOk = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaNote = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelNote.setText("Notiz:");

        jButtonCancel.setText("Abbrechen");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jLabelName.setText("Titel:");

        jTextAreaNote.setColumns(20);
        jTextAreaNote.setLineWrap(true);
        jTextAreaNote.setRows(5);
        jTextAreaNote.setMaximumSize(new java.awt.Dimension(100, 100));
        jScrollPane1.setViewportView(jTextAreaNote);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNote)
                            .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldName)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNote)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        note = null;
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        String name = jTextFieldName.getText().trim();
        if (!name.isEmpty()) {
            String title = jTextFieldName.getText().trim();
            String noteContent = jTextAreaNote.getText().trim();

            Date dt = new Date();
            SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm" );

            if (note == null) {
                note = new Note(0, title, noteContent, dt);
            } else {
                note.setTitle(name);
                note.setNoteContent(noteContent);
                note.setCreateDate(dt);
            }
            this.dispose();
        } else {
            jTextFieldName.setText("");
            jTextFieldName.requestFocus();
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    public Note getNote() {
        return note;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNote;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaNote;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}