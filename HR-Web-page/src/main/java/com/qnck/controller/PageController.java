package com.qnck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("toPage")
    private String toPage(String page) {
        return page;
    }

    @RequestMapping("/")
    private String toIndex() {
        return "login";
    }
}
