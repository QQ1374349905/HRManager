package com.qnck.dao.login;

import com.qnck.entity.User;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from User where user_id = #{id}")
    @ResultMap("userMap")
    User queryUserById(int id);

    @Update("update User set user_name=#{userName},user_true_name=#{userTrueName},user_password=#{userPassword},identity_id=#{identity.identityId} where user_id=#{userId}")
    void updateUser(User user);

    @Select("select count(*) from User where user_name=#{userName}")
    int verifyUserName(String userName);

    @Insert("insert into User values (null,#{userName},#{userTrueName},#{userPassword},#{identity.identityId})")
    void addUser(User user);
}
