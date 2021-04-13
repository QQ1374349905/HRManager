package com.qnck.service;

import com.github.pagehelper.Page;
import com.qnck.entity.User;

public interface UserService {
    Page<Object> queryUserList(int currentPage, int pageSize);

    void deleteUser(int id);

    User queryUserById(int id);
}
