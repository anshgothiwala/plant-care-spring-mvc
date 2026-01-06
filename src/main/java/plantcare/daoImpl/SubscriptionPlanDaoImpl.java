package plantcare.daoImpl;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import plantcare.dao.SubscriptionPlanDao;
import plantcare.model.SubscriptionPlan;

@Repository
public class SubscriptionPlanDaoImpl implements SubscriptionPlanDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<SubscriptionPlan> getAllPlans() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM SubscriptionPlan");
        return query.getResultList();
    }

    @Override
    public SubscriptionPlan getPlanById(int id) {
        return sessionFactory.getCurrentSession().get(SubscriptionPlan.class, id);
    }

    @Override
    public void savePlan(SubscriptionPlan plan) {
        sessionFactory.getCurrentSession().save(plan);
    }

    @Override
    public void updatePlan(SubscriptionPlan plan) {
        sessionFactory.getCurrentSession().update(plan);
    }

    @Override
    public void deletePlan(int id) {
        Session session = sessionFactory.getCurrentSession();
        SubscriptionPlan plan = session.get(SubscriptionPlan.class, id);
        if (plan != null) session.delete(plan);
    }
}
