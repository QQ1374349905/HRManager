package com.qnck.service.power;

import com.github.pagehelper.Page;
import com.qnck.entity.User;

public interface UserService {
    Page<Object> queryUserList(int currentPage, int pageSize);

    void deleteUser(int id);

    User queryUserById(int id);

    void updateUser(User user);

    int verifyUserName(String userName);

    void addUser(User user);
}
