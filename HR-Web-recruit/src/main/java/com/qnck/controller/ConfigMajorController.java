package com.qnck.controller;

import com.qnck.entity.*;
import com.qnck.service.recruit.Config_majorService;
import com.qnck.service.recruit.Engage_major_releasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 招聘管理控制器
 * @author wrz
 */
@Controller
public class ConfigMajorController {
    //导入招聘管理
    @Autowired
    private Config_majorService configMajorService;

    @Autowired
    private Engage_major_releasesService engageMajorReleasesService;
    /**
     * 查询招聘管理
     */
    @RequestMapping("QueryConfigMajors")
    @ResponseBody
    public List<Config_major> configMajors(){
        return configMajorService.queryConfigMajar();
    }

    /**
     * 添加招聘信息
     * @return
     */
    @RequestMapping("addMajor")
    public String AddConfigMajor(Config_file_first_kind configFileFirstKind,Config_file_second_kind configFileSecondKind,Config_file_third_kind configFileThirdKind,Config_major configMajor,Engage_major_release engageMajorRelease){
        engageMajorRelease.setConfig_file_first_kinds(configFileFirstKind);
        engageMajorRelease.setConfig_file_second_kinds(configFileSecondKind);
        engageMajorRelease.setConfig_file_third_kinds(configFileThirdKind);
        engageMajorRelease.setConfig_major(configMajor);
        engageMajorReleasesService.addEngage_major_release(engageMajorRelease);
        return "redirect:PositionRegisterInfo";
    }
    /**
     * 查询职位发布登记信息
     */
    @RequestMapping("PositionRegisterInfo")
    public String QueryPositionRegister(ModelMap modelMap){
        try {
            List<Engage_major_release> engage_major_releases = engageMajorReleasesService.selectEngage_major_release();
            System.out.println(engage_major_releases);
            modelMap.put("engage_major_releases",engage_major_releases);
            System.out.println("______________________________");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "forward:toPage?page=page/recruit/position/position_change_update.html";
    }
    /**
     * 查询职位发布登记信息
     */
    @RequestMapping("PositionRegisterInfo2")
    public String QueryPositionRegister2(ModelMap modelMap){
        try {
            List<Engage_major_release> engage_major_releases = engageMajorReleasesService.selectEngage_major_release();
            System.out.println(engage_major_releases);
            modelMap.put("engage_major_releases",engage_major_releases);
            System.out.println("______________________________");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "forward:toPage?page=page/recruit/position/position_release_search.html";
    }

    /**
     *  查看职业发布信息
     * @param id
     * @return
     */
    @RequestMapping("PositionRegisterInfoByID")
    public String QueryPositionRegisterByID(int id,ModelMap modelMap){
        Engage_major_release engage_major_release = engageMajorReleasesService.queryEngage_major_release(id);
        modelMap.put("engage_major_release",engage_major_release);
        modelMap.put("MreId",id);
        return "forward:toPage?page=page/recruit/position/position_release_change.html";
    }

    /**
     * 职业发布变更,这个版本修改的非常不好
     * @param map
     * @param deadline
     * @return
     */
    @RequestMapping("UpdatePositionRegister")
    public String UpdatePositionRegister(@RequestParam Map map,Date deadline){
        System.out.println("_________________________________________"+map);
        //从map中获取值
        int mre_id = Integer.parseInt(map.get("mre_id").toString());
        String engage_type = map.get("engage_type").toString();
        int human_amount = Integer.parseInt(map.get("human_amount").toString());
        String register = map.get("register").toString();
        String major_describe = map.get("major_describe").toString();
        String engage_required = map.get("engage_required").toString();
        Engage_major_release engageMajorRelease =new Engage_major_release();
        engageMajorRelease.setDeadline(deadline);//注入修改日期
        engageMajorRelease.setHuman_amount(human_amount);//注入注册人数
        engageMajorRelease.setEngage_type(engage_type);//职业类型
        engageMajorRelease.setEngage_required(engage_required);//招聘要求
        engageMajorRelease.setMre_id(mre_id);//招聘信息ID
        engageMajorRelease.setMajor_describe(major_describe);//职业要求
        engageMajorReleasesService.UpdateEngage_major_release(engageMajorRelease);
        return "redirect:PositionRegisterInfo";
    }

    /**
     * 删除职业发布信息
     * @param id
     * @return
     */
    @RequestMapping("DeleteEngageMajorRelease")
    @ResponseBody
    public String DeleteEngage_major_release(int id){
        try {
            engageMajorReleasesService.DeleteEngage_major_release(id);
            return "yes";
        }catch (Exception e){
            e.printStackTrace();
            return "no";
        }
    }

    /**
     * 登记职业发布
     * @param id
     * @return
     */
    @RequestMapping("Engage_major_releaseStatus")
    public String Engage_major_releaseStatus(int id){
        engageMajorReleasesService.UpdateEngageStatus(id);
        return "redirect:toPage?page=page/recruit/resume/register";
    }
    /**
     * 查询职业分类
     */
    @RequestMapping("queryEngage_resume")
    @ResponseBody
    public List<Config_major> queryEngage_resume(){
        List<Config_major> config_majors = configMajorService.queryConfigMajar();
        return config_majors;
    }
    /**
     * 根据职业分类查询职业
     */
    @RequestMapping("Engage_resumeByMajor")
    @ResponseBody
    public List<Config_major> queryEngage_resumeByMajor(int majorID){
        List<Config_major> config_majors = configMajorService.queryConfigMajar02(majorID);
        return config_majors;
    }
}
