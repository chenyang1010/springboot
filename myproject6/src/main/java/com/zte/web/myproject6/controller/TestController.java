package com.zte.web.myproject6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/redis/test1")
    public String getOne(){

        ValueOperations<String,String> operations = stringRedisTemplate.opsForValue();

        operations.set("cy","测试redis添加");

        String result = operations.get("cy");

        return result;

    }

}
