package com.garbi.coursero.dtos.mapper;

//This class will be used to mapper course dtos

import com.garbi.coursero.dtos.CourseRequestDto;
import com.garbi.coursero.entity.Course;

public class CourseMapper {
    public static Course courseRequestToCourse(CourseRequestDto requestDto){

        //Here we will use the Lombok Builder to build the course specifying the things we need
       var course  =  Course.builder()
                .courseDescription(requestDto.getCourseDescription())
               .courseName(requestDto.getCourseName())
               .numberOfHours(requestDto.getNumberOfHours())
               .instructorName(requestDto.getInstructorName())
               .build();

        return course;
    }
}
