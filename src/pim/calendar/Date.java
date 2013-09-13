/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.calendar;

import java.util.Calendar;

/**
 *
 * @author Christopher Schuetz
 */
public class Date {
    
    //Variablen
    private String date;
    private String time;
    private String description;
    
    //Konstruktor
    public Date (String date, String time, String description) {
        this.date = date;
        this.time = time;
        this.description = description;
    }
    
    // Set und Get Methoden
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public String getTime() {
        return this.time;
    }
    
    public void setDesc(String desc) {
        this.description = desc;
    }
    
    public String getDesc() {
        return this.description;
    }
    
    public Object[] getTableRow() {
        return new Object[] {
            this,
            (time == null) ? "" : time,
            (description == null) ? "" : description
        };
    }
    
    @Override
    public String toString() {
        return date;
    }
}
