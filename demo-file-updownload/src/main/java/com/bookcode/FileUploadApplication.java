package com.bookcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * Hello world!
 *
 */
@SpringBootApplication   // SpringBooApplication 还包含了Configuration 注解配置类的作用
public class FileUploadApplication
{

    // 也可以在application.properties文件中配置
    // spring.servlet.multipart.max-file=128KB
    // spring.servlet.multipart.max-request-size=256KB
//    @Bean
//    public MultipartConfigElement multipartConfigElement(){
//        MultipartConfigFactory configFactory = new MultipartConfigFactory();
//        // 设置文件上传最大限制，超过设置的大小，则页面会抛出异常信息，需要单独进行异常信息的处理
//        configFactory.setMaxFileSize(DataSize.ofKilobytes(128));
//
//        // 设置上传数据的总大小
//        configFactory.setMaxRequestSize(DataSize.ofKilobytes(256));
//
//        return configFactory.createMultipartConfig();
//    }

    public static void main( String[] args )
    {
        SpringApplication.run(FileUploadApplication.class, args);
    }
}
