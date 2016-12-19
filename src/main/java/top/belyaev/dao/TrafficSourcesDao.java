package top.belyaev.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import top.belyaev.HibernateUtil;
import top.belyaev.entity.TrafficSource;

public class TrafficSourcesDao {
    private static TrafficSourcesDao dao;

    public static TrafficSourcesDao getInstanse() {
        if (dao == null) {
            dao = new TrafficSourcesDao();
        }

        return dao;
    }

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private TrafficSourcesDao() {}

    public TrafficSource findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        TrafficSource ts = (TrafficSource) session.byId(TrafficSource.class).load(id);
        transaction.commit();
        return ts;
    }

    public void save(TrafficSource trafficSource) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(trafficSource);
        transaction.commit();
    }

    public void delete(TrafficSource trafficSource) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(trafficSource);
        transaction.commit();
    }
}
