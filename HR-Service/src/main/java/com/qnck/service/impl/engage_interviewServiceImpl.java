package com.qnck.service.impl;

import com.qnck.dao.recruit.engage_interviewDao;
import com.qnck.entity.Engage_interview;
import com.qnck.service.recruit.engage_interviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 面试
 * @author wrz
 */
@Service
public class engage_interviewServiceImpl implements engage_interviewService {
    @Autowired
    private engage_interviewDao engageInterviewDao;
    @Override
    public List<Engage_interview> queryEngageInterview() {
        return engageInterviewDao.queryEngageInterview();
    }

    //筛选简历
    @Override
    public Engage_interview queryEngageInterviewByID(int einID) {
        return engageInterviewDao.queryEngageInterviewByID(einID);
    }
    //修改面试状态
    @Override
    public void updateCheck_status(int checkStatusID, int einID) {
        engageInterviewDao.updateCheck_status(checkStatusID,einID);
    }
    @Override
    public Engage_interview EmploymentApplication(int humanID) {
        return engageInterviewDao.EmploymentApplication(humanID);
    }
}
