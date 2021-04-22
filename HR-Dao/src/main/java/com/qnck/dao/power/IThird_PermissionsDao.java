package com.qnck.dao.power;

import com.qnck.entity.Third_Permissions;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IThird_PermissionsDao {

    @Select("select * from Third_permissions where second_permissions_id=#{id}")
    @ResultMap("thirdPermissionsMap")
    List<Third_Permissions> queryById(int id);
}
