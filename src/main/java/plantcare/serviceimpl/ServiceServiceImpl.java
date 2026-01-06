package plantcare.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import plantcare.dao.ServiceDao;
import plantcare.model.PlantService;
import plantcare.service.ServiceService;

@Service
@Transactional
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceDao serviceDao;

    @Override
    public void addService(PlantService service) {
        serviceDao.save(service);
    }

    @Override
    public List<PlantService> getAllServices() {
        return serviceDao.getAllServices();
    }

    @Override
    public PlantService getServiceById(int id) {
        return serviceDao.getById(id);
    }

    @Override
    public void deleteService(int id) {
        serviceDao.delete(id);
    }
}
