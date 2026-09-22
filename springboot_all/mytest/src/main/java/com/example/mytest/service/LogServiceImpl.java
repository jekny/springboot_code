package com.example.mytest.service;

import com.example.mytest.entity.Log;
import com.example.mytest.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * ClassName: LogServiceImpl
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/22 18:15
 * @Version 1.0
 */
@Service
public class LogServiceImpl implements LogService{
    @Autowired
    LogMapper logMapper;
    @Override
    public ArrayList<Log> getLog() {
        ArrayList<Log> log = logMapper.getLog();
        return log;
    }

    @Override
    public ArrayList<Log> getByinfo(String s) {
        ArrayList<Log> byInfo = logMapper.getByInfo(s);
        return byInfo;
    }
}
