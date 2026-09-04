package com.hyw.springboot007.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * ClassName: ShuZhuJiHeMap
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/4 10:40
 * @Version 1.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "my.leixing")
public class ShuZhuJiHeMap {
    List<Address> lists;
    Map<String,Address> maps;
    Address[] strings;
}
