package com.garbi.coursero.controllers;

import com.garbi.coursero.entity.User;
import com.garbi.coursero.services.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//This controller is in charge of all the auth operations
@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    @GetMapping("/login")
    public String login(ModelMap model) {
        model.addAttribute("content","login");
        return "base-layout";
    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("content","register");
        model.addAttribute("user", new User());
        return "base-layout";
    }
    //Then the Post Mapping for Register
    //We will just save the user to the db
    @PostMapping("/register")
    public String processRegisteration(@ModelAttribute("user")User user, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        //If there are any errors  when trying to save the user like UniqueCO
        try {
            userService.registerUser(user);
        }catch (DataIntegrityViolationException e){
            //If there is an error due to the email not being unique
            //we will redirect back to the register page with the flash atrributes
           redirectAttributes.addFlashAttribute("error","Email is already taken ");
           return  "redirect:/register";
        }
        catch (DataAccessException exception){
            //If there is an error due to the email not being unique
            //we will redirect back to the register page with the flash atrributes
            redirectAttributes.addFlashAttribute("error",exception.getMessage());
            return  "redirect:/register";
        }
        //If the user is successful registered we will go te login page
        return "redirect:/login";
    }
}
