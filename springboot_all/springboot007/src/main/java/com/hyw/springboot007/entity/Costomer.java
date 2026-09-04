package com.hyw.springboot007.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * ClassName: Costomer
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/4 10:02
 * @Version 1.0
 */
@Configuration(proxyBeanMethods = false)
@Data
@ConfigurationProperties
public class Costomer {
    String costomerName;
    String age;
    Address address;
}
