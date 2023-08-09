package com.xujia.config;


import com.xujia.realm.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConfig {

    @Bean
    public DefaultWebSecurityManager manager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm);
        return manager;
    }


    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(@Qualifier("manager")DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(manager);

        HashMap<String, String> map = new HashMap<>();
        map.put("/main","authc");
        map.put("/manage","perms[manage]");
        map.put("/administrator","roles[administrator]");

        factoryBean.setFilterChainDefinitionMap(map);
        // 设置登陆页面
        factoryBean.setLoginUrl("/login");
        // 设置未认证的页面
        factoryBean.setUnauthorizedUrl("/unauth");
        return factoryBean;
    }
}
