package plantcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @RequestMapping
    public String payment() {
        return "payment";
    }

    @RequestMapping("/invoice")
    public String invoice() {
        return "invoice";
    }
}
