package com.qnck.dao.recruit;

import com.qnck.entity.Config_public_char;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 公共字段设置
 */
public interface Config_public_charDao {
    //查询公共字段设置
    @Select("SELECT * FROM config_public_char WHERE attribute_kind=#{attribute}")
    @ResultMap("Config_public_charMap")
    List<Config_public_char> queryNationality(@Param("attribute")String attribute);
    @Select("SELECT * FROM config_public_char")
    @ResultMap("Config_public_charMap")
    List<Config_public_char> selectNationality();
}
