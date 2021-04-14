package com.qnck.service.impl;

import com.qnck.dao.recruit.Engage_major_releaseDao;
import com.qnck.entity.Engage_major_release;
import com.qnck.service.recruit.Engage_major_releasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职业发布管理业务区
 */
@Service
public class Engage_major_releasesServiceImpl implements Engage_major_releasesService {

    @Autowired
    private Engage_major_releaseDao engage_major_releaseDao;
    @Override
    public void addEngage_major_release(Engage_major_release engageMajorRelease) {
        engage_major_releaseDao.addEngage_major_release(engageMajorRelease);
    }

    @Override
    public List<Engage_major_release> selectEngage_major_release() {
        return engage_major_releaseDao.selectEngage_major_release();
    }

    @Override
    public Engage_major_release queryEngage_major_release(int id) {
        return engage_major_releaseDao.queryEngage_major_release(id);
    }
}
