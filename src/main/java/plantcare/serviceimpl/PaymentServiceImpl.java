package plantcare.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import plantcare.dao.PaymentDao;
import plantcare.model.Payment;
import plantcare.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    @Transactional
    public List<Payment> getAllPayments() {
        return paymentDao.getAllPayments();
    }

    @Override
    @Transactional
    public Payment getPaymentById(int id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    @Transactional
    public void savePayment(Payment payment) {
        paymentDao.savePayment(payment);
    }

    @Override
    @Transactional
    public void updatePayment(Payment payment) {
        paymentDao.updatePayment(payment);
    }

    @Override
    @Transactional
    public void deletePayment(int id) {
        paymentDao.deletePayment(id);
    }
}
