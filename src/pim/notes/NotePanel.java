/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.notes;

import java.awt.BorderLayout;
import java.awt.Color;
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


import pim.*;


/**
 *
 * @author Beware
 */
public class NotePanel extends javax.swing.JPanel  {

    NoteItem[] noteItems;
    private int size;
    private int selectedIndex;
    private Color bgColor;
    private Color selectedColor;
    
    private static final String ALPHABETIC = "alphabetic";
    private static final String DATE = "date";
    private static final int MAXARRAYSIZE = 100;
    
    
         
    private DateFormat df = new SimpleDateFormat();

    
    
    
    /**
     * Creates new form NotePanel
     */
    public NotePanel() {
        initComponents();
        disableCancelButton();
        
        bgColor = new java.awt.Color(236, 227, 159);
        selectedColor = new java.awt.Color(244,239,202);
        
        
        noteItems = new NoteItem[MAXARRAYSIZE];
        size = 0;
        selectedIndex = -1;
        
        //initNoteItems("");
        TextFieldListener textFieldListener = new TextFieldListener();
        jTextFieldSearch.addMouseListener(textFieldListener);
    }

    
    public void updateNotes(Note[] notes) {
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
    
    
    public Note[] getNotes() {
        Note[] notes = new Note[size];
        for (int i = 0; i < size; i++) {
            notes[i] = noteItems[i].getNote();
        }
        return notes;
    }
    
    
    
    private void initNoteItems(String searchString) {

        jPanelLeft.removeAll();
        jPanelRight.removeAll();
        
        
        if (searchString.isEmpty()) {
            
            
            //create a GroupLayout object associate with the panel  
            GroupLayout grpLayoutLeft = new GroupLayout(jPanelLeft); 
            jPanelLeft.setLayout(grpLayoutLeft);  
            grpLayoutLeft.setAutoCreateGaps(true);      // specify automatic gap insertion  
            grpLayoutLeft.setAutoCreateContainerGaps(true);  
            GroupLayout.Group group1 = grpLayoutLeft.createParallelGroup(GroupLayout.Alignment.LEADING);
            GroupLayout.Group group2 = grpLayoutLeft.createSequentialGroup().addGap(5);



            GroupLayout grpLayoutRight = new GroupLayout(jPanelRight); 
            jPanelRight.setLayout(grpLayoutRight);  
            grpLayoutRight.setAutoCreateGaps(true);      // specify automatic gap insertion  
            grpLayoutRight.setAutoCreateContainerGaps(true);  
            GroupLayout.Group group3 = grpLayoutRight.createParallelGroup(GroupLayout.Alignment.LEADING);
            GroupLayout.Group group4 = grpLayoutRight.createSequentialGroup().addGap(5);     

            for (int i = 0; i <= size - 1; i++) {
                noteItems[i].setPosition(i);
                System.out.println("IsEmpty");
                
                if (noteItems[i].getPosition() % 2 == 0) {
                    group1.addComponent(noteItems[i], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                    group2.addComponent(noteItems[i], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
                    group2.addGap(10);
                    
                } else {
                    group3.addComponent(noteItems[i], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                    group4.addComponent(noteItems[i], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
                    group4.addGap(10);
                }  
            }
            
            
            
            grpLayoutLeft.setHorizontalGroup(
                grpLayoutLeft.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(grpLayoutLeft.createSequentialGroup()
                .addContainerGap()
                .addGroup(group1)
                .addContainerGap()));

            grpLayoutLeft.setVerticalGroup(
                grpLayoutLeft.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(group2));
        
        
            grpLayoutRight.setHorizontalGroup(
                grpLayoutRight.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(grpLayoutRight.createSequentialGroup()
                .addContainerGap()
                .addGroup(group3)
                .addContainerGap()));

            grpLayoutRight.setVerticalGroup(
                grpLayoutRight.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(group4));
            
            
            
            
            
            
            
            
            
        } else {
            
            enableCancelButton();
            //create a GroupLayout object associate with the panel  
            GroupLayout grpLayoutLeftSearched = new GroupLayout(jPanelLeft); 
            jPanelLeft.setLayout(grpLayoutLeftSearched);  
            grpLayoutLeftSearched.setAutoCreateGaps(true);      // specify automatic gap insertion  
            grpLayoutLeftSearched.setAutoCreateContainerGaps(true);  
            GroupLayout.Group group1Searched = grpLayoutLeftSearched.createParallelGroup(GroupLayout.Alignment.LEADING);
            GroupLayout.Group group2Searched = grpLayoutLeftSearched.createSequentialGroup().addGap(5);



            GroupLayout grpLayoutRightSearched = new GroupLayout(jPanelRight); 
            jPanelRight.setLayout(grpLayoutRightSearched);  
            grpLayoutRightSearched.setAutoCreateGaps(true);      // specify automatic gap insertion  
            grpLayoutRightSearched.setAutoCreateContainerGaps(true);  
            GroupLayout.Group group3Searched = grpLayoutRightSearched.createParallelGroup(GroupLayout.Alignment.LEADING);
            GroupLayout.Group group4Searched = grpLayoutRightSearched.createSequentialGroup().addGap(5);     
            

            unselectAll();
            int counter = 0;
            for (int i = 0; i <= size - 1; i++) {
                //noteItems[i].setPosition(i);
                
                System.out.println(noteItems[i].getTitle() + " " + i);
                if (noteItems[i].getTitle().matches(".*"+searchString+".*") | noteItems[i].getContent().matches(".*"+searchString+".*")) {
                    System.out.println(noteItems[i].getTitle() + " passt");
                    if (counter % 2 == 0) {
                        group1Searched.addComponent(noteItems[i], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                        group2Searched.addComponent(noteItems[i], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
                        group2Searched.addGap(10);
                        System.out.println(i + " add links");
                    } else {
                        group3Searched.addComponent(noteItems[i], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                        group4Searched.addComponent(noteItems[i], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
                        group4Searched.addGap(10);
                        System.out.println(i + " add rechts");
                    } 
                    counter++;
                }
            }
            
            
            grpLayoutLeftSearched.setHorizontalGroup(
                grpLayoutLeftSearched.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(grpLayoutLeftSearched.createSequentialGroup()
                .addContainerGap()
                .addGroup(group1Searched)
                .addContainerGap()));

            grpLayoutLeftSearched.setVerticalGroup(
                grpLayoutLeftSearched.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(group2Searched));


            grpLayoutRightSearched.setHorizontalGroup(
                grpLayoutRightSearched.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(grpLayoutRightSearched.createSequentialGroup()
                .addContainerGap()
                .addGroup(group3Searched)
                .addContainerGap()));

            grpLayoutRightSearched.setVerticalGroup(
                grpLayoutRightSearched.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(group4Searched));
            
            
            
            
            
            
            
            
        }
        
      
        
                
        
        
        //selectNote(size - 1);
        
        
        
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
        jPanelLeft = new javax.swing.JPanel();
        jPanelRight = new javax.swing.JPanel();
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

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );
        jPanelLeftLayout.setVerticalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRightLayout = new javax.swing.GroupLayout(jPanelRight);
        jPanelRight.setLayout(jPanelRightLayout);
        jPanelRightLayout.setHorizontalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );
        jPanelRightLayout.setVerticalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jScrollPane1.setViewportView(jPanel1);

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
                        .addGap(0, 125, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUndoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNew)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonEdit))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUndoSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldSearch)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    
    
    public void insertNote(Note note) {

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
        initNoteItems("");
    }
    
    
    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        if (size < noteItems.length) {
            JFrame rootWindow = getRootWindow();
            CreateNoteDialog dialog = new CreateNoteDialog(rootWindow, true, null);
            dialog.setTitle("Notiz erstellen"); //FIXME
            dialog.setLocationRelativeTo(rootWindow);
            dialog.setVisible(true);
            Note note = dialog.getNote();
            
            if (note != null) {
                insertNote(note);
            }
        } else {
            JOptionPane.showMessageDialog(getRootWindow(),
                    "Es können maximal " + noteItems.length + " Notizen erstellt werden.");
        }
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        if (selectedIndex > -1) {    
            editSelectedNote();

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
                System.out.println("es wird geloescht:" + noteItems[selectedIndex].getTitle());
                for (int i = selectedIndex; i < size - 1; i++) {
                    noteItems[i] = noteItems[i + 1];
                }
                noteItems[--size] = null;
                selectedIndex = -1;
                unselectAll();
                disableCancelButton();
                initNoteItems("");
            }
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
        selectNote(((NoteItem) evt.getComponent()).getPosition());
        if (evt.getClickCount() == 2) {
            editSelectedNote();
        }  
    }
    
        
    
    
    private void selectNote(int position) {
        if (size > 0) {
            if (selectedIndex > -1) {
                noteItems[selectedIndex].setBackground(bgColor);
                noteItems[selectedIndex].getjTextAreaNoteOut().setBackground(bgColor);
            }
            noteItems[position].setBackground(selectedColor);
            noteItems[position].getjTextAreaNoteOut().setBackground(bgColor);
            selectedIndex = position;
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
    
    private JFrame getRootWindow() {
        return (JFrame) SwingUtilities.getWindowAncestor(this.getParent());
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonUndoSearch;
    private javax.swing.JComboBox jComboBoxSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables



    private void sortList(String sortBy) {

        if (noteItems.length > 0) {
            
            List<NoteItem> tempNoteItemList = new ArrayList<NoteItem>();
            
            for (int i = 0; i < size; i++) {                       
                tempNoteItemList.add(noteItems[i]);
                System.out.println(noteItems[i].getTitle() + " " + noteItems[i].getDate());
            } 
            ListIterator<NoteItem> it = tempNoteItemList.listIterator(tempNoteItemList.size());
            
            
            switch (sortBy) {
                case ALPHABETIC:

                    Collections.sort(tempNoteItemList, TITLE_COMPARATOR);
                    //Collections.reverse(tempNoteItemList);

                    int i = 0;
                    
                    for (NoteItem noteItemTemp : tempNoteItemList) {
                        noteItems[i] = noteItemTemp;
                        System.out.println(noteItemTemp.getTitle());
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
                        System.out.println(noteItemTemp.getDate());
                        i++;
                    }

                    initNoteItems(jTextFieldSearch.getText());
                    unselectAll();
                    
                    break;
            }
            

        }   
    }
    
    
    public final static Comparator<NoteItem>
        TITLE_COMPARATOR = new Comparator<NoteItem>() {
        @Override public int compare( NoteItem p1, NoteItem p2 ) {
            return p1.getTitle().compareTo( p2.getTitle() );
        }
    };

    public final static Comparator<NoteItem>
        DATE_COMPARATOR = new Comparator<NoteItem>() {
        @Override public int compare( NoteItem p1, NoteItem p2 ) {
            return p1.getDate().compareTo( p2.getDate());
        }
    };

    private void enableCancelButton() {
        jButtonUndoSearch.setEnabled(true);
    }

    private void disableCancelButton() {
        jButtonUndoSearch.setEnabled(false);
        jTextFieldSearch.setText("");
    }

    private void editSelectedNote() {
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
    }


}
