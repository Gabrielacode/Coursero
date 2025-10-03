package com.garbi.coursero.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //This class will serve as the controller for the home page


    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("title","Welcome to Cousero");
        model.addAttribute("content","home");
        return "base-layout";
    }
}
