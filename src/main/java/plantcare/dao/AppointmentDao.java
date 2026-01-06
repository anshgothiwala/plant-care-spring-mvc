package plantcare.dao;

import java.util.List;
import plantcare.model.Appointment;

public interface AppointmentDao {
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(int id);
    List<Appointment> getAppointmentsByUser(int userId);
    void saveAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(int id);
}
