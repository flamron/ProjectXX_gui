package by.pvt.controller;

import by.pvt.pojo.AppUser;
import by.pvt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    UserService userService;

    @GetMapping
    public String showRegistrationForm(Model model) {
       return "registration";
    }

    @PostMapping
    public String registerForm(
            @ModelAttribute AppUser appUser,
            BindingResult bindingResult) {
        if (userService.saveUser(appUser)) {
            return "redirect:/login";
        } else {
            return "error";
        }
    }
}
