package com.qnck.service.recruit;

import com.github.pagehelper.Page;
import com.qnck.entity.Engage_interview;

import java.util.List;

public interface engage_interviewService {
    Page<Object> queryEngageInterview(int currentPage,int pageSize);
    Engage_interview queryEngageInterviewByID(int einID);
    void updateCheck_status(int checkStatusID,int einID);
    Engage_interview EmploymentApplication(int humanID);
}
