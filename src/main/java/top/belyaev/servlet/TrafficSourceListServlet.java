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
        name = "TrafficSourceListServlet",
        urlPatterns = {"/traffic-sources"}
)

public class TrafficSourceListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer userId = Helper.parseInt(req.getParameter("userId"));
        if (userId == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        UsersDao dao = UsersDao.getInstanse();
        User user = dao.findById(userId.intValue());
        if (user == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        req.setAttribute("user", user);
        req.getRequestDispatcher("userTrafficSources.jsp").forward(req, resp);
    }
}
