/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.calendar2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import pim.exam.CreateExamDialog;
import pim.exam.Exam;
import pim.exam.ExamPanel;
import pim.notes.CreateNoteDialog;
import pim.notes.Note;
import pim.notes.NotePanel;
import pim.todo.ToDo;

/**
 *
 * @author lk
 */
public class CalendarPanel extends javax.swing.JPanel {
    
    private static final String[] HOURS = new String[]{"", 
        "06:00", "06:30", "07:00", "07:30", "08:00", "08:30",
        "09:00", "09:30", "10:00", "10:30", "11:00", "11:30",
        "12:00", "12:30", "13:00", "13:30", "14:00", "14:30",
        "15:00", "15:30", "16:00", "16:30", "17:00", "17:30",
        "18:00", "18:30", "19:00", "19:30", "20:00", "20:30",
        "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"
    };
    
    private static final String[] MONTHS = new String[]{
        "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli",
        "August", "September", "Oktober", "November", "Dezember"
    };
    
    private ExamPanel examPanel;
    private NotePanel notePanel;
    
    private int year;
    private int month;
    private Calendar calendar;
    private DefaultTableModel model;
    
    /**
     * Creates new form CalendarPanel
     */
    public CalendarPanel(ExamPanel examPanel, NotePanel notePanel) {
        
        this.examPanel = examPanel;
        this.notePanel = notePanel;
        initComponents();
        
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        
        jLabelDate.setText(MONTHS[month] + " " + year);
        
        model = getModel();
        
        jTableCalendar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        jTableCalendar.getColumnModel().getColumn(0).setPreferredWidth(46);
        
        
        jTableCalendar.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
 
                Component c = super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);
                
                if (value != null) {
                    if (value instanceof Exam) {
                        setBackground(new Color(255, 196, 196));
                    }
                    if (value instanceof Note) {
                       setBackground(new Color(255, 255, 128));
                    }
                    if (value instanceof ToDo) {
                        //setBackground(new Color(255, 85, 85));
                    }
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        
        jTableCalendar.setShowHorizontalLines(true);
        //jTableCalendar.setShowVerticalLines(true);
        
        jTableCalendar.getTableHeader().setResizingAllowed(false);
        
        jTableCalendar.setGridColor(new Color(146, 151, 161));
        FixedColumnTable fct = new FixedColumnTable(1, jScrollPane1);
    }

    public void update() {
        model = getModel();
    }

    private DefaultTableModel getModel() {
        
        int max = 31;
        if (month == 3 || month == 5 || month == 8 || month == 10) {
            max = 30;
        } else if (month == 1) {
            max = 28;
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                max = 29;
            }
        }
        
        Object[][] data = new Object[max][HOURS.length];
        
        DecimalFormat df = new DecimalFormat("00");
        for (int i = 0; i < max; i++) {
            data[i][0] = df.format(i + 1) + "." + df.format(month + 1);
        }
        DefaultTableModel model = new DefaultTableModel(data, HOURS) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        
        Exam[] exams = (Exam[]) examPanel.getValues();
        for (int i = 0; i < exams.length; i++) {
            Date date = exams[i].getDate();
            if (date != null && date.getMonth() == month) {
                int[] cell = dateToCell(date);
                if (cell[1] > 0) {
                    model.setValueAt(exams[i], cell[0], cell[1]);
                }
            }
        }
        
        Note[] notes = (Note[]) notePanel.getValues();
        for (int i = 0; i < notes.length; i++) {
            Date date = notes[i].getCreateDate();
            if (date != null && date.getMonth() == month) {
                int[] cell = dateToCell(date);
                if (cell[1] > 0) {
                    model.setValueAt(notes[i], cell[0], cell[1]);
                }
            }
        }
        
