package db.dao;

import db.ConnectionManager.ConnectionManagerJDBCImpl;
import pojo.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserByLogin(String login) throws SQLException {
        User student = null;
        Connection connection = new ConnectionManagerJDBCImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "* FROM users " +
                "WHERE login=?");
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            student = new User(resultSet.getInt("id"), resultSet.getString("login"),
                    resultSet.getString("password"), resultSet.getInt("type"),0);
        }
        connection.close();
        return student;
    }

    @Override
    public ArrayList<User> getAllbyLesson(int lesson) throws SQLException {
        ArrayList<User> listOfStudents = new ArrayList<>();
        User student = null;
        Connection connection = new ConnectionManagerJDBCImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "u.*,g.grade FROM users u join IsHere i on i.iduser=u.id join Grades g on g.idishere=i.id"+
                "WHERE i.idlesson=?");
        preparedStatement.setInt(1, lesson);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            student = new User(resultSet.getInt("id"), resultSet.getString("login"),
                    resultSet.getString("password"), resultSet.getInt("type"), resultSet.getInt("grade"));
            listOfStudents.add(student);
        }
        connection.close();
        return listOfStudents;
    }

    @Override
    public Map<String, Integer> getGrades(int lesson, int UserId) throws SQLException {
        Map<String, Integer> result = new HashMap<String, Integer>() {
        };
        Connection connection = new ConnectionManagerJDBCImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "l.datestart, tl.name ,g.grade FROM grades g join IsHere i on i.id=g.idishere"+
                        " join Lessons l on l.id=i.idlesson join typelessons tl on l.type=tl.id"+
                "WHERE i.idlesson=? and i.iduser=?");
        preparedStatement.setInt(1, lesson);
        preparedStatement.setInt(2, UserId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            result.put(resultSet.getString("name")+" "+resultSet.getDate("datestart").toString(),resultSet.getInt("grade"));
        }
        connection.close();
        return result;
    }

    public Map<String, Integer> getGrades(int UserId) throws SQLException {
        Map<String, Integer> result = new HashMap<String, Integer>() {
        };
        Connection connection = new ConnectionManagerJDBCImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "l.datestart, tl.name ,g.grade FROM grades g join IsHere i on i.id=g.idishere"+
                " join Lessons l on l.id=i.idlesson join typelessons tl on l.type=tl.id"+
                "WHERE i.iduser=?");
        preparedStatement.setInt(1, UserId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            result.put(resultSet.getString("name")+" "+resultSet.getDate("datestart").toString(),resultSet.getInt("grade"));
        }
        connection.close();
        return result;
    }
}
