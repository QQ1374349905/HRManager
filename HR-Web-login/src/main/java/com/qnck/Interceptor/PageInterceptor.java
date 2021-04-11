package com.qnck.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PageInterceptor implements HandlerInterceptor {

    private List<String> urlList;

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    @Override
    //配置界面拦截器,防止管理界面泄露
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取路径
        String url = request.getServletPath();

        //判断是否包含放行的url包含直接放行
        if (urlList.contains(url) || urlList.contains(url+"?page="+request.getParameter("page"))) {
            System.out.println(url.equals("/")?url:url+"?page="+request.getParameter("page"));
            return true;
        }

        //获取用户登录后的session
        Object user = request.getSession().getServletContext().getAttribute("user");
        System.out.println("获取到session:"+user);

        //如果没有登录,则不放行
        if (user == null) {
            System.out.println("拦截:"+url);
            response.sendRedirect("toPage?page=login");
            return false;
        }

        return true;
    }
}
