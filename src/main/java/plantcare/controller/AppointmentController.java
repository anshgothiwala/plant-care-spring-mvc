package plantcare.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import plantcare.model.Appointment;
import plantcare.model.PlantService;
import plantcare.model.User;
import plantcare.service.AppointmentService;
import plantcare.service.ServiceService;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
	
	@Autowired
    private ServiceService serviceService;
	
	@Autowired
    private AppointmentService appointmentService;

	@RequestMapping("/bookAppointment")
    public String bookAppointment(@RequestParam("serviceId") int serviceId, Model model) {
        // Fetch service from DB
        PlantService selectedService = serviceService.getServiceById(serviceId);

        // Add service to model
        model.addAttribute("selectedService", selectedService);

        // Also pass serviceId if needed
        model.addAttribute("serviceId", serviceId);

        return "user/bookAppointment"; // goes to bookappointment.jsp
    }
	
	@PostMapping("/saveAppointment")
	public String saveAppointment(
	        @RequestParam("date") String dateStr,
	        @RequestParam("time") String timeStr,
	        @RequestParam("serviceId") int serviceId,
	        HttpSession session) {

	    // ✅ Parse manually
	    LocalDate date = LocalDate.parse(dateStr);              // expects yyyy-MM-dd
	    LocalTime time = LocalTime.parse(timeStr);              // expects HH:mm
	    LocalDateTime dateTime = LocalDateTime.of(date, time);

	    // ✅ Logged-in user
	    User user = (User) session.getAttribute("loggedUser");
	    if (user == null) {
	        return "redirect:/auth/login"; 
	    }

	    // ✅ Selected service
	    PlantService service = serviceService.getServiceById(serviceId);

	    // ✅ Build appointment
	    Appointment appointment = new Appointment();
	    appointment.setDateTime(dateTime);
	    appointment.setUser(user);
	    appointment.setService(service);

	    // ✅ Save appointment
	    appointmentService.saveAppointment(appointment);

	    return "redirect:/appointments/myAppointments";
	}



	@RequestMapping("/myAppointments")
	public String appointments(HttpSession session, Model model) {
	    User user = (User) session.getAttribute("loggedUser");
	    if (user == null) {
	        return "redirect:/auth/login";
	    }

	    List<Appointment> appointments = appointmentService.getAppointmentsByUser(user.getId());
	    model.addAttribute("appointments", appointments);

	    return "appointments";
	}
	
	@PostMapping("/cancel")
	public String cancelAppointment(@RequestParam("id") int appointmentId, HttpSession session) {
	    User user = (User) session.getAttribute("loggedUser");
	    if (user == null) {
	        return "redirect:/auth/login";
	    }

	    // Get the appointment from DB
	    Appointment appointment = appointmentService.getAppointmentById(appointmentId);

	    // Ensure the appointment belongs to the logged-in user (security check)
	    if (appointment != null && appointment.getUser().getId() == user.getId()) {
	        appointmentService.deleteAppointment(appointmentId);
	    }

	    // Redirect back to My Appointments page
	    return "redirect:/appointments/myAppointments";
	}

}
