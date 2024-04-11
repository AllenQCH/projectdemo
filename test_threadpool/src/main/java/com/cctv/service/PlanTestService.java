package com.cctv.service;

import com.cctv.entity.PlanTest;
import com.cctv.mapper.PlanTestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class PlanTestService {
    private static final Logger logger = LoggerFactory.getLogger(PlanTestService.class);

    @Autowired
    private PlanTestMapper planTestMapper;

    public String forCircleInsert() {
        List<PlanTest> planTests = new ArrayList<>();
        PlanTest planTest = new PlanTest();
        for (int i = 0; i < 1000; i++) {
            planTest = new PlanTest();
            planTest.setPlanType("1111111111111");
            planTest.setPlanCode("1111111111111");
            planTests.add(planTest);
        }
        long startTime = System.currentTimeMillis();
        planTests.forEach(p -> {
                    planTestMapper.insert(p);
                }
        );
        long endTime = System.currentTimeMillis() - startTime;
        // forCircleInsert打印时间：30408
        logger.info("forCircleInsert打印时间：{}", endTime);
        return String.valueOf(endTime);
    }

    public String insertBatch() {
        List<PlanTest> planTests = new ArrayList<>();
        PlanTest planTest;
        for (int i = 0; i < 1000; i++) {
            planTest = new PlanTest();
            planTest.setPlanType("2222222222222");
            planTest.setPlanCode("22222222222222");
            planTests.add(planTest);
        }
        long startTime = System.currentTimeMillis();
        planTestMapper.insertBatch(planTests);
        long endTime = System.currentTimeMillis() - startTime;
        // insertBatch打印时间：814
        logger.info("insertBatch打印时间：{}", endTime);
        return String.valueOf(endTime);
    }


    public void insertThreadPoolAsyc() {
        // 异步多线程  插入数据库
        List<PlanTest> planTests = new ArrayList<>();
        PlanTest planTest;
        for (int i = 0; i < 100000; i++) {
            planTest = new PlanTest();
            planTest.setPlanType("3333333333333333");
            planTest.setPlanCode("33333333333333333");
            planTests.add(planTest);
        }
        int total = planTests.size();
        int batchSize = 500;
        int number = total % batchSize == 0 ? total / batchSize : total / batchSize + 1;
        CountDownLatch countDownLatch = new CountDownLatch(number);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < number; i++) {
            List<PlanTest> batchList = new ArrayList<>();
            if (i == number - 1) {  // 最后一个
                batchList = planTests.subList(i * batchSize, total);
            } else {
                batchList = planTests.subList(i * batchSize, (i + 1) * batchSize);
            }
            insertThreadPoolCountDownLatch(countDownLatch, batchList);
        }
        long endTime = System.currentTimeMillis() - startTime;
        // insertBatch打印时间：1174
        logger.info("insertBatch打印时间：{}", endTime);
    }

    @Async("asyncServiceExecutor")
    public void insertThreadPoolCountDownLatch(CountDownLatch countDownLatch, List<PlanTest> planTestList) {
        try {
            logger.info("3333333333333333");
            planTestMapper.insertBatch(planTestList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            countDownLatch.countDown();
        }
    }

    @Async("asyncServiceExecutor1")
    public void insertThreadPoolCountDownLatch1(CountDownLatch countDownLatch, List<PlanTest> planTestList) {
        try {
            logger.info("444444444444444444444444444");
            planTestMapper.insertBatch(planTestList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            countDownLatch.countDown();
        }
    }

    public void insertThreadPoolAsyc1() {
        // 异步多线程  插入数据库
        List<PlanTest> planTests = new ArrayList<>();
        PlanTest planTest;
        for (int i = 0; i < 100000; i++) {
            planTest = new PlanTest();
            planTest.setPlanType("444444444444444444444444444");
            planTest.setPlanCode("444444444444444444444444444");
            planTests.add(planTest);
        }
        int total = planTests.size();
        int batchSize = 500;
        int number = total % batchSize == 0 ? total / batchSize : total / batchSize + 1;
        CountDownLatch countDownLatch = new CountDownLatch(number);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < number; i++) {
            List<PlanTest> batchList = new ArrayList<>();
            if (i == number - 1) {  // 最后一个
                batchList = planTests.subList(i * batchSize, total);
            } else {
                batchList = planTests.subList(i * batchSize, (i + 1) * batchSize);
            }
            insertThreadPoolCountDownLatch1(countDownLatch, batchList);
        }
        long endTime = System.currentTimeMillis() - startTime;
        // insertBatch打印时间：1174
        logger.info("insertBatch打印时间：{}", endTime);
    }

    public void insertThreadPool() {
        // 异步多线程  插入数据库
        List<PlanTest> planTests = new ArrayList<>();
        PlanTest planTest;
        for (int i = 0; i < 10000; i++) {
            planTest = new PlanTest();
            planTest.setPlanType("55555555555555555");
            planTest.setPlanCode("555555555555555555");
            planTests.add(planTest);
        }
        int total = planTests.size();
        int batchSize = 500;
        int number = total % batchSize == 0 ? total / batchSize : total / batchSize + 1;
        // 创建一个线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // 核心线程数
                5, // 最大线程数
                1, // 线程空闲时间
                TimeUnit.SECONDS, // 时间单位
                new ArrayBlockingQueue<>(5), // 任务队列
                new ThreadPoolExecutor.CallerRunsPolicy() // 拒绝策略
        );

        long startTime = System.currentTimeMillis();

        // 提交任务给线程池
        for (int i = 0; i < number; i++) {
            List<PlanTest> batchList = new ArrayList<>();
            if (i == number - 1) {  // 最后一个
                batchList = planTests.subList(i * batchSize, total);
            } else {
                batchList = planTests.subList(i * batchSize, (i + 1) * batchSize);
            }
            final int taskId = i;
            List<PlanTest> finalBatchList = batchList;
            executor.execute(() -> {
                planTestMapper.insertBatch(finalBatchList);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskId + " is completed.");
            });
        }

        // 关闭线程池
        executor.shutdown();
        long endTime = System.currentTimeMillis() - startTime;
        // insertBatch打印时间：9306
        logger.info("insertBatch打印时间：{}", endTime);

    }

}
