package plantcare.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import plantcare.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public int getTotalServices() {
        List<Long> list = (List<Long>) hibernateTemplate.find("SELECT COUNT(*) FROM PlantService");
        return (list != null && !list.isEmpty()) ? list.get(0).intValue() : 0;
    }

    @Override
    public int getTotalUsers() {
        List<Long> list = (List<Long>) hibernateTemplate.find("SELECT COUNT(*) FROM User");
        return (list != null && !list.isEmpty()) ? list.get(0).intValue() : 0;
    }

    @Override
    public int getTotalAppointments() {
        List<Long> list = (List<Long>) hibernateTemplate.find("SELECT COUNT(*) FROM Appointment");
        return (list != null && !list.isEmpty()) ? list.get(0).intValue() : 0;
    }

    @Override
    public int getTotalSubscriptions() {
        List<Long> list = (List<Long>) hibernateTemplate.find("SELECT COUNT(*) FROM Subscription");
        return (list != null && !list.isEmpty()) ? list.get(0).intValue() : 0;
    }
}