        jTableCalendar.setModel(model);
        return model;
    }
    
    private Date cellToDate() {
        Date date = null;
        String d = model.getValueAt(jTableCalendar.getSelectedRow(), 0) + "." + year;

        String t = (String) jTableCalendar.getTableHeader()
                .getColumnModel()
                .getColumn(jTableCalendar.getSelectedColumn())
                .getHeaderValue();
        
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(f.parse(d + " " + t));
            date = cal.getTime();
        } catch (ParseException ex) {
        }
        
        return date;
    }
    
    private int[] dateToCell(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("dd:HH:mm");
        
        String datestring = f.format(date);
        int row = Integer.parseInt(datestring.substring(0, 2)) - 1;
        int hour = Integer.parseInt(datestring.substring(3, 5));
        int minute = Integer.parseInt(datestring.substring(6, 8));
        
        int column = ((hour - 5) * 2) - 1;
        if (minute >= 30) {
            column++;
        }
        
        int[] cell = new int[2];
        cell[0] = row;
        cell[1] = column;
        
        return cell;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCalendar = new javax.swing.JTable();
        jLabelDate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonExam = new javax.swing.JButton();
        jButtonEvent = new javax.swing.JButton();
        jButtonNote = new javax.swing.JButton();
        jButtonNow = new javax.swing.JButton();
        jButtonPrev = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();

        jTableCalendar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableCalendar.setRowHeight(24);
        jTableCalendar.setRowMargin(3);
        jTableCalendar.setRowSelectionAllowed(false);
        jTableCalendar.getTableHeader().setReorderingAllowed(false);
        jTableCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCalendarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableCalendarMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCalendar);

        jLabelDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDate.setText("August 2012");

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jButtonExam.setText("Klausur");
        jButtonExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExamActionPerformed(evt);
            }
        });

        jButtonEvent.setText("Termin");
        jButtonEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEventActionPerformed(evt);
            }
        });

        jButtonNote.setText("Notiz");
        jButtonNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNoteActionPerformed(evt);
            }
        });

        jButtonNow.setText("Jetzt");
        jButtonNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNowActionPerformed(evt);
            }
        });

        jButtonPrev.setText("<");
        jButtonPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrevActionPerformed(evt);
            }
        });

        jButtonNext.setText(">");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonExam, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNote, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jButtonNow, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonPrev)
                .addGap(0, 0, 0)
                .addComponent(jButtonNext))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonEvent)
                        .addComponent(jButtonExam)
                        .addComponent(jButtonNote))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonPrev)
                        .addComponent(jButtonNext)
                        .addComponent(jButtonNow))))
        );

        jPanel2.add(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCalendarMouseClicked
        
        //cellToDate();
        if (evt.getButton() == 3) {
            Point p = evt.getPoint();
            int row = jTableCalendar.rowAtPoint(p);
            int column = jTableCalendar.columnAtPoint(p);
            jTableCalendar.requestFocus();
            jTableCalendar.changeSelection(row, column, false, false);
            
            row = jTableCalendar.getSelectedRow();
            column = jTableCalendar.getSelectedColumn() + 1;
            
            
            CalendarPopup popup = new CalendarPopup(this, model.getValueAt(row, column) != null);
            
            popup.show(jTableCalendar, (int) p.getX(), (int) p.getY());
            
        }
    }//GEN-LAST:event_jTableCalendarMouseClicked

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        month++;
        if (month == 12) {
            month = 0;
            year++;
        }
        jLabelDate.setText(MONTHS[month] + " " + year);
        model = getModel();
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrevActionPerformed
        month--;
        if (month == -1) {
            month = 11;
            year--;
        }
        jLabelDate.setText((MONTHS[month]) + " " + year);
        model = getModel();
    }//GEN-LAST:event_jButtonPrevActionPerformed

    private void jButtonNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNowActionPerformed
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        jLabelDate.setText(MONTHS[month] + " " + year);
        
        model = getModel();
        
        Calendar cal = Calendar.getInstance();
        int[] cell = dateToCell(cal.getTime());
        
        if (cell[1] < 1) {
            cell[1] = 1;
        }
        
        jTableCalendar.changeSelection(cell[0], cell[1] - 1, true, false);
        jTableCalendar.requestFocus();
        
    }//GEN-LAST:event_jButtonNowActionPerformed

    private void jTableCalendarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCalendarMousePressed

        if (evt.getButton() == 3) {
            Point p = evt.getPoint();
            int row = jTableCalendar.rowAtPoint(p);
            int column = jTableCalendar.columnAtPoint(p);
            jTableCalendar.requestFocus();
            jTableCalendar.changeSelection(row, column, false, false);
        }
    }//GEN-LAST:event_jTableCalendarMousePressed

    private void jButtonExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExamActionPerformed
        insertExam();
    }//GEN-LAST:event_jButtonExamActionPerformed

    private void jButtonEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEventActionPerformed
        
    }//GEN-LAST:event_jButtonEventActionPerformed

    private void jButtonNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNoteActionPerformed
        insertNote();
    }//GEN-LAST:event_jButtonNoteActionPerformed

    
    public void change() {
        int row = jTableCalendar.getSelectedRow();
        int column = jTableCalendar.getSelectedColumn() + 1;
        Object value = model.getValueAt(row, column);
        if (value != null) {
            if (value instanceof Exam) {
                examPanel.showChangeDialog(value, getRootWindow());    
            }
            if (value instanceof Note) {
                notePanel.showChangeDialog(value, getRootWindow());
            }
            if (value instanceof ToDo) {
                
            }
            update();
        }
    }
    
    public void delete() {
        int row = jTableCalendar.getSelectedRow();
        int column = jTableCalendar.getSelectedColumn() + 1;
        Object value = model.getValueAt(row, column);
        if (value != null) {
            if (value instanceof Exam) {
                examPanel.showDeleteDialog(value, getRootWindow()); 
            }
            if (value instanceof Note) {
                notePanel.showDeleteDialog(value, getRootWindow());
            }
            if (value instanceof ToDo) {
            }
            update();
        }
    }
    
    
    public void insertExam() {
        int column = jTableCalendar.getSelectedColumn() + 1;
        if (column > 0) {
            
            Date date = cellToDate();
            
            int row = jTableCalendar.getSelectedRow();
            Exam exam = new Exam(null, "WS 13/14", 1, date, null, 0d, null);
            JFrame rootWindow = getRootWindow();
            CreateExamDialog dialog = new CreateExamDialog(rootWindow, true, exam);
            dialog.setLocationRelativeTo(rootWindow);
            dialog.setVisible(true);
            exam = dialog.getExam();
            if (exam != null) {
                examPanel.insertValue(exam);
                model.setValueAt(exam, row, column);
                update();
            }
        }
        jTableCalendar.requestFocus();
    }
    
    
    public void insertNote() {
        int column = jTableCalendar.getSelectedColumn() + 1;
        if (column > 0) {
            
            Date date = cellToDate();
            
            int row = jTableCalendar.getSelectedRow();
            Note note = new Note(0, "", "", date);
            JFrame rootWindow = getRootWindow();
            CreateNoteDialog dialog = new CreateNoteDialog(rootWindow, true, note);
            dialog.setLocationRelativeTo(rootWindow);
            dialog.setVisible(true);
            note = dialog.getNote();
            if (note != null) {
                notePanel.insertValue(note);
                model.setValueAt(note, row, column);
                update();
            }
        }
        jTableCalendar.requestFocus();
    }
    
    
    private JFrame getRootWindow() {
        return (JFrame) SwingUtilities.getWindowAncestor(this.getParent());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEvent;
    private javax.swing.JButton jButtonExam;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonNote;
    private javax.swing.JButton jButtonNow;
    private javax.swing.JButton jButtonPrev;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCalendar;
    // End of variables declaration//GEN-END:variables
}
