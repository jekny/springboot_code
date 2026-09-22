package com.example.mytest.service;

import com.example.mytest.entity.Log;
import com.example.mytest.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * ClassName: LogService
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/22 18:13
 * @Version 1.0
 */
public interface LogService {
    ArrayList<Log> getLog();
    ArrayList<Log> getByinfo(String s);

}
