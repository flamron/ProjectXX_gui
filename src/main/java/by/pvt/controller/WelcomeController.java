package by.pvt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcome(Model model, Principal principal) {
        String name;
        if (principal == null) name = "anonymous";
        else name = principal.getName();
            model.addAttribute("username", name);
        return "welcome";
    }
}
