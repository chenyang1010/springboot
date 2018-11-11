package com.zte.web.myproject2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/hello")
    @ResponseBody
    public String say() {
        System.out.println("hello");
        return "hello,world!";
    }
}
