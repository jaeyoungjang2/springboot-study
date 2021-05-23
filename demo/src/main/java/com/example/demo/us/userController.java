package com.example.demo.user;

import com.example.demo.user.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userController {
    user userArray = new user(20, "jaeyoung");

    @RequestMapping("/user")
    public String user(Model model) {
        model.addAttribute("user", userArray);
        return "user.html";
    }
}
