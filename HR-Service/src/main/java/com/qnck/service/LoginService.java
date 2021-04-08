package com.qnck.service;

import com.qnck.entity.User;

public interface LoginService {
    User verifyLogin(String username, String password);
}
