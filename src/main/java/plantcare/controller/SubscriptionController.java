package plantcare.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import plantcare.model.Subscription;
import plantcare.model.SubscriptionPlan;
import plantcare.model.User;
import plantcare.service.SubscriptionPlanService;
import plantcare.service.SubscriptionService;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionPlanService subscriptionPlanService;
	
	@Autowired
    private SubscriptionService subscriptionService;


	@RequestMapping("/subscriptionPlans")
	public String subscriptionPlans(Model model) {
	    // Fetch all plans from DB
	    List<SubscriptionPlan> plans = subscriptionPlanService.getAllPlans();
	    
	    // Add to model
	    model.addAttribute("plans", plans);
	    
	    return "subscriptionPlans";
	}
	
	// Subscribe to a plan
    @PostMapping("/subscribe")
    public String subscribePlan(@RequestParam("planId") int planId, HttpSession session) {
        // Get logged-in user from session
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/auth/login"; // user not logged in
        }

        // Get the subscription plan
        SubscriptionPlan plan = subscriptionPlanService.getPlanById(planId);
        if (plan == null) {
            return "redirect:/subscriptions/plans"; // invalid plan
        }

        // Create subscription
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setPlan(plan);
        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(LocalDate.now().plusDays(plan.getDurationInDays()));
        subscription.setStatus("ACTIVE");

        // Save subscription
        subscriptionService.saveSubscription(subscription);

        // Redirect to user's subscriptions or confirmation page
        return "redirect:/subscription/mySubscriptions";
    }
    
    @RequestMapping("/mySubscriptions")
    public String mySubscriptions(HttpSession session, Model model) {
        // Get logged-in user
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/auth/login";
        }

        // Fetch subscriptions for this user
        List<Subscription> subscriptions = subscriptionService.getSubscriptionsByUser(user.getId());

        // Add to model
        model.addAttribute("subscriptions", subscriptions);

        return "/user/mySubscriptions"; // JSP page name
    }


}
