/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.mail;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pim.*;

/**
 *
 * @author lk
 */
public class MailWriteDialog extends JDialog {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Creates new form MailWriteDialog
     */
    public MailWriteDialog(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        TextFieldListener textFieldListener = new TextFieldListener();
        jTextFieldSender.addMouseListener(textFieldListener);
        jTextFieldReceiver.addMouseListener(textFieldListener);
        jTextFieldSubject.addMouseListener(textFieldListener);
        jTextAreaBody.addMouseListener(textFieldListener);

        jTextFieldSender.setText("hier wird der sender eingetragen mit iein get;)");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButtonSend = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonAttach = new javax.swing.JButton();
        jLabelSender = new javax.swing.JLabel();
        jLabelReceiver = new javax.swing.JLabel();
        jLabelSubject = new javax.swing.JLabel();
        jTextFieldSender = new javax.swing.JTextField();
        jTextFieldReceiver = new javax.swing.JTextField();
        jTextFieldSubject = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaBody = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonSend.setText("Senden");
        jButtonSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSendMouseClicked(evt);
            }
        });
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jButtonSave.setText("Speichern");

        jButtonCancel.setText("Anhang");

        jButtonAttach.setText("Abbrechen");
        jButtonAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAttachActionPerformed(evt);
            }
        });

        jLabelSender.setText("Absender:");

        jLabelReceiver.setText("Empfänger:");

        jLabelSubject.setText("Betreff:");

        jTextAreaBody.setColumns(20);
        jTextAreaBody.setLineWrap(true);
        jScrollPane2.setViewportView(jTextAreaBody);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jButtonAttach, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelSender, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSender)
                            .addComponent(jTextFieldSubject)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelReceiver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldReceiver, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSend)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonAttach))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSender)
                    .addComponent(jTextFieldSender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelReceiver)
                    .addComponent(jTextFieldReceiver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSubject)
                    .addComponent(jTextFieldSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void jButtonAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAttachActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAttachActionPerformed

    private void jButtonSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSendMouseClicked
        // TODO add your handling code here:


        String recipient = jTextFieldReceiver.getText().trim();
        String subject = jTextFieldSubject.getText().trim();
        String text = jTextAreaBody.getText();
        if (recipient.equals("")) {
            JOptionPane.showMessageDialog(this, "Bitte geben Sie einen Empfänger ein.");
        } else if (!isEmail(recipient)) {
            JOptionPane.showMessageDialog(this, "Bitte geben Sie eine gültige Mail-Adresse ein.");
        } else {
            int n = 1;
            if (subject.equals("")) {
                Object[] options = {"Nicht senden", "Trotzdem senden"};
                n = JOptionPane.showOptionDialog(this, "Möchten Sie diese Nachricht ohne Betreff senden?", "PIM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }
            if (n == 1 || !subject.equals("")) {
                try {
                    MailFunction.send(MailAccounts.GOOGLEMAIL, recipient, subject, text);
                } catch (AddressException ex) {
                    Logger.getLogger(MailWriteDialog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MessagingException ex) {
                    Logger.getLogger(MailWriteDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
        }

    }//GEN-LAST:event_jButtonSendMouseClicked
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonAttach;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JLabel jLabelReceiver;
    private javax.swing.JLabel jLabelSender;
    private javax.swing.JLabel jLabelSubject;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaBody;
    private javax.swing.JTextField jTextFieldReceiver;
    private javax.swing.JTextField jTextFieldSender;
    private javax.swing.JTextField jTextFieldSubject;
    // End of variables declaration                   

    private boolean isEmail(String mail) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher;
        matcher = pattern.matcher(mail);
        return matcher.matches();
   
    }
}

