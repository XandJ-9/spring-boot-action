package com.xujia.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义登录表单信息
        http.authorizeRequests()
                .antMatchers("/admin/api").hasRole("ADMIN")
                .antMatchers("/user/api").hasRole("USER")
                .antMatchers("/app/api").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/myLogin.html")
                // 指定处理登陆成功时的url
                // .loginProcessingUrl("/login")
                // 指定登陆成功时的处理逻辑
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.getWriter().write("login success");
                    }
                })
                // 登陆成功后跳转请求
                // .successForwardUrl("/hello")
                // 请求失败时的处理逻辑
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        e.printStackTrace();
                    }
                })

                // 登陆页面不设限访问
                .permitAll()
                .and()
                .csrf().disable();
    }
}
