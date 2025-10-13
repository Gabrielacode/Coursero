package com.garbi.coursero.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, ModelMap model) {
        Object status = request.getAttribute("jakarta.servlet.error.status_code");
        Object message = request.getAttribute("jakarta.servlet.error.message");
        Object error = request.getAttribute("jakarta.servlet.error.exception");

        model.addAttribute("status", status != null ? status : 500);
        model.addAttribute("error", "Something went wrong");
        model.addAttribute("message", message != null ? message : "Unexpected error occurred");
        model.addAttribute("content", "error");
        model.addAttribute("title", "Error");

        return "base-layout";
    }
}
