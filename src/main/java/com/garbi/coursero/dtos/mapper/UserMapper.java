package com.garbi.coursero.dtos.mapper;

import com.garbi.coursero.dtos.UserRegisterationDto;
import com.garbi.coursero.entity.User;

public class UserMapper {
   public  static User UserRegistrationDtoToUser(UserRegisterationDto dto){
        var newUser = new User();
        newUser.setEmail(dto.getEmail());
        newUser.setPassword(dto.getPassword());
        newUser.setUsername(dto.getUsername());
        newUser.setRole(dto.getRole());
        return  newUser;
    }
}
