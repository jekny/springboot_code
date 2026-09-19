package com.example.kaoshi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName: StudentScore
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/19 15:02
 * @Version 1.0
 */
@Data
@TableName("student_score")
public class StudentScore {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String studentNo;
    private String studentName;
    private String courseName;
    private BigDecimal score;
    private String className;
    private String semester;
}
