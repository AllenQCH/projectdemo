package com.cctv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolMonitor {

    @Autowired
    @Qualifier("serviceExecutorBatch")
    private ThreadPoolTaskExecutor serviceExecutorBatch;

    @Autowired
    @Qualifier("serviceExecutor01")
    private ThreadPoolTaskExecutor serviceExecutor01;

    @Scheduled(fixedRate = 5000)
    public void monitor() {
        int poolSize = serviceExecutorBatch.getPoolSize();
        int activeCount = serviceExecutorBatch.getActiveCount();
        int queueSize = serviceExecutorBatch.getThreadPoolExecutor().getQueue().size();
        long completedTaskCount = serviceExecutorBatch.getThreadPoolExecutor().getCompletedTaskCount();


        System.out.println("/serviceExecutorBatch:-------------------/");
        System.out.println("serviceExecutorBatch:Total Threads: " + poolSize);
        System.out.println("serviceExecutorBatch:Active Threads: " + activeCount);
        System.out.println("serviceExecutorBatch:Queue Size: " + queueSize);
        System.out.println("serviceExecutorBatch:completedTaskCount: " + completedTaskCount);

//
//        if(queueSize > 50 && poolSize < 10) {
//            int newPoolSize = Math.min(poolSize + 1, 10);
//            executor.setPoolSize(newPoolSize);
//            System.out.println("Increased pool size to: " + newPoolSize);
//        } else if(queueSize < 20 && poolSize > 5) {
//            int newPoolSize = Math.max(poolSize - 1, 5);
//            executor.setPoolSize(newPoolSize);
//            System.out.println("Decreased pool size to: " + newPoolSize);
//        }
    }



    @Scheduled(fixedRate = 5000)
    public void monitorServiceExecutor01() {
        int poolSize = serviceExecutor01.getPoolSize();
        int activeCount = serviceExecutor01.getActiveCount();
        int queueSize = serviceExecutor01.getThreadPoolExecutor().getQueue().size();

        System.out.println("/monitorServiceExecutor01:**********************/");
        System.out.println("monitorServiceExecutor01:Total Threads: " + poolSize);
        System.out.println("monitorServiceExecutor01:Active Threads: " + activeCount);
        System.out.println("monitorServiceExecutor01:Queue Size: " + queueSize);

//        }
    }
}

