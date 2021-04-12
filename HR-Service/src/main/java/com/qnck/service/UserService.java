package com.qnck.service;

import com.github.pagehelper.Page;

public interface UserService {
    Page<Object> queryUserList(int currentPage, int pageSize);

    void deleteUser(int id);
}
