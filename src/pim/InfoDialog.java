/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim;

/**
 *
 * @author lk
 */
public class InfoDialog extends javax.swing.JDialog {

    /**
     * Creates new form InfoDialog
     */
    public InfoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        String htmltext =
                "<html><b>Autoren<b>"
                + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"2\">"
                + "	<tr>"
                + "		<td style=\"padding-right:10px\">Andreas Dier</td>"
                + "		<td>dierandreas@gmail.com</td>"
                + "	</tr>"
                + "	<tr>"
                + "		<td style=\"padding-right:10px\">Ardian Beqiri</td>"
                + "		<td>ardi1@live.de</td>"
                + "	</tr>"
                + "	<tr>"
                + "		<td style=\"padding-right:10px\">Dominik Erb</td>"
                + "		<td>dominik.a.erb@gmail.com</td>"
                + "	</tr>"
                + "	<tr>"
                + "		<td style=\"padding-right:10px\">J&ouml;rg Federspiel</td>"
                + "		<td>joerg.federspiel@gmx.de</td>"
                + "	</tr>"
                + "	<tr>"
                + "		<td style=\"padding-right:10px\">Lukas Ewen</td>"
                + "		<td>lewen65@gmail.com</td>"
                + "	</tr>"
                + "	<tr>"
                + "		<td style=\"padding-right:10px\">Matthias Kiefer</td>"
                + "		<td>kiefer.matthias@gmail.com</td>"
                + "	</tr>"
                + "	<tr>"
                + "		<td style=\"padding-right:10px\">Thomas Quinter</td>"
                + "		<td>thomasquitter@gmail.com</td>"
                + "	</tr>"
                + "</table>"
                + "</html>";
        
        jLabel4.setText(htmltext);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pim/icons/penguin.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Personal Information Manager");

        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        dispose();
    }//GEN-LAST:event_formMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
