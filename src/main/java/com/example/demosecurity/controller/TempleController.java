package com.example.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TempleController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("courses")
    public String course() {
        return "courses";
    }
}
