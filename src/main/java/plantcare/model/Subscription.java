package plantcare.model;

import java.time.LocalDate;

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
@Table(name = "subscriptions")
public class Subscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subscriptionid;
	
	private LocalDate startDate;
    private LocalDate endDate;
    
    private String status; // ACTIVE, EXPIRED, CANCELLED



    // Subscription belongs to a user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Subscription belongs to a plan
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private SubscriptionPlan plan;

    // One subscription can have one payment
    @OneToOne(mappedBy = "subscription", cascade = CascadeType.ALL)
    private Payment payment;

	public int getSubscriptionid() {
		return subscriptionid;
	}

	public void setSubscriptionid(int subscriptionid) {
		this.subscriptionid = subscriptionid;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SubscriptionPlan getPlan() {
		return plan;
	}

	public void setPlan(SubscriptionPlan plan) {
		this.plan = plan;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
