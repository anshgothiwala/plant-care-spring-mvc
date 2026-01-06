package plantcare.serviceimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import plantcare.dao.SubscriptionDao;
import plantcare.model.Subscription;
import plantcare.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Subscription> getAllSubscriptions() {
        return subscriptionDao.getAllSubscriptions();
    }

    @Override
    @Transactional
    public Subscription getSubscriptionById(int id) {
        return subscriptionDao.getSubscriptionById(id);
    }
    
    @Override
    @Transactional
    public List<Subscription> getSubscriptionsByUser(int id) {
        String hql = "FROM Subscription s WHERE s.user.id = :userId";
        return sessionFactory.getCurrentSession()
                             .createQuery(hql, Subscription.class)
                             .setParameter("userId", id)
                             .getResultList();
    }


    @Override
    @Transactional
    public void saveSubscription(Subscription subscription) {
        subscriptionDao.saveSubscription(subscription);
    }

    @Override
    @Transactional
    public void updateSubscription(Subscription subscription) {
        subscriptionDao.updateSubscription(subscription);
    }

    @Override
    @Transactional
    public void deleteSubscription(int id) {
        subscriptionDao.deleteSubscription(id);
    }
}
