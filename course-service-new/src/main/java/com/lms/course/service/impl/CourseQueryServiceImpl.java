package com.lms.course.service.impl;

import com.lms.course.entity.Course;
import com.lms.course.service.CourseQueryService;
import com.lms.course.service.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseQueryServiceImpl implements CourseQueryService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getCourseByCourseName(String courseName) {

        List<Course> courseList = courseRepository.findByCourseName(courseName);

        System.out.println(courseList);
        return courseList;
    }

    @Override
    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }

    @Override
    public List<Course> getCourseByTechnology(String technology) {
        return courseRepository.findByTechnology(technology);
    }

    @Override
    public List<Course> getCourseByTechnologyOrDuration(Course course) {

        return courseRepository.findByTechnologyOrDurationBetween(course.getTechnology(),course.getDurationFrom(),course.getDurationTo());
    }
}

