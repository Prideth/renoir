/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.event;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import pim.PanelInterface;
import pim.util.WrapLayout;

/**
 * Aufgabenverwaltung fuer PIM
 * 
 * @author Joerg Federspiel
 */
public class EventPanel extends JPanel implements PanelInterface {
    
    EventItem[] eventSlots;
    private int size;
    private int selectedIndex;
    private Color backGroundColor;

    /**
     * Creates new form EventPanel
     */
    public EventPanel(Event[] events) {
        initComponents();
        eventSlots = new EventItem[100];
        
        size = 0;
        selectedIndex = -1;
        
        for (int i=0; i<size; i++) {
            eventSlots[i] = new EventItem(events[i]);
            eventSlots[i].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    eventPanelMousePressed(evt);
                }
            });
        }
        
        //initEventButtons();
        jPanelContent.setLayout(new WrapLayout(FlowLayout.LEFT, 10, 10));
        
        jPanelContent.add(new EventItem(null));
        jPanelContent.add(new EventItem(null));
        jPanelContent.add(new EventItem(null));
        //jPanelContent.add(new EventItem(null));
        //jPanelContent.add(new EventItem(null));
        //jPanelContent.add(new EventItem(null));
        
        jPanelContent.setSize(new Dimension(300, 1));
        
        
    }
    
    private void initEventButtons() {
        
        
        
        jPanelContent.add(new EventItem(null));
        jScrollPaneContent.updateUI();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneContent = new javax.swing.JScrollPane();
        jPanelContent = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonChange = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonUndoSearch = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(518, 355));

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        jScrollPaneContent.setViewportView(jPanelContent);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jButtonAdd.setText("Erstellen");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonChange.setText("Ändern");
        jButtonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Löschen");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonChange, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonAdd)
                .addComponent(jButtonChange)
                .addComponent(jButtonDelete))
        );

        jPanel1.add(jPanel2);

        jLabel1.setText("Suche: ");
        jPanel1.add(jLabel1);
        jPanel1.add(jTextFieldSearch);

        jButtonUndoSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/ok.png"))); // NOI18N
        jButtonUndoSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
        jButtonUndoSearch.setIconTextGap(0);
        jButtonUndoSearch.setInheritsPopupMenu(true);
        jButtonUndoSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUndoSearch);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPaneContent, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        JFrame rootWindow = getRootWindow();
        showAddDialog(rootWindow);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeActionPerformed
        
        /*
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
        */
    }//GEN-LAST:event_jButtonChangeActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        /*
        JFrame rootWindow = getRootWindow();
        int index = getSelectedRow();
        if (index > -1) {
            Exam exam = (Exam) model.getValueAt(index, 0);
            showDeleteDialog(exam, rootWindow);
        } else {
            JOptionPane.showMessageDialog(rootWindow, "Es ist keine Klausur ausgewählt.");
        }
        */
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonUndoSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoSearchActionPerformed
        //disableCancelButton();
        //initNoteItems("");
    }//GEN-LAST:event_jButtonUndoSearchActionPerformed
    
    private void eventPanelMousePressed(java.awt.event.MouseEvent evt) {
        selectEvent(((EventItem) evt.getComponent()).getPosition());
    }

    private void selectEvent(int position) {
        if (size > 0) {
            if (selectedIndex > -1) {
                eventSlots[selectedIndex].setBackground(backGroundColor);
            }
            eventSlots[position].setBackground(new Color(233, 236, 242));
            selectedIndex = position;
        }
    }
    
    private JFrame getRootWindow() {
        return (JFrame) SwingUtilities.getWindowAncestor(this.getParent());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonChange;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUndoSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JScrollPane jScrollPaneContent;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateValues(Object[] values) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showAddDialog(JFrame rootWindow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showChangeDialog(Object value, JFrame rootWindow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showDeleteDialog(Object value, JFrame rootWindow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
