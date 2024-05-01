package com.yteam.jcompany.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yteam.jcompany.exception.UnauthenticatedException;

import com.yteam.jcompany.service.Interface.AuthServcie;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuthAspect {
    @Autowired
    AuthServcie authServcie;
    @Before("execution(* com.yteam.jcompany.controller..*..*(..)) && args(.., request)")
    public void beforeControllerMethodExecution(HttpServletRequest request) {
        String headerValue = request.getHeader("Login-Key");
        if(!authServcie.isAuthenticated(headerValue)){
            throw new UnauthenticatedException("you are not authenticated");
    }
}
}

