package com.lms.course.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.lms.course.entity.Course;
import com.lms.course.service.CourseRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CourseQueryServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CourseQueryServiceImplTest {
    @Autowired
    private CourseQueryServiceImpl courseQueryServiceImpl;

    @MockBean
    private CourseRepository courseRepository;

    /**
     * Method under test: {@link CourseQueryServiceImpl#getCourseByCourseName(String)}
     */
    @Test
    void testGetCourseByCourseName() {
        ArrayList<Course> courseList = new ArrayList<>();
        when(courseRepository.findByCourseName(Mockito.<String>any())).thenReturn(courseList);
        List<Course> actualCourseByCourseName = courseQueryServiceImpl.getCourseByCourseName("Course Name");
        assertSame(courseList, actualCourseByCourseName);
        assertTrue(actualCourseByCourseName.isEmpty());
        verify(courseRepository).findByCourseName(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CourseQueryServiceImpl#getAllCourses()}
     */
    @Test
    void testGetAllCourses() {
        ArrayList<Course> courseList = new ArrayList<>();
        when(courseRepository.findAll()).thenReturn(courseList);
        List<Course> actualAllCourses = courseQueryServiceImpl.getAllCourses();
        assertSame(courseList, actualAllCourses);
        assertTrue(actualAllCourses.isEmpty());
        verify(courseRepository).findAll();
    }

    /**
     * Method under test: {@link CourseQueryServiceImpl#getCourseByTechnology(String)}
     */
    @Test
    void testGetCourseByTechnology() {
        ArrayList<Course> courseList = new ArrayList<>();
        when(courseRepository.findByTechnology(Mockito.<String>any())).thenReturn(courseList);
        List<Course> actualCourseByTechnology = courseQueryServiceImpl.getCourseByTechnology("Technology");
        assertSame(courseList, actualCourseByTechnology);
        assertTrue(actualCourseByTechnology.isEmpty());
        verify(courseRepository).findByTechnology(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CourseQueryServiceImpl#getCourseByTechnologyOrDuration(Course)}
     */
    @Test
    void testGetCourseByTechnologyOrDuration() {
        ArrayList<Course> courseList = new ArrayList<>();
        when(courseRepository.findByTechnologyOrDurationBetween(Mockito.<String>any(), anyLong(), anyLong()))
                .thenReturn(courseList);

        Course course = new Course();
        course.setCourseName("Course Name");
        course.setDescription("The characteristics of someone or something");
        course.setDuration(1L);
        course.setDurationFrom(1L);
        course.setDurationTo(1L);
        course.setId(1);
        course.setLaunchURL("https://example.org/example");
        course.setTechnology("Technology");
        List<Course> actualCourseByTechnologyOrDuration = courseQueryServiceImpl.getCourseByTechnologyOrDuration(course);
        assertSame(courseList, actualCourseByTechnologyOrDuration);
        assertTrue(actualCourseByTechnologyOrDuration.isEmpty());
        verify(courseRepository).findByTechnologyOrDurationBetween(Mockito.<String>any(), anyLong(), anyLong());
    }
}

