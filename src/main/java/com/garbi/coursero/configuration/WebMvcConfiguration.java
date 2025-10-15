package com.garbi.coursero.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer  {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //We added this so that spring can serve resources to use when we are authenticated
        registry.addResourceHandler("/images/**").addResourceLocations("file:/home/garbi/IdeaProjects/Coursero/assets/users/");
    }
}
