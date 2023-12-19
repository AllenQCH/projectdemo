package com.cctv.service;

import com.cctv.mapper.DemoTestMapper;
import com.cctv.pojo.DemoTest;
import com.cctv.util.RandomIDGeneratorUtil;
import com.cctv.util.SnowFlakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class DemoTestService {
    @Autowired
    private DemoTestMapper demoTestMapper;

    public int insertBatch(Integer integer) {

        for (int i=0;i<integer;i++){
            DemoTest demoTest = new DemoTest();

            demoTest.setCertificateNo(RandomIDGeneratorUtil.generateIDCard());
            demoTest.setCertificateType("01");//todo：暂时定为01身份证
            demoTest.setCreatedBy("create" + i);
            demoTest.setCreatedDate(new Date());
//            demoTest.setId();
            demoTest.setOrderDesc("自动插入" + i);
            demoTest.setOrderId(String.valueOf(SnowFlakeUtil.getDefaultSnowFlakeId()));
            demoTest.setPolicyNo("123456789123456789");//todo:随机生成但是可以重复
            demoTest.setProductCode("123466");//todo:随机生成但是可以重复
            demoTest.setTestType(String.valueOf(i % 2));//todo:随机生成0/1
            demoTest.setUpdatedBy("update" + i);
            demoTest.setUpdatedDate(new Date());
            demoTestMapper.insert(demoTest);
            log.info("第{}次插入成功", i);


        }

        return integer;
    }

}
