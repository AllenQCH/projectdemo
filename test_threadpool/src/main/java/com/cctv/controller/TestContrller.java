package com.cctv.controller;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cctv.entity.PlanTest;
import com.cctv.mapper.PlanTestMapper;
import com.cctv.service.PlanTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestContrller {

    @PostMapping(value = "/paymentCheck")
    public String paymentCheck() {

        System.out.printf("666666666666");
        return "666666666666";
    }

    @Autowired
    private PlanTestService planTestService;

    /**
     * for循环单个插入
     * @return
     */
    @PostMapping(value = "/forCircleInsert")
    public String forCircleInsert() {
        String s = planTestService.forCircleInsert();
        return s;
    }

    /**
     * 数据库批量出入
     * @return
     */
    @PostMapping(value = "/insertBatch")
    public String insertBatch() {
        String s = planTestService.insertBatch();
        return s ;
    }

    /**
     * 异步线程池批量插入
     * @return
     */
    @PostMapping(value = "/insertThreadPoolAsyc")
    public String insertThreadPoolAsyc() {
        planTestService.insertThreadPoolAsyc();
        return null;
    }

    /**
     * 异步线程池批量插入1
     * @return
     */
    @PostMapping(value = "/insertThreadPoolAsyc1")
    public String insertThreadPoolAsyc1() {
        planTestService.insertThreadPoolAsyc1();
        return null;
    }

    /**
     * 线程池批量插入
     * @return
     */
    @PostMapping(value = "/insertThreadPool")
    public String insertThreadPool() {
        planTestService.insertThreadPool();
        return null;
    }



}
