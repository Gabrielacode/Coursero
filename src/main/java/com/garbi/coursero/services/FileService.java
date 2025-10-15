package com.garbi.coursero.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

//This service class will be in charge of handling all file uploads and downloads from the user
@Service
public class FileService {
    //We will define a constant for the folder for users and courses
    private final String BASE_FILE_PATH = "/home/garbi/IdeaProjects/Coursero/assets";
    private final String USER_FILE_PATH = "users";
    private final String COURSES_FILE_PATH = "courses";



    //When we are storing users profile images we will sanitize the email address so that when the fiel is being viewed the image address is not used or we use a uuid to do that

    public String saveUserProfileImage(MultipartFile file)throws java.io.IOException,IllegalArgumentException {
      // We will need to define the path the image will be stored and then create adirectory for that
//First we will need to get the extension type
        var filenameResult = Optional.ofNullable(file.getOriginalFilename());
        var fileName = filenameResult.orElseThrow(IllegalArgumentException::new);
        var extensionLocation = fileName.lastIndexOf('.');
        var extension = fileName.substring(extensionLocation);
        //This will be the path to be stored
        var storedPath =  UUID.randomUUID().toString()+extension;
        var userPath = Path.of("/"+BASE_FILE_PATH,USER_FILE_PATH, storedPath);
        //We will need to create a directory for them in the file if they dont exist
        System.out.println(userPath.toString());
        if(Files.notExists(Paths.get(userPath.toString()))){
            Files.createDirectories(Paths.get(userPath.toString()));
        }
       //Then we transfer the data to the file path
        file.transferTo(userPath.toFile());
        System.out.println(userPath.toString());
        return storedPath;
    }

}
