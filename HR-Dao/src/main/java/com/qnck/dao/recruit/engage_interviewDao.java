package com.qnck.dao.recruit;

import com.qnck.entity.Engage_interview;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.faces.annotation.RequestMap;
import java.util.List;

/**
 * 面试表的Dao
 * @author wrz
 */
public interface engage_interviewDao {
    @Select("SELECT ein_id,resume_id,major_id,er.res_id,er.human_name,cm.major_kind_name,cm.major_name,ei.interview_amount,ei.registe_time,ei.multi_quality_degree FROM engage_interview ei JOIN Engage_resume er ON ei.resume_id=er.res_id JOIN config_major cm \n" +
            "ON cm.major_kind_id=er.human_major_kind_id WHERE ei.check_status!=4")
    @ResultMap("engageInterviewMap")
    List<Engage_interview> queryEngageInterview();

    @Select("SELECT DISTINCT * from engage_interview ei JOIN Engage_resume er ON ei.resume_id=er.res_id JOIN config_major cm \n" +
            "ON cm.major_kind_id=ei.human_major_kind_id where ein_id=#{EinID}")
    @ResultMap("engageInterviewMap")
    Engage_interview queryEngageInterviewByID(int einID);
    //修改简历状态
    @Update("UPDATE engage_interview SET check_status=#{checkStatusID} where ein_id=#{einID}")
    void updateCheck_status(@Param("checkStatusID") int checkStatusID, @Param("einID") int einID);

    //录用申请
    @Select("SELECT DISTINCT * FROM engage_interview ei JOIN Engage_resume er ON ei.resume_id=er.res_id JOIN config_major cm \n" +
            "ON cm.major_kind_id=ei.human_major_kind_id where ei.resume_id=#{humanID}")
    @ResultMap("engageInterviewMap")
    Engage_interview EmploymentApplication(@Param("humanID") int humanID);
    //是否通过面试
    @Update("update Engage_resume set interview_status=#{yesorno} where res_id=#{resID}")
    void passInterview(@Param("yesorno") int yesorno,@Param("resID") int resID);
}
