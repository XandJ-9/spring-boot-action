package com.bookcode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class DemoController {

    @GetMapping("hello")
    public String  hello(){
        return "hello";
    }

}
