package com.lms.course.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.lms.course.entity.Course;
import com.lms.course.service.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CourseCommandServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CourseCommandServiceImplTest {
    @Autowired
    private CourseCommandServiceImpl courseCommandServiceImpl;

    @MockBean
    private CourseRepository courseRepository;

    /**
     * Method under test: {@link CourseCommandServiceImpl#addCourse(Course)}
     */
    @Test
    void testAddCourse() {
        Course course = new Course();
        course.setCourseName("Course Name");
        course.setDescription("The characteristics of someone or something");
        course.setDuration(1L);
        course.setDurationFrom(1L);
        course.setDurationTo(1L);
        course.setId(1);
        course.setLaunchURL("https://example.org/example");
        course.setTechnology("Technology");
        when(courseRepository.save(Mockito.<Course>any())).thenReturn(course);

        Course course2 = new Course();
        course2.setCourseName("Course Name");
        course2.setDescription("The characteristics of someone or something");
        course2.setDuration(1L);
        course2.setDurationFrom(1L);
        course2.setDurationTo(1L);
        course2.setId(1);
        course2.setLaunchURL("https://example.org/example");
        course2.setTechnology("Technology");
        assertEquals("Course added successfully.", courseCommandServiceImpl.addCourse(course2));
        verify(courseRepository).save(Mockito.<Course>any());
    }

    /**
     * Method under test: {@link CourseCommandServiceImpl#deleteCourse(String)}
     */
    @Test
    void testDeleteCourse() {
        when(courseRepository.deleteByCourseName(Mockito.<String>any())).thenReturn(1L);
        assertEquals(1L, courseCommandServiceImpl.deleteCourse("Course Name"));
        verify(courseRepository).deleteByCourseName(Mockito.<String>any());
    }
}

