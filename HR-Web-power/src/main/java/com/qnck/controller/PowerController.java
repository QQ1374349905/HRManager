package com.qnck.controller;

import com.qnck.entity.User;
import com.qnck.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PowerController {

    @Autowired
    private UserService userService;

    Logger logger = Logger.getLogger(PowerController.class);

    /**
     * @Author zhangfuwei
     * @Description 查询所有用户
     * @Param map
     * @return String
     */
    @GetMapping("queryUserList")
    private String queryUserList(ModelMap map){
        List<User> userList = null;
        try {
            userList = userService.queryUserList();
        } catch (Exception e) {
            logger.error("查询全部用户失败!",e);
            e.printStackTrace();
        }
        map.addAttribute("userList", userList);
        System.out.println("获取到数据:"+userList);
        return "page/power/user_list";
    }

    /**
    * @Author zhangfuwei
    * @Description 删除用户
    * @Date 19:04 2021/4/11P
    * @Param id
    * @return boolean
    **/
    @RequestMapping("deleteUser")
    @ResponseBody
    private boolean deleteUser(int id){
        try {
            userService.deleteUser(id);
            return true;
        } catch (Exception e) {
            logger.error("删除用户失败!",e);
            e.printStackTrace();
            return false;
        }
    }
}
