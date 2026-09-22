package com.example.mytest.controller;

import com.example.mytest.entity.Log;
import com.example.mytest.service.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * ClassName: LogController
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/22 18:18
 * @Version 1.0
 */
@RestController
public class LogController {
    @Autowired
    LogServiceImpl logService;

    @GetMapping("/logall")
    public ArrayList<Log> getall(){
        ArrayList<Log> log = logService.getLog();
        return log;
    }

    @GetMapping("/getInfo")
    public ArrayList<Log> b(String s){
        ArrayList<Log> byinfo = logService.getByinfo(s);
        return byinfo;
    }
}
