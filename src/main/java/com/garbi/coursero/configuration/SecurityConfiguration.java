package com.garbi.coursero.configuration;

import com.garbi.coursero.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

//This is for the security configuration of our application
@EnableWebSecurity
public class SecurityConfiguration  {

    //First we going to lock all the endpoints

    //First lets define our userDetails service

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return  userService;
    }

    //Then our password encoder
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //For our authentication manager
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder){
        //First our authentication provider
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        ProviderManager manager = new ProviderManager(provider);
        return manager;
    }

    //Then our filter chain
    @Bean
    public SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {
                 return http.
                         authorizeHttpRequests((authentication)->{
                            //We are going to allow all access to the login and register urls and the css url
                            authentication.requestMatchers("/login","/register","/styles.css").permitAll()
                                    .anyRequest().authenticated();
                         }).
                         //first we will allow session management
                        sessionManagement((sessionManagementConfigurer)->{
                            sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
                         }).
                         //Then crsf
                         csrf(Customizer.withDefaults()).
                         //Then our form login
                        formLogin(formLoginSettings ->{
                            formLoginSettings.loginPage("/login")
                                    .usernameParameter("usernameOrEmail")
                                    .passwordParameter("password")
                                    .defaultSuccessUrl("/");
                         }).build();

    }
}
