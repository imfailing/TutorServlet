package pojo;

import java.util.ArrayList;
import java.util.Date;

public class Lesson {
    private int id;
    private ArrayList<User> listOfStudents;
    private String teacher;
    private Date dateStart;
    private Date dateEnd;
    private String name;


    public Lesson(int id, ArrayList<User> listOfStudents, String teacher, Date dateStart, Date dateEnd, String name) {
        this.id = id;
        this.listOfStudents = listOfStudents;
        this.teacher = teacher;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<User> getListOfStudents() {
        return listOfStudents;
    }

    public String getTeacher() {
        return teacher;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListOfStudents(ArrayList<User> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setName(String name) {
        this.name = name;
    }
}
