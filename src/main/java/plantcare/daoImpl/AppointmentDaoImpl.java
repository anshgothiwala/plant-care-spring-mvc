package plantcare.daoImpl;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import plantcare.dao.AppointmentDao;
import plantcare.model.Appointment;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Appointment> getAllAppointments() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Appointment");
        return query.getResultList();
    }

    @Override
    public Appointment getAppointmentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Appointment.class, id);
    }
    
    @Override
    public List<Appointment> getAppointmentsByUser(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(
            "FROM Appointment a WHERE a.user.id = :userId ORDER BY a.dateTime DESC"
        );
        query.setParameter("userId", userId);
        return query.getResultList();
    }


    @Override
    public void saveAppointment(Appointment appointment) {
        sessionFactory.getCurrentSession().save(appointment);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        sessionFactory.getCurrentSession().update(appointment);
    }

    @Override
    public void deleteAppointment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Appointment appointment = session.get(Appointment.class, id);
        if (appointment != null) session.delete(appointment);
    }
}
