package com.qnck.service.impl;

import com.qnck.dao.recruit.Config_public_charDao;
import com.qnck.entity.Config_public_char;
import com.qnck.service.recruit.Config_public_charService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公共字段设置
 */
@Service
public class Config_public_charServiceImpl implements Config_public_charService {
    @Autowired
    private Config_public_charDao config_public_charDao;
    @Override
    public List<Config_public_char> queryNationality(String attribute) {
        return config_public_charDao.queryNationality(attribute);
    }

    @Override
    public List<Config_public_char> selectNationality() {
        return config_public_charDao.selectNationality();
    }
}