package pim.calendar;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;


public class FixedColumnTable implements ChangeListener, PropertyChangeListener {

    private JTable main;
    private JTable fixed;
    private JScrollPane scrollPane;

    
    public FixedColumnTable(int fixedColumns, JScrollPane scrollPane) {
        this.scrollPane = scrollPane;

        main = ((JTable) scrollPane.getViewport().getView());
        main.setAutoCreateColumnsFromModel(false);
        main.addPropertyChangeListener(this);
        
        fixed = new JTable();
        fixed.setAutoCreateColumnsFromModel(false);
        fixed.setModel(main.getModel());
        fixed.setFocusable(false);
        fixed.setRowHeight(main.getRowHeight());
        fixed.setRowSelectionAllowed(false);
        fixed.getTableHeader().setReorderingAllowed(false);
        fixed.setEnabled(false);
        
        fixed.setShowHorizontalLines(true);
        fixed.setShowVerticalLines(true);
        fixed.setGridColor(new Color(146, 151, 161));
        fixed.setBackground(new Color(214, 217, 223));
        
        for (int i = 0; i < fixedColumns; i++) {
            TableColumnModel columnModel = main.getColumnModel();
            TableColumn column = columnModel.getColumn(0);
            columnModel.removeColumn(column);
            fixed.getColumnModel().addColumn(column);
        }
        
        fixed.setPreferredScrollableViewportSize(fixed.getPreferredSize());
        scrollPane.setRowHeaderView(fixed);
        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixed.getTableHeader());
        
        scrollPane.getRowHeader().addChangeListener(this);
    }

    
    public JTable getFixedTable() {
        return fixed;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JViewport viewport = (JViewport) e.getSource();
        scrollPane.getVerticalScrollBar().setValue(viewport.getViewPosition().y);
    }
    

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if ("selectionModel".equals(e.getPropertyName())) {
            fixed.setSelectionModel(main.getSelectionModel());
        }
        if ("model".equals(e.getPropertyName())) {
            fixed.setModel(main.getModel());
        }
    }

}
