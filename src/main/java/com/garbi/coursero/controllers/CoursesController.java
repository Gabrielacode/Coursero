package com.garbi.coursero.controllers;

import com.garbi.coursero.dtos.CourseRequestDto;
import com.garbi.coursero.entity.Course;
import com.garbi.coursero.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/courses")
public class CoursesController {
    //This page is to view the main courses page
   private final CourseService courseService;
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
        model.addAttribute("courseRequestDto",new CourseRequestDto());
        return "base-layout";
    }

    @PostMapping("/add-course")
    public String addCourse(@ModelAttribute("courseRequestDto") CourseRequestDto course, ModelMap model){
           //We will add the course to the db and then redirect to the course
        var courseAdded = courseService.addNewCourse(course);
        return "redirect:/courses";
    }
}
