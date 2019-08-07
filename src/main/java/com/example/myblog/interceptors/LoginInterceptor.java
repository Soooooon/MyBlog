package com.example.myblog.interceptors;

import com.example.myblog.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        HttpSession session=request.getSession();

        User user= (User) session.getAttribute("user");

        if (user==null){
            return false;
        } else {
            return true;
        }
    }
}
