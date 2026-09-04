package com.hyw.springboot007;

import com.hyw.springboot007.entity.Costomer;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot007ApplicationTests {
    @Resource
    Costomer costomer;

    @Test
    void contextLoads() {
        System.out.println(costomer);
    }

}
