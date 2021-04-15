package com.qnck.service.recruit;

import com.qnck.entity.Engage_major_release;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职业发布管理业务区
 */
public interface Engage_major_releasesService {
    void addEngage_major_release(Engage_major_release engageMajorRelease);
    List<Engage_major_release> selectEngage_major_release();
    Engage_major_release queryEngage_major_release(@Param("id") int id);
    void UpdateEngage_major_release(Engage_major_release engageMajorRelease);
    void DeleteEngage_major_release(int Did);
}
