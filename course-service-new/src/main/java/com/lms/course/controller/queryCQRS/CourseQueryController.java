package com.lms.course.controller.queryCQRS;

import com.lms.course.entity.Course;
import com.lms.course.service.impl.CourseQueryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1.0/lms/courses")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class CourseQueryController {

    private static final Logger log = LoggerFactory.getLogger(CourseQueryController.class);
    public List<Course> courses;
    @Autowired
    CourseQueryServiceImpl courseService;

    @GetMapping("/info/{technology}")
    public List<Course> getCourceByTechnology(@PathVariable String technology){

        return courseService.getCourseByTechnology(technology);
    }

    @PostMapping("/get")
    public List<Course> getCourseByTechnologyAndDuration(@RequestBody Course course){

        return courseService.getCourseByTechnologyOrDuration(course);
    }



    @GetMapping("/getall")
    public List<Course> getAllCources(){

    log.info("Inside getAllCourses");

    try{

        courses = courseService.getAllCourses();
        log.info("List of courses: { }",courses);
    }catch (Exception e){
        log.debug("Exception while getting all courses e { }",e);
    }

        return courses;
    }
}
