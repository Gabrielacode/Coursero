package com.garbi.coursero.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {
    //We want to add the authentication before each method

    @ModelAttribute("auth")
    public Authentication addAuthBeforeEach (Authentication authentication)
    {
        return  authentication;
    }
}
