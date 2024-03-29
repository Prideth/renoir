/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.contact;



/**
 *
 * @author lk
 */
public class ContactButton extends javax.swing.JPanel {

    private int position;
    private Contact contact;
    
    /**
     * Creates new form PersonPanel
     */
    public ContactButton(Contact contact) {
        initComponents();
        this.contact = contact;
        position = 0;
        jLabelName.setText(contact.getName());
        jLabelMail.setText(contact.getMail());
        jLabelMobil.setText(contact.getMobil());
    }

    public Contact getContact() {
        return contact;
    }
    
    public void setContact(Contact contact) {
        this.contact = contact;
        jLabelName.setText(contact.getName());
        jLabelMail.setText(contact.getMail());
        jLabelMobil.setText(contact.getMobil());
    }
    
    public int getPosition() {
        return position;
    }
    
    public void setPosition(int position) {
        this.position = position;
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

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/member.png"))); // NOI18N
        jLabelImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelImage.setOpaque(true);

        jLabelName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelName.setText("Edward Snowden");

        jLabelMail.setText("edward.snowden@cia.com");
        jLabelMail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelMobil.setText("016378967112");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelName)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelMobil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelMail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMobil))
                    .addComponent(jLabelImage))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelMobil;
    private javax.swing.JLabel jLabelName;
    // End of variables declaration//GEN-END:variables
}
