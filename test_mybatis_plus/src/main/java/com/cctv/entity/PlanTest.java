package com.cctv.entity;

import javax.persistence.*;

@Table(name = "plan_test")
public class PlanTest {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID_PLAN_TEST")
    private Long idPlanTest;

    /**
     * 计划code
     */
    @Column(name = "PLAN_CODE")
    private String planCode;

    /**
     * 计划类型
     */
    @Column(name = "PLAN_TYPE")
    private String planType;

    /**
     * 获取主键
     *
     * @return ID_PLAN_TEST - 主键
     */
    public Long getIdPlanTest() {
        return idPlanTest;
    }

    /**
     * 设置主键
     *
     * @param idPlanTest 主键
     */
    public void setIdPlanTest(Long idPlanTest) {
        this.idPlanTest = idPlanTest;
    }

    /**
     * 获取计划code
     *
     * @return PLAN_CODE - 计划code
     */
    public String getPlanCode() {
        return planCode;
    }

    /**
     * 设置计划code
     *
     * @param planCode 计划code
     */
    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    /**
     * 获取计划类型
     *
     * @return PLAN_TYPE - 计划类型
     */
    public String getPlanType() {
        return planType;
    }

    /**
     * 设置计划类型
     *
     * @param planType 计划类型
     */
    public void setPlanType(String planType) {
        this.planType = planType;
    }
}