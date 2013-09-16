/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.event;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import pim.PanelInterface;
import pim.util.WrapLayout;

/**
 * Aufgabenverwaltung fuer PIM
 *
 * @author Joerg Federspiel
 */
public class EventPanel extends JPanel implements PanelInterface {

    private static final int MAX_SIZE = 100;
    EventItem[] eventItems;
    private int size;
    private EventItem selectedItem;

    /**
     * Creates new form EventPanel
     */
    public EventPanel() {
        initComponents();
        eventItems = new EventItem[MAX_SIZE];

        size = 0;
        selectedItem = null;


        jPanelContent.setLayout(new WrapLayout(FlowLayout.LEFT, 10, 10));
        jPanelContent.setSize(new Dimension(300, 1));
    }

    private void initEventItems() {
        jPanelContent.removeAll();
        for (int i = 0; i < size; i++) {
            jPanelContent.add(eventItems[i]);
        }
        jScrollPaneContent.updateUI();
    }

    @Override
    public void updateValues(Object[] values) {
        if (values != null) {
            Event[] events = (Event[]) values;
            eventItems = new EventItem[100];
            size = 0;
            size = events.length;
            for (int i = 0; i < size; i++) {
                eventItems[i] = new EventItem(events[i]);
                eventItems[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        eventPanelMousePressed(evt);
                    }
                });
                eventItems[i].getTextArea().addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        eventPanelMousePressed(evt);
                    }
                });
            }

        } else {
            eventItems = new EventItem[MAX_SIZE];
            size = 0;
        }
        initEventItems();
    }

    @Override
    public void insertValue(Object value) {
        Event event = (Event) value;
        EventItem eventItem = new EventItem(event);
        eventItem.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eventPanelMousePressed(evt);
            }
        });
        eventItem.getTextArea().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventPanelMousePressed(evt);
            }
        });
        eventItems[size++] = eventItem;
        //initEventItems();
        jPanelContent.add(eventItem);
        jPanelContent.updateUI();
    }

    @Override
    public Object[] getValues() {
        Event[] events = new Event[size];
        for (int i = 0; i < size; i++) {
            events[i] = eventItems[i].getEvent();
        }
        return events;
    }

    @Override
    public void changeValue(Object value) {
        Event event = (Event) value;
        int index = getIndex(event);
        eventItems[index].setEvent(event);
        eventItems[index].update();
        jPanelContent.updateUI();
    }

    @Override
    public void deleteValue(Object value) {
        int index = getIndex((Event) value);
        for (int i = index; i < size - 1; i++) {
            eventItems[i] = eventItems[i + 1];
        }
        eventItems[--size] = null;
        selectedItem = null;
        selectEvent(null);
        initEventItems();
    }

    @Override
    public void showAddDialog(Object value, JFrame rootWindow) {
        Event event = null;
        if (value != null) {
            event = (Event) value;
        }
        CreateEventDialog dialog = new CreateEventDialog(rootWindow, true, event);
        dialog.setLocationRelativeTo(rootWindow);
        dialog.setVisible(true);
        event = dialog.getEvent();
        if (event != null) {
            insertValue(event);
        }
    }

    @Override
    public void showChangeDialog(Object value, JFrame rootWindow) {
        Event event = (Event) value;
        CreateEventDialog dialog = new CreateEventDialog(rootWindow, true, event);
        dialog.setLocationRelativeTo(rootWindow);
        dialog.setTitle(event.getTitle());
        dialog.setVisible(true);
        event = dialog.getEvent();
        if (event != null) {
            changeValue(event);
        }
    }

    @Override
    public void showDeleteDialog(Object value, JFrame rootWindow) {
        Event event = (Event) value;
        Object[] options = {"Ja", "Nein"};
        int n = JOptionPane.showOptionDialog(null,
                "Notiz \"" + event.getTitle() + "\" löschen?",
                "Löschen bestätigen",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (n == 0) {
            deleteValue(event);
        }
    }

    private void selectEvent(EventItem eventItem) {
        selectedItem = eventItem;
        for (int i = 0; i < size; i++) {
            eventItems[i].unselect();
        }
        if (eventItem != null) {
            eventItem.select();
        }
    }

    private int getIndex(Event event) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (event == eventItems[i].getEvent()) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void eventPanelMousePressed(java.awt.event.MouseEvent evt) {
        if (evt.getButton() == 1) {

            EventItem eventItem = null;
            if (evt.getComponent() instanceof EventItem) {
                eventItem = (EventItem) evt.getComponent();
                selectEvent(eventItem);
            }
            if (evt.getComponent() instanceof JTextArea) {
                eventItem = (EventItem) evt.getComponent().getParent().getParent().getParent();
                selectEvent(eventItem);
            }
            if (evt.getClickCount() == 2) {

                showChangeDialog(eventItem.getEvent(), getRootWindow());
            }
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

        jScrollPaneContent = new javax.swing.JScrollPane();
        jPanelContent = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonChange = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
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

        jLabelSearch.setText("Suche: ");
        jPanel1.add(jLabelSearch);
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
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
        showAddDialog(null, rootWindow);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeActionPerformed
        JFrame rootWindow = getRootWindow();
        if (selectedItem != null) {
            showChangeDialog(selectedItem.getEvent(), rootWindow);
        } else {
            JOptionPane.showMessageDialog(rootWindow, "Es ist kein Termin ausgewählt.");
        }
    }//GEN-LAST:event_jButtonChangeActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        JFrame rootWindow = getRootWindow();
        if (selectedItem != null) {
            showDeleteDialog(selectedItem.getEvent(), rootWindow);
        } else {
            JOptionPane.showMessageDialog(getRootWindow(), "Es ist kein Termin ausgewählt.");
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonUndoSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoSearchActionPerformed
        //disableCancelButton();
        //initNoteItems("");
    }//GEN-LAST:event_jButtonUndoSearchActionPerformed

    private JFrame getRootWindow() {
        return (JFrame) SwingUtilities.getWindowAncestor(this.getParent());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonChange;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUndoSearch;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JScrollPane jScrollPaneContent;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
