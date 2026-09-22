package com.hyw.springboot010.mapper;

import com.hyw.springboot010.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * ClassName: UserMapper
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/22 15:31
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    ArrayList<User> selectAll();
}
