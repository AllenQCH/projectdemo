package com.threadpool.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CachedThreadPool 用于并发执行大量短期的小任务，或者是负载较轻的服务器。
 */
public class _CachedThreadPoolTest {
    public static void main(String[] args) {
        /**
         * 可以看到，CachedThreadPool 没有核心线程，非核心线程数无上限，也就是全部使用外包，但是每个外包空闲的时间只有 60 秒，超过后就会被回收。
         *
         * CachedThreadPool 使用的队列是 SynchronousQueue，这个队列的作用就是传递任务，并不会保存。
         *
         * 因此当提交任务的速度大于处理任务的速度时，每次提交一个任务，就会创建一个线程。极端情况下会创建过多的线程，耗尽 CPU 和内存资源。
         *
         * 它的执行流程如下：
         *
         * 没有核心线程，直接向 SynchronousQueue 中提交任务
         * 如果有空闲线程，就去取出任务执行；如果没有空闲线程，就新建一个
         * 执行完任务的线程有 60 秒生存时间，如果在这个时间内可以接到新任务，就可以继续活下去，否则就拜拜
         * 由于空闲 60 秒的线程会被终止，长时间保持空闲的 CachedThreadPool 不会占用任何资源。
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 10; i++) {
            executorService.execute(myRunnable);
        }

        System.out.println(Thread.currentThread().getName()+ "CachedThreadPoolTest线程任务开始执行");
        executorService.shutdown();
    }

}
