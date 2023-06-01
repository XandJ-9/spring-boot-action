package com.bookcode.controller;


import com.bookcode.JpaApplication;
import com.bookcode.dao.UserRepository;
import com.bookcode.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/all")
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        log.info(users.toString());
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id) {
        Optional<User> user = userRepository.findById((long) id);
        log.info(user.get().toString());
        return user.get();
    }

    @PostMapping("/user/add")
    public User saveUser(String name, String sex){
        User user = new User(name, sex);
        userRepository.save(user);
        log.info("add a user: {}", user);
        return user;
    }

    /**
     * 返回分页查询的结果
     * @param pageNum
     * @param size
     * @return
     */
    @GetMapping("/users/pages")
    public Page<User> selectPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("size") Integer size){

        PageRequest pageRequest = PageRequest.of(pageNum, size);

        Page<User> userPage = userRepository.findAll(pageRequest);

        return userPage;
    }

}
