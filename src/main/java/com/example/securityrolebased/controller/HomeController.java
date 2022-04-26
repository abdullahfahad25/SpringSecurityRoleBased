package com.example.securityrolebased.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class HomeController {

    @GetMapping(path = "/home")
    public String home() {
        System.out.println("In Home");
        return "Welcome Home";
    }
}
