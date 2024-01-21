package com.threadpool.demo.config;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 创建一个通用的异步任务类AsyncTask和工具类AsyncTaskUtil
 */
public class AsyncTaskUtil {

    private volatile static ThreadPoolTaskExecutor threadPoolTaskExecutor;

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        if(threadPoolTaskExecutor == null) {
            LOCK.lock();
            try {
                if(threadPoolTaskExecutor == null) {
                    threadPoolTaskExecutor = (ThreadPoolTaskExecutor)SpringContextHelper.getBean("threadPoolTaskExecutor");
                }
            } finally {
                LOCK.unlock();
            }
        }
        return threadPoolTaskExecutor;
    }

    public static void asyncTask(Object object, String methodName, Object[] args) {
        AsyncTask asyncTask = new AsyncTask(object, methodName, args);
        asyncTask(asyncTask);
    }

    public static void asyncTask(Runnable asyncTask) {
        getThreadPoolTaskExecutor().execute(asyncTask);
    }

    public static <T> Future<T> asyncTask(Callable<T> callableTask) {
        return getThreadPoolTaskExecutor().submit(callableTask);
    }

}
