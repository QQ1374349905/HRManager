package com.qnck.service.impl;

import com.qnck.dao.power.Irights_controlDao;
import com.qnck.entity.rights_control;
import com.qnck.service.power.Irights_controlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Irights_controlServiceImpl implements Irights_controlService {
    @Autowired
    private Irights_controlDao dao;
    @Override
    public rights_control queryByid(int id) {
        return dao.queryByid(id);
    }
}
