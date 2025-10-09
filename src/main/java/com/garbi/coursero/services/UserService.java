package com.garbi.coursero.services;

import com.garbi.coursero.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//This will be our user service that is in charge of all things about user
//It will also be our user details service
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;


    //Here the user can enter an email or a username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userResult = userRepository.findUserByUsernameOrEmail(username);
        var user = userResult.orElseThrow(()-> new UsernameNotFoundException("User name or email not found "));
        return  user;
    }
}
