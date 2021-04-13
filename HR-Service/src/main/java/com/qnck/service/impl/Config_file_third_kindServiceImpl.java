package com.qnck.service.impl;

import com.qnck.dao.recruit.Config_file_third_kindDao;
import com.qnck.entity.Config_file_third_kind;
import com.qnck.service.recruit.Config_file_third_kindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Config_file_third_kindServiceImpl implements Config_file_third_kindService {

    @Autowired
    private Config_file_third_kindDao configFileThirdKindDao;
    @Override
    public List<Config_file_third_kind> CONFIG_FILE_THIRD_KINDS(int id) {
        return configFileThirdKindDao.CONFIG_FILE_THIRD_KINDS(id);
    }
}
