/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.notes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Collections;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.util.Collections;
import java.util.Comparator;

import pim.*;


/**
 *
 * @author Beware
 */
public class NotePanel extends javax.swing.JPanel {

    NoteItem[] noteItems;
    private int size;
    private int selectedIndex;
    private Color bgColor;
    
    private static final String ALPHABETIC = "alphabetic";
    private static final String DATE = "date";
    private static final int MAXARRAYSIZE = 50;
            
    
    /**
     * Creates new form NotePanel
     */
    public NotePanel(Note[] notes) {
        initComponents();
        noteItems = new NoteItem[MAXARRAYSIZE];
        
        size = 0;
        selectedIndex = -1;
        
        if (notes != null) {
            size = notes.length;
            
             for (int i = 0; i < size; i++) {
                noteItems[i] = new NoteItem(notes[i]);
                noteItems[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        notePanelMousePressed(evt);
                    }
                });
            }
        }
        
        initNoteItems();
        TextFieldListener textFieldListener = new TextFieldListener();
        jTextFieldSearch.addMouseListener(textFieldListener);
        bgColor = this.getBackground();
        
        
    }

    private void initNoteItems() {

        
        
        //create a GroupLayout object associate with the panel  
        GroupLayout grpLayout = new GroupLayout(jPanel1); 
        jPanel1.setLayout(grpLayout);  
        grpLayout.setAutoCreateGaps(true);      // specify automatic gap insertion  
        grpLayout.setAutoCreateContainerGaps(true);  
        GroupLayout.Group group1 = grpLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.Group group2 = grpLayout.createSequentialGroup().addGap(5);

        for (int i = size - 1; i >= 0; i--) {
            noteItems[i].setPosition(i);
            
            if (noteItems[i].getPosition() % 2 == 0) {
                
                group1.addComponent(noteItems[i], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                group2.addComponent(noteItems[i], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
                group2.addGap(10);
  
            } else {
        
                group1.addComponent(noteItems[i], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                group2.addComponent(noteItems[i], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
                group2.addGap(10);
  
            }
            
            
        }

        grpLayout.setHorizontalGroup(
                grpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(grpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(group1)
                .addContainerGap()));

        grpLayout.setVerticalGroup(
                grpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(group2));
        
        
        
        selectNote(size - 1);
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    


    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonNew = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jComboBoxSort = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(200, 200));

        jButtonNew.setText("Erstellen");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Ändern");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jButtonDelete.setText("Löschen");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Suche:");

        jComboBoxSort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Datum", "Alphabetisch" }));
        jComboBoxSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSortActionPerformed(evt);
            }
        });

        jLabel2.setText("Sortieren:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxSort, 0, 100, Short.MAX_VALUE)
                    .addComponent(jButtonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 145, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNew)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonEdit))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        if (size < noteItems.length) {
            JFrame rootWindow = getRootWindow();
            CreateNoteDialog dialog = new CreateNoteDialog(rootWindow, true, null);
            dialog.setTitle("Notiz erstellen"); //FIXME
            dialog.setLocationRelativeTo(rootWindow);
            dialog.setVisible(true);
            Note note = dialog.getNote();
            
            if (note != null) {
                NoteItem n = new NoteItem(dialog.getNote());
                n.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        notePanelMousePressed(evt);
                    }
                });
                noteItems[size++] = n;
                initNoteItems();
            }
        } else {
            JOptionPane.showMessageDialog(getRootWindow(),
                    "Es können maximal " + noteItems.length + " Notizen erstellt werden.");
        }
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        if (selectedIndex > -1) {        
            Note note = noteItems[selectedIndex].getNote();
            
            JFrame rootWindow = getRootWindow();
            CreateNoteDialog dialog = new CreateNoteDialog(rootWindow, true, note);
            dialog.setTitle(note.getTitle());
            dialog.setLocationRelativeTo(rootWindow);
            dialog.setVisible(true);
            note = dialog.getNote();
            if (note != null) {
                noteItems[selectedIndex].setNote(note);
            }
        } else {
            JOptionPane.showMessageDialog(getRootWindow(), "Es ist keine Notiz ausgewählt.");
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if (selectedIndex > -1) {         
            
            Object[] options = {"Ja", "Nein"};
            int n = JOptionPane.showOptionDialog(null,
                    "Notiz \"" + noteItems[selectedIndex].getNote().getTitle()+ "\" löschen?",
                    "Löschen bestätigen",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (n == 0) {
                for (int i = selectedIndex; i < size - 1; i++) {
                    noteItems[i] = noteItems[i + 1];
                }
                noteItems[--size] = null;
                selectedIndex = -1;
                initNoteItems();
            }
        } else {
            JOptionPane.showMessageDialog(getRootWindow(), "Es ist keine Notiz ausgewählt.");
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jComboBoxSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSortActionPerformed
        int sortBy = jComboBoxSort.getSelectedIndex();
        if (sortBy == 0) {
            JOptionPane.showMessageDialog(getRootWindow(), "Nach Dat Sortieren");
            sortList(DATE);
        } else {
            JOptionPane.showMessageDialog(getRootWindow(), "Nach Alph Sortieren.");
            sortList(ALPHABETIC);
        }
    
    }//GEN-LAST:event_jComboBoxSortActionPerformed

    private void notePanelMousePressed(java.awt.event.MouseEvent evt) {
        selectNote(((NoteItem) evt.getComponent()).getPosition());
    }
    
        
    
    
    private void selectNote(int position) {
        if (size > 0) {
            if (selectedIndex > -1) {
                noteItems[selectedIndex].setBackground(bgColor);
            }
            noteItems[position].setBackground(new Color(233, 236, 242));
            selectedIndex = position;
        }
    }
    
    private JFrame getRootWindow() {
        return (JFrame) SwingUtilities.getWindowAncestor(this.getParent());
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JComboBox jComboBoxSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables



    private void sortList(String sortBy) {
        if (noteItems.length > 0) {
            switch (sortBy) {
                case ALPHABETIC:
                    JOptionPane.showMessageDialog(getRootWindow(), "Es wird nach alph sortiert");
                    
                    break;
                    
                case DATE:
                    JOptionPane.showMessageDialog(getRootWindow(), "Es wird nach date sortiert");
                    
                    break;
            }
        }   
    }
    


}
