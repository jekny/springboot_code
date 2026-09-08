package com.example.springboot009;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Springboot009Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot009Application.class, args);
    }

}
