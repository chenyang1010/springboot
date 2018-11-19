package com.zte.web.myproject7.controller;

import com.zte.web.myproject7.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    CacheService cacheService;

    @RequestMapping(value = "/redis/test2")
    public String test2() throws Exception {
        cacheService.set("ccyy","测试jedis");

        return cacheService.get("ccyy");
    }
}
