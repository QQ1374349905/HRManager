package com.qnck.dao.recruit;

import com.qnck.entity.Config_file_first_kind;
import com.qnck.entity.Engage_major_release;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * 一级机构Dao
 */
public interface Config_file_first_kindDao {

    @Select("select * from Config_file_first_kind")
    @ResultMap("ConfigfilefirstkindMap")
    List<Config_file_first_kind> CONFIG_FILE_FIRST_KINDS();

    @Select("SELECT * FROM Config_file_first_kind WHERE first_kind_id=1")
    @ResultMap("ConfigfilefirstkindMap")
    Engage_major_release queryByCONFIG_FILE_FIRST_KINDS();
}
