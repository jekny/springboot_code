package com.hyw.springboot006.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyConfig
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/3 11:15
 * @Version 1.0
 */
@Component
@Data
public class MyConfig {
    @Value("${spring.my.name}")
    private String name;
    @Value("${spring.my.name2}")
    private String name2;
}
