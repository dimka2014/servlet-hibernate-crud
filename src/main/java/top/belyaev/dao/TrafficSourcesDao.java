package top.belyaev.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import top.belyaev.HibernateUtil;
import top.belyaev.entity.TrafficSource;
import top.belyaev.entity.User;

import java.util.List;

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

    public List<TrafficSource> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(TrafficSource.class);
        List<TrafficSource> trafficSources = (List<TrafficSource>) criteria.list();
        transaction.commit();
        return trafficSources;
    }
}
