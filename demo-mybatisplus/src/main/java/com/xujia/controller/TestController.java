package com.xujia.controller;

import com.xujia.domain.User;
import com.xujia.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/users")
    public List<User> findAll(){
        return userMapper.selectList(null);
    }


}
