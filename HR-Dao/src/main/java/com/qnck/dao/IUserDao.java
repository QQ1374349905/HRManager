package com.qnck.dao;

import com.qnck.entity.User;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface IUserDao {

    @Select("select * from User where username=#{0} and password=#{1}")
    @ResultMap("userMap")
    User verifyLogin(String username, String password);
}
