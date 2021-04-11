package com.qnck.service;

import com.qnck.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryUserList();

    void deleteUser(int id);
}
