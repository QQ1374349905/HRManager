package com.qnck.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.*;
import java.util.List;

/**
 * @Author zhangfuwei
 **/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PagingQuery {
    String pageNumParameterName() default "pageNum";//页号的参数名
    String pageSizeParameterName() default "pageSize";//每页行数的参数名
}

@Aspect
@Component
class Aop{
    @Around("@annotation(pagingQuery)")
    public Object pagingQuery(ProceedingJoinPoint joinPoint, PagingQuery  pagingQuery) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> returnType = signature.getMethod().getReturnType();
        if (returnType == List.class) {
            String pageNumParameterName = pagingQuery.pageNumParameterName();
            String pageSizeParameterName = pagingQuery.pageSizeParameterName();
            //获取request，从中获取分页参数
            ServletRequestAttributes currentRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                    .currentRequestAttributes();
            HttpServletRequest request = currentRequestAttributes.getRequest();
            String pageNum = request.getParameter(pageNumParameterName);
            String pageSize = request.getParameter(pageSizeParameterName);
            if (StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)) {
                try {
                    PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
                    Object result = joinPoint.proceed();
                    return new PageInfo<>((List<?>) result);//建议自己实现返回类型，官方自带的返回数据太冗余了
                } finally {//保证线程变量被清除
                    if (PageHelper.getLocalPage() != null)
                        PageHelper.clearPage();
                }
            }
        }
        return joinPoint.proceed();
    }
}
