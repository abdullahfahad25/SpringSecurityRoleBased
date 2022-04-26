package com.example.securityrolebased.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class SearchController {

    @GetMapping(path = "/search")
    public String search() {
        System.out.println("In Search");
        return "This is Search";
    }
}
