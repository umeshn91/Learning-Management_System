package com.lms.user.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link User}
     *   <li>{@link User#setEmailId(String)}
     *   <li>{@link User#setName(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#getEmailId()}
     *   <li>{@link User#getName()}
     *   <li>{@link User#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setEmailId("42");
        actualUser.setName("Name");
        actualUser.setPassword("iloveyou");
        assertEquals("42", actualUser.getEmailId());
        assertEquals("Name", actualUser.getName());
        assertEquals("iloveyou", actualUser.getPassword());
    }
}

