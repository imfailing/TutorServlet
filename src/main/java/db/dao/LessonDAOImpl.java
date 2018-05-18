package db.dao;

import db.ConnectionManager.ConnectionManager;
import db.ConnectionManager.ConnectionManagerJDBCImpl;
import pojo.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LessonDAOImpl implements LessonDAO {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();

    @Override
    public boolean StartLesson(Lesson lesson) {
        return false;
    }

    @Override
    public Lesson getLessonById(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM Lessons WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Lesson lesson = null;

        connection.close();
        return lesson;
    }

    @Override
    public boolean updateLesson(Lesson lesson) {
        return false;
    }

    @Override
    public boolean FinishLesson(int id) {
        return false;
    }
}
