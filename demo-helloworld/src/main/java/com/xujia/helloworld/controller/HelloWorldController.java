package com.xujia.helloworld.controller;

import com.xujia.helloworld.properties.MysqlProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!!!";
    }

//    @Autowired
    @Resource
    MysqlProperties mysqlProperties;

    @RequestMapping("/showJdbc")
    public String showJdbc(){
        return mysqlProperties.toString();
    }

}
