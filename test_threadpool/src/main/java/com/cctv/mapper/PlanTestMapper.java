package com.cctv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cctv.entity.PlanTest;

import java.util.List;

public interface PlanTestMapper extends BaseMapper<PlanTest> {
    void insertBatch(List<PlanTest> planTestList);
}