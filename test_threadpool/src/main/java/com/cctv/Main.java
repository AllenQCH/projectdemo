package com.cctv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cctv.mapper")
public class Main {
    public static void main(String[] args) {
        System.out.printf("正在启动");
        SpringApplication.run(Main.class);
        System.out.printf("启动成功");
    }
}