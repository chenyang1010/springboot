package com.zte.myproject1.mapper;


import com.zte.myproject1.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {
    Account getAccount(@Param("id") int id);
    void delAccount(@Param("id") int id);
    void addAccount(Account account);
    void updateAccount(Account user);
}
