package com.xujia;

import com.xujia.demo.quickstart.domain.User;
import com.xujia.demo.quickstart.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusApplicationTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        User user = new User();
//        user.setId(6L);
        user.setName("ZhangSan");
        user.setAge(30);
        user.setEmail("zs@163.com");
        int result = userMapper.insert(user);
        System.out.println(result);
    }

}
