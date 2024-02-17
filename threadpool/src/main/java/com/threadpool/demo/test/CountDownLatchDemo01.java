package com.threadpool.demo.test;

/**
 * CountDownLatch是倒计时的门栓
 * 怎么使用 CountDownLatch：
 * 构造方法：public CountDownLatch(int count)-------count 就是需要等待的线程数量
 * 重要方法：
 * // 调用此方法的线程会被阻塞，直到 CountDownLatch 的 count 为 0
 * public void await() throws InterruptedException
 *
 * // 和上面的 await() 作用基本一致，只是可以设置一个最长等待时间
 * public boolean await(long timeout, TimeUnit unit) throws InterruptedException
 *
 * // 会将 count 减 1，直至为 0
 * public void countDown()
 *
 */

import java.util.concurrent.CountDownLatch;

/**
 * 需求：现在实现主线程等待其他线程的任务完成之后，才继续执行的代码。
 *
 */

/**
 * 代码解释：
 *
 * 设置 CountDownLatch 的等待线程数为 10
 * 开启 10 个线程，每个线程都会睡眠 1 秒，睡眠结束后就会调用 CountDownLatch 的 countDown() 方法
 * 主线程调用 CountDownLatch 的 await() 方法，所以会开始阻塞，直到 CountDownLatch 的 count 为 0 才继续执行
 *
 * mainTask Start!
 * Thread-8 Task is Done
 * Thread-0 Task is Done
 * Thread-7 Task is Done
 * Thread-1 Task is Done
 * Thread-3 Task is Done
 * Thread-9 Task is Done
 * Thread-2 Task is Done
 * Thread-5 Task is Done
 * Thread-4 Task is Done
 * Thread-6 Task is Done
 * mainAll Task is Done!
 *
 */
public class CountDownLatchDemo01 {

    static class TaskThread extends Thread {

        CountDownLatch latch;

        public TaskThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(getName() + " Task is Done");
                latch.countDown();
            }


        }

    }


    public static void main(String[] args) throws InterruptedException {

        int threadNum = 10;
        CountDownLatch latch = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {
            TaskThread task = new TaskThread(latch);
            task.start();
        }

        System.out.println(Thread.currentThread().getName()+ "Task Start!");

        latch.await();

        System.out.println(Thread.currentThread().getName()+"All Task is Done!");
    }

}
