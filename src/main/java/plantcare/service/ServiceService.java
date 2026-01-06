package plantcare.service;

import java.util.List;
import plantcare.model.PlantService;

public interface ServiceService {
    void addService(PlantService service);
    List<PlantService> getAllServices();
    PlantService getServiceById(int id);
    void deleteService(int id);
}