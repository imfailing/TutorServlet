package db.dao;

import pojo.Lesson;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface LessonDAO {
    public Lesson getLessonById(int id) throws SQLException;
    public List<Lesson> getAll() throws SQLException;
    public boolean updateLesson(Lesson lesson);
    public Map<String, Integer> getGrades(int lesson) throws SQLException ;
}
