package com.qnck.service.impl;

import com.qnck.dao.recruit.Engage_resumeDao;
import com.qnck.entity.Engage_resume;
import com.qnck.service.recruit.Engage_resumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 简历管理
 * @author wrz
 */
@Service
public class Engage_resumeServiceImpl implements Engage_resumeService {

    @Autowired
    private Engage_resumeDao engage_resumeDao;
    @Override
    public void addEngage_resume(Engage_resume engageResume) {
        engage_resumeDao.addEngage_resume(engageResume);
    }
}
