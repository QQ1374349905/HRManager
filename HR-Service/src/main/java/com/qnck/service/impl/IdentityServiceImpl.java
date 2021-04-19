package com.qnck.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qnck.dao.power.IIdentityDao;
import com.qnck.entity.Identity;
import com.qnck.service.power.IdentityService;
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

    @Override
    public Page<Object> queryIdentityList(int currentPage, int pageSize) {
        Page<Object> page = PageHelper.startPage(currentPage, pageSize);
        List<Identity> identities = identityDao.queryIdentityList();
        System.out.println("获取到数据:"+identities);
        return page;
    }

    @Override
    public Identity queryIdentityById(int id) {
        return identityDao.queryIdentityById(id);
    }
}
