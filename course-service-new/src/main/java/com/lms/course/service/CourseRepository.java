package com.lms.course.service;

import com.lms.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findByCourseName(String courseName);

    List<Course> findByTechnology(String technology);

    List<Course> findByTechnologyOrDurationBetween(String technology, long durationFrom, long durationTo);

    @Transactional
    long deleteByCourseName(String courseName);



}
