package com.qnck;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws ClassNotFoundException, SQLException {
//        String username = "zhangsan";
//        String realName = "张三";
//        String password = "admin";
//        int identity = 8;
//        System.out.println("加密前:"+password);
//        password = DigestUtils.md5DigestAsHex(password.getBytes());
//        System.out.println("加密后:"+password);
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.61:3306/hr_Manager", "root", "Zhang3@.");
//        System.out.println("获取连接:"+connection);
//
//        PreparedStatement prepareStatement = connection.prepareStatement("insert into User values (null,?,?,?,?)");
//        prepareStatement.setString(1,username);
//        prepareStatement.setString(2,realName);
//        prepareStatement.setString(3,password);
//        prepareStatement.setInt(4,identity);
//
//        int result = prepareStatement.executeUpdate();
//        if (result > 0){
//            System.out.println("插入成功");
//        } else {
//            System.out.println("插入失败");
//        }
    }
}
