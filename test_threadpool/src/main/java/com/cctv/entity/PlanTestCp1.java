package com.cctv.entity;

import javax.persistence.*;

@Table(name = "plan_test_cp1")
public class PlanTestCp1 {
    @Column(name = "ID_PLAN_TEST")
    private Long idPlanTest;

    @Column(name = "PLAN_CODE")
    private String planCode;

    @Column(name = "PLAN_TYPE")
    private String planType;

    /**
     * @return ID_PLAN_TEST
     */
    public Long getIdPlanTest() {
        return idPlanTest;
    }

    /**
     * @param idPlanTest
     */
    public void setIdPlanTest(Long idPlanTest) {
        this.idPlanTest = idPlanTest;
    }

    /**
     * @return PLAN_CODE
     */
    public String getPlanCode() {
        return planCode;
    }

    /**
     * @param planCode
     */
    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    /**
     * @return PLAN_TYPE
     */
    public String getPlanType() {
        return planType;
    }

    /**
     * @param planType
     */
    public void setPlanType(String planType) {
        this.planType = planType;
    }
}