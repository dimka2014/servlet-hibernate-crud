package top.belyaev.servlet;

import top.belyaev.dao.UsersDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "UserManageServlet",
        urlPatterns = {"/"}
)
public class UsersListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UsersDao dao = UsersDao.getInstanse();
        req.setAttribute("users", dao.findAll());
        req.getRequestDispatcher("usersList.jsp").forward(req, resp);
    }
}
