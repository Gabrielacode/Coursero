package com.garbi.coursero.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

//This controller is in charge of all the auth operations
@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(ModelMap model) {
        model.addAttribute("content","login");
        return "base-layout";
    }
}
