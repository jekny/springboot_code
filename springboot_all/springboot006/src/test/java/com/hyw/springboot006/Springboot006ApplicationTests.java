package com.hyw.springboot006;

import com.hyw.springboot006.entity.MyConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot006ApplicationTests {

    @Autowired
    private MyConfig myConfig;
    @Test
    void contextLoads() {
        System.out.println(myConfig.toString());
    }

}
