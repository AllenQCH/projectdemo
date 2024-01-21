package com.threadpool.demo.controller;
import com.threadpool.demo.config.AsyncTaskUtil;
import com.threadpool.demo.test.Test01AsyncTask;
import com.threadpool.demo.test.Test03AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/test1")
    public String test1() {
        // 异步执行任务
        AsyncTaskUtil.asyncTask(new Test01AsyncTask());
        return "执行成功";
    }


    @Autowired
    private Test03AsyncTask test03AsyncTask;

    @GetMapping(value = "/test2")
    public String test2() {
        test03AsyncTask.run();
        test03AsyncTask.run1();
        return "执行成功";
    }
}
