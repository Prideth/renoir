/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;


import pim.database.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import pim.database.Account;

/**
 *
 * @author lk
 */
public class LoginDialog extends javax.swing.JDialog {

    private User user;
    private Connection con;
    
    private String userexists;
    private String error;
    
    /**
     * Creates new form LoginDialog
     */
    public LoginDialog(java.awt.Frame parent, boolean modal, Connection con) {
        super(parent, modal);
        user = null;
        this.con = con;
        initComponents();
        
        Settings settings = Settings.instance();
        setTexts(settings.locale);

        TextFieldListener textFieldListener = new TextFieldListener();
        jTextFieldUser.addMouseListener(textFieldListener);
        jPasswordField.addMouseListener(textFieldListener);
        
    
        jTextFieldUser.setDocument(new pim.JTextFieldLimit(12, false));
        jPasswordField.setDocument(new pim.JTextFieldLimit(12, false));
        
        jTextFieldUser.setText("renoir");
        jPasswordField.setText("test");
    }

    private void setTexts(String locale) {
        Properties texts = null;
        switch (locale) {
            case "en":
                texts = Texts.instance().props_en;
                break;
            case "de":
                texts = Texts.instance().props_de;
                break;
        }

        if (texts != null) {
            jLabelUser.setText(texts.getProperty("jLabelUser") + ":");
            jLabelPassword.setText(texts.getProperty("jLabelPassword") + ":");
            jButtonLogin.setText(texts.getProperty("jButtonLogin"));
            jButtonNew.setText(texts.getProperty("jButtonNew"));
            jButtonCancel.setText(texts.getProperty("jButtonCancel"));
            jCheckBoxRemember.setText(texts.getProperty("jCheckBoxRemember"));
            userexists = texts.getProperty("userexists");
            error = texts.getProperty("error");
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

        jLabelUser = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jButtonNew = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jCheckBoxRemember = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelUser.setText("Benutzername:");

        jLabelPassword.setText("Passwort:");

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jButtonNew.setText("Neu");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Abbrechen");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jCheckBoxRemember.setText("Beim nächsten Start automatisch einloggen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUser)
                            .addComponent(jLabelPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldUser)
                            .addComponent(jPasswordField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBoxRemember))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUser)
                    .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxRemember)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogin)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonNew))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
         dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        String username = jTextFieldUser.getText().trim();
        String password = new String(jPasswordField.getPassword());
        
        if (username.isEmpty()) {
            jTextFieldUser.requestFocus();
            return;
        } else if (password.isEmpty()) {
            jPasswordField.requestFocus();
            return;
        }
       
        try {
            con = DatabaseConnector.getConnection(con);
            if (con != null) {
                Account account = new Account(con);
                user = account.createNewUser(username, password);
                if (user != null) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, userexists, error, JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        String username = jTextFieldUser.getText();
        String password = new String(jPasswordField.getPassword());
        
        if (username.isEmpty()) {
            jTextFieldUser.requestFocus();
            return;
        } else if (password.isEmpty()) {
            jPasswordField.requestFocus();
            return;
        }
        
        try {
            con = DatabaseConnector.getConnection(con);
            if (con != null) {
                Account account = new Account(con);
                user = account.login(username, password);
                if (user != null) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, userexists, error, JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonLoginActionPerformed
    
    public User getUser() {
        return user;
    }
    
    public boolean getRemember() {
        return jCheckBoxRemember.isSelected();
    }
    
    public Connection getConnection() {
        return con;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JCheckBox jCheckBoxRemember;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}
