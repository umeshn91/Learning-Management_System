package com.lms.user.service.impl;

import com.lms.user.entity.User;
import com.lms.user.service.UserRepo;
import com.lms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public String saveUser(User user) {

        User user1 = userRepo.save(user);

        return user1.getName()+"..! User Added successfully.";
    }
}
