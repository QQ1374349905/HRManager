package com.qnck.controller;

import com.qnck.entity.*;
import com.qnck.service.recruit.Config_majorService;
import com.qnck.service.recruit.Engage_major_releasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

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
            modelMap.put("name","王任重");
            System.out.println("______________________________");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "forward:toPage?page=page/recruit/position/position_change_update.html";
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
        return "forward:toPage?page=page/recruit/position/position_release_change.html";
    }
}
