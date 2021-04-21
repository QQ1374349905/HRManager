package com.qnck.dao.recruit;

import com.qnck.entity.Config_major;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Config_majorDao {
    @Select("SELECT * FROM Config_major")
    @ResultMap("Config_majorMap")
    List<Config_major> queryConfigMajar();

    @Select("SELECT * FROM Config_major where major_id=#{id}")
    Config_major queryBymajorID(@Param("id") int id);
    //查询职业信息
    @Select(" SELECT * FROM Config_major WHERE major_kind_id=#{majorID}")
    @ResultMap("Config_majorMap")
    List<Config_major> queryConfigMajar02(@Param("majorID") int majorID);
}
