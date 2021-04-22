package com.qnck.dao.power;

import com.qnck.entity.First_Permissions;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface IFirst_PermissionsDao {

    @Select("select * from First_Permissions fp join Identity_Permissions ip on fp.first_permissions_id=ip.first_permissions_id where fp.first_permissions_id = #{id}")
    @ResultMap("firstSecondMap")
    First_Permissions queryById(int id);
}
