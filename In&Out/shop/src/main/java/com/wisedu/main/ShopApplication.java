package com.wisedu.main;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.wisedu")
@MapperScan(annotationClass = Mapper.class, basePackages = "com.wisedu")
@EnableScheduling
public class ShopApplication {
    public static void main(String args[]){
        SpringApplication.run(ShopApplication.class,args);
    }
} 