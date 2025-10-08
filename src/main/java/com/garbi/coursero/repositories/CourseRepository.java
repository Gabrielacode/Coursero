package com.garbi.coursero.repositories;

import com.garbi.coursero.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//This is the course repository
@Repository
public interface  CourseRepository extends JpaRepository<Course,Integer> {

}
