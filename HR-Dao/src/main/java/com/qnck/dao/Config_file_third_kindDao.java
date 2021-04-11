package com.qnck.dao;

import com.qnck.entity.Config_file_third_kind;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 三级机构Dao
 */
public interface Config_file_third_kindDao {
    @Select("select * from Config_file_third_kind where second_kind_id=#{id}")
    @ResultMap("Config_file_third_kindDaoMap")
    List<Config_file_third_kind> CONFIG_FILE_THIRD_KINDS(@Param("id") int id);
}
