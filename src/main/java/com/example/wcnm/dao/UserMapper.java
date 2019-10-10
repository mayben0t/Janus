package com.example.wcnm.dao;

import com.example.wcnm.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    void insert(@Param("user") User user);


    User selectUserByUserName(@Param("username")String username);
}
