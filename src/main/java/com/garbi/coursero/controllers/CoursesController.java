package com.garbi.coursero.controllers;

import com.garbi.coursero.dtos.CourseRequestDto;
import com.garbi.coursero.dtos.mapper.CourseMapper;
import com.garbi.coursero.entity.Course;
import com.garbi.coursero.entity.User;
import com.garbi.coursero.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/courses")
public class CoursesController {
    //This page is to view the main courses page
   private final CourseService courseService;
    @GetMapping()
    public String getCourses(
            @RequestParam(name = "num",defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "size",defaultValue = "10") Integer pageSize,
            @RequestParam(name="sort",defaultValue = "courseName:asc") Sort sort,
            ModelMap model) {
      var result =   courseService.getPaginatedResultOfCourse(pageSize,pageNumber,sort);
        System.out.println(result.getSort());
      model.addAttribute("result",result);
        model.addAttribute("content","courses");
        return "base-layout";
    }

    //Then for the individual courses we will pass the course id
    @GetMapping("/{id}")
        public String getIndividualCourse(@PathVariable int id, ModelMap model) {
       var courseResult = courseService.findByCourseId(id);
       //We pass the optional directly to the model
        model.addAttribute("result",courseResult);
        model.addAttribute("content","course-details");
       return "base-layout";
    }
    @GetMapping("/add")
    public String addCourse(ModelMap model){
        model.addAttribute("content","add-courses");
        model.addAttribute("courseRequestDto",new CourseRequestDto());
        return "base-layout";
    }
    @GetMapping("/update/{id}")
    public String updateCourse(ModelMap model ,@PathVariable Integer id){
        var course = courseService.findByCourseId(id);
        model.addAttribute("course",course.orElse(new Course()));
        model.addAttribute("content","update-courses");
        return "base-layout";
    }

    @PostMapping("/add-course")
    public String addCourse( @Valid @ModelAttribute("courseRequestDto") CourseRequestDto course, BindingResult results , Authentication authentication,  ModelMap model){
           //We will add the course to the db and then redirect to the course
        //Now we need to link the course to a user when we are creating a new  course
        if(results.hasErrors()){
            model.addAttribute("content","add-courses");
            model.addAttribute("courseRequestDto",new CourseRequestDto());
            // Extract all validation messages into a list
            List<String> errorMessages = results.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();

            model.addAttribute("errorMessages", errorMessages);
            model.addAttribute("showErrorPopup", true);
            return "base-layout";
        }
        var user = (User) authentication.getPrincipal();
        var courseAdded = courseService.addNewCourse(course,user);
        return "redirect:/courses";
    }

    @PreAuthorize("@courseService.doesUserOwnCourseBasedOnId(authentication,#course.id)")
    @PostMapping("/update-course")
    public String updateCourse(@ModelAttribute("course") Course course, Authentication authentication, ModelMap model){
        //We added method security to chaeck whether the owner of the course is the authenticated user trying to access this course
        var user = (User)authentication.getPrincipal();
        course.setUser(user);
        courseService.updateCourse(course);
        return "redirect:/courses";
    }
    //We will do the same for deleting
    //But we want to use a custom bean for the authorization
    @PreAuthorize("@courseService.doesUserOwnCourseBasedOnId(authentication,#id)")
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id){
        //We added method security to chaeck whether the owner of the course is the authenticated user trying to access this course
        courseService.deleteCourseById(id);
        return "redirect:/courses";
    }

}
