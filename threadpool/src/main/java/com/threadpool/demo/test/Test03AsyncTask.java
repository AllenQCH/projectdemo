package com.threadpool.demo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Async // 标注到类上说明类中所有方法都是异步方法，若标注到方法上则标注方法为异步方法
public class Test03AsyncTask {
    private static final Logger logger = LoggerFactory.getLogger(Test03AsyncTask.class);

    public void run() {
        try {
            // TODO 执行业务逻辑
            logger.info("{}:异步任务执行成功"+Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }

    public void run1() {
        try {
            // TODO 执行业务逻辑
            logger.info("{}:异步任务执行成功"+Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }
}

