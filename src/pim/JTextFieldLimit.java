package pim;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {

    private int limit;
    private boolean onlynumbers;

    public JTextFieldLimit(int limit, boolean onlynumbers) {
        super();
        this.limit = limit;
        this.onlynumbers = onlynumbers;
    }
    
    public JTextFieldLimit(int limit) {
        this(limit, false);
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (str == null) {
            return;
        }
        if ((getLength() + str.length()) <= limit) {
            if (!onlynumbers) {
                super.insertString(offset, str, attr);
            } else if (str.matches("\\d+")) {
                super.insertString(offset, str, attr);
            }
        }
    }
}