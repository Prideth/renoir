/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class ToDo to generate ToDos 
 * 
 * @author Joerg Federspiel
 */
public class ToDo {
    
    private String subject;
    private Date beginDate;
    private Date endDate;
    private Object priority;
    private String comments;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ToDo(String subject, Date beginDate, Date endDate, Object priority, String comments) {
        this.subject = subject;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.priority = priority;
        this.comments = comments;
    }

    public String getSubject() {
        return subject;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Object getPriority() {
        return priority;
    }
    
    public String getComments() {
        return comments;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    /**
     * Method returns Date object as String
     * 
     * @return
     */
    public String getBeginDateString () {
        return sdf.format(beginDate);   
    }
    
    public String getEndDateString () {
        return sdf.format(endDate);   
    }
}