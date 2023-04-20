package com.lms.course.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CourseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Course}
     *   <li>{@link Course#setCourseName(String)}
     *   <li>{@link Course#setDescription(String)}
     *   <li>{@link Course#setDuration(long)}
     *   <li>{@link Course#setDurationFrom(long)}
     *   <li>{@link Course#setDurationTo(long)}
     *   <li>{@link Course#setId(int)}
     *   <li>{@link Course#setLaunchURL(String)}
     *   <li>{@link Course#setTechnology(String)}
     *   <li>{@link Course#getCourseName()}
     *   <li>{@link Course#getDescription()}
     *   <li>{@link Course#getDuration()}
     *   <li>{@link Course#getDurationFrom()}
     *   <li>{@link Course#getDurationTo()}
     *   <li>{@link Course#getId()}
     *   <li>{@link Course#getLaunchURL()}
     *   <li>{@link Course#getTechnology()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Course actualCourse = new Course();
        actualCourse.setCourseName("Course Name");
        actualCourse.setDescription("The characteristics of someone or something");
        actualCourse.setDuration(1L);
        actualCourse.setDurationFrom(1L);
        actualCourse.setDurationTo(1L);
        actualCourse.setId(1);
        actualCourse.setLaunchURL("https://example.org/example");
        actualCourse.setTechnology("Technology");
        assertEquals("Course Name", actualCourse.getCourseName());
        assertEquals("The characteristics of someone or something", actualCourse.getDescription());
        assertEquals(1L, actualCourse.getDuration());
        assertEquals(1L, actualCourse.getDurationFrom());
        assertEquals(1L, actualCourse.getDurationTo());
        assertEquals(1, actualCourse.getId());
        assertEquals("https://example.org/example", actualCourse.getLaunchURL());
        assertEquals("Technology", actualCourse.getTechnology());
    }
}

