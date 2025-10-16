package com.garbi.coursero.dtos;

import com.garbi.coursero.utils.MultipartIsValid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

//This will be used to register a user and also recieve thier image
@Data

public class UserRegisterationDto
  {
    @NotBlank(message ="User Name must not be blank ")
    String username;
    @NotBlank(message ="User Email  must not be blank ")
    String email;
    @NotBlank(message ="Password must not be blank ")
    String password;
    String role;
    @MultipartIsValid
    MultipartFile imageFile;
}
