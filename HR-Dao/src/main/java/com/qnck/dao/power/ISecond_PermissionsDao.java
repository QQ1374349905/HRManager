package com.qnck.dao.power;

import com.qnck.entity.Second_Permissions;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISecond_PermissionsDao {
    @Select("select * from Second_Permissions where first_permissions_id=#{id}")
    List<Second_Permissions> queryById(int id);
}
