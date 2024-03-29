/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import pim.database.DatabaseReader;
import pim.mail.MailSettings;
import pim.todo.ToDoPanel;

/**
 *
 * @author lk
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public MainFrame() {
        
        DatabaseReader dr = new DatabaseReader();
        
        //mailPanel = new pim.mail.MailPanel();
        examPanel = new pim.exam.ExamPanel(dr.getExams());
        contactPanel = new pim.contact.ContactPanel(dr.getContacts());
        calendarPanel = new pim.calendar.CalendarPanel();
        toDoPanel = new pim.todo.ToDoPanel(dr.getToDos());
        notePanel = new pim.notes.NotePanel();
        
        initComponents();
        
        switchPanel(examPanel, jButtonExams);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = new javax.swing.JToolBar();
        jButtonMail = new javax.swing.JButton();
        jButtonExams = new javax.swing.JButton();
        jButtonContacts = new javax.swing.JButton();
        jButtonCalendar = new javax.swing.JButton();
        jButtonToDo = new javax.swing.JButton();
        jButtonNotes = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelContent = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuSettings = new javax.swing.JMenu();
        jMenuItemMailSettings = new javax.swing.JMenuItem();
        jMenuInfo = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personal Information Manager");

        jToolBar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jToolBar.setFloatable(false);
        jToolBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar.setRollover(true);

        jButtonMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/mail.png"))); // NOI18N
        jButtonMail.setText("E-Mail");
        jButtonMail.setFocusable(false);
        jButtonMail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMail.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMailActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonMail);

        jButtonExams.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/exams.png"))); // NOI18N
        jButtonExams.setText("Klausuren");
        jButtonExams.setFocusable(false);
        jButtonExams.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonExams.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonExams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExamsActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonExams);

        jButtonContacts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/contacts.png"))); // NOI18N
        jButtonContacts.setText("Kontakte");
        jButtonContacts.setFocusable(false);
        jButtonContacts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonContacts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonContacts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContactsActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonContacts);

        jButtonCalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/calendar.png"))); // NOI18N
        jButtonCalendar.setText("Kalender");
        jButtonCalendar.setFocusable(false);
        jButtonCalendar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCalendar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalendarActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonCalendar);

        jButtonToDo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/todo.png"))); // NOI18N
        jButtonToDo.setText("ToDo");
        jButtonToDo.setFocusable(false);
        jButtonToDo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonToDo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonToDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonToDoActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonToDo);

        jButtonNotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/notes.png"))); // NOI18N
        jButtonNotes.setText("Notizen");
        jButtonNotes.setFocusable(false);
        jButtonNotes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNotes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNotesActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonNotes);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenuFile.setText("Datei");
        jMenuBar.add(jMenuFile);

        jMenuSettings.setText("Einstellungen");

        jMenuItemMailSettings.setText("E-Mail Einstellungen");
        jMenuItemMailSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMailSettingsActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMenuItemMailSettings);

        jMenuBar.add(jMenuSettings);

        jMenuInfo.setText("Info");
        jMenuBar.add(jMenuInfo);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMailActionPerformed
        switchPanel(mailPanel, jButtonMail);
    }//GEN-LAST:event_jButtonMailActionPerformed

    private void jButtonExamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExamsActionPerformed
        switchPanel(examPanel, jButtonExams);
    }//GEN-LAST:event_jButtonExamsActionPerformed

    private void jButtonContactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContactsActionPerformed
        switchPanel(contactPanel, jButtonContacts);
    }//GEN-LAST:event_jButtonContactsActionPerformed

    private void jButtonCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalendarActionPerformed
        switchPanel(calendarPanel, jButtonCalendar);
    }//GEN-LAST:event_jButtonCalendarActionPerformed

    private void jButtonToDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonToDoActionPerformed
        switchPanel(toDoPanel, jButtonToDo);
    }//GEN-LAST:event_jButtonToDoActionPerformed

    private void jButtonNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNotesActionPerformed
        switchPanel(notePanel, jButtonNotes);
    }//GEN-LAST:event_jButtonNotesActionPerformed

    private void jMenuItemMailSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMailSettingsActionPerformed
      JFrame rootWindow = (JFrame) SwingUtilities.getWindowAncestor(this);
        MailSettings dialog = new MailSettings(rootWindow, true);
        dialog.setTitle("E-Mail Einstellungen");
        dialog.setLocationRelativeTo(rootWindow);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemMailSettingsActionPerformed

    
    private void switchPanel(javax.swing.JPanel panel, javax.swing.JButton button) {
        
        if (!jButtonMail.isEnabled()) {
            jButtonMail.setForeground(Color.BLACK);
            jButtonMail.setEnabled(true);
        }
        if (!jButtonExams.isEnabled()) {
            jButtonExams.setForeground(Color.BLACK);
            jButtonExams.setEnabled(true);
        }
        if (!jButtonContacts.isEnabled()) {
            jButtonContacts.setForeground(Color.BLACK);
            jButtonContacts.setEnabled(true);
        }
        if (!jButtonCalendar.isEnabled()) {
            jButtonCalendar.setForeground(Color.BLACK);
            jButtonCalendar.setEnabled(true);
        }
        if (!jButtonToDo.isEnabled()) {
            jButtonToDo.setForeground(Color.BLACK);
            jButtonToDo.setEnabled(true);
        }
        if (!jButtonNotes.isEnabled()) {
            jButtonNotes.setForeground(Color.BLACK);
            jButtonNotes.setEnabled(true);
        }
        
        button.setForeground(Color.GRAY);
        button.setEnabled(false);
        
        jPanelContent.removeAll();
        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    private pim.mail.MailPanel mailPanel;
    private pim.exam.ExamPanel examPanel;
    private pim.contact.ContactPanel contactPanel;
    private pim.calendar.CalendarPanel calendarPanel;
    private pim.todo.ToDoPanel toDoPanel;
    private pim.notes.NotePanel notePanel;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalendar;
    private javax.swing.JButton jButtonContacts;
    private javax.swing.JButton jButtonExams;
    private javax.swing.JButton jButtonMail;
    private javax.swing.JButton jButtonNotes;
    private javax.swing.JButton jButtonToDo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuInfo;
    private javax.swing.JMenuItem jMenuItemMailSettings;
    private javax.swing.JMenu jMenuSettings;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
