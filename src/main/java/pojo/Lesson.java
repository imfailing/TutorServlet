package pojo;

import java.util.ArrayList;
import java.util.Date;

public class Lesson {
    private int id;
    private ArrayList<User> listOfStudents;
    private User teacher;
    private Date dateStart;
    private Date dateEnd;
    private int type;


    public Lesson(int id, ArrayList<User> listOfStudents, User teacher, Date dateStart, Date dateEnd, int type) {
        this.id = id;
        this.listOfStudents = listOfStudents;
        this.teacher = teacher;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public ArrayList<User> getListOfStudents() {
        return listOfStudents;
    }

    public User getTeacher() {
        return teacher;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public int getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListOfStudents(ArrayList<User> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setType(int type) {
        this.type = type;
    }
}
