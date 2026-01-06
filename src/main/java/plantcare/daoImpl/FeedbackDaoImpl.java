package plantcare.daoImpl;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import plantcare.dao.FeedbackDao;
import plantcare.model.Feedback;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Feedback> getAllFeedbacks() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Feedback");
        return query.getResultList();
    }

    @Override
    public Feedback getFeedbackById(int id) {
        return sessionFactory.getCurrentSession().get(Feedback.class, id);
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        sessionFactory.getCurrentSession().save(feedback);
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        sessionFactory.getCurrentSession().update(feedback);
    }

    @Override
    public void deleteFeedback(int id) {
        Session session = sessionFactory.getCurrentSession();
        Feedback feedback = session.get(Feedback.class, id);
        if (feedback != null) session.delete(feedback);
    }
}
