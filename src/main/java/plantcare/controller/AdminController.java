package plantcare.controller;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import plantcare.model.Appointment;
import plantcare.model.Subscription;
import plantcare.model.User;
import plantcare.service.AppointmentService;
import plantcare.service.DashboardService;
import plantcare.service.FeedbackService;
import plantcare.service.ServiceService;
import plantcare.service.SubscriptionPlanService;
import plantcare.service.SubscriptionService;
import plantcare.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private ServiceService serviceService;
	
	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private AppointmentService appointmentService;
	
	@Autowired
    private SubscriptionService subscriptionService;
	
	@Autowired
	private SubscriptionPlanService subscriptionPlanService;
	
	@Autowired
	private FeedbackService feedbackService;

    // ✅ Utility method to check session & role
    private boolean isAdmin(HttpSession session) {
        String role = (String) session.getAttribute("userRole");
        return role != null && role.equalsIgnoreCase("ADMIN");
    }

    @RequestMapping("/adminDashboard")
    public String dashboard(Model model, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";

        model.addAttribute("totalServices", dashboardService.getTotalServices());
        model.addAttribute("totalUsers", dashboardService.getTotalUsers());
        model.addAttribute("totalAppointments", dashboardService.getTotalAppointments());
        model.addAttribute("totalSubscriptions", dashboardService.getTotalSubscriptions());
        
        return "admin/adminDashboard";
    }

    @RequestMapping("/users")
    public String users(Model model, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "admin/users";
    }

    @RequestMapping("/services")
    public String services(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";
        return "admin/services";
    }

    @RequestMapping("/appointments")
    public String appointments(Model model, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";

        List<Appointment> allAppointments = appointmentService.getAllAppointments();
        model.addAttribute("appointments", allAppointments);
        return "admin/appointments";
    }

    @RequestMapping("/subscriptions")
    public String subscriptions(Model model, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";

        List<Subscription> allSubscriptions = subscriptionService.getAllSubscriptions();
        model.addAttribute("subscriptions", allSubscriptions);
        model.addAttribute("now", LocalDate.now());
        return "admin/subscriptions";
    }
    
    @RequestMapping("/addService")
    public String addService(HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";
        return "admin/addService";
    }

    @RequestMapping("/managePlans")
    public String managePlans(Model model, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";

        model.addAttribute("plans", subscriptionPlanService.getAllPlans());
        return "admin/managePlans";
    }
    
    

    @RequestMapping("/viewFeedback")
    public String viewFeedback(Model model, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";

        model.addAttribute("feedbackList", feedbackService.getAllFeedbacks());
        return "admin/viewFeedback";
    }
    
    @RequestMapping("appointment/delete/{id}")
    public String deleteAppointments(@PathVariable int id)
    {
    	appointmentService.deleteAppointment(id);
    	return "redirect:/admin/appointments";
    }
}
