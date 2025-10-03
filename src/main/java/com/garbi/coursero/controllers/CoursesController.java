package com.garbi.coursero.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CoursesController {
    //This page is to view the main courses page

    @GetMapping()
    public String getCourses(ModelMap model) {
        model.addAttribute("content","courses");
        return "base-layout";
    }

    //Then for the individual courses we will pass the course id
    @GetMapping("/{id}")
    public String getIndividualCourse(@PathVariable Long id, ModelMap model) {
        model.addAttribute("content","course-details");
        return "base-layout";
    }
    @GetMapping("/add")
    public String addCourse(ModelMap model){
        model.addAttribute("content","add-courses");
        return "base-layout";
    }
}
