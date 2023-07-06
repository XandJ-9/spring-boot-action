package com.xujia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MyBatis-plus使用简单样例
 *
 */
@SpringBootApplication
@MapperScan("com.xujia")
public class MyBatisPlusApplication
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(MyBatisPlusApplication.class, args);
    }
}
