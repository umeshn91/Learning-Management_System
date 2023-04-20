package com.lms.user.controller;

import com.lms.user.entity.User;
import com.lms.user.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/lms/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserServiceImpl userService;
    String result;

    @PostMapping("/register")
    public String addUser(@Valid @RequestBody User user){

        log.info("Inside addUSer:");

        result = userService.saveUser(user);

        log.info(result);

     return result;

    }

    @GetMapping("/test")
    public String testService(){

        return "Working..!";

    }

}
