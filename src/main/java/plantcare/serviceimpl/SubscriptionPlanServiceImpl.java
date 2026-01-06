package plantcare.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import plantcare.dao.SubscriptionPlanDao;
import plantcare.model.SubscriptionPlan;
import plantcare.service.SubscriptionPlanService;

@Service
public class SubscriptionPlanServiceImpl implements SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanDao planDao;

    @Override
    @Transactional
    public List<SubscriptionPlan> getAllPlans() {
        return planDao.getAllPlans();
    }

    @Override
    @Transactional
    public SubscriptionPlan getPlanById(int id) {
        return planDao.getPlanById(id);
    }

    @Override
    @Transactional
    public void savePlan(SubscriptionPlan plan) {
        planDao.savePlan(plan);
    }

    @Override
    @Transactional
    public void updatePlan(SubscriptionPlan plan) {
        planDao.updatePlan(plan);
    }

    @Override
    @Transactional
    public void deletePlan(int id) {
        planDao.deletePlan(id);
    }
}
