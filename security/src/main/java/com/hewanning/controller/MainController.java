package com.hewanning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName controller
 * @Author hewanning
 * @Date 2019/4/27 14:31
 * @Description TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("admin")
public class MainController {


    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/detail")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}