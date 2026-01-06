package plantcare.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import plantcare.model.SubscriptionPlan;
import plantcare.service.SubscriptionPlanService;

@Controller
@RequestMapping("/admin/plans")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    // ✅ Utility method for session check
    private boolean isAdmin(HttpSession session) {
        String role = (String) session.getAttribute("userRole");
        return role != null && role.equalsIgnoreCase("ADMIN");
    }

    // Add new plan
    @PostMapping("/add")
    public String addPlan(@ModelAttribute SubscriptionPlan plan, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";

        subscriptionPlanService.savePlan(plan);
        return "redirect:/admin/managePlans";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String editPlanForm(@PathVariable("id") int id, Model model, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";

        SubscriptionPlan plan = subscriptionPlanService.getPlanById(id);
        model.addAttribute("plan", plan);
        return "admin/editPlan";
    }

    // Update plan
    @PostMapping("/update")
    public String updatePlan(@ModelAttribute SubscriptionPlan plan, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";

        subscriptionPlanService.updatePlan(plan);
        return "redirect:/admin/managePlans";
    }

    // Delete plan
    @GetMapping("/delete/{id}")
    public String deletePlan(@PathVariable("id") int id, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/auth/login";

        subscriptionPlanService.deletePlan(id);
        return "redirect:/admin/managePlans";
    }
}
