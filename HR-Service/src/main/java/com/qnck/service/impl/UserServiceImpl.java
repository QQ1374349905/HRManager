package com.qnck.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qnck.dao.login.IUserDao;
import com.qnck.entity.User;
import com.qnck.service.power.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public Page<Object> queryUserList(int currentPage,int pageSize) {
        Page<Object> page = PageHelper.startPage(currentPage, pageSize);
        userDao.queryUserList();
        return page;
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);

    }

    @Override
    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    @Override
    public void updateUser(User user, String oldPwd) {

        //如果与旧密码相同则不加密直接加入,相当于源密码
        if (!oldPwd.equals(user.getUserPassword())) {
            String userPassword = user.getUserPassword();
            System.out.println("加密前数据:" + userPassword);
            userPassword = DigestUtils.md5DigestAsHex(userPassword.getBytes());
            System.out.println("加密后数据:" + userPassword);
            user.setUserPassword(userPassword);
            return;
        }
        //密码不相同则加密后重新加入
        userDao.updateUser(user);
    }

    @Override
    public int verifyUserName(String userName) {
        return userDao.verifyUserName(userName);
    }

    @Override
    public void addUser(User user) {
        String userPassword = user.getUserPassword();
        System.out.println("加密前数据:"+userPassword);
        userPassword = DigestUtils.md5DigestAsHex(userPassword.getBytes());
        System.out.println("加密后数据:"+userPassword);
        user.setUserPassword(userPassword);
        userDao.addUser(user);
    }
}
