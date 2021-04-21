package com.qnck.service.recruit;

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
    List<Engage_resume> queryEngage_resume(Map map);
    Engage_resume findValidResumeById(int resID);
    void updatePassCheckStatus(@Param("resID") int resID);
    List<Engage_resume> queryEngage_resume2(Map map);
    void ReCheck(int resID);
}
