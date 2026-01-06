package plantcare.service;

import java.util.List;
import plantcare.model.Subscription;

public interface SubscriptionService {
    List<Subscription> getAllSubscriptions();
    Subscription getSubscriptionById(int id);
    public List<Subscription> getSubscriptionsByUser(int id);
    void saveSubscription(Subscription subscription);
    void updateSubscription(Subscription subscription);
    void deleteSubscription(int id);
}