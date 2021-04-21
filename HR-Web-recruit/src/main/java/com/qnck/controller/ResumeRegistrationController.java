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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.faces.annotation.RequestMap;
import java.util.List;
import java.util.Map;

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
    //
    //查询公共字段
    @RequestMapping("PublicColumn")
    @ResponseBody
    public List<Config_public_char> queryPublicColumn(String Nationality){
        return configPublicCharService.queryNationality(Nationality);
    }
    //简历登记功能
    @RequestMapping("addEngageResume")
    public String addEngageResume(Engage_resume engageResume, Config_major configMajor, Config_major_kind configMajorKind){
        engageResume.setConfig_major(configMajor);
        engageResumeService.addEngage_resume(engageResume);
        return "redirect:toPage?page=page/recruit/resume/resume-choose";
    }

    /**
     * 根据条件查询登记信息
     */
    @RequestMapping("EngageResumeByMajor")
    public String queryEngageResumeByMajor(@RequestParam Map map, ModelMap modelMap){
        System.out.println(map);
        List<Engage_resume> engage_resumes = engageResumeService.queryEngage_resume(map);
        modelMap.put("engage_resumes",engage_resumes);
        return "forward:toPage?page=page/recruit/resume/valid-list";
    }
    /**
     * 根据条件查询有效的登记信息
     */
    @RequestMapping("EngageResumeByMajor2")
    public String queryEngageResumeByMajor2(@RequestParam Map map, ModelMap modelMap){
        System.out.println(map);
        List<Engage_resume> engage_resumes = engageResumeService.queryEngage_resume2(map);
        modelMap.put("engage_resumes",engage_resumes);
        return "forward:toPage?page=page/recruit/resume/resume-list";
    }

    /**
     * 根据编号查询简历信息
     */
    @RequestMapping("findValidResumeById")
    public String findValidResumeById(int resID,Map map){
        Engage_resume validResume = engageResumeService.findValidResumeById(resID);
        map.put("validResume",validResume);
        System.out.println("____________________________________________________________");
        return "forward:toPage?page=page/recruit/resume/resume-details";
    }


    /**
     * 通过审核
     */
    @RequestMapping("CheckPass")
    public String CheckPass(int resID){
        engageResumeService.updatePassCheckStatus(resID);
        return "redirect:toPage?page=page/recruit/resume/resume-choose";
    }
    @RequestMapping("Recheck")
    public String Recheck(int resID){
        engageResumeService.ReCheck(resID);
        return "redirect:toPage?page=page/recruit/resume/valid-resume";
    }
}
