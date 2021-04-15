package com.qnck.dao.recruit;

import com.qnck.entity.Engage_major_release;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 职业发布信息
 */
public interface Engage_major_releaseDao {
    //添加职业发布信息
    @Insert("INSERT INTO Engage_major_release(mre_id,first_kind_id,second_kind_id,third_kind_id,\n" +
            "major_kind_id,major_id,human_amount,engage_type," +
            "deadline,register,regist_time,major_describe,engage_required) " +
            "VALUES(DEFAULT,#{config_file_first_kinds.first_kind_id},#{config_file_second_kinds.second_kind_id}" +
            ",#{config_file_third_kinds.third_kind_id},#{config_major.major_kind_id},#{config_major.major_id},#{human_amount},#{engage_type}" +
            ",#{deadline},#{register},sysdate(),#{major_describe},#{engage_required})")
    void addEngage_major_release(Engage_major_release engageMajorRelease);
    //查询职业发布信息
    @Select("SELECT er.`mre_id`,cm.`major_name`,sc.`second_kind_name`,er.`regist_time`,er.`deadline` ,er.`human_amount` FROM Engage_major_release er\n" +
            "JOIN Config_file_second_kind sc ON sc.`second_kind_id`=er.`second_kind_id` JOIN Config_major cm ON cm.`major_id`=er.`major_id`")
    @ResultMap("Engage_major_releaseMap02")
    List<Engage_major_release> selectEngage_major_release();
    //查询所在的发布信息
    @Select("SELECT sc.`first_kind_name`,sc.`second_kind_name`,ch.`third_kind_name`,er.`engage_type`,cm.`major_kind_name`,cm.`major_name`,er.`human_amount`,er.`deadline`,er.`major_describe`,er.`engage_required` FROM Engage_major_release er JOIN Config_file_second_kind sc ON sc.`second_kind_id`=er.`second_kind_id` JOIN Config_major cm\n" +
            " ON cm.`major_id`=er.`major_id` JOIN Config_file_third_kind ch ON ch.`third_kind_id`=er.`third_kind_id` WHERE er.`mre_id`=#{id}")
    @ResultMap("Engage_major_releaseMap03")
    Engage_major_release queryEngage_major_release(@Param("id") int id);
    //职业修改信息
    @Update("UPDATE Engage_major_release SET human_amount=#{human_amount},deadline=#{deadline}," +
            "register=#{register},regist_time=sysdate(),major_describe=#{major_describe},engage_required=#{engage_required},engage_type=#{engage_type} " +
            " WHERE mre_id=#{mre_id}")
    void UpdateEngage_major_release(Engage_major_release engageMajorRelease);
    //删除职业发布信息
    @Delete("DELETE FROM Engage_major_release WHERE mre_id=#{Did}")
    void DeleteEngage_major_release(@Param("Did") int Did);
}

