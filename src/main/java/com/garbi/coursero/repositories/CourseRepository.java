package com.garbi.coursero.repositories;

import com.garbi.coursero.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


//This is the course repository
@Repository
public interface  CourseRepository extends JpaRepository<Course,Integer> {
   //We want to search for based on the course name or description
    //We will paginate it
    @Query("SELECT u FROM Course u WHERE lower( u.courseName) LIKE lower(CONCAT('%',:search,'%') ) " +
            "OR lower( u.courseDescription) LIKE lower(CONCAT('%',:search,'%') )")
   public  Page<Course> findCourseByNameAndDescription(@Param("search")String search , Pageable pageRequests);

}
