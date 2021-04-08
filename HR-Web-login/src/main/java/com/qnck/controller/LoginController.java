package com.qnck.controller;

import com.qnck.entity.User;
import com.qnck.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("verifyLogin")
    @ResponseBody
    private boolean verifyLogin(String username, String password){
        System.out.println("获取到数据:{账号:"+username+",密码:"+password+"}");
        User user = loginService.verifyLogin(username,password);
        if (user != null) {
            System.out.println("登录失败");
            return false;
        } else {
            System.out.println("登录成功");
            return true;
        }
    }
}
