package com.garbi.coursero.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseRequestDto{
    String courseName;
    //The course description column
    String courseDescription;
    //The instructors name
    //It will be unique as well
    String instructorName;
    //Then the number of hours of the course
    int numberOfHours;
}
