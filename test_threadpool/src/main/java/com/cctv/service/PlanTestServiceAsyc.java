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
public class PlanTestServiceAsyc {
    private static final Logger logger = LoggerFactory.getLogger(PlanTestServiceAsyc.class);

    @Autowired
    private PlanTestMapper planTestMapper;



    @Async("asyncServiceExecutor")
    public void insertThreadPoolCountDownLatch(CountDownLatch countDownLatch, List<PlanTest> planTestList) {
        try {
            logger.info("3333333333333333333333333");
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
            logger.info("55555555555555555");
            planTestMapper.insertBatch(planTestList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            countDownLatch.countDown();
        }
    }

    @Async("serviceExecutorBatch")
    public void insertThreadPoolCountDownLatchBatch(int start, int end) {
        try {
            logger.info("{}******************************{}",start,end);
            List<PlanTest> planTests = new ArrayList<>();
            for (int i = start; i <=end; i++) {
                PlanTest planTest = new PlanTest();
                planTest.setPlanCode(String.valueOf(i));
                planTest.setPlanType(String.valueOf(i));
                planTests.add(planTest);
            }
            planTestMapper.insertBatch(planTests);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
