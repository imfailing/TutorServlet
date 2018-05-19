package service;

import db.dao.LessonDAO;
import db.dao.LessonDAOImpl;
import pojo.Lesson;

import java.sql.SQLException;
import java.util.List;

public class LessonService {
    private static LessonDAO userDao = new LessonDAOImpl();

    public List<Lesson> getLessons() {
        try {
            LessonDAO lessonDAO = new LessonDAOImpl();
            return lessonDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
