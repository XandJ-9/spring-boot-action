package com.xujia.controller;

import com.xujia.domain.User;
import com.xujia.utils.JWTUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {

    @GetMapping("/login")
    @ResponseBody
    public Map<String, Object> login(User user){

        // 可以从数据库查询获得
        String username = "admin";
        String password = "123654";

        Map<String,Object> map = new HashMap<>();
        if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
            // 用户存在，则创建本次登陆的token
            //controller层接收数据，生成token，并响应

            try{
                Map<String,String> payload = new HashMap<>();
                payload.put("username",user.getUsername());
                payload.put("password",user.getPassword());
                //生成JWT令牌
                String token = JWTUtil.getToken(payload);
                map.put("state",true);
                map.put("msg","认证成功");
                map.put("token",token);//响应token
            } catch (Exception e) {
                map.put("state","false");
                map.put("msg",e.getMessage());
            }

        }

        return map;
    }

}
