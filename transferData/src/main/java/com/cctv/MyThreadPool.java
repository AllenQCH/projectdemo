package com.cctv;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {

    public static void main(String[] args) {
        // 创建一个线程池，包含5个线程
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5, // 核心线程数
                10, // 最大线程数
                60, // 空闲线程超时时间（秒）
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(Constants.capacity), // 任务队列
                new ThreadPoolExecutor.AbortPolicy() // 线程数达最大时的处理策略：丢弃任务并抛出异常
                // new ThreadPoolExecutor.CallerRunsPolicy() // 线程数达最大时的处理策略：新任务由调用线程执行
        );

        // 提交14个任务给线程池处理
        for (int i = 0; i < Constants.taskNum; i++) {
            executor.execute(new Task(i + 1));
        }

        // 关闭线程池
        executor.shutdown();
    }

    // 一些常量
    public class Constants {
        public static final int capacity = 4;
        public static final int taskNum = 14;
    }

    static class Task implements Runnable {

        private final int id;

        public Task(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Task " + id + " started by " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("~~~~~~~~~~Task " + id + " completed by " + Thread.currentThread().getName());
        }
    }
}
