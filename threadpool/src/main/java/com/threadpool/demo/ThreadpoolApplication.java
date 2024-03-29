package com.threadpool.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ThreadpoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadpoolApplication.class, args);
    }

}
