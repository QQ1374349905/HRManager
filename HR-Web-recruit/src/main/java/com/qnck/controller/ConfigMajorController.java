package com.qnck.controller;

import com.qnck.entity.*;
import com.qnck.service.Config_majorService;
import com.qnck.service.Engage_major_releasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String AddConfigMajor(Engage_major_release engageMajorRelease){
        System.out.println("______________________________________");
        engageMajorReleasesService.addEngage_major_release(engageMajorRelease);
        return "toPage?page=page/recruit/position/position_change_update.html";

    }
}
