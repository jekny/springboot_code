package com.hyw.springboot010;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hyw.springboot010.mapper")
public class Springboot010Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot010Application.class, args);
    }

}
