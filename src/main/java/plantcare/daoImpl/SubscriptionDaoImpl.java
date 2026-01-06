package plantcare.daoImpl;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import plantcare.dao.SubscriptionDao;
import plantcare.model.Subscription;

@Repository
public class SubscriptionDaoImpl implements SubscriptionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Subscription> getAllSubscriptions() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Subscription");
        return query.getResultList();
    }

    @Override
    public Subscription getSubscriptionById(int id) {
        return sessionFactory.getCurrentSession().get(Subscription.class, id);
    }

    @Override
    public void saveSubscription(Subscription subscription) {
        sessionFactory.getCurrentSession().save(subscription);
    }

    @Override
    public void updateSubscription(Subscription subscription) {
        sessionFactory.getCurrentSession().update(subscription);
    }

    @Override
    public void deleteSubscription(int id) {
        Session session = sessionFactory.getCurrentSession();
        Subscription subscription = session.get(Subscription.class, id);
        if (subscription != null) session.delete(subscription);
    }
}
