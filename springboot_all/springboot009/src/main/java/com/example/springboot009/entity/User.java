package com.example.springboot009.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName: User
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/7 19:04
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class User {
    long id;
    String name;
}
