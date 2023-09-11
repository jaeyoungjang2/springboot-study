package com.example.demo.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mainController {
    @RequestMapping(value = "/")
    public String main() {
        return "main.html";
    };

    @RequestMapping("/get")
    @ResponseBody
    public String get() {
        return "Hi";
    }

    @RequestMapping("/valueTest")
    @ResponseBody
    public String valueTest() {
        String value = "테스트 String";
        return value;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("hello", "서버에서 보내준 값입니다.");
        return "/hello.html";
    }

}
