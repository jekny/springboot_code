package com.hyw.springboot_005.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName: order
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/2 9:53
 * @Version 1.0
 */
@Component
@Data
public class order {
    @Value("${name}")
    String name;
    @Value("${age}")
    Integer age;
}
