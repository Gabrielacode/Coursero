package com.garbi.coursero.services;

import com.garbi.coursero.entity.User;
import com.garbi.coursero.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//This will be our user service that is in charge of all things about user
//It will also be our user details service
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    //Here the user can enter an email or a username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userResult = userRepository.findUserByUsernameOrEmail(username);
        return userResult.orElseThrow(()-> new UsernameNotFoundException("User name or email not found "));
    }

    //We will also  want to register a user so lets
    public void registerUser(User user) {
        //If the user exists  based on the email then a unique constraint exception will be thrown
        //We will need to encode the password when we are saving it
        var password = user.getPassword();
        var encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        //We will also need to append ROLE_
        //to the user so that it can then be recognized as a role by Spring Security
        var role = user.getRole();
        user.setRole("ROLE_"+role);
        userRepository.save(user);
    }
}
