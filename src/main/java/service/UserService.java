package service;

import db.dao.LessonDAOImpl;
import db.dao.UserDao;
import db.dao.UserDaoImpl;
import pojo.User;

import java.sql.SQLException;
import java.util.Map;

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

    public Map<String, Integer> getGrades(int userid) {
        try {
            UserDao userDao = new UserDaoImpl();
            return userDao.getGrades(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
