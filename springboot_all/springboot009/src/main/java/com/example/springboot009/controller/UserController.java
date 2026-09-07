package com.example.springboot009.controller;

import com.example.springboot009.entity.User;
import com.example.springboot009.r.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/7 19:05
 * @Version 1.0
 */
@RestController
public class UserController {
    @GetMapping("/detail")
    public R<User> getuser(){
        User user = new User(123,"namelihua");
        R<User> ok = R.OK("这里是信息",user);
        return ok;
    }
}
