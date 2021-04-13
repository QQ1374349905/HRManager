package com.qnck.service.login;

import com.qnck.entity.User;

public interface LoginService {
    User verifyLogin(String username, String password);
}
