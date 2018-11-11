package com.zte.web.myproject3.controller;

import com.zte.web.myproject3.entity.User;
import com.zte.web.myproject3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    //走数据源1库
    @GetMapping(value = "/test1")
    @ResponseBody
    public String testOne(){
        User user = new User("cy01",20);
        userService.addUser1(user);
        return "success";
    }

    //使用数据源2插入数据
    @GetMapping(value = "/test2")
    @ResponseBody
    public String testTwo(){
        User user = new User("cy02",20);
        userService.addUser2(user);
        return "success";
    }

}