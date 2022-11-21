package com.bookcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 */
@EnableScheduling // 启用调度注解
@SpringBootApplication
public class ScheduleDemoApplication {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ConfigurableApplicationContext applicationContext = SpringApplication.run(ScheduleDemoApplication.class, args);
    }
}
