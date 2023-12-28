package com.cctv.controller;

import cn.hutool.json.JSONUtil;
import com.cctv.dto.InsertBatchDemoTestDTO;
import com.cctv.pojo.UwsAttachment;
import com.cctv.service.DemoTestService;
import com.cctv.service.UwsAttachmentService;
import com.cctv.util.RandomIDGeneratorUtil;
//import com.cctv.util.RedisUtils;
import com.cctv.util.RedisService;
import com.cctv.util.SnowFlakeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@Api(tags = "测试swagger")
public class TestController {
    @Autowired
    private UwsAttachmentService uwsAttachmentService;

    @Autowired
    private DemoTestService demoTestService;

    @Autowired
    private RedisService redisService;

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

    // 注意：这里@Autowired是报错的，因为@Autowired按照类名注入的
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * @param str
     * @return String
     */
    @PostMapping("/add")
    public String add(@RequestParam String str) {
        redisTemplate.opsForValue().set("str", str);
        String str1 = redisTemplate.opsForValue().get("str");
        return str1;
    }

    /**
     * @return user list
     */
    @PostMapping("/find")
    public String edit(@RequestParam String str) {
        return redisTemplate.opsForValue().get(str);
    }

    /**
     * @return user list
     */
    @ApiOperation("测试接口")
    @PostMapping("/testnewgetset")
    @ResponseBody
    public String test(@RequestParam String str) {
        redisService.set(str,str);
        Object value = redisService.get(str);
        return String.valueOf(value);
    }

}
