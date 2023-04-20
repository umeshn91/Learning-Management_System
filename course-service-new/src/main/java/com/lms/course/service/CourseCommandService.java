package com.lms.course.service;

import com.lms.course.entity.Course;

public interface CourseCommandService {

    public String addCourse(Course course);
    public long deleteCourse(String courseName);

}
