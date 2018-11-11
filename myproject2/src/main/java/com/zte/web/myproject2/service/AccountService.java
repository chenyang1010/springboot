package com.zte.web.myproject2.service;

import com.zte.web.myproject2.entity.Account;
import com.zte.web.myproject2.mapper.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    public void deleteAccount(int id) {
        accountDao.deleteAccountById(id);
    }

    public Account queryAccount(int id) {
        return accountDao.queryAccount(id);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }
}
