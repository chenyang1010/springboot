package com.zte.web.myproject8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, Object> sayHello() {
        Map<String, Object> data = new HashMap<>();
        data.put("hello","hello");
        return data;
    }
}
