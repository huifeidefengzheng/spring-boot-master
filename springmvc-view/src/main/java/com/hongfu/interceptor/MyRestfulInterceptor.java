package com.hongfu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyRestfulInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前：登录检查
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功的时候，用户信息放到了session中，所以这时就从session中取
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser==null){//没有登录
            request.setAttribute("msg","您还没有登录，请先登录");
            //转发到登陆页面
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        //到了这里说明登录成功的，直接放行
        return true;
    }
}
