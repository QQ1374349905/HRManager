package com.qnck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("verifyLogin")
    private boolean verifyLogin(String username, String password){
        System.out.println("获取到数据:{账号:"+username+",密码:"+password);
        return true;
    }
}
