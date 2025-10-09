package com.garbi.coursero.repositories;

import com.garbi.coursero.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//This repository will be used to access the user details
public interface UserRepository extends JpaRepository<User, Integer> {
    //We will just write  a custom query
    @Query("SELECT u FROM User u where u.email = :details OR u.username =:details")
    public Optional<User> findUserByUsernameOrEmail(String details);

}
