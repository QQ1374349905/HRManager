package com.qnck.controller;

import com.qnck.entity.User;
import com.qnck.service.login.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    Logger logger = Logger.getLogger(LoginController.class);

    /**
     * 用户登录系统
     * @author zhangfuwei
     * @param username
     * @param password
     * @param session
     * @return boolean
     */
    @PostMapping("verifyLogin")
    @ResponseBody
    private boolean verifyLogin(String username, String password, HttpSession session){
        logger.debug("获取到数据:{账号:"+username+",密码:"+password+"}");

        //对密码进行加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //可能发生异常,打印日志
        try {
            //查询数据库,判断是否登陆成功
            User user = loginService.verifyLogin(username,password);
            System.out.println("User:"+user);
            //将登录用户数据存入session中
            session.getServletContext().setAttribute("user", user);
            return user != null;
        } catch (Exception e) {
            logger.error("登录出现错误!",e);
            e.printStackTrace();
        }
        return false;
    }
}
