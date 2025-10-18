package com.garbi.coursero.utils;

//Here we will create a custom validator for our multipart file to check if the file is not empty and it is of image type and it can be transfered

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFileValidator implements ConstraintValidator<MultipartIsValid, MultipartFile> {
    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
       //Now lets make our check
        var isFileLessThan100MB = value.getSize()<= 1024L *1024*100;
        var isFileNotEmpty = value.getSize() >=0;
        var isFileImageType = value.getContentType() != null && value.getContentType().startsWith("image");
        //We want to disable the default validators
        context.disableDefaultConstraintViolation();
        if(!isFileLessThan100MB){
            context.buildConstraintViolationWithTemplate("File is more than 100MB").addConstraintViolation();
            return false;
        }
        if(!isFileNotEmpty){
            context.buildConstraintViolationWithTemplate("File is empty").addConstraintViolation();
            return false;
        }
        if(!isFileImageType){
            context.buildConstraintViolationWithTemplate("File is not of type image/").addConstraintViolation();
            return false;
        }
        return true;
    }
}
