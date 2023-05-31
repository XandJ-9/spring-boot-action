package com.bookcode;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing
public class SpringDataBatchDemo
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        SpringApplication.run(SpringDataBatchDemo.class,args);
    }
}
