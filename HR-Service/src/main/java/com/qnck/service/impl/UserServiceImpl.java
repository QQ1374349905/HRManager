package com.qnck.service.impl;

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
    public List<User> queryUserList() {
        return userDao.queryUserList();
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);

    }
}
