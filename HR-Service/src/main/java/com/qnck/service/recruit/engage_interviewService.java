package com.qnck.service.recruit;

import com.qnck.entity.Engage_interview;

import java.util.List;

public interface engage_interviewService {
    List<Engage_interview> queryEngageInterview();
    Engage_interview queryEngageInterviewByID(int einID);
    void updateCheck_status(int checkStatusID,int einID);
}
