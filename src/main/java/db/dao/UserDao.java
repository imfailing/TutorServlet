package db.dao;

import pojo.User;

import java.sql.SQLException;

public interface UserDao {
    public User getUserByLogin(String login) throws SQLException;
}
