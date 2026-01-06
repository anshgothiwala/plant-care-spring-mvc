package plantcare.dao;

import java.util.List;
import plantcare.model.SubscriptionPlan;

public interface SubscriptionPlanDao {
    List<SubscriptionPlan> getAllPlans();
    SubscriptionPlan getPlanById(int id);
    void savePlan(SubscriptionPlan plan);
    void updatePlan(SubscriptionPlan plan);
    void deletePlan(int id);
}
