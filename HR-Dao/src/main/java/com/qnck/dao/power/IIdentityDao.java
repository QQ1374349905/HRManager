package com.qnck.dao.power;

import com.qnck.entity.Identity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IIdentityDao {

    @Select("select * from Identity where identity_id = #{id}")
    @ResultMap("identityMap")
    Identity queryById(int id);

    @Select("select * from Identity")
    @ResultMap("identityMap")
    List<Identity> queryAllIdentity();
}
