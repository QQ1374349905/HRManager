package com.qnck.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author zhangfuwei
 **/
public class PageUtil {
    public Page<Object> getPage(int pageSize, int currentPage, Map condition, Object object,String method) throws IllegalAccessException, InstantiationException {
        if (currentPage < 0) {
            currentPage = 1;
        }
        if (pageSize < 0) {
            pageSize = 5;
        }
        Page<Object> page = PageHelper.startPage(currentPage, pageSize);
        //获取类加载器
        Class aClass = object.getClass();
        //判断是否有条件需要查询
        try {
            if (condition != null) {
                //有条件执行条件查询
                Method declaredMethod = aClass.getDeclaredMethod(method,Map.class);
                declaredMethod.invoke(object, condition);
            } else {
                //无条件直接查询
                Method declaredMethod = aClass.getDeclaredMethod(method);
                declaredMethod.invoke(object );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }
}
