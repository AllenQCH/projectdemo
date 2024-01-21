package com.cctv.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsynchronousTask {

    @Async("taskExecutor")
    public void recordLoginLog(Long userId){
        System.out.println("======== 登录日志记录=====start=======");
        try {
            // TODO: 2022/4/14 业务处理
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("========登录日志记录------end=======");
    }

}
