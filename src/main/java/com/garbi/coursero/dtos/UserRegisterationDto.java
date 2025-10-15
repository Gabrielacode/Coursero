package com.garbi.coursero.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

//This will be used to register a user and also recieve thier image
@Data

public class UserRegisterationDto
  {
    String username;
    String email;
    String password;
    String role;
    MultipartFile imageFile;
}
