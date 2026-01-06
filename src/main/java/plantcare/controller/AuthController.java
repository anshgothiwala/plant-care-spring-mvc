package plantcare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import plantcare.model.User;
import plantcare.service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @RequestMapping("/register")
    public String registerPage() {
        return "auth/register";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute User user) {
        // Default role
        user.setRole("USER");
        // save user
        userService.registerUser(user);

        // after successful registration → redirect to login
        return "redirect:/auth/login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               HttpSession session) {

        User user = userService.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) { // simple check; ideally use BCrypt
            // store user info in session
        	session.setAttribute("loggedUser", user);
            session.setAttribute("userName", user.getFullname());
            session.setAttribute("userRole", user.getRole());

            // Redirect based on role
            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                return "redirect:/admin/adminDashboard";
            } else {
                return "redirect:/user/userDashboard";
            }
        } else {
            // login failed
            return "auth/login"; // or add error message
        }
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session
        session.invalidate();
        // Redirect to login page after logout
        return "redirect:/auth/login";
    }
    
}
