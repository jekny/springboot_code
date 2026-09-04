package com.hyw.springboot007.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * ClassName: Address
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/4 10:02
 * @Version 1.0
 */
@Configuration
@Data
public class Address {
    String a;
    String b;
}
