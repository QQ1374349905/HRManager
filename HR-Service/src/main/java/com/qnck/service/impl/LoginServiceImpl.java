package com.qnck.service.impl;

import com.qnck.dao.IUserDao;
import com.qnck.entity.User;
import com.qnck.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User verifyLogin(String username, String password) {
        return userDao.verifyLogin(username, password);
    }
}
