package com.bookcode.helloworld.controller;

import com.bookcode.helloworld.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(){
        return "greeting";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"jack", "male"));
        users.add(new User(2,"daisy", "female"));
        users.add(new User(3,"jobs", "male"));
        return users;
    }

}
