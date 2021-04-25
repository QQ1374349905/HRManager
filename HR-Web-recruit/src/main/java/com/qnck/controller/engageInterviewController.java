package com.qnck.controller;

import com.qnck.entity.Engage_interview;
import com.qnck.service.recruit.engage_interviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.enterprise.inject.Model;
import java.util.List;

/**
 * 面试功能控制器
 * @author wrz
 */
@Controller
public class engageInterviewController {
    @Autowired
    private engage_interviewService engageInterviewService;

    /**
     *能筛选的面试信息
     * @param modelMap
     * @return
     */
    @RequestMapping("engageInterview")
    public String engageInterview(ModelMap modelMap){
        List<Engage_interview> engage_interviews = engageInterviewService.queryEngageInterview();
        System.out.println("查询数据——————————————————————"+engage_interviews);
        modelMap.put("engage_interviews",engage_interviews);
        return "forward:toPage?page=page/recruit/interview/sift-list";
    }

    /**
     * 查询面试信息
     */
    @RequestMapping("InterviewByID")
    public String engageInterviewByID(int einID,ModelMap modelMap){
        Engage_interview engage_interview = engageInterviewService.queryEngageInterviewByID(einID);
        modelMap.put("engage_interviews",engage_interview);
        return "forward:toPage?page=page/recruit/interview/interview-sift";
    }

    /**
     * 修改简历信息
     * @param checkStatus 筛选状态 (1.建议面试，2.建议笔试，3.建议录用，4删除简历。)
     * @param einID 面试编号
     * @return
     */
    @RequestMapping("updateStatus")
    public String updateStatus(String checkStatus,int einID){
        System.out.println("面试状态:"+checkStatus);
        int checkStatusID=3;
        if(checkStatus.equals("建议面试")){
            checkStatusID=1;
        }else if(checkStatus.equals("建议笔试")){
            checkStatusID=2;
        }else if(checkStatus.equals("删除简历")){
            checkStatusID=4;
        }
        engageInterviewService.updateCheck_status(checkStatusID,einID);
        return "redirect:engageInterview";
    }

}
