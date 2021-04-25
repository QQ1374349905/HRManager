package com.qnck.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qnck.dao.power.IrightsDao;
import com.qnck.dao.power.Irights_controlDao;
import com.qnck.entity.Rights;
import com.qnck.entity.rights_control;
import com.qnck.service.power.IrightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@EnableTransactionManagement
public class IrightsServiceImpl implements IrightsService {
    //自动注入角色dao
    @Autowired
    private IrightsDao dao;
    //自动注入权限dao
    @Autowired
    private Irights_controlDao controlDao;


    @Override
    public List<Rights> queryAll() {
        return dao.queryAll();
    }

    @Override
    public Page<Rights> queryBypage(int pageNum,int pageSize) {
        Page<Rights> page = PageHelper.startPage(pageNum, pageSize);
        dao.queryrightsAll();
        return page;
    }

    @Override
    public Rights queryAndcontro(int id) {
        return dao.queryAndcontro(id);
    }

    @Override
    public void updaterights(Rights r, rights_control rc) {
        dao.updaterights(r);
        controlDao.updatecontrol(rc);
    }

    @Override
    public void addrights(Rights r) {
        dao.addrights(r);
        controlDao.addcontrol(r.getR_id());
    }

    @Override
    @Transactional
    public void deleteRole(int id) {
        dao.deleteRole(id);
        controlDao.deleteControl(id);
    }
}
