package com.threadpool.demo.test;

import java.util.concurrent.CountDownLatch;

/**
 * 同时启动多个线程
 * 如果想同时启动多个线程，实现最大的并行性，就可以使用 CountDownLatch。稍微修改上面的例子代码，代码如下：
 */

/**
 * 代码解释：
 *
 * 设置 CountDownLatch 等待线程数为 1
 * 开启 10 个线程，每个线程都会调用 CountDownLatch 的 await() 方法，这样每个线程都会被阻塞
 * 主线程休眠 1 秒后，调用 CountDownLatch 的 countDown() 方法，调用后就会唤醒所有等待的线程，所有等待的线程就会同时执行
 *
 * 打印结果：
 * mainTask Start!
 * Thread-1 start 1535987605552
 * Thread-3 start 1535987605552
 * Thread-2 start 1535987605552
 * Thread-0 start 1535987605552
 * Thread-6 start 1535987605552
 * Thread-5 start 1535987605552
 * Thread-8 start 1535987605552
 * Thread-4 start 1535987605552
 * Thread-9 start 1535987605552
 * Thread-7 start 1535987605552
 */
public class CountDownLatchDemo02 {

    static class TaskThread extends Thread {

        CountDownLatch latch;

        public TaskThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                latch.await();
                System.out.println(getName() + " start " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        int threadNum = 10;
        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < threadNum; i++) {
            TaskThread task = new TaskThread(latch);
            task.start();
        }
        System.out.println(Thread.currentThread().getName()+ "Task Start!");
        Thread.sleep(1000);
        latch.countDown();

    }

}