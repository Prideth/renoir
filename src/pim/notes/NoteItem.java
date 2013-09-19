package pim.notes;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Klasse zum erstellen eines visuellen Notizelementes über ein JPanel
 * 
 * @author Thomas Quitter
 */
public class NoteItem extends javax.swing.JPanel {

    private final Color BACK_COLOR = new Color(236, 227, 159);
    private final Color SELECT_COLOR = new Color(244, 239, 202);
    private final SimpleDateFormat SDF = new SimpleDateFormat("dd.MM.yyyy   HH:mm");
    
    private int pos;
    private Note note;
    private String title;
    private Date date;
    private String content;
    
    /**
     * Creates new form NoteItem
     */
    public NoteItem(Note note) {
        
        initComponents();
        jTextAreaContent.setBorder(null);
        jTextAreaContent.setLineWrap(true);
        jTextAreaContent.setWrapStyleWord(true);

        this.note = note;
        pos = 0;
        title = note.getTitle();
        date = note.getCreateDate();
        content = note.getNoteContent();
        
        jLabelTitle.setText(title);
        jTextAreaContent.setText(content);
        jLableDate.setText(SDF.format(getDate()));
       
    }
    
    /*
     * getNote
     */
    public Note getNote() {
        return note;
    }

    /*
     * setNote
     */
    public void setNote(Note note) {
        this.note = note;
        setTitle(note.getTitle());
        setDate(note.getCreateDate());
        setContent(note.getNoteContent());
        jLabelTitle.setText(getTitle());
        jTextAreaContent.setText(getContent());
        jLableDate.setText(SDF.format(getDate()));
    }
    
    /*
     * getPosition
     */
    public int getPosition() {
        return pos;
    }
    
    /*
     * setPosition
     */
    public void setPosition(int pos) {
        this.pos = pos;
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
        jTextAreaContent = new javax.swing.JTextArea();
        jLableDate = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 227, 159));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(270, 155));
        setRequestFocusEnabled(false);

        jScrollPaneContent.setBorder(null);

        jTextAreaContent.setEditable(false);
        jTextAreaContent.setBackground(new java.awt.Color(236, 227, 159));
        jTextAreaContent.setLineWrap(true);
        jTextAreaContent.setText("...");
        jTextAreaContent.setBorder(null);
        jTextAreaContent.setFocusable(false);
        jTextAreaContent.setSelectionEnd(0);
        jTextAreaContent.setSelectionStart(0);
        jScrollPaneContent.setViewportView(jTextAreaContent);

        jLableDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLableDate.setText("Datum");

        jLabelTitle.setBackground(new java.awt.Color(120, 68, 41));
        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("Title");
        jLabelTitle.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLableDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPaneContent)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(jLableDate))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addComponent(jScrollPaneContent, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLableDate;
    private javax.swing.JScrollPane jScrollPaneContent;
    private javax.swing.JTextArea jTextAreaContent;
    // End of variables declaration//GEN-END:variables



    /**
     * getTitle
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    
    /**
     * setTitle
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getDate
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * setDate
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * getContent
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * setContent
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /*
     * addListener
     * Methode zur setzen eines MouseListeners auf die UI-Elemente
     * @param listener  uebergebener MouseListener
     */
    public void addListener(MouseListener listener) {
        addMouseListener(listener);
        jTextAreaContent.addMouseListener(listener);
    }

    /*
     * select
     * Methode zur visuellen Auswahl des NoteItems
     */
    public void select() {
        setBackground(SELECT_COLOR);
        jTextAreaContent.setBackground(SELECT_COLOR);
    }

    /*
     * unselect
     * Methode zur entfernung der visuellen Auswahl des NoteItems
     */
    public void unselect() {
        setBackground(BACK_COLOR);
        jTextAreaContent.setBackground(BACK_COLOR);
    }
}