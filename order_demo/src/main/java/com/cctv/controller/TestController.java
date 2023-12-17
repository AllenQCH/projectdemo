//package com.cctv.controller;
//
//import cn.hutool.json.JSONUtil;
//import com.cctv.pojo.UwsAttachment;
//import com.cctv.service.UwsAttachmentService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RestController
//public class TestController {
//@Autowired
//private UwsAttachmentService uwsAttachmentService;
//
//    @PostMapping(value = "/queryUws")
//    public String queryUws(){
//        UwsAttachment uwsAttachment = uwsAttachmentService.selectByPrimaryKey((long) 1);
//        return JSONUtil.toJsonStr(uwsAttachment);
//    }
//
//}
