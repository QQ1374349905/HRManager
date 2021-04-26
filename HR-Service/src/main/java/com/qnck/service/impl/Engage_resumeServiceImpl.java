package com.qnck.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qnck.dao.recruit.Engage_resumeDao;
import com.qnck.dao.recruit.engage_interviewDao;
import com.qnck.entity.Engage_interview;
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
    //引入面试的依赖
    @Autowired
    private engage_interviewDao engageInterviewDao;
    @Override
    public void addEngage_resume(Engage_resume engageResume) {
        engage_resumeDao.addEngage_resume(engageResume);
    }

    @Override
    public Page<Object> queryEngage_resume(Map map,int currentPage,int pageSize) {
        Page<Object> engage_resumes = PageHelper.startPage(currentPage, pageSize);
        engage_resumeDao.queryEngage_resume(map);
        return engage_resumes;
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
    public Page<Object> queryEngage_resume2(Map map,int currentPage,int pageSize) {
        Page<Object> engage_resumes = PageHelper.startPage(currentPage, pageSize);
        engage_resumeDao.queryEngage_resume2(map);
        return engage_resumes;
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
    public Page<Object> Interview(int currentPage,int pageSize) {
        Page<Object> objects = PageHelper.startPage(currentPage, pageSize);
        System.out.println("----------------------执行前");
        engage_resumeDao.Interview();
        System.out.println("----------------------执行后");
        return objects;
    }
    //登记简历
    @Override
    public void register(int resID) {
        engage_resumeDao.register(resID);
    }
    //录用
    @Override
    public Page<Object> queryEmploy(int currentPage,int pageSize) {
        Page<Object> objects = PageHelper.startPage(currentPage, pageSize);
        System.out.println("-------------------------执行前");
        engage_resumeDao.queryEmploy();
        System.out.println("-------------------------执行后");
        return objects;
    }

    @Override
    public void releaseResume(int checkID, int resID,String passCheckcomment) {
        engage_resumeDao.releaseResume(checkID,resID,passCheckcomment);
    }

    @Override
    public void passInterview(int yesorno, int resID) {
        engageInterviewDao.passInterview(yesorno, resID);
    }

}
