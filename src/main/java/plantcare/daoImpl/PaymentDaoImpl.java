package plantcare.daoImpl;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import plantcare.dao.PaymentDao;
import plantcare.model.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Payment> getAllPayments() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Payment");
        return query.getResultList();
    }

    @Override
    public Payment getPaymentById(int id) {
        return sessionFactory.getCurrentSession().get(Payment.class, id);
    }

    @Override
    public void savePayment(Payment payment) {
        sessionFactory.getCurrentSession().save(payment);
    }

    @Override
    public void updatePayment(Payment payment) {
        sessionFactory.getCurrentSession().update(payment);
    }

    @Override
    public void deletePayment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Payment payment = session.get(Payment.class, id);
        if (payment != null) session.delete(payment);
    }
}
