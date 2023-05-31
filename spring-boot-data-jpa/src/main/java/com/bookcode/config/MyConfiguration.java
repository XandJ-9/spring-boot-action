package com.bookcode.config;

import com.bookcode.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    User createUser(){
        return new User("xu","jia");
    }

}
