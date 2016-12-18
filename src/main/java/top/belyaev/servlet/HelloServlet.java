package top.belyaev.servlet;

import org.hibernate.Session;
import top.belyaev.HibernateUtil;
import top.belyaev.entity.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/hello"}
)
public class HelloServlet extends HttpServlet {

    Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        session.beginTransaction();

        User user = new User();

        user.setBirthDate(new java.util.Date());
        user.setFirstName("Nick");
        user.setLastName("VN");
        user.setOrganization("Google Inc.");
        user.setPhone("0508392938");

        session.save(user);
        session.getTransaction().commit();

        session.close();

        ServletOutputStream out = resp.getOutputStream();
        out.write(user.toString().getBytes());
        out.flush();
        out.close();
    }

}
