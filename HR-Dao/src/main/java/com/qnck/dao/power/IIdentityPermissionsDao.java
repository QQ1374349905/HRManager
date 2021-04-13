package com.qnck.dao.power;

import org.apache.ibatis.annotations.Delete;

public interface IIdentityPermissionsDao {

    @Delete("delete from Identity_Permissions where identity_id = #{id}")
    void deleteByIdentityId(int id);
}
