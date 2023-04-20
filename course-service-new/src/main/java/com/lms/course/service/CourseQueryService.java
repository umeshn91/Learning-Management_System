package com.lms.course.service;

import com.lms.course.entity.Course;

import java.util.List;

public interface CourseQueryService {


    public List<Course> getCourseByCourseName(String courseName);
    public List<Course> getCourseByTechnology(String technology);
    public List<Course> getAllCourses();
    public List<Course> getCourseByTechnologyOrDuration(Course course);

}
