package pim.notes;

import java.util.Comparator;
import java.util.Date;

/**
 * Klasse Note zur definierung eines Notiz-Objektes
 * 
 * @author Thomas Quitter
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
     * getID
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * setID
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

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
     * getNoteContent
     * @return the noteContent
     */
    public String getNoteContent() {
        return noteContent;
    }

    /**
     * setNoteContent
     * @param noteContent the noteContent to set
     */
    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    /**
     * getCreateDate
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * setCreateDate
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    @Override
    /**
     * compareTo
     * @param note  Noteobject to compare
     */
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
    /*
     * toString
     * @return title as String
     */
    public String toString() {
        return title;
    }

    /**
     * Comparator to compare Notes by Title
     * @param one first Note to compare
     * @param other secound Note to compare
     */
    public static Comparator<Note> COMPARE_BY_TITLE = new Comparator<Note>() {
        public int compare(Note one, Note other) {
            return one.title.compareTo(other.title);
        }
    };
    
    /**
     * Comparator to compare Notes by Date
     * @param one first Note to compare
     * @param other secound Note to compare
     */
    public static Comparator<Note> COMPARE_BY_DATE = new Comparator<Note>() {
        public int compare(Note one, Note other) {
            return one.createDate.compareTo(other.createDate);
        }
    };
}
