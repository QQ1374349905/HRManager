package com.qnck.dao;

import com.qnck.entity.Identity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface IIdentityDao {

    @Select("select * from Identity where identity_id = #{id}")
    @ResultMap("identityMap")
    Identity queryById(int id);
}
