package com.xujia.config;

import com.xujia.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    User createUser(){
        return new User("xu","jia");
    }

}
