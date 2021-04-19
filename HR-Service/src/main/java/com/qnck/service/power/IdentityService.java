package com.qnck.service.power;

import com.github.pagehelper.Page;
import com.qnck.entity.Identity;

import java.util.List;

public interface IdentityService {
    List<Identity> queryAllIdentity();

    Page<Object> queryIdentityList(int currentPage, int pageSize);

    Identity queryIdentityById(int id);
}
