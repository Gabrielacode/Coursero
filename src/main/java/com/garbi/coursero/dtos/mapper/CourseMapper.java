package com.garbi.coursero.dtos.mapper;

//This class will be used to mapper course dtos

import com.garbi.coursero.dtos.CourseRequestDto;
import com.garbi.coursero.entity.Course;

public class CourseMapper {
    public static Course courseRequestToCourse(CourseRequestDto requestDto){
        return new Course(null, requestDto.getCourseName(),requestDto.getCourseDescription(),requestDto.getInstructorName(),requestDto.getNumberOfHours());
    }
}
