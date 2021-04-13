package com.qnck.service.impl;

import com.qnck.dao.recruit.Config_file_second_kindDao;
import com.qnck.entity.Config_file_second_kind;
import com.qnck.service.recruit.Config_file_second_kindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Config_file_second_kindServiceImpl implements Config_file_second_kindService {
    @Autowired
    private Config_file_second_kindDao configFileSecondKindDao;
    @Override
    public List<Config_file_second_kind> QueryConfigFileSecondKind(int id) {
        return configFileSecondKindDao.QueryConfigFileSecondKind(id);
    }
}
