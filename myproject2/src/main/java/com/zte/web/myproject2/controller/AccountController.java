package com.zte.web.myproject2.controller;

import com.zte.web.myproject2.entity.Account;
import com.zte.web.myproject2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/zte/account/{id}",produces = "application/json")
    @ResponseBody
    public Account getUser(@PathVariable Integer id) {
        System.out.println(id);
        Account account = accountService.queryAccount(id);
        return account;
    }

    @PostMapping(value = "/zte/account", produces = "application/json")
    @ResponseBody
    public Object addUser(@RequestBody Account account) {
        System.out.println(account);
        accountService.addAccount(account);
        Map map = new HashMap<String, String>();
        map.put("result", "SUCCESS");
        return map;
    }

    @DeleteMapping(value = "/zte/account/{id}", produces = "application/json")
    @ResponseBody
    public Object deleteAccount(@PathVariable("id") Integer id) {
        accountService.deleteAccount(id);
        Map map = new HashMap<String, String>();
        map.put("result", "SUCCESS");
        return map;
    }

    @PostMapping(value = "/zte/account/{id}", produces = "application/json")
    @ResponseBody
    public Object updateAccount(@PathVariable("id") int id, String name, double money) {
        accountService.updateAccount(new Account(id, name, money));
        Map map = new HashMap<String, String>();
        map.put("result", "SUCCESS");
        return map;
    }
}
