package com.qnck.controller;

import com.github.pagehelper.Page;
import com.qnck.entity.Identity;
import com.qnck.entity.User;
import com.qnck.service.IdentityService;
import com.qnck.service.UserService;
import com.qnck.utils.PagingQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PowerController {

    @Autowired
    private UserService userService;

    @Autowired
    private IdentityService identityService;

    Logger logger = Logger.getLogger(PowerController.class);

    /**
     * @Author zhangfuwei
     * @Description 查询所有用户
     * @Param map
     * @return String
     */
    @GetMapping("queryUserList")
    private String queryUserList(ModelMap map,int currentPage,int pageSize){
        Page<Object> page = null;

        try {
            page = userService.queryUserList(currentPage,pageSize);
        } catch (Exception e) {
            logger.error("查询用户失败!",e);
            e.printStackTrace();
        }

        assert page != null;
        map.addAttribute("pages", page);
        System.out.println("获取到数据:"+page);
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

    /**
    * @Author 张符伟
    * @Description 根据ID查询用户,并将数据返回到界面
    * @Date 15:06 2021/4/12
    * @Param id,map
    * @return String
    **/
    @RequestMapping("queryUserById")
    private String queryUserById(int id,ModelMap map){
        User user = userService.queryUserById(id);
        map.addAttribute("user", user);
//        System.out.println("获取到用户:"+user);
        List<Identity> identityList = identityService.queryAllIdentity();
        map.addAttribute("identityList", identityList);
//        System.out.println("获取到职位:"+identityList);
        return "page/power/user_edit";
    }
}