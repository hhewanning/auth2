package com.hewanning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName WebSecurityConfig
 * @Author hewanning
 * @Date 2019/4/27 14:03
 * @Description TODO https://blog.csdn.net/qq_27828675/article/details/82466599
 *
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @Author hewanning
     * @Description -   配置用户签名服务 主要是user-details 机制,设置用户权限方式-重写这个方法
     * @Date 14:04 2019/4/27
     * @Param auth 签名管理器构造器，用于构建用户具体权限控制
     * @Return void
     **/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * @Author hewanning
     * @Description - 用来配置拦截保护的请求,限制请求-重写这个方法
     * @Date 14:04 2019/4/27
     * @Param http
     * @Return void
     **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()//禁用了 csrf 功能
                .authorizeRequests()//限定签名成功的请求
                .antMatchers("/decision/**", "/govern/**").hasAnyRole("USER", "ADMIN")//对decision和govern 下的接口 需要 USER 或者 ADMIN 权限
                .antMatchers("/admin/login").permitAll()///admin/login 不限定
                .antMatchers("/admin/**").hasRole("ADMIN")//对admin下的接口 需要ADMIN权限
                .antMatchers("/oauth/**").permitAll()//不拦截 oauth 开放的资源
                .anyRequest().permitAll()//其他没有限定的请求，允许访问
                .and().anonymous()//对于没有配置权限的其他请求允许匿名访问
                .and().formLogin()//使用 spring security 默认登录页面
                .and().httpBasic();//启用http 基础验证
    }


    /**
     * @Author hewanning
     * @Description - 用来构建 Filter 链
     * @Date 14:04 2019/4/27
     * @Param web
     * @Return void
     **/
    @Override
    public void configure(WebSecurity web) throws Exception {

        super.configure(web);
    }

}
