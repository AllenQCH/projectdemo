package com.cctv.controller;

import cn.hutool.json.JSONUtil;
import com.cctv.dto.InsertBatchDemoTestDTO;
import com.cctv.pojo.DemoTest;
import com.cctv.pojo.UwsAttachment;
import com.cctv.service.DemoTestService;
import com.cctv.service.UwsAttachmentService;
import com.cctv.util.RandomIDGeneratorUtil;
import com.cctv.util.SnowFlakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TestController {
    @Autowired
    private UwsAttachmentService uwsAttachmentService;

    @Autowired
    private DemoTestService demoTestService;

    @PostMapping(value = "/queryUws")
    public String queryUws() {
        UwsAttachment uwsAttachment = uwsAttachmentService.selectByPrimaryKey((long) 1);
        return JSONUtil.toJsonStr(uwsAttachment);
    }

    @PostMapping(value = "/insertWithoutId")
    public void  insertWithoutId(@RequestBody UwsAttachment uwsAttachment){
        int i = uwsAttachmentService.insertWithoutId(uwsAttachment);
        log.info("插入了{}条记录",i);
    }

    @PostMapping(value = "/generateSnowId")
    public String  generateSnowId(){
        Long id = SnowFlakeUtil.getDefaultSnowFlakeId();
        log.info("snowId:{},length:{}",id,String.valueOf(id).length());
        return String.valueOf(id);
    }

    @PostMapping(value = "/insertBatchDemoTest")
    public String  insertBatchDemoTest(@RequestBody InsertBatchDemoTestDTO insertBatchDemoTestDTO){
        int i = demoTestService.insertBatch(insertBatchDemoTestDTO.getParamInt());
        return String.valueOf(i);
    }


    public static void main(String[] args) {
        String s = RandomIDGeneratorUtil.generateIDCard();
        System.out.println(s);
    }
}
