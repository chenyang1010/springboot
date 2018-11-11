package com.zte.web.myproject2.mapper;

import com.zte.web.myproject2.entity.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface AccountDao {

    @Insert({"insert into account values(#{id},#{name},#{money})"})
    int addAccount(Account account);

    @Delete({"delete from account where id=#{value}"})
    int deleteAccountById(int id);

    @Update({"update account set name=#{name, jdbcType=INTEGER},money=#{money, jdbcType=DOUBLE} where id=#{id}"})
    void updateAccount(Account account);

    @Select({"select * from account where id=#{value, jdbcType=INTEGER}"})
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "money", property = "money", jdbcType = JdbcType.DOUBLE)
    })
    Account queryAccount(int id);
}
