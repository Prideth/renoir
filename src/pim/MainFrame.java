/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;

import pim.database.DatabaseSettingsDialog;
import pim.database.DatabaseConnector;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import pim.contact.Contact;
import pim.contact.ContactPanel;
import pim.database.Account;
import pim.database.DatabaseReader;
import pim.database.DatabaseWriter;
import pim.event.Event;
import pim.event.EventPanel;
import pim.exam.Exam;
import pim.exam.ExamPanel;
import pim.mail.MailSettings;
import pim.notes.Note;

/**
 *
 * @author lk
 */
public class MainFrame extends javax.swing.JFrame {

    private static final String CONFIG_FILE = "settings.properties";
    
    private Properties props;
    private User user;
    private Connection con;
    
    /**
     * Creates new form NewJFrame
     */
    public MainFrame() {
        con = null;
        props = new Properties();
        File f = new File(CONFIG_FILE);
        if (!f.exists()) {
            InputStream in = getClass().getResourceAsStream(CONFIG_FILE);
            try {
                props.load(in);
                in.close();
                try (FileOutputStream out = new FileOutputStream(CONFIG_FILE)) {
                    props.store(out, null);
                }
            } catch (IOException e) {}
        } else {
            try {
                try (FileReader in = new FileReader(CONFIG_FILE)) {
                    props.load(in);
                }
            } catch (IOException e) {}
        }
        
        initComponents();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                dispose();
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {}
                }
                System.exit(0);
            }
        });
        
        String username = props.getProperty("username");
        if (!username.isEmpty()) {
            String password = props.getProperty("password");
            con = DatabaseConnector.getConnection(props, con);
            if (con != null) {
                Account account = new Account(con);
                try {
                    user = account.login(username, password);
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        
        contactPanel = new ContactPanel();
        examPanel = new ExamPanel();
        notePanel = new pim.notes.NotePanel();
        
        if (user != null) {
            updatePanels(con);
        }
               
        Event[] events = null;
        
        mailPanel = new pim.mail.MailPanel();
        calendarPanel = new pim.calendar2.CalendarPanel(examPanel, notePanel);
        //calendarPanel = new pim.calendar.CalendarPanel();
        eventPanel = new EventPanel(null);
        
        
        if (user != null) {
            setTitle("Personal Information Manager - " + user.getUsername());
            jMenuItemLogout.setEnabled(true);
            jMenuItemDelete.setEnabled(true);
            jMenuItemSave.setEnabled(true);
        }
        
        switchPanel(eventPanel, jButtonEvents);
        
    }
    
    private void updatePanels(Connection con) {
        if (con == null) {
            con = DatabaseConnector.getConnection(props, con);
        }
        if (con != null) {
            DatabaseReader dr = new DatabaseReader(con);
            
            System.out.print("read exams... ");
            long start = System.currentTimeMillis();
            try {
                examPanel.updateValues(dr.getExams(user.getId()));
                System.out.println(System.currentTimeMillis() - start);
            } catch (SQLException e) {
                System.err.println("error");
            }

            System.out.print("read notes... ");
            start = System.currentTimeMillis();
            try {
                notePanel.updateValues(dr.getNotes(user.getId()));
                System.out.println(System.currentTimeMillis() - start);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("error");
            }
            
            System.out.print("read contacts... ");
            start = System.currentTimeMillis();
            try {
                contactPanel.updateValues(dr.getContacts(user.getId()));
                System.out.println(System.currentTimeMillis() - start);
            } catch (SQLException e) {
                System.err.println("error");
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

        jToolBar = new javax.swing.JToolBar();
        jButtonMail = new javax.swing.JButton();
        jButtonExams = new javax.swing.JButton();
        jButtonContacts = new javax.swing.JButton();
        jButtonCalendar = new javax.swing.JButton();
        jButtonEvents = new javax.swing.JButton();
        jButtonNotes = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelContent = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemLogin = new javax.swing.JMenuItem();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jMenuItemDelete = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSave = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuSettings = new javax.swing.JMenu();
        jMenuItemDatabase = new javax.swing.JMenuItem();
        jMenuItemMail = new javax.swing.JMenuItem();
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

        jButtonEvents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/todo.png"))); // NOI18N
        jButtonEvents.setText("Termine");
        jButtonEvents.setFocusable(false);
        jButtonEvents.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEvents.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEventsActionPerformed(evt);
            }
        });
        jToolBar.add(jButtonEvents);

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

        jMenuItemLogin.setText("Login");
        jMenuItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLoginActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemLogin);

        jMenuItemLogout.setText("Logout");
        jMenuItemLogout.setEnabled(false);
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemLogout);

        jMenuItemDelete.setText("Account löschen");
        jMenuItemDelete.setEnabled(false);
        jMenuFile.add(jMenuItemDelete);
        jMenuFile.add(jSeparator2);

        jMenuItemSave.setText("Speichern");
        jMenuItemSave.setEnabled(false);
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);
        jMenuFile.add(jSeparator3);

        jMenuItemExit.setText("Beenden");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBar.add(jMenuFile);

        jMenuSettings.setText("Einstellungen");

        jMenuItemDatabase.setText("Datenbank");
        jMenuItemDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDatabaseActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMenuItemDatabase);

        jMenuItemMail.setText("E-Mail");
        jMenuItemMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMailActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMenuItemMail);

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
        calendarPanel.update();
    }//GEN-LAST:event_jButtonCalendarActionPerformed

    private void jButtonEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEventsActionPerformed
        switchPanel(eventPanel, jButtonEvents);
    }//GEN-LAST:event_jButtonEventsActionPerformed

    private void jButtonNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNotesActionPerformed
        switchPanel(notePanel, jButtonNotes);
    }//GEN-LAST:event_jButtonNotesActionPerformed
	
    private void jMenuItemDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDatabaseActionPerformed
        DatabaseSettingsDialog dialog = new DatabaseSettingsDialog(this, true, props);
        dialog.setTitle("Datenbankverbindung");
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemDatabaseActionPerformed

    private void jMenuItemMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMailActionPerformed
        MailSettings dialog = new MailSettings(this, true);
        dialog.setTitle("E-Mail Einstellungen");
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemMailActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        con = DatabaseConnector.getConnection(props, con);

        if (con != null) {
            DatabaseWriter dw = new DatabaseWriter(con);
            
            System.out.print("write contacts... ");
            long start = System.currentTimeMillis();
            try {
                dw.writeContacts((Contact[]) contactPanel.getValues(), user.getId());
                System.out.println(System.currentTimeMillis() - start);
            } catch (SQLException e) {
                System.out.println("error");
            }
            
            System.out.print("write exams... ");
            start = System.currentTimeMillis();
            try {
                dw.writeExams((Exam[]) examPanel.getValues(), user.getId());
                System.out.println(System.currentTimeMillis() - start);
            } catch (SQLException e) {
                System.out.println("error");
            }
            
            System.out.print("write notes... ");
            start = System.currentTimeMillis();
            try {
                dw.writeNotes((Note[]) notePanel.getValues(), user.getId());
                System.out.println(System.currentTimeMillis() - start);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error");
            }
            
            JOptionPane.showMessageDialog(this, "Datenbank aktualisiert.");
        }
        
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoginActionPerformed
        LoginDialog dialog = new LoginDialog(this, true, props, con);
        dialog.setTitle("Login");
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        
        if (dialog.getUser() != null) {
            user = dialog.getUser();
            if (dialog.getRemember()) {
                props.setProperty("username", user.getUsername());
                props.setProperty("password", user.getPassword());
                FileWriter out;
                try {
                    out = new FileWriter("settings.properties");
                    props.store(out, null);
                    out.close();
                } catch (IOException e) {}
            }
            jMenuItemLogout.setEnabled(true);
            jMenuItemDelete.setEnabled(true);
            jMenuItemSave.setEnabled(true);
            this.setTitle("Personal Information Manager - " + user.getUsername());
            con = dialog.getConnection();
            updatePanels(con);
            calendarPanel.update();
        }
    }//GEN-LAST:event_jMenuItemLoginActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        this.dispose();
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {}
        }
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        user = null;
        jMenuItemLogout.setEnabled(false);
        jMenuItemDelete.setEnabled(false);
        jMenuItemSave.setEnabled(false);
        props.setProperty("username", "");
        props.setProperty("password", "");
        FileWriter out;
        try {
            out = new FileWriter("settings.properties");
            props.store(out, null);
            out.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        contactPanel.updateValues(null);
        examPanel.updateValues(null);
        notePanel.updateValues(null);
        calendarPanel.update();
        this.setTitle("Personal Information Manager");
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    
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
        if (!jButtonEvents.isEnabled()) {
            jButtonEvents.setForeground(Color.BLACK);
            jButtonEvents.setEnabled(true);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    private pim.mail.MailPanel mailPanel;
    private pim.exam.ExamPanel examPanel;
    private pim.contact.ContactPanel contactPanel;
    private pim.calendar2.CalendarPanel calendarPanel;
    //private pim.calendar.CalendarPanel calendarPanel;
    private EventPanel eventPanel;
    private pim.notes.NotePanel notePanel;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalendar;
    private javax.swing.JButton jButtonContacts;
    private javax.swing.JButton jButtonEvents;
    private javax.swing.JButton jButtonExams;
    private javax.swing.JButton jButtonMail;
    private javax.swing.JButton jButtonNotes;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuInfo;
    private javax.swing.JMenuItem jMenuItemDatabase;
    private javax.swing.JMenuItem jMenuItemDelete;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemLogin;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenuItem jMenuItemMail;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenu jMenuSettings;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
