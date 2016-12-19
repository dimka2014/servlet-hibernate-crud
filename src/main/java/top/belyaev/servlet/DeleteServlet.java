package top.belyaev.servlet;

import top.belyaev.Helper;
import top.belyaev.dao.TrafficSourcesDao;
import top.belyaev.dao.UsersDao;
import top.belyaev.entity.TrafficSource;
import top.belyaev.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "DeleteServlet",
        urlPatterns = {"/delete"}
)
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if (!type.equals("user") && !type.equals("ts")) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        Integer id = Helper.requestParameterInt(req, "id");
        if (id == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        if (type.equals("user")) {
            UsersDao dao = UsersDao.getInstanse();
            User user = dao.findById(id.intValue());
            if (user == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            dao.delete(user);
        } else if (type.equals("ts")) {
            TrafficSourcesDao tsDao = TrafficSourcesDao.getInstanse();
            TrafficSource ts = tsDao.findById(id);
            if (ts == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            tsDao.delete(ts);
        }


        resp.sendRedirect("/");
    }
}
