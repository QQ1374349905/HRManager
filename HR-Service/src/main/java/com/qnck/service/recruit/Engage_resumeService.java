package com.qnck.service.recruit;

import com.github.pagehelper.Page;
import com.qnck.entity.Engage_interview;
import com.qnck.entity.Engage_resume;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 简历管理Dao
 * @author wrz
 */
public interface Engage_resumeService {
    void addEngage_resume(Engage_resume engageResume);
    Page<Object> queryEngage_resume(Map map, int currentPage, int pageSize);
    Engage_resume findValidResumeById(int resID);
    void updatePassCheckStatus(int resID);
    Page<Object> queryEngage_resume2(Map map,int currentPage,int pageSize);
    void ReCheck(int resID);
    void UpdateInfo(Engage_resume engageResume);
    Page<Object> Interview(int currentPage,int pageSize);
    void register(int resID);
    Page<Object> queryEmploy(int currentPage,int pageSize);
    void releaseResume(int checkID,int resID,String passCheckcomment);
    void passInterview(int yesorno,int resID);
}
