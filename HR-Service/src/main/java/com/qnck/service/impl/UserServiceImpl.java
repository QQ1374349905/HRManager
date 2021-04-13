package com.qnck.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qnck.dao.IUserDao;
import com.qnck.entity.User;
import com.qnck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
