package com.xujia.controller;



import com.xujia.scala.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    Animal animal;
    @GetMapping("/test")
    public String tets(){

        animal.run();
        return "running...";
    }

}
