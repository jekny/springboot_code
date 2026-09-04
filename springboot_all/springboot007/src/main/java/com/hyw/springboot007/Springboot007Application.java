package com.hyw.springboot007;

import com.hyw.springboot007.entity.Costomer;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({Costomer.class})
public class Springboot007Application {
    public static void main(String[] args) {
        SpringApplication.run(Springboot007Application.class, args);
    }

}
