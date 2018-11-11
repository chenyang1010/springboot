package com.zte.web.myproject3.mapper;

import com.zte.web.myproject3.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    //使用xml配置形式查询

    List<Map> getAllUser();
    Long addUserGetID(User user);


    void addUser(User user);
}
