package com.cctv.controller;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cctv.entity.PlanTest;
import com.cctv.mapper.PlanTestMapper;
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
    private PlanTestMapper planTestMapper;

    @PostMapping(value = "/query111")
    public String query111() {
        PlanTest planTest = planTestMapper.selectOne(new LambdaQueryWrapper<PlanTest>().eq(PlanTest::getIdPlanTest, ""));

        if (ObjectUtil.isNotEmpty(planTest)){
            planTest.setIdPlanTest(1l);

        }else {
            planTest = new PlanTest();
            planTest.setIdPlanTest(1l);
        }
        return JSONUtil.toJsonStr(planTest);
    }

}
