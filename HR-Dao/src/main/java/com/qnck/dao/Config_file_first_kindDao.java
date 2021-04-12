package com.qnck.dao;

import com.qnck.entity.Config_file_first_kind;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * 一级机构Dao
 */
public interface Config_file_first_kindDao {

    @Select("select * from Config_file_first_kind")
    @ResultMap("ConfigFileFirstKindMap")
    List<Config_file_first_kind> CONFIG_FILE_FIRST_KINDS();
}
