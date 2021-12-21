package com.example.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class TempleController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("courses")
    public String course() {
        return "courses";
    }

    @GetMapping(value = "/")
    public String hello() {
        return "Welcome to security";
    }

    @GetMapping(value = "/pass")
    public String pass() {
        return "Pass demo";
    }
}
