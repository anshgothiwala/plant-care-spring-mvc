package plantcare.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import plantcare.model.PlantService;
import plantcare.service.ServiceService;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @RequestMapping("/services")
    public String servicePage() {
        return "user/services"; // JSP page
    }

    @RequestMapping(value = "/addService", method = RequestMethod.POST)
    public String addService(@ModelAttribute PlantService service,
                             @RequestParam(value = "image", required = false) MultipartFile file,
                             HttpSession session) {

        String role = (String) session.getAttribute("userRole");
        if (role == null || !"ADMIN".equalsIgnoreCase(role)) {
            return "redirect:/auth/login";
        }

        // save image and service
        if (file != null && !file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                Path uploadPath = Paths.get("uploads/");
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                file.transferTo(uploadPath.resolve(fileName));
                service.setImagePath(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        serviceService.addService(service);

        // 🔑 Redirect to the correct URL that matches your controller mapping
        return "redirect:/service/list";
    }

    
    @RequestMapping("/list")
    public String listServices(Model model) {
        List<PlantService> allServices = serviceService.getAllServices();
        System.out.println("DEBUG: allServices=" + allServices);
        model.addAttribute("allServices", allServices);
        return "admin/services"; // your JSP
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteServices(@PathVariable int id) {
    	serviceService.deleteService(id);
    	return "redirect:/service/list";
    }





}
