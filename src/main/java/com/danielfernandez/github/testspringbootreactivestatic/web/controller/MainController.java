package com.danielfernandez.github.testspringbootreactivestatic.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @RequestMapping("/")
    public String main() {
        return "Call '/images/logo.png' to check resolution of static resources";
    }

}
