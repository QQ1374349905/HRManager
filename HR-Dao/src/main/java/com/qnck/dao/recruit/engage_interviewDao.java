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
            "ON cm.major_kind_id=er.human_major_kind_id WHERE ei.check_status!=4;\n")
    @ResultMap("EngageInterviewMap")
    List<Engage_interview> queryEngageInterview();

    @Select("SELECT DISTINCT * from engage_interview ei JOIN Engage_resume er ON ei.resume_id=er.res_id JOIN config_major cm \n" +
            "ON cm.major_kind_id=ei.human_major_kind_id where ein_id=#{EinID}")
    @ResultMap("EngageInterviewMap")
    Engage_interview queryEngageInterviewByID(int einID);
    //修改简历状态
    @Update("UPDATE engage_interview SET check_status=#{checkStatusID} where ein_id=#{einID}")
    void updateCheck_status(@Param("checkStatusID") int checkStatusID, @Param("einID") int einID);
}
