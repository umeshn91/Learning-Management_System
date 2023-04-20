package com.lms.course.service.impl;

import com.lms.course.entity.Course;
import com.lms.course.service.CourseCommandService;
import com.lms.course.service.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseCommandServiceImpl implements CourseCommandService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public String addCourse(Course course) {

        courseRepository.save(course);

        return "Course added successfully.";
    }

    @Override
    public long deleteCourse(String courseName) {

        return courseRepository.deleteByCourseName(courseName);
    }
}
