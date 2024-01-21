package com.threadpool.demo.test;


import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 参考：https://www.cnblogs.com/zjfjava/p/11227456.html
 *
 *  corepoolsize：3
 *  maxmumPoolsize：6
 *  blockingqueue：2
 *  创建线程数：8 = maxmumPoolsize + blockingqueue
 *  8个线程依次创建并执行；
 *  提交第1个任务时，由于当前线程池中正在执行的任务为 0，小于 3（corePoolSize 指定），所以会创建一个线程用来执行提交的任务1；
 *  提交第 2， 3 个任务的时候，由于当前线程池中正在执行的任务数量小于等于 3 （corePoolSize 指定），所以会为每一个提交的任务创建一个线程来执行任务；
 *  当提交第4个任务的时候，由于当前正在执行的任务数量为 3 （因为每个线程任务执行时间为10s，所以提交第4个任务的时候，前面3个线程都还在执行中），此时会将第4个任务存放到 workQueue 队列中等待执行；
 *  由于 workQueue 队列的大小为 2 ，所以该队列中也就只能保存 2 个等待执行的任务，所以第5个任务也会保存到任务队列中；
 *  当提交第6个任务的时候，因为当前线程池正在执行的任务数量为3，workQueue 队列中存储的任务数量也满了，这时会判断当前线程池中正在执行的任务的数量是否小于6（maximumPoolSize指定）；
 *  如果小于 6 ，那么就会新创建一个线程来执行提交的任务 6；
 *  执行第7，8个任务的时候，也要判断当前线程池中正在执行的任务数是否小于6（maximumPoolSize指定），如果小于6，那么也会立即新建线程来执行这些提交的任务；
 *  此时，6个任务都已经提交完毕，那 workQueue 队列中的等待 任务4 和 任务5 什么时候执行呢？
 *  当任务1执行完毕后（10s后），执行任务1的线程并没有被销毁掉，而是获取 workQueue 中的任务4来执行；
 *  当任务2执行完毕后，执行任务2的线程也没有被销毁，而是获取 workQueue 中的任务5来执行；
 *
 *
 *  其实，线程池中会线程执行完毕后，并不会被立刻销毁，线程池中会保留 corePoolSize 数量的线程，
 *  当 workQueue 队列中存在任务或者有新提交任务时，那么会通过线程池中已有的线程来执行任务，避免了频繁的线程创建与销毁，
 *  而大于 corePoolSize 小于等于 maximumPoolSize 创建的线程，则会在空闲指定时间（keepAliveTime）后进行回收。
 */
public class ThreadPoolSerialTest1 {
    /**
     * 测试ThreadPoolExecutor对线程的执行顺序
     * @param args
     */
    public static void main(String[] args) {
        //核心线程数
        int corePoolSize = 3;
        //最大线程数
        int maximumPoolSize = 6;
        //超过 corePoolSize 线程数量的线程最大空闲时间
        long keepAliveTime = 2;
        //以秒为时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        //创建工作队列，用于存放提交的等待执行任务
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
        ThreadPoolExecutor threadPoolExecutor = null;
        try {
            //创建线程池
            threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
                    maximumPoolSize,
                    keepAliveTime,
                    unit,
                    workQueue,
                    new ThreadPoolExecutor.AbortPolicy());

            //循环提交任务
            for (int i = 0; i < 8; i++) {
                //提交任务的索引
                final int index = (i + 1);
                threadPoolExecutor.submit(() -> {
                    // 线程打印输出
                    System.out.println(new Date());
                    System.out.println(Thread.currentThread().getName() + "大家好，我是线程：" + index);
                    try {
                        //模拟线程执行时间，10s
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                //每个任务提交后休眠500ms再提交下一个任务，用于保证提交顺序
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}