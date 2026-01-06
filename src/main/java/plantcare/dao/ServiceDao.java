package plantcare.dao;

import java.util.List;
import plantcare.model.PlantService;

public interface ServiceDao {
    void save(PlantService service);
    List<PlantService> getAllServices();
    PlantService getById(int id);
    void delete(int id);
}
