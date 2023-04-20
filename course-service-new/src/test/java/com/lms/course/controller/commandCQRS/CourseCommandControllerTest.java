package com.lms.course.controller.commandCQRS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.course.entity.Course;
import com.lms.course.service.impl.CourseCommandServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CourseCommandController.class})
@ExtendWith(SpringExtension.class)
class CourseCommandControllerTest {
    @Autowired
    private CourseCommandController courseCommandController;

    @MockBean
    private CourseCommandServiceImpl courseCommandServiceImpl;

    /**
     * Method under test: {@link CourseCommandController#addCource(Course)}
     */
    @Test
    void testAddCource() throws Exception {
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1.0/lms/courses/addcourse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(courseCommandController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

}

