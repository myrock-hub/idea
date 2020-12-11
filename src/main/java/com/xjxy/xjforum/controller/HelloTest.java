package com.xjxy.xjforum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class HelloTest {
    @RequestMapping("/hello")
    public String hello(){
       return "hello";
    }
}
