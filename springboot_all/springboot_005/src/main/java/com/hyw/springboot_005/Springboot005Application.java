package com.hyw.springboot_005;

import com.hyw.springboot_005.entity.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot005Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot005Application.class, args);
        order bean = run.getBean(order.class);
        String string1 = bean.toString();
        System.out.println(string1);
    }

}
