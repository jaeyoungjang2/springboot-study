package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
