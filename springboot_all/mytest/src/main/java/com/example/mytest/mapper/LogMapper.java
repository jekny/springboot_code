package com.example.mytest.mapper;

import com.example.mytest.entity.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * ClassName: LogMapper
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/22 18:11
 * @Version 1.0
 */
@Mapper
public interface LogMapper {
    ArrayList<Log> getLog();
    ArrayList<Log> getByInfo(String s);
}
