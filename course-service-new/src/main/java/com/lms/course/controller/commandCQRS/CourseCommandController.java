package com.lms.course.controller.commandCQRS;

import com.lms.course.entity.Course;
import com.lms.course.service.impl.CourseCommandServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/lms/courses")
//@ConditionalOnProperty(name = "app.write.enabled", havingValue = "true")
public class CourseCommandController {
    private String result;
    private Long records;
    private static final Logger log = LoggerFactory.getLogger(CourseCommandController.class);

    @Autowired
    CourseCommandServiceImpl serviceImpl;

    @PostMapping("/addcourse")
    public String addCource(@Validated @RequestBody Course course){

        log.info("Inside addCourse:",course);

        try {
            result=serviceImpl.addCourse(course);
            log.info("New course successfully added...");
        }
        catch (Exception e){
            log.error("Course not addedd...",e);
        }

        return result;

    }

    @DeleteMapping("/delete{courseName}")
    public String deleteCourse(@PathVariable String courseName){

        log.info("Inside deleteCourse:");

        try{
            records = serviceImpl.deleteCourse(courseName);
            log.debug(""+records+" Records deleted successfully ");
        }
        catch (Exception e){
            log.error("Records not deleted",e);
        }

        return records+" Records deleted successfully";
    }

}
