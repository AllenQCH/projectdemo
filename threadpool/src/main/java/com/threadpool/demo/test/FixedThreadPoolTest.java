package com.threadpool.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool 用于负载比较重的服务器，为了资源的合理利用，需要限制当前线程数量。
 */
public class FixedThreadPoolTest {
    /**
     * 因此这个线程池执行任务的流程如下：
     *
     * 线程数少于核心线程数，也就是设置的线程数时，新建线程执行任务
     * 线程数等于核心线程数后，将任务加入阻塞队列
     * 由于队列容量非常大，可以一直加
     * 执行完任务的线程反复去队列中取任务执行
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 10; i++) {
            executorService.execute(myRunnable);
        }

        System.out.println(Thread.currentThread().getName() + "FixedThreadPoolTest线程任务开始执行");
        executorService.shutdown();
    }
}
