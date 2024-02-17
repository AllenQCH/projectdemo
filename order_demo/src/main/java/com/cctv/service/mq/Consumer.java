package com.cctv.service.mq;


import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener( consumerGroup = "${rocketmq.group}", topic = "${rocketmq.topic}" )
public class Consumer implements RocketMQListener<String> {

    private static final Logger logger = LoggerFactory.getLogger( Consumer.class );

    @Override
    public void onMessage( String message ){

        System.out.println( "message:  " + message );
        //模拟消费失败，抛出异常
        if( "1".equals( message ) ){
            message = null;
            message.toString();
        }
    }
}
