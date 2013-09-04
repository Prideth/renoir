/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.mail;

import java.util.Date;
import java.util.Vector;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author matthiaskiefer
 */
class MailTableModel implements TableModel {
    public static final int COLUMN_COUNT = 3;

    private Vector mails = new Vector();
    private Vector listeners = new Vector();

    public void addMail(Mail mail) {
        // Das wird der Index des Vehikels werden
        int index = mails.size();
        mails.add(mail);

        // Jetzt werden alle Listeners benachrichtigt

        // Zuerst ein Event, "neue Row an der Stelle index" herstellen
        TableModelEvent e = new TableModelEvent(this, index, index,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);

        // Nun das Event verschicken
        for (int i = 0, n = listeners.size(); i < n; i++) {
            ((TableModelListener) listeners.get(i)).tableChanged(e);
        }
    }

    // Die Anzahl Columns
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    // Die Anzahl Vehikel
    public int getRowCount() {
        return mails.size();
    }

    // Die Titel der einzelnen Columns
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Absender";
            case 1:
                return "Betreff";
            case 2:
                return "Datum";
            default:
                return null;
        }
    }

    // Der Wert der Zelle (rowIndex, columnIndex)
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mail mail = (Mail) mails.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return mail.getFrom();
            case 1:
                return mail.getSubject();
            case 2:
                return mail.getSentDate();
           
            default:
                return null;
        }
    }

    // Eine Angabe, welchen Typ von Objekten in den Columns angezeigt werden soll
    public Class getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Date.class;
            default:
                return null;
        }
    }

    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // nicht beachten
    }
}
