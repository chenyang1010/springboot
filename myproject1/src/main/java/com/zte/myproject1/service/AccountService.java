package com.zte.myproject1.service;

import com.zte.myproject1.mapper.AccountMapper;
import com.zte.myproject1.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountService {

    @Resource
    AccountMapper accountMapper;

    public Account getAccount(int id) {
        System.out.println(id);
        return accountMapper.getAccount(id);
    }

    public void delAccount(int id) {
        accountMapper.delAccount(id);
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.MANDATORY, readOnly = true)
    public void addAccount(Account account) {
        accountMapper.addAccount(account);
    }
    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
    }
}
