package Controller;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message","Hello");
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("userName");
        String password = req.getParameter("userPassword");
        if(userService.checkAuth(login,password)) {
            Integer Role = userService.getRole(login);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", Role);
            if (Role == 1) {
                resp.sendRedirect("/teacherdashboard");
            } else {
                resp.sendRedirect("/dashboard");
            }
        }
        {
            resp.sendRedirect("/login?errorMsg=authError");
        }
    }
}
