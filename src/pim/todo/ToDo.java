/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.todo;

/**
 * Class ToDo to generate ToDos 
 * 
 * @author Joerg Federspiel
 */
public class ToDo {
    
    private String subject;
    private String beginDate;
    private String endDate;
    private String priorityString;
    private String comments;
    private Object priorityObject;
    
    public ToDo(String subject, String beginDate, String endDate, String priorityString, String comments, Object priorityObject) {
        this.subject = subject;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.priorityString = priorityString;
        this.comments = comments;
        this.priorityObject = priorityObject;
    }

    public String getSubject() {
        return subject;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getPriorityString() {
        return priorityString;
    }

    public String getComments() {
        return comments;
    }

    public Object getPriorityObject() {
        return priorityObject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPriorityString(String priorityString) {
        this.priorityString = priorityString;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setPriorityObject(Object priorityObject) {
        this.priorityObject = priorityObject;
    }

    
    
}