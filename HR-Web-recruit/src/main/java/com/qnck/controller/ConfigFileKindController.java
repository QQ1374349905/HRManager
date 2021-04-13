package com.qnck.controller;

import com.qnck.entity.Config_file_first_kind;
import com.qnck.entity.Config_file_second_kind;
import com.qnck.entity.Config_file_third_kind;
import com.qnck.service.recruit.Config_file_second_kindService;
import com.qnck.service.recruit.Config_file_third_kindService;
import com.qnck.service.recruit.iConfig_file_first_kindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 机构控制器
 * @author wrz
 */
@Controller
public class ConfigFileKindController {

    //导入一级机构
    @Autowired
    private iConfig_file_first_kindService configFileFirstKindService;
    //导入二级机构
    @Autowired
    private Config_file_second_kindService configFileSecondKindService;
    //导入三级机构
    @Autowired
    private Config_file_third_kindService configFileThirdKindService;
    /**
     * 查询一级机构
     * @return 任重
     */
    @RequestMapping("QueryConfigFileFirstKind")
    @ResponseBody
    public List<Config_file_first_kind> ConfigFileFirstKind(){
        List<Config_file_first_kind> config_file_first_kinds = configFileFirstKindService.CONFIG_FILE_FIRST_KINDS();
        return config_file_first_kinds;
    }

    /**
     * 查询二级机构
     * @return 任重
     */
    @RequestMapping("QueryConfigFileSecondKind")
    @ResponseBody
    public List<Config_file_second_kind> ConfigFileSecondKind(int id){
        List<Config_file_second_kind> config_file_second_kinds = configFileSecondKindService.QueryConfigFileSecondKind(id);
        return config_file_second_kinds;
    }

    /**
     * 查询三级机构
     * @return 任重
     */
    @RequestMapping("QueryConfigFileThirdKind")
    @ResponseBody
    public List<Config_file_third_kind> ConfigFilethKind(int id){
        return configFileThirdKindService.CONFIG_FILE_THIRD_KINDS(id);
    }

}
