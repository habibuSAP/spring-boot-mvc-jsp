package com.demo.hplus.interceptors;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.logging.Logger;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String seesionID = null;
        if(null != request.getCookies()){
            for (Cookie cookie: request.getCookies()){
                if("JSESSIONID".equals(cookie.getName())){
                    seesionID = cookie.getValue();
                }
            }
            System.out.println("Incoming request data log, session: " + seesionID + " at " + new Date() + " for " + request.getRequestURI());
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("in post processing");
    }
}
