package com.qnck.service.impl;

import com.qnck.dao.recruit.Config_file_first_kindDao;
import com.qnck.entity.Config_file_first_kind;
import com.qnck.service.recruit.iConfig_file_first_kindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Config_file_first_kindServiceImpl implements iConfig_file_first_kindService {
    @Autowired
    private Config_file_first_kindDao configFileFirstKindDao;
    @Override
    public List<Config_file_first_kind> CONFIG_FILE_FIRST_KINDS() {
        return configFileFirstKindDao.CONFIG_FILE_FIRST_KINDS();
    }
}
