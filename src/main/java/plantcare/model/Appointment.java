package plantcare.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentid;
	
	private LocalDateTime dateTime;

    // Appointment belongs to a user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Appointment belongs to a service
    @ManyToOne
    @JoinColumn(name = "service_id")
    private PlantService service;

    // One appointment can have one payment
    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Payment payment;

    // One appointment can have one feedback
    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Feedback feedback;

	public int getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PlantService getService() {
		return service;
	}

	public void setService(PlantService service) {
		this.service = service;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	
}
