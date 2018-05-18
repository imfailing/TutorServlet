package db.dao;

import db.ConnectionManager.ConnectionManagerJDBCImpl;
import pojo.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserByLogin(String login) throws SQLException {
        User result = null;
        Connection connection = new ConnectionManagerJDBCImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "* FROM users " +
                "WHERE login=?");
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            result = new User(resultSet.getInt("id"), resultSet.getString("login"),
                    resultSet.getString("password"), resultSet.getInt("type"));
        }
        connection.close();
        return result;
    }
}
