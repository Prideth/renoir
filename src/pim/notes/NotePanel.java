/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package pim.notes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.util.*;
import javax.swing.JPanel;


import pim.*;
import pim.util.WrapLayout;

/**
*
* @author Beware
*/
public class NotePanel extends JPanel implements PanelInterface {

    NoteItem[] noteItems;
    private int size;
    private int selectedIndex;
    private Color bgColor;
    private Color selectedColor;
    private static final String ALPHABETIC = "alphabetic";
    private static final String DATE = "date";
    private static final int MAXARRAYSIZE = 100;

    /**
* Creates new form NotePanel
*/
    public NotePanel() {
        initComponents();
        disableCancelButton();

        bgColor = new java.awt.Color(236, 227, 159);
        selectedColor = new java.awt.Color(244, 239, 202);


        noteItems = new NoteItem[MAXARRAYSIZE];
        size = 0;
        selectedIndex = -1;

        //initNoteItems("");
        TextFieldListener textFieldListener = new TextFieldListener();
        jTextFieldSearch.addMouseListener(textFieldListener);
        
        jPanelContent.setLayout(new WrapLayout(FlowLayout.LEFT, 10, 10));
        
        jPanelContent.setSize(new Dimension(300, 1));
    }

    /**
* This method is called from within the constructor to initialize the form.
* WARNING: Do NOT modify this code. The content of this method is always
* regenerated by the Form Editor.
*/
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonNew = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelContent = new javax.swing.JPanel();
        jButtonDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jComboBoxSort = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButtonUndoSearch = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelContent);

        jButtonDelete.setText("Löschen");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Suche:");

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        jComboBoxSort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Datum", "Alphabetisch" }));
        jComboBoxSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSortActionPerformed(evt);
            }
        });

        jLabel2.setText("Sortieren:");

        jButtonUndoSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/cancel.png"))); // NOI18N
        jButtonUndoSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUndoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNew)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonEdit)
                    .addComponent(jComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUndoSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldSearch)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    
    private void initNoteItems(String searchString) {
        jPanelContent.removeAll();
        if (searchString.isEmpty()) {
            for (int i = 0; i < size; i++) {
                jPanelContent.add(noteItems[i]);
            }
        } else {
            enableCancelButton();
            for (int i = 0; i < size; i++) {
                if (noteItems[i].getTitle().matches(".*" + searchString + ".*") | noteItems[i].getContent().matches(".*" + searchString + ".*")) {
                    jPanelContent.add(noteItems[i]);
                }
            }
        }
        jPanelContent.updateUI();

        selectNote(noteItems[size - 1]);
    }

    
    @Override
    public void updateValues(Object[] values) {
        Note[] notes = (Note[]) values;
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
        } else {
            noteItems = new NoteItem[MAXARRAYSIZE];
            size = 0;
            selectedIndex = -1;
        }
        initNoteItems("");
    }

    
    @Override
    public void insertValue(Object value) {
        Note note = (Note) value;
        NoteItem n = new NoteItem(note);
        n.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                notePanelMousePressed(evt);
            }
        });
        noteItems[size++] = n;
        disableCancelButton();
        jTextFieldSearch.setText("");
        initNoteItems("");}

    
    @Override
    public Object[] getValues() {
        Note[] notes = new Note[size];
        for (int i = 0; i < size; i++) {
            notes[i] = noteItems[i].getNote();
        }
        return notes;
    }

    
    @Override
    public void changeValue(Object value) {
        Note note = (Note) value;
        int index = getIndex(note);
        noteItems[index].setNote(note);
    }

    @Override
    public void deleteValue(Object value) {
        int index = getIndex((Note) value);
        for (int i = index; i < size - 1; i++) {
            noteItems[i] = noteItems[i + 1];
        }
        noteItems[--size] = null;
        selectedIndex = -1;
        unselectAll();
        disableCancelButton();
        initNoteItems("");
    }

    @Override
    public void showAddDialog(JFrame rootWindow) {
        CreateNoteDialog dialog = new CreateNoteDialog(rootWindow, true, null);
        dialog.setLocationRelativeTo(rootWindow);
        dialog.setVisible(true);
        Note note = dialog.getNote();
        if (note != null) {
            insertValue(note);
        }
    }

    @Override
    public void showChangeDialog(Object value, JFrame rootWindow) {
        Note note = (Note) value;
        CreateNoteDialog dialog = new CreateNoteDialog(rootWindow, true, note);
        dialog.setTitle(note.getTitle());
        dialog.setLocationRelativeTo(rootWindow);
        dialog.setVisible(true);
        note = dialog.getNote();
        if (note != null) {
            changeValue(note);
        }
    }

    @Override
    public void showDeleteDialog(Object value, JFrame rootWindow) {
        Note note = (Note) value;
        Object[] options = {"Ja", "Nein"};
        int n = JOptionPane.showOptionDialog(null,
                "Notiz \"" + note.getTitle() + "\" löschen?",
                "Löschen bestätigen",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (n == 0) {
            deleteValue(note);
        }
    }


    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        if (size < noteItems.length) {
            JFrame rootWindow = getRootWindow();
            showAddDialog(rootWindow);
        } else {
            JOptionPane.showMessageDialog(getRootWindow(),
                    "Es können maximal " + noteItems.length + " Notizen erstellt werden.");
        }
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        
        JFrame rootWindow = getRootWindow();
        if (selectedIndex > -1) {
            Note note = noteItems[selectedIndex].getNote();
            showChangeDialog(note, rootWindow);
        } else {
            JOptionPane.showMessageDialog(rootWindow, "Es ist keine Notiz ausgewählt.");
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        JFrame rootWindow = getRootWindow();
        if (selectedIndex > -1) {
            Note note = noteItems[selectedIndex].getNote();
            showDeleteDialog(note, rootWindow);
        } else {
            JOptionPane.showMessageDialog(getRootWindow(), "Es ist keine Notiz ausgewählt.");
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jComboBoxSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSortActionPerformed
        int sortBy = jComboBoxSort.getSelectedIndex();
        if (sortBy == 0) {

            sortList(DATE);
        } else {

            sortList(ALPHABETIC);

        }


    }//GEN-LAST:event_jComboBoxSortActionPerformed

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed

        String searchString = jTextFieldSearch.getText();
        if (size > 0) {
            initNoteItems(searchString);
        }
        if (jTextFieldSearch.getText().isEmpty()) {
            disableCancelButton();
        }


    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jButtonUndoSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoSearchActionPerformed
        disableCancelButton();
        initNoteItems("");

    }//GEN-LAST:event_jButtonUndoSearchActionPerformed

    private void notePanelMousePressed(java.awt.event.MouseEvent evt) {
        if (evt.getButton() == 1) {
            if (evt.getComponent() instanceof NoteItem) {
                NoteItem noteItem = (NoteItem) evt.getComponent();
                selectNote(noteItem);
                if (evt.getClickCount() == 2) {
                    JFrame rootWindow = getRootWindow();
                    showChangeDialog(noteItem.getNote(), rootWindow);
                }
            }
        }
    }

    
    private int getIndex(Note note) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (note == noteItems[i].getNote()) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    private void selectNote(NoteItem noteItem) {
        if (size > 0) {
            unselectAll();
            noteItem.setBackground(selectedColor);
            noteItem.getjTextAreaNoteOut().setBackground(selectedColor);
            noteItem.setjTextAreaNoteOutBgColor(selectedColor);
            selectedIndex = noteItem.getPosition();
        }
    }

    private void unselectAll() {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                noteItems[i].setBackground(bgColor);
                noteItems[i].getjTextAreaNoteOut().setBackground(bgColor);
                selectedIndex = -1;

            }
        }

    }

    private void sortList(String sortBy) {

        if (noteItems.length > 0) {

            List<NoteItem> tempNoteItemList = new ArrayList<NoteItem>();

            for (int i = 0; i < size; i++) {
                tempNoteItemList.add(noteItems[i]);

            }
            ListIterator<NoteItem> it = tempNoteItemList.listIterator(tempNoteItemList.size());


            switch (sortBy) {
                case ALPHABETIC:

                    Collections.sort(tempNoteItemList, TITLE_COMPARATOR);
                    //Collections.reverse(tempNoteItemList);

                    int i = 0;

                    for (NoteItem noteItemTemp : tempNoteItemList) {
                        noteItems[i] = noteItemTemp;

                        i++;
                    }

                    initNoteItems(jTextFieldSearch.getText());
                    unselectAll();


                    break;

                case DATE:

                    Collections.sort(tempNoteItemList, DATE_COMPARATOR);
                    //Collections.reverse(tempNoteItemList);
                    i = 0;

                    for (NoteItem noteItemTemp : tempNoteItemList) {
                        noteItems[i] = noteItemTemp;

                        i++;
                    }

                    initNoteItems(jTextFieldSearch.getText());
                    unselectAll();

                    break;
            }


        }
    }
    

    private void enableCancelButton() {
        jButtonUndoSearch.setEnabled(true);
    }

    private void disableCancelButton() {
        jButtonUndoSearch.setEnabled(false);
        jTextFieldSearch.setText("");
    }
    
    private JFrame getRootWindow() {
        return (JFrame) SwingUtilities.getWindowAncestor(this.getParent());
    }
    
    public final static Comparator<NoteItem> TITLE_COMPARATOR = new Comparator<NoteItem>() {
        @Override
        public int compare(NoteItem p1, NoteItem p2) {
            return p1.getTitle().toLowerCase().compareTo(p2.getTitle().toLowerCase());
        }
    };
    
    public final static Comparator<NoteItem> DATE_COMPARATOR = new Comparator<NoteItem>() {
        @Override
        public int compare(NoteItem p1, NoteItem p2) {
            return p1.getDate().compareTo(p2.getDate());
        }
    };
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonUndoSearch;
    private javax.swing.JComboBox jComboBoxSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}