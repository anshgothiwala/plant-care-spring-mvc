package plantcare.controller;

import java.time.LocalDateTime;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import plantcare.model.Feedback;
import plantcare.model.User;
import plantcare.service.FeedbackService;
import plantcare.service.ServiceService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private ServiceService serviceService;
	
	@Autowired
    private FeedbackService feedbackService;
	
	@Autowired
	private JavaMailSender mailSender;

    @RequestMapping("/userDashboard")
    public String dashboard() {
        return "user/userDashboard";
    }
    
    @RequestMapping("/services")
    public String services(Model model) {
        // fetch all services from DB
        model.addAttribute("services", serviceService.getAllServices());
        return "user/services";  // goes to services.jsp
    }
    
	/*
	 * @RequestMapping("/bookAppointment") public String bookAppointment() { return
	 * "user/bookAppointment"; }
	 */

    @RequestMapping("/profile")
    public String profile() {
        return "user/profile";
    }

    @RequestMapping("/mySubscriptions")
    public String mySubscriptions() {
        return "user/mySubscriptions";
    }

    @RequestMapping("/feedback")
    public String feedback() {
        return "feedback";
    }
    
 // POST: save feedback
    @PostMapping("/feedback/submit")
    public String submitFeedback(@RequestParam("feedback") String comment,
                                 @RequestParam("rating") int rating,
                                 HttpSession session,
                                 Model model) {

        User user = (User) session.getAttribute("loggedUser");
        
        if (user == null) {
            // redirect to login if no user in session
            return "redirect:/auth/login";
        }

        Feedback fb = new Feedback();
        fb.setComment(comment);
        fb.setRating(rating);
        fb.setDate(LocalDateTime.now());
        fb.setUser(user);
        feedbackService.saveFeedback(fb);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo("er.anshu.2026@gmail.com");
            helper.setSubject("🌿 New Feedback Submitted - PlantCare");

            String htmlContent = "<html>"
                    + "<body style='font-family: Arial, sans-serif;'>"
                    + "<h2 style='color: green;'>🌿 New Feedback Received</h2>"
                    + "<p><b>User:</b> " + (user != null ? user.getFullname() : "Guest") + "</p>"
                    + "<p><b>Rating:</b> " + rating + " / 5 ⭐</p>"
                    + "<p><b>Comment:</b><br/>" + comment + "</p>"
                    + "<p style='margin-top:20px; color:gray;'>Submitted on " + LocalDateTime.now() + "</p>"
                    + "</body></html>";

            helper.setText(htmlContent, true); // true = HTML

            mailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("msg", "✅ Thank you! Your feedback has been submitted.");
        return "feedback";
    }
}
