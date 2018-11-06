package com.zte.myproject1.controller;

import com.zte.myproject1.entity.Account;
import com.zte.myproject1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping(value = "/zte/account/{id}",produces = "application/json")
    @ResponseBody
    public Account getUser(@PathVariable Integer id) {
        System.out.println(id);
        Account account = accountService.getAccount(id);
        return account;
    }
}
