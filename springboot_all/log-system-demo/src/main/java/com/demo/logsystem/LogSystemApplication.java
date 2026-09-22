package com.demo.logsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.logsystem.mapper")
public class LogSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogSystemApplication.class, args);
    }
}
