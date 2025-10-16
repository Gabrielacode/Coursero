package com.garbi.coursero.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseRequestDto{
    @NotBlank(message ="Course Name must not be blank ")
    String courseName;
    //The course description column
    @NotBlank( message = "Course Description must not be blank ")
    String courseDescription;
    //The instructors name
    //It will be unique as well
    @NotBlank(message ="Instructor Name must not be blank")
    String instructorName;
    //Then the number of hours of the course must be positive
    //We want to add validation
    @Positive(message = "The number of hours must be positive")
    int numberOfHours;
}
