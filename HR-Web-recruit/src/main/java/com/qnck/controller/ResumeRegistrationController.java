package com.qnck.controller;

import com.qnck.dao.recruit.Engage_resumeDao;
import com.qnck.entity.Config_major;
import com.qnck.entity.Config_major_kind;
import com.qnck.entity.Config_public_char;
import com.qnck.entity.Engage_resume;
import com.qnck.service.recruit.Config_public_charService;
import com.qnck.service.recruit.Engage_major_releasesService;
import com.qnck.service.recruit.Engage_resumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 简历管理控制器
 * @author wrz
 */
@Controller
public class ResumeRegistrationController {
    //加入添加的相关信息
    @Autowired
    private Config_public_charService configPublicCharService;
    //加入简历管理
    @Autowired
    private Engage_resumeService engageResumeService;
    //查询公共字段
    @RequestMapping("PublicColumn")
    @ResponseBody
    public List<Config_public_char> queryPublicColumn(String Nationality){
        return configPublicCharService.queryNationality(Nationality);
    }
    //简历登记功能
    @RequestMapping("addEngageResume")
    public String addEngageResume(Engage_resume engageResume, Config_major configMajor, Config_major_kind configMajorKind){
        engageResumeService.addEngage_resume(engageResume);
        return "redirect:toPage?page=page/recruit/resume/resume-choose";
    }
}
