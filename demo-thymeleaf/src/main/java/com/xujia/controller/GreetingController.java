package com.xujia.controller;


import com.xujia.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller   // 返回的默认结果为视图对象
public class GreetingController {

    @GetMapping("/greeting")
    @ResponseBody   // 返回字符串为响应内容
    public String greeting(){
        System.out.println("greeting....");
        return "greeting...";
    }

    @GetMapping("/hi")
    public String hi(@RequestParam(name="name", required = false, defaultValue = "world") String name,  // 从请求参数中获取变量信息， 例如: /hi?name=haha
                     Model model){
        model.addAttribute("name", name);
        return "hi";
    }

    @GetMapping(value = "/users/{userid}/{username}")
    public String user(@PathVariable int userid, @PathVariable  String username, Model model){  // 从请求的url路径中获得变量信息 例如： /users/1     == > userid = 1
        User user = new User();
        user.setUserId(userid);
        user.setUserName(username);
        model.addAttribute(user);

        return "users";
    }
}
