package com.threadpool.demo.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutor 用于需要多个后台线程执行周期任务，同时需要限制线程数量的场景。
 */
public class _ScheduledThreadPoolTest {
    public static void main(String[] args) {
        /**
         * /**
         *  * 核心线程池大小=传入参数
         *  * 最大线程池大小为Integer.MAX_VALUE
         *  * 线程过期时间为0ms
         *  * DelayedWorkQueue作为工作队列
         *  */
        /**
         * ScheduledThreadPoolExecutor 的执行流程如下：
         *
         * 添加一个任务
         * 线程池中的线程从 DelayQueue 中取任务
         * 然后执行任务
         * 具体执行任务的步骤也比较复杂：
         *
         * 线程从 DelayQueue 中获取 time 大于等于当前时间的 ScheduledFutureTask
         *
         * 执行完后修改这个 task 的 time 为下次被执行的时间
         *
         * 然后再把这个 task 放回队列中
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 10; i++) {
            // 参数1:目标对象,参数2:隔多长时间开始执行线程,参数3:执行周期,参数4:时间单位
            scheduledExecutorService.scheduleAtFixedRate(myRunnable, 1, 2, TimeUnit.SECONDS);
        }

        System.out.println(Thread.currentThread().getName()+ "线程任务开始执行");
    }

}
