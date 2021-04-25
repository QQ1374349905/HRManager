package com.qnck.controller;

import com.qnck.dao.recruit.Engage_resumeDao;
import com.qnck.entity.*;
import com.qnck.service.recruit.*;
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
    //加入职业信息
    @Autowired
    private Config_majorService ConfigMajorService;
    //引入面试管理
    @Autowired
    private engage_interviewService engageInterviewService;
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
        //查询公共字段
        List<Config_public_char> charList = configPublicCharService.selectNationality();
        //查询简历信息
        Engage_resume validResume = engageResumeService.findValidResumeById(resID);
        //查询职业信息
        List<Config_major> config_majors = ConfigMajorService.queryConfigMajar();
        map.put("validResume",validResume);
        map.put("charList",charList);
        map.put("config_majors",config_majors);
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

    /**
     * 复核
     */
    @RequestMapping("Recheck")
    public String Recheck(int resID){
        engageResumeService.ReCheck(resID);
        return "redirect:toPage?page=page/recruit/resume/valid-resume";
    }

    /**
     * 修改简历信息
     */
    @RequestMapping("updateInfo")
    public String updateInfo(Engage_resume engageResume,Config_major configMajor){
        System.out.println(configMajor);
        engageResume.setConfig_major(configMajor);
        engageResumeService.UpdateInfo(engageResume);
        return "redirect:EngageResumeByMajor";
    }
    /**
     * 待面试信息
     */
    @RequestMapping("WaitInterview")
    public String WaitInterview(ModelMap modelMap){
        List<Engage_resume> interview = engageResumeService.Interview();
        modelMap.put("interviews",interview);
        System.out.println("______________________________________________________");
        return "forward:toPage?page=page/recruit/interview/interview-list";
    }

    /**
     * 登记简历信息
     * @param resID
     */
    @RequestMapping("register")
    public String register(int resID){
        engageResumeService.register(resID);
        return "redirect:WaitInterview";
    }

    /**
     * 录用功能查询
     * @param map
     * @return
     */
    @RequestMapping("queryEmploy")
    public String queryEmploy(ModelMap map){
        List<Engage_resume> engage_resumes = engageResumeService.queryEmploy();
//        System.out.println(engage_resumes);
        map.addAttribute("engage_resumes",engage_resumes);
        return "forward:toPage?page=page/recruit/employ/register_list";
    }
    /**
     * 录用审批功能查询
     * @param map
     * @return
     */
    @RequestMapping("queryEmploy2")
    public String queryEmploy2(ModelMap map){
        List<Engage_resume> engage_resumes = engageResumeService.queryEmploy();
        map.addAttribute("engage_resumes",engage_resumes);
        return "forward:toPage?page=page/recruit/employ/check_list";
    }
    /**
     * 录用查询功能
     * @param map
     * @return
     */
    @RequestMapping("queryEmploy3")
    public String queryEmploy3(ModelMap map){
        List<Engage_resume> engage_resumes = engageResumeService.queryEmploy();
        map.addAttribute("engage_resumes",engage_resumes);
        return "forward:toPage?page=page/recruit/employ/list";
    }

    /**
     * 录用申请
     * @param resumeID,modelMap
     * @return
     */
    @RequestMapping("EmploymentApplication")
    public String EmploymentApplication(int resumeID,ModelMap modelMap){
        Engage_interview engage_interview = engageInterviewService.EmploymentApplication(resumeID);
        modelMap.addAttribute("engage_interviews",engage_interview);
        return "forward:toPage?page=page/recruit/employ/register";
    }
    /**
     * 录用审批
     * @param resumeID,modelMap
     * @return
     */
    @RequestMapping("EmploymentApplication2")
    public String EmploymentApplication2(int resumeID,ModelMap modelMap){
        Engage_interview engage_interview = engageInterviewService.EmploymentApplication(resumeID);
        modelMap.addAttribute("engage_interviews",engage_interview);
        return "forward:toPage?page=page/recruit/employ/check";
    }
    /**
     * 录用查询
     * @param resumeID,modelMap
     * @return
     */
    @RequestMapping("EmploymentApplication3")
    public String EmploymentApplication3(int resumeID,ModelMap modelMap){
        Engage_interview engage_interview = engageInterviewService.EmploymentApplication(resumeID);
        modelMap.addAttribute("engage_interviews",engage_interview);
        return "forward:toPage?page=page/recruit/employ/details";
    }

    /**
     * 一组查询
     * @param checkInfo 审核状态
     * @param resID 简历编号
     * @param passCheckcomment 审核意见
     * @return
     */
    @RequestMapping("ReleaseResume")
    public String updateReleaseResume(String checkInfo,int resID,String passCheckcomment){
        int checkID=0;
        if(checkInfo.equals("申请录用")){
            checkID=1;
        }
        engageResumeService.releaseResume(checkID,resID,passCheckcomment);
        return "redirect:queryEmploy";
    }
    /**
     * 一组查询
     * @param checkID 审核状态
     * @param resID 简历编号
     * @param passCheckcomment 审核意见
     * @return
     */
    @RequestMapping("ReleaseResume2")
    public String updateReleaseResume2(int checkID,int resID,String passCheckcomment){
        engageResumeService.releaseResume(checkID,resID,passCheckcomment);
        return "redirect:queryEmploy";
    }
    /**
     * 一组查询
     * @param checkID 审核状态
     * @param resID 简历编号
     * @param passCheckcomment 审核意见
     * @return
     */
    @RequestMapping("ReleaseResume3")
    public String updateReleaseResume3(int checkID,int resID,String passCheckcomment){
        engageResumeService.releaseResume(checkID,resID,passCheckcomment);
        return "redirect:queryEmploy";
    }
    //是否通过面试
    @RequestMapping("passInterView")
    public String passInterView(String passInfo,int resID){
        int pass=0;
        if("通过".equals(passInfo)){
            pass=1;
        }
        engageResumeService.passInterview(pass,resID);
        return "redirect:queryEmploy2";
    }

}
