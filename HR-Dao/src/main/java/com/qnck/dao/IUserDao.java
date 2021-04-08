package com.qnck.dao;

import com.qnck.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface IUserDao {

    @Select("select * from User where user_name=#{username} and user_password=#{password}")
    @ResultMap("userMap")
    User verifyLogin(@Param("username") String username,@Param("password") String password);
}
