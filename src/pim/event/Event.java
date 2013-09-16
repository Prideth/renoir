/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.event;

import java.util.Date;


public class Event {
    
    private String title;
    private String content;
    private Date date;

    public Event(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }
   
    @Override
    public String toString() {
        return title;
    }

}