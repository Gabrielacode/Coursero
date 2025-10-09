package com.garbi.coursero.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

//We will want the user entity to be in charge of all security operations
//It will also implement user details
@Entity()
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter

public class User implements UserDetails {
    //The user will have an id
    @Id
    @GeneratedValue
    Integer id;

    //Then a unique email address
    @Column(unique = true)
    String email;
    //Then a user name which can be inputted or generated
    String username;

    //Then a hashed password
    @Column
    String password;

    //Then the role
    //The default role will be user
    @Column()
    String role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(role).map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
