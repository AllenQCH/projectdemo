package com.cctv.service;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LoginService {

    @Resource
    private AsynchronousTask asynchronousTask;

    public Boolean login() {
        //登录处理
        Long userId = 10001L;
        boolean isSucc = true;
        if (isSucc) {
            asynchronousTask.recordLoginLog(userId);
        }
        System.out.println("=====登录成功====");
        return true;
    }
}