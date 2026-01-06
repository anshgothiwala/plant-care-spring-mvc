package plantcare.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import plantcare.dao.AppointmentDao;
import plantcare.model.Appointment;
import plantcare.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    @Transactional
    public List<Appointment> getAllAppointments() {
        return appointmentDao.getAllAppointments();
    }

    @Override
    @Transactional
    public Appointment getAppointmentById(int id) {
        return appointmentDao.getAppointmentById(id);
    }
    
    @Override
    @Transactional
    public List<Appointment> getAppointmentsByUser(int userId) {
        return appointmentDao.getAppointmentsByUser(userId);
    }


    @Override
    @Transactional
    public void saveAppointment(Appointment appointment) {
        appointmentDao.saveAppointment(appointment);
    }

    @Override
    @Transactional
    public void updateAppointment(Appointment appointment) {
        appointmentDao.updateAppointment(appointment);
    }

    @Override
    @Transactional
    public void deleteAppointment(int id) {
        appointmentDao.deleteAppointment(id);
    }
}
