package com.lms.user.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.lms.user.entity.User;
import com.lms.user.service.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepo userRepo;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#saveUser(User)}
     */
    @Test
    void testSaveUser() {
        User user = new User();
        user.setEmailId("42");
        user.setName("Name");
        user.setPassword("iloveyou");
        when(userRepo.save(Mockito.<User>any())).thenReturn(user);

        User user2 = new User();
        user2.setEmailId("42");
        user2.setName("Name");
        user2.setPassword("iloveyou");
        assertEquals("Name..! User Added successfully.", userServiceImpl.saveUser(user2));
        verify(userRepo).save(Mockito.<User>any());
    }
}

