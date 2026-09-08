package com.example.springboot009.controller;

import com.example.springboot009.entity.User;
import com.example.springboot009.r.R;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

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
    @Scheduled(cron = "0/3 * * * * ?",timeUnit = TimeUnit.SECONDS)
    public R<User> getuser(){
        User user = new User(123,"namelihua");
        R<User> ok = R.OK("这里是信息",user);
        System.out.println("执行了："+LocalDateTime.now());
        return ok;
    }
}
