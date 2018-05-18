package db.dao;

import pojo.Lesson;

import java.sql.SQLException;

public interface LessonDAO {
    public boolean StartLesson(Lesson lesson);
    public Lesson getLessonById(int id) throws SQLException;
    public boolean updateLesson(Lesson lesson);
    public boolean FinishLesson(int id);
}
