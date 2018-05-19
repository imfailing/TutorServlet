package db.dao;

import pojo.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDao {
    public User getUserByLogin(String login) throws SQLException;
    public List<User> getAllbyLesson(int lesson) throws SQLException;
    public Map<String, Integer> getGrades(int lesson, int UserId) throws SQLException ;
    public Map<String, Integer> getGrades(int UserId) throws SQLException ;
}
