package com.hyw.springboot010.service;

import com.hyw.springboot010.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * ClassName: UserService
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/22 15:34
 * @Version 1.0
 */

public interface UserService {
    ArrayList<User> getAll();
}
