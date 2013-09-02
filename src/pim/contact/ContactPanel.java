/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.contact;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import pim.*;

/**
 *
 * @author lk
 */
public class ContactPanel extends javax.swing.JPanel {

    ContactButton[] contactButtons;
    private int size;
    private int selectedIndex;
    private Color bgColor;

    /**
     * Creates new form ContactPanel
     */
    public ContactPanel(Contact[] contacts) {
        initComponents();
        contactButtons = new ContactButton[100];
        
        size = 0;
        selectedIndex = -1;
        if (contacts != null) {
            size = contacts.length;
            for (int i = 0; i < size; i++) {
                contactButtons[i] = new ContactButton(contacts[i]);
                contactButtons[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        personPanelMousePressed(evt);
                    }
                });
            }
        }
        initContactButtons();
        TextFieldListener textFieldListener = new TextFieldListener();
        jTextFieldSearch.addMouseListener(textFieldListener);
        bgColor = this.getBackground();
    }

    private void initContactButtons() {
        jPanel1.removeAll();
        
        javax.swing.GroupLayout layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(layout);

        Group group1 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        Group group2 = layout.createSequentialGroup().addGap(5);

        for (int i = size - 1; i >= 0; i--) {
            contactButtons[i].setPosition(i);
            group1.addComponent(contactButtons[i], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            group2.addComponent(contactButtons[i], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
            group2.addGap(5);
        }

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(group1)
                .addContainerGap()));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(group2));
        
        selectPerson(size - 1);
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
            .addGap(0, 516, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNew)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonDelete)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        if (size < contactButtons.length) {
            JFrame rootWindow = getRootWindow();
            CreateContactDialog dialog = new CreateContactDialog(rootWindow, true, null);
            dialog.setTitle("Kontakt erstellen");
            dialog.setLocationRelativeTo(rootWindow);
            dialog.setVisible(true);
            Contact contact = dialog.getContact();
            
            if (contact != null) {
                ContactButton p = new ContactButton(dialog.getContact());
                p.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        personPanelMousePressed(evt);
                    }
                });
                contactButtons[size++] = p;
                initContactButtons();
            }
        } else {
            JOptionPane.showMessageDialog(getRootWindow(),
                    "Es können maximal " + contactButtons.length + " Kontakte erstellt werden.");
        }


    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if (selectedIndex > -1) {         
            
            Object[] options = {"Ja", "Nein"};
            int n = JOptionPane.showOptionDialog(null,
                    "Kontakt \"" + contactButtons[selectedIndex].getContact().getName() + "\" löschen?",
                    "Löschen bestätigen",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (n == 0) {
                for (int i = selectedIndex; i < size - 1; i++) {
                    contactButtons[i] = contactButtons[i + 1];
                }
                contactButtons[--size] = null;
                selectedIndex = -1;
                initContactButtons();
            }
        } else {
            JOptionPane.showMessageDialog(getRootWindow(), "Es ist kein Kontakt ausgewählt.");
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        if (selectedIndex > -1) {        
            Contact contact = contactButtons[selectedIndex].getContact();
            
            JFrame rootWindow = getRootWindow();
            CreateContactDialog dialog = new CreateContactDialog(rootWindow, true, contact);
            dialog.setTitle(contact.getName());
            dialog.setLocationRelativeTo(rootWindow);
            dialog.setVisible(true);
            contact = dialog.getContact();
            if (contact != null) {
                contactButtons[selectedIndex].setContact(contact);
            }
        } else {
            JOptionPane.showMessageDialog(getRootWindow(), "Es ist kein Kontakt ausgewählt.");
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void personPanelMousePressed(java.awt.event.MouseEvent evt) {
        selectPerson(((ContactButton) evt.getComponent()).getPosition());
    }

    private void selectPerson(int position) {
        if (size > 0) {
            if (selectedIndex > -1) {
                contactButtons[selectedIndex].setBackground(bgColor);
            }
            contactButtons[position].setBackground(new Color(233, 236, 242));
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
