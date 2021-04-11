package com.qnck.dao;

import com.qnck.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    //验证登录,根据用户名和密码查询数据
    @Select("select * from User where user_name=#{username} and user_password=#{password}")
    @ResultMap("userMap")
    User verifyLogin(@Param("username") String username,@Param("password") String password);

    //查询所有用户
    @Select("select * from User")
    @ResultMap("userMap")
    List<User> queryUserList();

    //根据id删除用户
    @Delete("delete from User where user_id = #{id}")
    void deleteUser(int id);
}
