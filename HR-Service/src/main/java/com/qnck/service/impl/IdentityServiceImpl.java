package com.qnck.service.impl;

import com.qnck.dao.IIdentityDao;
import com.qnck.entity.Identity;
import com.qnck.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhangfuwei
 * @Description identity实体类 Service
 **/
@Service
public class IdentityServiceImpl implements IdentityService {

    @Autowired
    private IIdentityDao identityDao;

    @Override
    public List<Identity> queryAllIdentity() {
        return identityDao.queryAllIdentity();
    }
}
