package com.xys.car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xys.car.mapper")
public class XysApplication {
    public static void main(String[] args) {
        SpringApplication.run(XysApplication.class,args);
    }
}
