package com.garbi.coursero.services;

import com.garbi.coursero.dtos.CourseRequestDto;
import com.garbi.coursero.dtos.mapper.CourseMapper;
import com.garbi.coursero.entity.Course;
import com.garbi.coursero.entity.User;
import com.garbi.coursero.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service("courseService")
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    //This is the service class that will handle all the course operations
  public Optional<Course> findByCourseId(int courseId) {
      var course = courseRepository.findById(courseId);
      return course;
  }

  public Course addNewCourse (CourseRequestDto course, User user ) {
     var courseToAdd = CourseMapper.courseRequestToCourse(course);
     courseToAdd.setUser(user);
      return courseRepository.save(courseToAdd);
  }

  public Page<Course> getPaginatedResultOfCourse(int pageSize , int pageNumber){
     PageRequest pageRequest = PageRequest.of(pageNumber, pageSize) ;
      return courseRepository.findAll(pageRequest) ;
  }
  //Before a user can delete or save a course we willneed to check if the user is the owner of the course
  public void deleteCourseById(int id ) {
      courseRepository.deleteById(id);
  }

  public void updateCourse(Course course){
      courseRepository.save(course);
  }
//We want to be able to use this service bean to handle our method security and all that so we will create our custom method to be called
    public  boolean doesUserOwnCourseBasedOnId(Authentication auth, int courseId){

        var course = courseRepository.findById(courseId);
        if (course.isPresent()){
            var courseResult = course.get();
            var user =(User)auth.getPrincipal() ;
              if (Objects.isNull(user) || Objects.isNull(courseResult.getUser())){
                  return false;
              }
            return courseResult.getUser().getId().equals(user.getId());
        }
        else return false;
    }
}
