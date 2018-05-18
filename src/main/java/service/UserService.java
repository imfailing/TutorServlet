package service;

import db.dao.UserDao;
import db.dao.UserDaoImpl;
import pojo.User;

import java.sql.SQLException;

public class UserService {
    private static UserDao userDao = new UserDaoImpl();

    public boolean checkAuth(String login, String password) {
        User user = null;
        try {
            user = userDao.getUserByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user != null) && (user.getPassword().equals(password));
    }

    public Integer getRole(String login) {
        User user = null;
        try {
            user = userDao.getUserByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user != null) ? user.getType() : 0;
    }
}
