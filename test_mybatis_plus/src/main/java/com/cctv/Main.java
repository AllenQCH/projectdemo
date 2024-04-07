package com.cctv;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


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