/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.notes;

import java.util.Date;

/**
 *
 * @author Beware
 */
public class NoteItem extends javax.swing.JPanel {

    private int pos;
    private Note note;

    
    /**
     * Creates new form NoteItem
     */
    public NoteItem(Note note) {
        initComponents();
        this.note = note;
        pos = 0;
        jLabelTitle.setText(note.getTitle());
        jLabelNote.setText(note.getNoteContent());
        jLableDate.setText(note.getCreateDate().toString());
    }
    
    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
        jLabelTitle.setText(note.getTitle());
        jLabelNote.setText(note.getNoteContent());
        jLableDate.setText(note.getCreateDate().toString());
    }
    
    public int getPosition() {
        return pos;
    }
    
    public void setPosition(int pos) {
        this.pos = pos;
    }
    

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLableDate = new javax.swing.JLabel();
        jLabelNote = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(100, 100));

        jLableDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLableDate.setText("Datum");

        jLabelNote.setText("Inhalt");
        jLabelNote.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitle.setText("Titel");
        jLabelTitle.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(jLableDate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNote, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLableDate))
        );

        jLabelNote.getAccessibleContext().setAccessibleName("Notiz");
        jLabelTitle.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelNote;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLableDate;
    // End of variables declaration//GEN-END:variables
}
