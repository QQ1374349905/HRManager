package com.qnck.dao.power;

import com.qnck.entity.Permissions;
import org.apache.ibatis.annotations.Select;

public interface IPermissionsDao {
    @Select("select * from First_Permissions where first_permissions_id=#{id}")
    Permissions queryPermissionsById(int id);
}
