package plantcare.daoImpl;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import plantcare.dao.ServiceDao;
import plantcare.model.PlantService;

@Repository
public class ServiceDaoImpl implements ServiceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(PlantService service) {
        sessionFactory.getCurrentSession().saveOrUpdate(service);
    }

    @Override
    public List<PlantService> getAllServices() {
        CriteriaQuery<PlantService> cq = sessionFactory.getCurrentSession()
                                                       .getCriteriaBuilder()
                                                       .createQuery(PlantService.class);
        cq.from(PlantService.class);
        return sessionFactory.getCurrentSession().createQuery(cq).getResultList();
    }

    @Override
    public PlantService getById(int id) {
        return sessionFactory.getCurrentSession().get(PlantService.class, id);
    }

    @Override
    public void delete(int id) {
        PlantService service = getById(id);
        if (service != null) {
            sessionFactory.getCurrentSession().delete(service);
        }
    }
}
