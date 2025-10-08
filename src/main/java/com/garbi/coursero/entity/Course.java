package com.garbi.coursero.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//This is the Course entity that is responsible for handling all the course responsibilities
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    Integer id;

    //The title column
    //The course name will be unique

    @Column(unique = true)
    String courseName;
    //The course description column
    String courseDescription;
    //The instructors name
    //It will be unique as well
    @Column(unique = true)
    String instructorName;

    //Then the number of hours of the course

    int numberOfHours;


}
