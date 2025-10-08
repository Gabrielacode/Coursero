package com.garbi.coursero.services;

import com.garbi.coursero.dtos.CourseRequestDto;
import com.garbi.coursero.dtos.mapper.CourseMapper;
import com.garbi.coursero.entity.Course;
import com.garbi.coursero.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    //This is the service class that will handle all the course operations
  public Optional<Course> findByCourseId(int courseId) {
      var course = courseRepository.findById(courseId);
      return course;
  }

  public Course addNewCourse (CourseRequestDto course) {
     var courseToAdd = CourseMapper.courseRequestToCourse(course);
      return courseRepository.save(courseToAdd);
  }

  public Page<Course> getPaginatedResultOfCourse(int pageSize , int pageNumber){
     PageRequest pageRequest = PageRequest.of(pageNumber, pageSize) ;
      return courseRepository.findAll(pageRequest) ;
  }

}
