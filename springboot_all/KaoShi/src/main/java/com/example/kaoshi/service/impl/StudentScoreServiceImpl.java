package com.example.kaoshi.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.kaoshi.entity.StudentScore;
import com.example.kaoshi.mapper.StudentScoreMapper;
import com.example.kaoshi.service.StudentScoreService;
import org.springframework.stereotype.Service;

/**
 * ClassName: StudentScoreServiceImpl
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/19 15:10
 * @Version 1.0
 */
@Service
public class StudentScoreServiceImpl extends ServiceImpl<StudentScoreMapper, StudentScore> implements StudentScoreService {
}
