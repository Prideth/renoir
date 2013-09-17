/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.contact;

import java.awt.Color;
import javax.swing.ImageIcon;



/**
 *
 * @author lk
 */
public class ContactItem extends javax.swing.JPanel {
    
    private static final Color SELECT_COLOR = new Color(233, 236, 242);
    private final Color bgColor;
    
    private int position;
    private Contact contact;
    
    /**
     * Creates new form PersonPanel
     */
    public ContactItem(Contact contact) {
        bgColor = this.getBackground();
        initComponents();
        this.contact = contact;
        position = 0;
        update();
    }

    public Contact getContact() {
        return contact;
    }
    
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    
    public void update() {
        jLabelName.setText(contact.getName());
        jLabelMail.setText(contact.getMail());
        jLabelMobil.setText(contact.getNumber());
        if (contact.getDescription1() != null && !contact.getDescription1().isEmpty()) {
            jLabelDescription1.setText(contact.getDescription1() + ":");
            jLabelContent1.setText(contact.getContent1());
        } else {
            jLabelDescription1.setText("");
            jLabelContent1.setText("");
        }
        if (contact.getDescription2() != null && !contact.getDescription2().isEmpty()) {
            jLabelDescription2.setText(contact.getDescription2() + ":");
            jLabelContent2.setText(contact.getContent2());
        } else {
            jLabelDescription2.setText("");
            jLabelContent2.setText("");
        }
        if (contact.getDescription3() != null && !contact.getDescription3().isEmpty()) {
            jLabelDescription3.setText(contact.getDescription3() + ":");
            jLabelContent3.setText(contact.getContent3());
        } else {
            jLabelDescription3.setText("");
            jLabelContent3.setText("");
        }
        if (contact.getImage() != null) {
            ImageIcon icon = new ImageIcon(contact.getImage());
            jLabelImage.setIcon(icon);
        }
    }
    
    public int getPosition() {
        return position;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }
    
    public void select() {
        setBackground(SELECT_COLOR);
    }
    
    public void unselect() {
        setBackground(bgColor);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImage = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelMail = new javax.swing.JLabel();
        jLabelMobil = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelContent3 = new javax.swing.JLabel();
        jLabelDescription3 = new javax.swing.JLabel();
        jLabelDescription1 = new javax.swing.JLabel();
        jLabelContent1 = new javax.swing.JLabel();
        jLabelDescription2 = new javax.swing.JLabel();
        jLabelContent2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/member.png"))); // NOI18N
        jLabelImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelImage.setOpaque(true);

        jLabelName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelName.setText("Edward Snowden");

        jLabelMail.setText("edward.snowden@cia.com");
        jLabelMail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelMobil.setText("016378967112");

        jPanel1.setOpaque(false);

        jLabelContent3.setText("Saarbrücken");

        jLabelDescription3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelDescription3.setText("Wohnort:");

        jLabelDescription1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelDescription1.setText("Festnetz:");

        jLabelContent1.setText("068112345");

        jLabelDescription2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelDescription2.setText("Alter:");

        jLabelContent2.setText("23");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelDescription1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelContent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelDescription3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelContent3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelDescription2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelContent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescription1)
                    .addComponent(jLabelContent1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescription2)
                    .addComponent(jLabelContent2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescription3)
                    .addComponent(jLabelContent3))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelMobil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelMail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelImage)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelMail)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelMobil))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelContent1;
    private javax.swing.JLabel jLabelContent2;
    private javax.swing.JLabel jLabelContent3;
    private javax.swing.JLabel jLabelDescription1;
    private javax.swing.JLabel jLabelDescription2;
    private javax.swing.JLabel jLabelDescription3;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelMobil;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
