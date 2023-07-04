package com.xujia.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

@Configuration
public class UserRoleConfig {


    /**
     * spring security会自动发现实现了UserDetailsService接口的对象
     * @return
     */
    @Bean
    public UserDetailsService getUserDetailsService(){
        // 基于内存的多用户信息
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        // 创建用户
        userDetailsManager.createUser(User.withDefaultPasswordEncoder().username("user").password("123").roles("USER").build());
        userDetailsManager.createUser(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("USER","ADMIN").build());
        return userDetailsManager;
    }


//    @Bean
//    @Autowired
//    public UserDetailsService jdbcUserDetailsService(DataSource dataSource){
//        // 基于内存的多用户信息
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//            // 创建用户
//            userDetailsManager.createUser(User.withUsername("user").password("123").roles("USER").build());
//            userDetailsManager.createUser(User.withUsername("admin").password("admin").roles("USER", "ADMIN").build());
//        return userDetailsManager;
//    }


}
