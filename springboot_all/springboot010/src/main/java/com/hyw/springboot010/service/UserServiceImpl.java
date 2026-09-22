package com.hyw.springboot010.service;

import com.hyw.springboot010.entity.User;
import com.hyw.springboot010.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/22 15:34
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users = userMapper.selectAll();
        return users;
    }
}
