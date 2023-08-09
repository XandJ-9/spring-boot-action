package com.xujia;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.xujia.mapper")
public class SpringbootShiroApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringbootShiroApplication.class, args);
    }
}
