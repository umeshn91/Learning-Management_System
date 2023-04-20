package com.lms.course.controller.queryCQRS;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.course.entity.Course;
import com.lms.course.service.impl.CourseQueryServiceImpl;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CourseQueryController.class})
@ExtendWith(SpringExtension.class)
class CourseQueryControllerTest {
    @Autowired
    private CourseQueryController courseQueryController;

    @MockBean
    private CourseQueryServiceImpl courseQueryServiceImpl;

    /**
     * Method under test: {@link CourseQueryController#getAllCources()}
     */
    @Test
    void testGetAllCources() throws Exception {
        when(courseQueryServiceImpl.getAllCourses()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1.0/lms/courses/getall");
        MockMvcBuilders.standaloneSetup(courseQueryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CourseQueryController#getAllCources()}
     */
    @Test
    void testGetAllCources2() throws Exception {
        when(courseQueryServiceImpl.getAllCourses()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1.0/lms/courses/getall");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(courseQueryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CourseQueryController#getCourceByTechnology(String)}
     */
    @Test
    void testGetCourceByTechnology() throws Exception {
        when(courseQueryServiceImpl.getCourseByTechnology(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1.0/lms/courses/info/{technology}", "Technology");
        MockMvcBuilders.standaloneSetup(courseQueryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CourseQueryController#getCourceByTechnology(String)}
     */
    @Test
    void testGetCourceByTechnology2() throws Exception {
        when(courseQueryServiceImpl.getCourseByTechnology(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1.0/lms/courses/info/{technology}", "Technology");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(courseQueryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CourseQueryController#getCourseByTechnologyAndDuration(Course)}
     */
    @Test
    void testGetCourseByTechnologyAndDuration() throws Exception {
        when(courseQueryServiceImpl.getCourseByTechnologyOrDuration(Mockito.<Course>any())).thenReturn(new ArrayList<>());

        Course course = new Course();
        course.setCourseName("Course Name");
        course.setDescription("The characteristics of someone or something");
        course.setDuration(1L);
        course.setDurationFrom(1L);
        course.setDurationTo(1L);
        course.setId(1);
        course.setLaunchURL("https://example.org/example");
        course.setTechnology("Technology");
        String content = (new ObjectMapper()).writeValueAsString(course);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1.0/lms/courses/get")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(courseQueryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

