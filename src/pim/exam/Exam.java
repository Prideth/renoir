/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.exam;

import java.util.Comparator;

/**
 *
 * @author lk
 */

class sortBySemester implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String c1 = (String) o1;
        String c2 = (String) o2;
        int pos1 = 0;
        int pos2 = 0;
        for (int i = 0; i < Exam.SEMESTER.length; i++) {
            if (c1.equals(Exam.SEMESTER[i])) {
                pos1 = i;
            }
            if (c2.equals(Exam.SEMESTER[i])) {
                pos2 = i;
            }
        }
        if (pos1 > pos2) {
            return 1;
        } else if (pos1 < pos2) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class Exam {
        
    public static final double[] GRADES = {
        1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9,
        2.0, 2.1, 2.2, 2.3, 2.4, 2.5, 2.6, 2.7, 2.8, 2.9,
        3.0, 3.1, 3.2, 3.3, 3.4, 3.5, 3.6, 3.7, 3.8, 3.9,
        4.0, 5.0};
    
   public static final String[] SEMESTER = {
       "WS 13/14", "SS 13", "WS 12/13", "SS 12",
       "WS 11/12", "SS 11", "WS 10/11" };

    
    private String subject;
    private String semester;
    private int ects;
    private String date;
    private String time;
    private String room;
    private double grade;
    private int[] numbers;
    private double average;
    private int students;

    public Exam(String subject, String semester, int ects, String date,
            String time, String room, double grade, int[] numbers) {
        this.subject = subject;
        this.semester = semester;
        this.ects = ects;
        this.date = date;
        this.time = time;
        this.room = room;
        this.grade = grade;
        this.numbers = numbers;
        calculateAverage();
    }

    private void calculateAverage() {
        if (numbers != null) {
            double sum = 0d;
            students = 0;
            for (int i = 0; i < GRADES.length - 1; i++) {
                sum += GRADES[i] * numbers[i];
                students += numbers[i];
            }
            average = Math.round((sum / students) * 10d) / 10d;
            students += numbers[31];
        } else {
            average = 0d;
            students = 0;
        }
    }

    public Object[] getTableRow() {
        return new Object[] {
            this,
            semester,
            ects,
            (date == null) ? "" : date,
            (time == null) ? "" : time,
            (room == null) ? "" : room,
            (grade == 0d) ? "" : grade,
            (average == 0d) ? "" : average
        };
    }

    public String getSubject() {
        return subject;
    }

    public String getSemester() {
        return semester;
    }

    public int getEcts() {
        return ects;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    public double getGrade() {
        return grade;
    }

    public double getAverage() {
        return average;
    }

    public int getStudents() {
        return students;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
        calculateAverage();
    }
    
    @Override
    public String toString() {
        return subject;
    }
}
