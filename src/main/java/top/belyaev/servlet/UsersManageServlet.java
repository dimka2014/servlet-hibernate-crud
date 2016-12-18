package top.belyaev.servlet;

import top.belyaev.Helper;
import top.belyaev.dao.UsersDao;
import top.belyaev.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "UsersListServlet",
        urlPatterns = {"/users"}
)
public class UsersManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = Helper.requestParameterInt(req, "id");
        if (userId != null) {
            UsersDao dao = UsersDao.getInstanse();
            User user = dao.findById(userId.intValue());
            req.setAttribute("user", user);
        }

        req.getRequestDispatcher("userManage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = Helper.requestParameterInt(req, "id");
        User user = null;
        UsersDao dao = UsersDao.getInstanse();

        if (userId != null) {
            user = dao.findById(userId.intValue());
        }

        if (user == null) {
            user = new User();
        }

        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setOrganization(req.getParameter("organization"));
        user.setPhone(req.getParameter("phone"));
        user.setBirthDate(Helper.requestParameterDate(req, "birthDate"));
        if (
                user.getFirstName() == null || user.getFirstName().length() == 0 ||
                user.getLastName() == null || user.getLastName().length() == 0 ||
                user.getBirthDate() == null  ||
                user.getPhone() == null || user.getPhone().length() == 0 ||
                user.getOrganization() == null || user.getOrganization().length() == 0) {
            req.setAttribute("user", user);
            req.setAttribute("error", "Invalid data");
            req.getRequestDispatcher("userManage.jsp").forward(req, resp);
            return;
        }

        dao.save(user);
        resp.sendRedirect("/");
    }
}
