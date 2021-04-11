package com.qnck.dao;

import com.qnck.entity.Config_file_second_kind;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * 二级机构Dao
 */
public interface Config_file_second_kindDao {
    @Select("select * from Config_file_second_kind WHERE first_kind_id=#{id}")
    @ResultMap("Config_file_second_kindMap")
    List<Config_file_second_kind> QueryConfigFileSecondKind(@Param("id") int id);
}
