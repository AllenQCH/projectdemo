package com.threadpool.demo.test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test01AsyncTask implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(Test01AsyncTask.class);

    @Override
    public void run() {
        logger.info("异步任务1执行开始");
        try {
            // TODO 执行业务逻辑
            logger.info("异步任务1执行成功");
        } catch (Exception e) {
            logger.error(" 异步任务1执行出错", e);
        }
    }
}
