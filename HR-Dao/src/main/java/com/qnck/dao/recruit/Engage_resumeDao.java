package com.qnck.dao.recruit;

import com.qnck.entity.Engage_resume;
import org.apache.ibatis.annotations.Insert;

/**
 * 简历管理
 * @author wrz
 */
public interface Engage_resumeDao {

    //简历登记
    @Insert(" INSERT INTO Engage_resume(res_id,human_major_kind_name,\n" +
            " human_major_name,engage_type,human_sex,human_email,human_telephone,human_homephone,human_mobilephone,human_address,\n" +
            " human_postcode,human_nationality,human_birthplace,human_birthday,human_race,human_religion,human_party,human_idcard,human_age,human_college\n" +
            " ,human_educated_degree,human_educated_years,human_educated_major,demand_salary_standard,regist_time,human_specility,\n" +
            " human_hobby,human_history_records,remark) VALUES(DEFAULT,#{human_major_kind_name},#{human_major_name},#{engage_type},#{human_sex},#{human_email},#{human_telephone},#{human_homephone},#{human_mobilephone},#{human_address}" +
            ",#{human_postcode},#{human_nationality},#{human_birthplace},#{human_birthday},#{human_race},#{human_religion},#{human_party},#{human_idcard},#{human_age},#{human_college},#{human_educated_degree}," +
            "#{human_educated_years},#{human_educated_major},#{demand_salary_standard},sysdate(),#{human_specility},#{human_hobby},#{human_history_records},#{remark})")
    void addEngage_resume(Engage_resume engageResume);
}
