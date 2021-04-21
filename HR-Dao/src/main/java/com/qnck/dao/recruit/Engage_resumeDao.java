package com.qnck.dao.recruit;

import com.qnck.entity.Engage_resume;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 简历管理
 * @author wrz
 */
public interface Engage_resumeDao {

    //简历登记
    @Insert(" INSERT INTO Engage_resume(res_id,human_name,human_major_kind_id,\n" +
            " human_major_id,engage_type,human_sex,human_email,human_telephone,human_homephone,human_mobilephone,human_address,\n" +
            " human_postcode,human_nationality,human_birthplace,human_birthday,human_race,human_religion,human_party,human_idcard,human_age,human_college\n" +
            " ,human_educated_degree,human_educated_years,human_educated_major,demand_salary_standard,regist_time,human_specility,\n" +
            " human_hobby,human_history_records,remark,pass_check_status) VALUES(DEFAULT,#{human_name},#{Config_major.major_kind_id},#{Config_major.major_id},#{engage_type},#{human_sex},#{human_email},#{human_telephone},#{human_homephone},#{human_mobilephone},#{human_address}" +
            ",#{human_postcode},#{human_nationality},#{human_birthplace},#{human_birthday},#{human_race},#{human_religion},#{human_party},#{human_idcard},#{human_age},#{human_college},#{human_educated_degree}," +
            "#{human_educated_years},#{human_educated_major},#{demand_salary_standard},sysdate(),#{human_specility},#{human_hobby},#{human_history_records},#{remark},0)")
    void addEngage_resume(Engage_resume engageResume);
    //根据条件查询信息
    List<Engage_resume> queryEngage_resume(Map map);
    //根据条件查询信息2.0
    List<Engage_resume> queryEngage_resume2(Map map);
    @Select("select * from Engage_resume where res_id=#{resID}")
    @ResultMap("Engage_resumeMap")
    Engage_resume findValidResumeById(@Param("resID") int resID);
    //修改审核状态
    @Update("update Engage_resume set pass_check_status=1 where res_id=#{resID}")
    void updatePassCheckStatus(@Param("resID") int resID);
    //复核
    @Update("update Engage_resume set pass_check_status=2 where res_id=#{resID}")
    void ReCheck(int resID);

}
