package com.hyw.springboot010.controller;

import com.hyw.springboot010.entity.User;
import com.hyw.springboot010.service.UserService;
import com.hyw.springboot010.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * ClassName: UserController
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/22 15:35
 * @Version 1.0
 */
@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/getall")
    public ArrayList<User> getAllUser(){
        ArrayList<User> all = userService.getAll();
        return all;
    }
}
