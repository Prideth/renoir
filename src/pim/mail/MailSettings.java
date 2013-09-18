/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.mail;

import java.io.File;
import pim.util.ObjectSerializer;

/**
 *
 * @author matthiaskiefer
 */
public class MailSettings extends javax.swing.JDialog {

    /**
     * Creates new form MailSettings
     */
    public MailSettings(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();


        setTextToCom();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldMailAddress = new javax.swing.JTextField();
        jComboBoxAccountTyp = new javax.swing.JComboBox();
        jTextFieldServerIn = new javax.swing.JTextField();
        jTextFieldServerOut = new javax.swing.JTextField();
        jTextFieldAccountName = new javax.swing.JTextField();
        jButtonCancel = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldPortIn = new javax.swing.JTextField();
        jTextFieldPortOut = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Benutzerinformationen");

        jLabel2.setText("Ihr Name:");

        jLabel3.setText("E-Mail-Adresse:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Serverinformationen");

        jLabel5.setText("Kontotyp:");

        jLabel6.setText("Posteingangsserver:");

        jLabel7.setText("Postausgangsserver:");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setText("Anmeldeinformationen");

        jLabel9.setText("Benutzername:");

        jLabel10.setText("Kennwort:");

        jTextFieldMailAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMailAddressActionPerformed(evt);
            }
        });

        jComboBoxAccountTyp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IMAP" }));

        jButtonCancel.setText("Abbrechen");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonSave.setText("Speichern");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel11.setText("Internet-E-Mail-Einstellungen");

        jLabel12.setText("Alle Einstellungen auf dieser Seite sind nötig.");

        jLabel13.setText("Port:");

        jLabel14.setText("Port:");

        jTextFieldPortIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPortInActionPerformed(evt);
            }
        });

        jTextFieldPortOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPortOutActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(jLabel12))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(layout.createSequentialGroup()
                            .add(jButtonSave)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jButtonCancel))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel1)
                            .add(jLabel4)
                            .add(jLabel8)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel5)
                                    .add(jLabel6)
                                    .add(jLabel7)
                                    .add(jLabel9)
                                    .add(jLabel10))
                                .add(78, 78, 78)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jComboBoxAccountTyp, 0, 256, Short.MAX_VALUE)
                                    .add(jTextFieldAccountName)
                                    .add(jPasswordFieldPassword)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, jTextFieldServerIn, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, jTextFieldServerOut))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(layout.createSequentialGroup()
                                                .add(jLabel14)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jTextFieldPortOut))
                                            .add(layout.createSequentialGroup()
                                                .add(jLabel13)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jTextFieldPortIn))))))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel3)
                                    .add(jLabel2))
                                .add(104, 104, 104)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jTextFieldName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .add(jTextFieldMailAddress)))))
                    .add(jLabel11))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel11)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel12)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 65, Short.MAX_VALUE)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jTextFieldName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jTextFieldMailAddress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jComboBoxAccountTyp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jTextFieldServerIn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel13)
                    .add(jTextFieldPortIn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(jTextFieldServerOut, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel14)
                    .add(jTextFieldPortOut, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel8)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(jTextFieldAccountName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(jPasswordFieldPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(59, 59, 59)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonCancel)
                    .add(jButtonSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMailAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMailAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMailAddressActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        String name = jTextFieldName.getText();
        String mail = jTextFieldMailAddress.getText();
        String type = (String) jComboBoxAccountTyp.getSelectedItem();
        String inServer = jTextFieldServerIn.getText();
        String outServer = jTextFieldServerOut.getText();
        char[] input = jPasswordFieldPassword.getPassword();
        String accountname = jTextFieldAccountName.getText();
        int portIn = Integer.parseInt(jTextFieldPortIn.getText());
        int portOut = Integer.parseInt(jTextFieldPortOut.getText());


        MailAccount acc = new MailAccount(inServer, outServer, portOut, portIn, accountname, input, mail, name, type);

        ObjectSerializer so = new ObjectSerializer();

        File dir = new File(System.getProperty("user.home") + "/pim/");
        File f = new File(System.getProperty("user.home") + "/pim/" + "mailaccount.ser");
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println(dir.getPath() + ", erstellt.");
        }

        so.save2file(acc, f);
        System.out.println(f.getPath() + ", erfolgreich gespeichert.");
        this.dispose();

    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jTextFieldPortInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPortInActionPerformed
         
    }//GEN-LAST:event_jTextFieldPortInActionPerformed

    private void jTextFieldPortOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPortOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPortOutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxAccountTyp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldAccountName;
    private javax.swing.JTextField jTextFieldMailAddress;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPortIn;
    private javax.swing.JTextField jTextFieldPortOut;
    private javax.swing.JTextField jTextFieldServerIn;
    private javax.swing.JTextField jTextFieldServerOut;
    // End of variables declaration//GEN-END:variables

    private void setTextToCom() {
        ObjectSerializer so = new ObjectSerializer();
        File f = new File(System.getProperty("user.home") + "/pim/" + "mailaccount.ser");

        if (!f.exists()) {
            System.out.println(f.getPath() + ", existiert nicht.");
        } else {
            MailAccount acc = (MailAccount) so.readFromFile(f);

            jTextFieldName.setText(acc.getName());
            jTextFieldMailAddress.setText(acc.getEmail());

            for (int i = 0; i < jComboBoxAccountTyp.getItemCount(); i++) {
                if (!((String) jComboBoxAccountTyp.getItemAt(i)).equals(acc.getType())) {
                } else {
                    jComboBoxAccountTyp.setSelectedIndex(i);
                    break;
                }
            }

            jTextFieldServerIn.setText(acc.getInServer());
            jTextFieldServerOut.setText(acc.getOutServer());
            jPasswordFieldPassword.setText(String.copyValueOf(acc.getPassword()));
            jTextFieldAccountName.setText(acc.getUsername());
            jTextFieldPortIn.setText(String.valueOf(acc.getImapPort()));
            jTextFieldPortOut.setText(String.valueOf(acc.getSmtpPort()));
        }


    }
}
