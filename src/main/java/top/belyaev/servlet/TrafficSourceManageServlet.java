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
import java.io.OutputStream;

@WebServlet(
        name = "TrafficSourceManageServlet",
        urlPatterns = {"/traffic-sources"}
)
public class TrafficSourceManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setUserAndTsAttributes(req);
        if (req.getAttribute("user") == null && req.getAttribute("ts") == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        req.getRequestDispatcher("tsManage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setUserAndTsAttributes(req);
        if (req.getAttribute("user") == null && req.getAttribute("ts") == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        TrafficSource ts = (TrafficSource) req.getAttribute("ts");
        if (ts == null) {
            ts = new TrafficSource();
            ts.setUser((User) req.getAttribute("user"));
        }


        ts.setTitle(req.getParameter("title"));
        ts.setUrl(req.getParameter("url"));
        ts.setCost(Helper.requestParameterFloat(req, "cost"));
        ts.setType(Helper.requestParameterTsType(req, "tstype"));
        if (
                ts.getTitle() == null || ts.getTitle().length() == 0 ||
                ts.getUrl() == null || ts.getUrl().length() == 0 ||
                ts.getCost() == null || ts.getCost().equals(0)||
                ts.getType() == null) {
            req.setAttribute("ts", ts);
            req.setAttribute("error", "Invalid data");
            req.getRequestDispatcher("tsManage.jsp").forward(req, resp);
            return;
        }

        TrafficSourcesDao.getInstanse().save(ts);
        resp.sendRedirect("/");
    }

    private void setUserAndTsAttributes(HttpServletRequest req) {
        Integer trafficSourceId = Helper.requestParameterInt(req, "tsId");
        TrafficSourcesDao tsDao = TrafficSourcesDao.getInstanse();
        if (trafficSourceId != null) {
            req.setAttribute("ts", tsDao.findById(trafficSourceId.intValue()));
        }

        Integer id = Helper.requestParameterInt(req, "userId");
        UsersDao dao = UsersDao.getInstanse();
        if (id != null) {
            req.setAttribute("user", dao.findById(id.intValue()));
        }
    }
}
