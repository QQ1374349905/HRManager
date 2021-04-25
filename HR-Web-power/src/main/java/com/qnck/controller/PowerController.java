package com.qnck.controller;

import com.github.pagehelper.Page;
import com.qnck.entity.Identity;
import com.qnck.entity.Rights;
import com.qnck.entity.User;
import com.qnck.entity.rights_control;
import com.qnck.service.power.IdentityService;
import com.qnck.service.power.IrightsService;
import com.qnck.service.power.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class PowerController {

    @Autowired
    private UserService userService;

    @Autowired
    private IdentityService identityService;

    //自动注入角色业务
    @Autowired
    private IrightsService irightsService;

    Logger logger = Logger.getLogger(PowerController.class);

    /**
     * @Author zhangfuwei
     * @Description 查询所有用户
     * @Param map
     * @Return String
     */
    @GetMapping("queryUserList")
    private String queryUserList(ModelMap map,int currentPage,@RequestParam(required = false) Integer countPage,int pageSize){
        Page<Object> page = null;

        if (countPage != null){
            if (currentPage > countPage){
                currentPage = countPage;
            }

            if (currentPage < 1 ){
                currentPage = 1;
            }
        }

        try {
            page = userService.queryUserList(currentPage,pageSize);
        } catch (Exception e) {
            logger.error("查询用户失败!",e);
            e.printStackTrace();
        }

        assert page != null;
        map.addAttribute("pages", page);
//        System.out.println("获取到数据:"+page);
        return "page/power/user_list";
    }

    @RequestMapping("queryIdentityList")
    private String queryIdentityList(int currentPage, int pageSize,@RequestParam(required = false) Integer countPage, ModelMap map){
        Page<Object> pages = null;

        if (countPage != null){
            if (currentPage > countPage){
                currentPage = countPage;
            }

            if (currentPage < 1 ){
                currentPage = 1;
            }
        }

        try {
            pages = identityService.queryIdentityList(currentPage, pageSize);
        } catch (Exception e) {
            logger.error("查询用户失败!",e);
            e.printStackTrace();
        }
        map.addAttribute("pages", pages);
//        System.out.println("获取到数据:"+pages);
        return "page/power/right_list";
    }

    /**
    * @Author zhangfuwei
    * @Description 删除用户
    * @Date 19:04 2021/4/11P
    * @Param id
    * @Return boolean
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
    * @Author zhangfuwei
    * @Description 根据ID查询用户,并将数据返回到界面
    * @Date 15:06 2021/4/12
    * @Param id,map
    * @Return String
    **/
    @RequestMapping("queryUserById")
    private String queryUserById(int id,ModelMap map){
        User user = userService.queryUserById(id);
        map.addAttribute("user", user);
        System.out.println("获取到用户:"+user);
        List<Rights> rights = irightsService.queryAll();
        map.addAttribute("rightsList", rights);
        System.out.println("获取到职位:"+rights);
        return "page/power/user_edit";
    }

    /**
    * @Author zhangfuwei
    * @Description edit_user page request
    * @Date 14:39 2021/4/16
    * @Param user
    * @Return String
    **/
    @RequestMapping("updateUser")
    private String updateUser(User user, String oldPwd){
        System.out.println("获取界面数据:"+user);
        System.out.println("旧密码:"+oldPwd);
        try {
            userService.updateUser(user,oldPwd);
            return "redirect:queryUserList?currentPage=1&pageSize=5";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:queryUserById";
        }
    }

    /**
    * @Author zhangfuwei
    * @Description ajax query Identity
    * @Date 14:40 2021/4/16
    * @Param
    * @Return List<Identity>
    **/
    @RequestMapping("queryIdentity")
    @ResponseBody
    private List<Rights> queryIdentity(){
        return irightsService.queryAll();
    }

    /**
    * @Author zhangfuwei
    * @Description verify repeat UserName
    * @Date 14:40 2021/4/16
    * @Param userName
    * @Return Boolean
    **/
    @RequestMapping("verifyUserName")
    @ResponseBody
    private boolean verifyUserName(String userName){
        int result = userService.verifyUserName(userName);
        return result > 0;
    }

    /**
    * @Author zhangfuwei
    * @Description add User
    * @Date 14:41 2021/4/16
    * @Param user
    * @Return String
    **/
    @RequestMapping("addUser")
    private String addUser(User user) {
//        System.out.println("获取到页面数据:"+user);
        try {
            userService.addUser(user);
            return "redirect:queryUserList?currentPage=1&pageSize=5";
        } catch (Exception e) {
            e.printStackTrace();
            return "page/power/user_add";
        }
    }

    /**
    * @Author zhangfuwei
    * @Description query Identity
    * @Date 15:29 2021/4/19
    * @Param id,map
    * @Return String
    **/
    @RequestMapping("queryIdentityById")
    private String queryIdentityById(int id,ModelMap modelMap){
        Identity identity = identityService.queryIdentityById(id);
        modelMap.addAttribute("Identity", identity);
        return "page/power/right_list_information";
    }

    @RequestMapping("deleteRole")
    private String deleteRole(int id){
        irightsService.deleteRole(id);
        return "redirect:queryrightsAllpage";
    }
    
    /**
    * @Author xuyongheng
    * @Description //TODO user and role
    * @Date 8:33 2021/4/25
    * @Param
    * @Return
    **/
    @RequestMapping("queryrightsAllajax")
    @ResponseBody
    public List<Rights> queryAllajax(ModelMap map){
        List<Rights> rights = irightsService.queryAll();
        map.put("rightsAll",rights);
        return rights;
    }
    @RequestMapping("queryrightsAllpage")
    public String queryAllpage(ModelMap map,@RequestParam(required = false) Map m){
        int pageNum = 1;
        if (m.get("pageNum")!=null){
            pageNum = Integer.parseInt(m.get("pageNum")+"");
        }
        Page<Rights> page = irightsService.queryBypage(pageNum,6);
        //一页的数据
        map.put("rightspage",page);
        return "page/power/right_list";
    }
    @RequestMapping("queryrightAndcontrol")
    public String queryrightAndcontrol(int id,ModelMap map){
        Rights rights = irightsService.queryAndcontro(id);
        System.out.println(rights);
        map.put("randc",rights );
        return "page/power/right_list_information";
    }
    @RequestMapping("controledit")
    public  String controledit(rights_control rc, Rights rights){
//        System.out.println(rc);
//        System.out.println(rights);
        irightsService.updaterights(rights, rc);
        return "page/power/success";
    }
    @RequestMapping("addrights")
    public String addrights(Rights r){
        irightsService.addrights(r);
        return "page/power/success";
    }
}