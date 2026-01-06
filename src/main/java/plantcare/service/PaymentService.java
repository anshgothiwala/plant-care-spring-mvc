package plantcare.service;

import java.util.List;
import plantcare.model.Payment;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(int id);
    void savePayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(int id);
}