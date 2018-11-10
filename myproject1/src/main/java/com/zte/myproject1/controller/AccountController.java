package com.zte.myproject1.controller;

import com.zte.myproject1.entity.Account;
import com.zte.myproject1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
        accountService.delAccount(id);
        Map map = new HashMap<String, String>();
        map.put("result", "SUCCESS");
        return map;
    }

    @PostMapping(value = "/zte/account/{id}", produces = "application/json")
    @ResponseBody
    public Object updateAccount(@PathVariable("id") int id, String name, double account) {
        accountService.updateAccount(new Account(id, name, account));
        Map map = new HashMap<String, String>();
        map.put("result", "SUCCESS");
        return map;
    }
}
