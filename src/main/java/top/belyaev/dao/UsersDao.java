package top.belyaev.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import top.belyaev.HibernateUtil;
import top.belyaev.entity.User;

import java.util.List;

public class UsersDao {
    private static UsersDao dao;

    public static UsersDao getInstanse() {
        if (dao == null) {
            dao = new UsersDao();
        }

        return dao;
    }

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private UsersDao() {}

    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        return  (List<User>) criteria.list();
    }
}
