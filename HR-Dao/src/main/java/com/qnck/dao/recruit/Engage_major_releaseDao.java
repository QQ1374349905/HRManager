package com.qnck.dao.recruit;

import com.qnck.entity.Engage_major_release;
import org.apache.ibatis.annotations.Insert;

public interface Engage_major_releaseDao {
    @Insert("INSERT INTO Engage_major_release(mre_id,first_kind_id,second_kind_id,third_kind_id,\n" +
            "major_kind_id,major_id,human_amount,engage_type," +
            "deadline,register,regist_time,major_describe,engage_required) " +
            "VALUES(DEFAULT,#{config_file_first_kinds.first_kind_id},#{config_file_second_kinds.second_kind_id}" +
            ",#{config_file_third_kinds.third_kind_id},#{Config_major.major_kind_id},#{Config_major.major_id},#{human_amount},#{engage_type}" +
            ",#{deadline},#{register},sysdate(),#{major_describe},#{engage_required})")
    void addEngage_major_release(Engage_major_release engageMajorRelease);
}

