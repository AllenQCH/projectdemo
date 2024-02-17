package com.cctv.controller;


import com.cctv.dto.mq.OrderMessageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@Api(tags = "mq_swagger")
public class MqController{

    /**
     * 引入template代替defaultMQProducer作为生产者
     */
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value( "${rocketmq.topic}" )
    private String topic;

    @ApiOperation("testMq")
    @PostMapping(value = "/testMq")
    public String testMq(@RequestBody OrderMessageRequest orderMessageRequest ){
        //通过MessageBuilder构建消息
        log.info("开始调用发送消息");
        Message<String> message = MessageBuilder.withPayload( orderMessageRequest.getMessage() ).build();
        //同步发送该消息，获取发送结果
        SendResult result = rocketMQTemplate.syncSend( topic, message );
        return result.getMsgId() + "----" + result.getSendStatus();
    }
}
