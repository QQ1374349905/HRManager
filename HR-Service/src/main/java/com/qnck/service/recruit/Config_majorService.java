package com.qnck.service.recruit;

import com.qnck.entity.Config_major;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Config_majorService {
    List<Config_major> queryConfigMajar();
    List<Config_major> queryConfigMajar02(@Param("majorID") int majorID);
}
