package com.otu.FlightBookingApp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.otu.FlightBookingApp.model.User;

@Controller
public class FlightBookingAppController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User("John")); // Add a user object to the model
        model.addAttribute("user2", new User("Billy")); // Add a user object to the model
        return "index";
    }
}
