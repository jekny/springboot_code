package com.hyw.springboot008;

import com.hyw.springboot008.service.VipServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan({"com.hyw.springboot008.mapper"})
public class Springboot008Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot008Application.class, args);
        VipServiceImpl vip = run.getBean(VipServiceImpl.class);
        vip.getall();
    }

}
