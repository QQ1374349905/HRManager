package com.qnck.dao;

import com.qnck.entity.Engage_major_release;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface iEngage_major_releaseDao {
    @Select("SELECT * FROM Config_file_first_kind")
    @ResultMap("Engage_major_releaseMap")
    void Addengage_major_release();
}
