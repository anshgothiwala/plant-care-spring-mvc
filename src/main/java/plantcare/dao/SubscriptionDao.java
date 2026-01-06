package plantcare.dao;

import java.util.List;
import plantcare.model.Subscription;

public interface SubscriptionDao {
    List<Subscription> getAllSubscriptions();
    Subscription getSubscriptionById(int id);
    void saveSubscription(Subscription subscription);
    void updateSubscription(Subscription subscription);
    void deleteSubscription(int id);
}