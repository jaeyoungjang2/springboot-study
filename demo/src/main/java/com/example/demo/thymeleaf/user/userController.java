package com.example.demo.thymeleaf.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class userController {
    user[] userArray = { new user(20, "jaeyoung"), new user(30, "jangheon"), new user(40, "chihoon") };
    // user userArray = new user(20, "jaeyoung");

    @RequestMapping("/user")
    public String user(Model model) {
        model.addAttribute("user", userArray);
        return "user.html";
    }
}
