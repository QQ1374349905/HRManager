package com.qnck.service.impl;

import com.qnck.dao.recruit.Engage_resumeDao;
import com.qnck.entity.Engage_resume;
import com.qnck.service.recruit.Engage_resumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<Engage_resume> queryEngage_resume(Map map) {
        return engage_resumeDao.queryEngage_resume(map);
    }

    @Override
    public Engage_resume findValidResumeById(int resID) {
        return engage_resumeDao.findValidResumeById(resID);
    }

    @Override
    public void updatePassCheckStatus(int resID) {
        engage_resumeDao.updatePassCheckStatus(resID);
    }

    @Override
    public List<Engage_resume> queryEngage_resume2(Map map) {
        return engage_resumeDao.queryEngage_resume2(map);
    }

    //复核简历
    @Override
    public void ReCheck(int resID) {
        engage_resumeDao.ReCheck(resID);
    }

    @Override
    public void UpdateInfo(Engage_resume engageResume) {
        engage_resumeDao.UpdateInfo(engageResume);
    }

    @Override
    public List<Engage_resume> Interview() {
        return engage_resumeDao.Interview();
    }
    //登记简历
    @Override
    public void register(int resID) {
        engage_resumeDao.register(resID);
    }
}
