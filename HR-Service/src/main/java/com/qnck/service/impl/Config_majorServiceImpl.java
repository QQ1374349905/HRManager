package com.qnck.service.impl;

import com.qnck.dao.recruit.Config_majorDao;
import com.qnck.entity.Config_major;
import com.qnck.service.recruit.Config_majorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Config_majorServiceImpl implements Config_majorService {
    @Autowired
    private Config_majorDao configMajorDao;
    @Override
    public List<Config_major> queryConfigMajar() {
        return configMajorDao.queryConfigMajar();
    }
}
