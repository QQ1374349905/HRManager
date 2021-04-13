package com.qnck.controller;

import com.qnck.entity.*;
import com.qnck.service.recruit.Config_majorService;
import com.qnck.service.recruit.Engage_major_releasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        engageMajorRelease.setConfig_file_third_kinds(configFileThirdKind);
        engageMajorRelease.setConfig_file_third_kinds(configFileThirdKind);
        engageMajorRelease.setConfig_major(configMajor);
        engageMajorReleasesService.addEngage_major_release(engageMajorRelease);
        return "redirect:toPage?page=page/recruit/position/position_change_update.html";

    }
}
