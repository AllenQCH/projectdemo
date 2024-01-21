package com.threadpool.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadExecutor 用于串行执行任务的场景，每个任务必须按顺序执行，不需要并发执行。
 */
public class SingleThreadExecutorTest {
    public static void main(String[] args) {
        /**
         *
         *  * 核心线程池大小=1
         *  * 最大线程池大小为1
         *  * 线程过期时间为0ms
         *  * LinkedBlockingQueue作为工作队列
         *
         *public static ExecutorService newSingleThreadExecutor () {
         *return new FinalizableDelegatedExecutorService
                    * (new ThreadPoolExecutor(1, 1,
                    * 0L,TimeUnit.MILLISECONDS,
         *new LinkedBlockingQueue<Runnable>()));
         *}
         * 从参数可以看出来，SingleThreadExecutor 相当于特殊的 FixedThreadPool，它的执行流程如下：
         *
         * 线程池中没有线程时，新建一个线程执行任务
         * 有一个线程以后，将任务加入阻塞队列，不停的加
         * 唯一的这一个线程不停地去队列里取任务执行
         **/
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 10; i++) {
            executorService.execute(myRunnable);
        }

        System.out.println(Thread.currentThread().getName() + "SingleThreadExecutorTest线程任务开始执行");
        executorService.shutdown();
    }

}
