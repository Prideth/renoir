/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.notes;

import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Beware
 */
public class Note implements Comparable<Note>{
    
    private int id;
    private String title;
    private String noteContent;
    private Date createDate;

    /**
     * Constructor
     */
    public Note(int id, String title, String noteContent, Date createDate){
        this.id = id;
        this.title = title;
        this.noteContent = noteContent;
        this.createDate = createDate;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the noteContent
     */
    public String getNoteContent() {
        return noteContent;
    }

    /**
     * @param noteContent the noteContent to set
     */
    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    @Override
    public int compareTo( Note note ) {
        if (note.getTitle( )== null && this.getTitle() == null) {
          return 0;
        }
        if (this.getTitle() == null) {
          return 1;
        }
        if (note.getTitle() == null) {
          return -1;
        }
        return this.getTitle().compareTo(note.getTitle());
    }
    
    @Override
    public String toString() {
        return title;
    }

    public static Comparator<Note> COMPARE_BY_TITLE = new Comparator<Note>() {
        public int compare(Note one, Note other) {
            return one.title.compareTo(other.title);
        }
    };

    public static Comparator<Note> COMPARE_BY_DATE = new Comparator<Note>() {
        public int compare(Note one, Note other) {
            return one.createDate.compareTo(other.createDate);
        }
    };

}
