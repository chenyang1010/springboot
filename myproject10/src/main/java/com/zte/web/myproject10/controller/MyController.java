package com.zte.web.myproject10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

        @GetMapping("/templates")
        String test(HttpServletRequest request) {
            System.out.println("templates");
            request.setAttribute("key", "hello world");
            return "/login";
        }

}
