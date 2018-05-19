package db.dao;

import db.ConnectionManager.ConnectionManager;
import db.ConnectionManager.ConnectionManagerJDBCImpl;
import pojo.Lesson;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonDAOImpl implements LessonDAO {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();

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
    public List<Lesson> getAll() throws SQLException {
        ArrayList<Lesson> result = new ArrayList<>();
        UserDaoImpl userDao = new UserDaoImpl();
        Connection connection = new ConnectionManagerJDBCImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "l.id, t.name, l.dateend, l.datestart, u.login " +
                " FROM Lessons l" +
                "INNER JOIN users u ON l.idteacher = u.id " +
                "INNER JOIN typelessons t ON t.id = l.type ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Lesson lesson = new Lesson(resultSet.getInt("id"), userDao.getAllbyLesson(resultSet.getInt("id")) ,
                    resultSet.getString("login"), resultSet.getDate("datestart"),
                    resultSet.getDate("dateend"), resultSet.getString("name"));
            result.add(lesson);
        }
        connection.close();
        return result;
    }

    public Map<String, Integer> getGrades(int lesson) throws SQLException {
        Map<String, Integer> result = new HashMap<String, Integer>() {
        };
        Connection connection = new ConnectionManagerJDBCImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "u.loginl.datestart, tl.name ,g.grade FROM grades g join IsHere i on i.id=g.idishere"+
                " join Lessons l on l.id=i.idlesson join typelessons tl on l.type=tl.id"+
                "join  Users u on i.iduser=u.id WHERE i.idlesson=?");
        preparedStatement.setInt(1, lesson);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            result.put(resultSet.getString("login")+" "+resultSet.getDate("datestart").toString(),resultSet.getInt("grade"));
        }
        connection.close();
        return result;
    }

    @Override
    public boolean updateLesson(Lesson lesson) {
        return false;
    }

}
