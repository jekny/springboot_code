package com.example.kaoshi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.kaoshi.mapper")
public class KaoShiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaoShiApplication.class, args);
    }

}
